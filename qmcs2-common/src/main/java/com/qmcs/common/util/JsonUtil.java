package com.qmcs.common.util;

import com.google.gson.Gson;

public class JsonUtil {

	private static Gson gson = new Gson();
	
	private JsonUtil() {
	}

	public static String toJson(Object o) {
		return gson.toJson(o);
	}
	
	public static <T> T fromJson(String jsonStr, Class<T> t) {
		return gson.fromJson(jsonStr, t);
	}
}
