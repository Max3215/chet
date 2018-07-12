package com.qmcs.sms.util;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * @author suyl
 * @version
 */
public class MapPhoneCodeUtils {

	public static Map<String, Object> paramsData = Maps.newHashMap();

	public static void saveMapData(String key, Object obj) {
		paramsData.put(key, obj);
	}

	public static Object getMapData(String key) {
		return paramsData.get(key);
	}

	public static void removeMapData(String key) {
		 paramsData.remove(key);
	}

}
