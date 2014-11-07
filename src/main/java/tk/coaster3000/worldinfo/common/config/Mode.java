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

import tk.coaster3000.worldinfo.util.PropertyTypes;

public enum Mode {
	UUID, File, Name;

	public static class ModeProperty extends PropertyTypes.StringProperty {
		public ModeProperty(String key) {
			super(key);
		}

		public Mode getModeValue() {
			try {
				return Mode.valueOf(getValue());
			} catch (IllegalArgumentException ignored) {
				return null;
			}
		}

		public Mode getModeValue(SettingsProvider provider) {
			try {
				return Mode.valueOf(getValue(provider));
			} catch (IllegalArgumentException ignored) {
				return null;
			}
		}

		public Mode getModeValue(SettingsProvider provider, Mode defValue) {
			return Mode.valueOf(getValue(provider, defValue.name()));
		}

		public boolean setValue(Mode mode) {
			return setValue(mode.name());
		}

		public boolean setValue(SettingsProvider provider, Mode mode) {
			return setValue(provider, mode.name());
		}

	}
}
