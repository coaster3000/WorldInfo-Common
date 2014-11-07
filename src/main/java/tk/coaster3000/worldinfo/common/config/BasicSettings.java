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
package tk.coaster3000.worldinfo.common.config;

import tk.coaster3000.worldinfo.common.data.MultiMap;

import java.util.*;

public abstract class BasicSettings<M extends Map<String, Object>> implements SettingsProvider {

	MultiMap<M> data;
	Set<Property<?>> properties;

	public BasicSettings(MultiMap<M> baseMap) {
		this.data = baseMap;
		this.properties = new HashSet<Property<?>>();
	}

	@Override
	public MultiMap<M> getData() {
		return data;
	}

	@Override
	public <T> T getProperty(Property<T> property) {
		return (T) getData().get(property.getKey(), property.getValueType());
	}

	@Override
	public <T> T getProperty(Property<T> property, T defValue) {
		return (T) getData().get(property.getKey(), defValue);
	}

	@Override
	public <T> boolean setProperty(Property<T> property, T value) {
		 return getData().set(property.getKey(), value);
	}

	@Override
	public boolean hasProperty(Property<?> property) {
		return getData().contains(property.getKey());
	}

	@Override
	public boolean addProperty(Property<?> property) {
		return properties.add(property);
	}

	@Override
	public boolean removeProperty(Property<?> property) {
		return properties.remove(property);
	}

	@Override
	public Collection<Property<?>> getProperties() {
		return Collections.unmodifiableSet(properties);
	}
}
