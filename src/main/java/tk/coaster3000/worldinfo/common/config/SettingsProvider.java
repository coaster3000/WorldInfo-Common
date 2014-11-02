package tk.coaster3000.worldinfo.common.config;

import tk.coaster3000.worldinfo.common.data.IMultiMap;

import java.util.Collection;

public interface SettingsProvider {
	void save();
	void load();

	IMultiMap getData();

	<T> T getProperty(Property<T> property);
	<T> T getProperty(Property<T> property, T defValue);

	<T> boolean setProperty(Property<T> property, T value);

	boolean hasProperty(Property<?> property);
	boolean addProperty(Property<?> property);
	boolean removeProperty(Property<?> property);

	Collection<Property<?>> getProperties();
}
