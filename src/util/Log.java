package util;

import keys.Keys;

public class Log {
	public static void d(String log) {
		// d is debug
		if (Keys.IS_DEBUG) {
			System.out.println(log);
		}
	}

	public static void f(String log) {
		// f is fatal
		System.out.println(log);
	}
}
