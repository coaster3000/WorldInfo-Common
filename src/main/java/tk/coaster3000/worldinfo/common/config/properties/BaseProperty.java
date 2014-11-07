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
package tk.coaster3000.worldinfo.common.config.properties;

import tk.coaster3000.worldinfo.common.config.Property;
import tk.coaster3000.worldinfo.common.config.SettingsProvider;
import tk.coaster3000.worldinfo.util.Validate;

public abstract class BaseProperty<T> implements Property<T> {

	private static final String PATH_SEP = ".";

	final Class<T> propertyType;
	final String key;
	final String path;
	SettingsProvider provider;

	public BaseProperty(Class<T> type, String key) {
		propertyType = type;
		if (key.contains(PATH_SEP)) {
			this.key = key.substring(key.lastIndexOf(PATH_SEP) + 1);
			this.path = key.substring(0, key.lastIndexOf(PATH_SEP));
		} else {
			this.key = key;
			this.path = "";
		}
	}

	@Override
	public String getComment() {
		return null;
	}

	public SettingsProvider getProvider() {
		return provider;
	}

	public void setProvider(SettingsProvider provider) {
		this.provider = provider;
	}

	public final boolean setValue(T value) {
		return setValue(this.provider, value);
	}

	public boolean setValue(SettingsProvider provider, T value) {
		return provider.setProperty(this, value);
	}

	public Class<T> getValueType() {
		return propertyType;
	}

	public T getValue(SettingsProvider provider) {
		Validate.notNull(provider, "Provider must not be null!");
		return provider.getProperty(this);
	}

	public T getValue(SettingsProvider provider, T defValue) {
		Validate.notNull(provider, "Provider must not be null!");
		return provider.getProperty(this, defValue);
	}

	public final T getValue() {
		return getValue(this.provider);
	}

	public final T getValue(T defValue) {
		return getValue(this.provider, defValue);
	}

	public final String getKey() {
		return key;
	}

	public final String getPath() {
		return path;
	}
}
