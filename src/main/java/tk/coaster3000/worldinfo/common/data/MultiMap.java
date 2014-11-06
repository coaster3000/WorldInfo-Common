/**
 * This file is part of WorldInfo, licensed under the MIT License (MIT).
 *
 * Copyright (c) WorldInfo
 * Copyright (c) contributors
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package tk.coaster3000.worldinfo.common.data;

import tk.coaster3000.worldinfo.util.Validate;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

public abstract class MultiMap<M extends Map<String, Object>> implements IMultiMap<M> {
	private static final String PATH_SEP = ".";
	private static final String PATH_SEP_REGEX = "\\.";

	String name;
	String path;

	M data;

	MultiMap<M> parent;

	public MultiMap() {
		this(null, "");
	}

	protected MultiMap(MultiMap<M> parent, String name) {
		Validate.notNull(name);
		this.parent = parent;
		this.name = name;
		this.path = parent != null ? parent.getPath() + PATH_SEP + name : name;
		data = getRoot().craftDataHolder();
	}

	public MultiMap<M> getRoot() {
		MultiMap<M> last = this;
		MultiMap<M> prev = last;
		while (prev != null) {
			prev = last.getParent();
			if (prev != null) last = prev;
		}
		return last;
	}

	public MultiMap<M> getParent() {
		return this.parent;
	}

	public String getPath() {
		return this.path;
	}

	public String getName() {
		return this.name;
	}

	public boolean isNode(String path) {
		return get(path, MultiMap.class) != null;
	}

	public boolean contains(String path) {
		return get(path) != null;
	}

	public Object get(String path) {
		int i = path.lastIndexOf(PATH_SEP);
		if (i > 0)
			return getNode(path.substring(0, i)).get(path.substring(i + 1));
		else return data.get(path);
	}

	@SuppressWarnings("unchecked")
	public <T> T get(String path, Class<T> type) {
		Object o = get(path);
		if (type.isInstance(o)) return (T) o;
		else return null;
	}

	@SuppressWarnings("unchecked")
	public <T> T get(String path, T defValue) {
		T ret = (T) get(path, defValue.getClass());
		if (ret == null) set(path, defValue);

		return defValue;
	}

	@SuppressWarnings("unchecked")
	public MultiMap<M> getNode(String path) {
		return (MultiMap<M>) get(path, MultiMap.class);
	}

	public MultiMap<M> createNode(String path) {
		MultiMap<M> node = getNode(path);
		if (node == null) {
			if (path.contains(PATH_SEP)) {
				Queue<String> paths = new LinkedBlockingQueue<String>();

				Collections.addAll(paths, path.split(PATH_SEP_REGEX));

				node = this;
				while (paths.peek() != null) {
					node = createNode(paths.poll());
				}
			} else {
				node = new MultiMap<M>(this, path) {
					@Override
					protected M craftDataHolder() {
						return getRoot().craftDataHolder();
					}
				};
				set(path, node);
			}
		}

		return node;
	}

	public boolean remove(String path) {
		return set(path, null);
	}

	public boolean set(String path, Object value) {
		int i = path.lastIndexOf(PATH_SEP);
		if (i > 0)
			return createNode(path.substring(0, i)).set(path.substring(i + 1), value);
		else if (value == null) return data.remove(path) != null;
		else return data.put(path, value) == null;
	}

	@SuppressWarnings("unchecked")
	public Set<String> getKeys(boolean recursive) {
		Set<String> keys = new LinkedHashSet<String>();

		if (recursive) {
			for (Map.Entry<String, Object> entry : data.entrySet()) {
				final String key = entry.getKey();
				keys.add(key);
				if (entry.getValue() instanceof MultiMap) {
					keys.addAll(((MultiMap<M>) entry.getValue()).getKeys(key));
				}
			}
		} else
			keys.addAll(data.keySet());

		return keys;
	}

	private Set<String> getKeys(String prefix) {
		Set<String> keys = new LinkedHashSet<String>();

		for (Map.Entry<String, Object> entry : data.entrySet()) {
			final String key = prefix + "." + entry.getKey();
			keys.add(key);
			if (entry.getValue() instanceof MultiMap) {
				keys.addAll(((MultiMap<M>) entry.getValue()).getKeys(key));
			}
		}

		return keys;
	}

	public Set<String> getKeys() {
		return getKeys(false);
	}

	public Set<String> getNodeKeys() {
		Set<String> keys = getKeys(true);

		for (Iterator<String> iterator = keys.iterator(); iterator.hasNext(); )
			if (!isNode(iterator.next())) iterator.remove();

		return keys;
	}

	public Set<String> getValueKeys() {
		Set<String> keys = getKeys(true);

		for (Iterator<String> iterator = keys.iterator(); iterator.hasNext(); )
			if (isNode(iterator.next())) iterator.remove();

		return keys;
	}

	public Map<String, Object> getFlatData() {
		Map<String, Object> ret = new HashMap<String, Object>();

		for (String key : getValueKeys())
			ret.put(key, get(key));

		return Collections.unmodifiableMap(ret);
	}

	public void clear() {
		for (Iterator<Map.Entry<String, Object>> iter = data.entrySet().iterator(); iter.hasNext(); ) {
			Map.Entry<String, Object> entry = iter.next();
			if (entry.getValue() instanceof MultiMap) {
				((MultiMap) entry.getValue()).reset();
			}
			iter.remove();
		}
	}

	private void reset() {
		this.name = "";
		this.path = "";
		this.parent = null;
		this.clear();
	}

	protected abstract M craftDataHolder();

	public final Map<String, Object> getData() {
		return Collections.unmodifiableMap(data);
	}
}
