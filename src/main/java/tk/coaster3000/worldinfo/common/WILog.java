package tk.coaster3000.worldinfo.common;

public interface WILog<LEVEL> {

	/**
	 * Logs an error message.
	 *
	 * @param msg to log
	 */
	void error(String msg);

	/**
	 * Logs an error from a throwable.
	 *
	 * @param throwable to log.
	 */
	void error(Throwable throwable);

	/**
	 * Logs an error message.
	 *
	 * Formats the message with {@code String.format(String msg, Object...)}.
	 *
	 * @param msg to log and format with
	 * @param args for formatting
	 */
	void error(String msg, Object... args);

	/**
	 * Logs an error message along with a throwable.
	 *
	 * @param msg to log
	 * @param throwable to log alongside the message
	 */
	void error(String msg, Throwable throwable);

	/**
	 * Logs an informational message.
	 *
	 * @param msg to log
	 */
	void info(String msg);

	/**
	 * Logs an informational message from a throwable.
	 *
	 * @param throwable to log.
	 */
	void info(Throwable throwable);

	/**
	 * Logs an informational message.
	 *
	 * Formats the message with {@code String.format(String msg, Object...)}.
	 *
	 * @param msg to log and format with
	 * @param args for formatting
	 */
	void info(String msg, Object... args);

	/**
	 * Logs an informational message along with a throwable.
	 *
	 * @param msg to log
	 * @param throwable to log alongside the message
	 */
	void info(String msg, Throwable throwable);

	/**
	 * Logs a warning message.
	 *
	 * @param msg to log
	 */
	void warning(String msg);

	/**
	 * Logs a warning from a throwable.
	 * @param throwable to log
	 */
	void warning(Throwable throwable);

	/**
	 * Logs a warning message.
	 *
	 * Formats the message with {@code String.format(String msg, Object...)}.
	 *
	 * @param msg to log and format with
	 * @param args for formatting
	 */
	void warning(String msg, Object... args);

	/**
	 * Logs a warning message along with a throwable.
	 *
	 * @param msg to log
	 * @param throwable to log alongside the message
	 */
	void warning(String msg, Throwable throwable);

	/**
	 * Logs a boxed warning message.
	 *
	 * @param msg to log
	 */
	void strongWarning(String msg);

	/**
	 * Logs a boxed warning message from a throwable.
	 *
	 * @param throwable to log
	 */
	void strongWarning(Throwable throwable);

	/**
	 * Logs a boxed warning message.
	 *
	 * Formats the message with {@code String.format(String msg, Object...)}.
	 *
	 * @param msg to log and format with
	 * @param args for formatting
	 */
	void strongWarning(String msg, Object... args);

	/**
	 * Logs a boxed warning message along with a throwable.
	 *
	 * @param msg to log
	 * @param throwable to log alongside the message
	 */
	void strongWarning(String msg, Throwable throwable);

	/**
	 * Logs a message at the specified level.
	 *
	 * @param level to log at
	 * @param msg to log
	 */
	void log(LEVEL level, String msg);

	/**
	 * Logs a message at the specified level.
	 *
	 * Formats the message with {@code String.format(String msg, Object... args)}.
	 *
	 * @param level to log at
	 * @param msg to log and format with
	 * @param args for formatting
	 */
	void log(LEVEL level, String msg, Object... args);

	/**
	 * Logs a message at the specified level in addition to logging the specified Throwable at the specified level.
	 *
	 * @param level to log at
	 * @param msg to log
	 * @param throwable to log alongside the message
	 */
	void log(LEVEL level, String msg, Throwable throwable);
}
