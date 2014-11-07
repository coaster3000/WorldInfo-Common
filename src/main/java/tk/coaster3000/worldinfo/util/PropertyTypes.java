package tk.coaster3000.worldinfo.util;

import tk.coaster3000.worldinfo.common.config.properties.BaseProperty;

public class PropertyTypes {
	public static class StringProperty extends BaseProperty<String> {
		public StringProperty(String key) {
			super(String.class, key);
		}
	}

	public static class BooleanProperty extends BaseProperty<Boolean> {
		public BooleanProperty(String key) {
			super(Boolean.class, key);
		}
	}

	public static class NumberProperty<T extends Number> extends BaseProperty<T> {
		public NumberProperty(Class<T> cls, String key) {
			super(cls, key);
		}

		public static class IntegerProperty extends NumberProperty<Integer> {
			public IntegerProperty(String key) {
				super(Integer.class, key);
			}
		}

		public static class DoubleProperty extends NumberProperty<Double> {
			public DoubleProperty(String key) {
				super(Double.class, key);
			}
		}

		public static class FloatProperty extends NumberProperty<Float> {
			public FloatProperty(String key) {
				super(Float.class, key);
			}
		}

		public static class ByteProperty extends NumberProperty<Byte> {
			public ByteProperty(String key) {
				super(Byte.class, key);
			}
		}

		public static class LongProperty extends NumberProperty<Long> {
			public LongProperty(String key) {
				super(Long.class, key);
			}
		}

		public static class ShortProperty extends NumberProperty<Short> {
			public ShortProperty(String key) {
				super(Short.class, key);
			}
		}
	}
}
