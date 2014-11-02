package tk.coaster3000.worldinfo.common.data;

import java.util.Collection;
import java.util.Map;

public interface IMultiMap<M extends Map<String, Object>> {

	IMultiMap<M> getRoot();
	IMultiMap<M> getParent();

	String getPath();
	String getName();

	boolean isNode(String path);
	boolean contains(String path);

	Object get(String path);
	<T> T get(String path, Class<T> type);
	<T> T get(String path, T defValue);

	boolean set(String path, Object value);

	Collection<String> getKeys(boolean recursive);
	Collection<String> getKeys();

	Collection<String> getNodeKeys();
	Collection<String> getValueKeys();

	Map<String, Object> getData();
	Map<String, Object> getFlatData();
}
