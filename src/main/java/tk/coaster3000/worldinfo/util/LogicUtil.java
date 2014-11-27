package tk.coaster3000.worldinfo.util;

public class LogicUtil {
	public static <T> T requireNonNull(T object, String msg) {
		if (object == null) throw new NullPointerException(msg);
		return object;
	}

	public static <T> T fixNull(T object, T fixedObject) {
		if (object == null) return fixedObject;
		return object;
	}

	public static boolean isNull(Object object) {
		return object == null;
	}

	public static boolean isNotNull(Object object) {
		return object != null;
	}
}
