package tk.coaster3000.worldinfo.common.config;

public interface Property<T> {
	T getValue();
	String getKey();

	String getComment();
}
