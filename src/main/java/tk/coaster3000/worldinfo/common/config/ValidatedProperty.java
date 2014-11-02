package tk.coaster3000.worldinfo.common.config;

public interface ValidatedProperty<T> extends Property<T> {
	boolean isValid(T value);
}
