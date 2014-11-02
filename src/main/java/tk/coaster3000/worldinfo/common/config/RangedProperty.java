package tk.coaster3000.worldinfo.common.config;

public interface RangedProperty<T> extends Property<T> {
	T getMinValue();
	T getMaxValue();
}
