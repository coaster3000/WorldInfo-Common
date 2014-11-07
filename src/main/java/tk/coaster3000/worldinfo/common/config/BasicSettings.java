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
