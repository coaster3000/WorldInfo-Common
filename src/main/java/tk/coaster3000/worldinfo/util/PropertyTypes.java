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
package tk.coaster3000.worldinfo.util;

import tk.coaster3000.worldinfo.common.config.properties.BaseProperty;

public class PropertyTypes {
	public abstract static class StringProperty extends BaseProperty<String> {
		public StringProperty(String key) {
			super(String.class, key);
		}
	}

	public abstract static class BooleanProperty extends BaseProperty<Boolean> {
		public BooleanProperty(String key) {
			super(Boolean.class, key);
		}
	}

	public abstract static class NumberProperty<T extends Number> extends BaseProperty<T> {
		public NumberProperty(Class<T> cls, String key) {
			super(cls, key);
		}

		public abstract static class IntegerProperty extends NumberProperty<Integer> {
			public IntegerProperty(String key) {
				super(Integer.class, key);
			}
		}

		public abstract static class DoubleProperty extends NumberProperty<Double> {
			public DoubleProperty(String key) {
				super(Double.class, key);
			}
		}

		public abstract static class FloatProperty extends NumberProperty<Float> {
			public FloatProperty(String key) {
				super(Float.class, key);
			}
		}

		public abstract static class ByteProperty extends NumberProperty<Byte> {
			public ByteProperty(String key) {
				super(Byte.class, key);
			}
		}

		public abstract static class LongProperty extends NumberProperty<Long> {
			public LongProperty(String key) {
				super(Long.class, key);
			}
		}

		public abstract static class ShortProperty extends NumberProperty<Short> {
			public ShortProperty(String key) {
				super(Short.class, key);
			}
		}
	}
}
