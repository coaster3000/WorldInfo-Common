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
import tk.coaster3000.worldinfo.util.StringUtil;

import java.util.regex.Pattern;

public enum Mode {
	UUID, File, Name;

	public static class ModeProperty extends PropertyTypes.StringProperty implements PatternValidatedProperty, SpecialProperty<String, Mode> {
		public ModeProperty(String key) {
			super(key);
		}

		static final Pattern regex;

		static {
			Mode[] modes = Mode.values();
			String[] vals = new String[modes.length];
			for (int i = 0; i < modes.length; i++)
				vals[i] = modes[i].name();

			regex = Pattern.compile(StringUtil.join("|", vals));
		}

		public String getDefaultValue() {
			return getDefaultSpecialValue().name();
		}

		public Pattern getPattern() {
			return regex;
		}

		@Override
		public String getComment() {
			return "A world id mode. It may contain either of the following: " + StringUtil.join(",", getPattern().pattern().split("\\|"));
		}

		public Class<Mode> getSpecialValueType() {
			return Mode.class;
		}

		public Mode getSpecialValue(SettingsProvider provider) {
			try {
				return Mode.valueOf(getValue(provider));
			} catch (IllegalArgumentException ignored) {
				return null;
			}
		}

		public Mode getSpecialValue(SettingsProvider provider, Mode defValue) {
			try {
				return Mode.valueOf(getValue(provider, defValue.name()));
			} catch (IllegalArgumentException ignored) {
				return null;
			}
		}

		public boolean setSpecialValue(SettingsProvider provider, Mode value) {
			return setValue(value.name());
		}

		public Mode getDefaultSpecialValue() {
			return Mode.UUID;
		}
	}
}
