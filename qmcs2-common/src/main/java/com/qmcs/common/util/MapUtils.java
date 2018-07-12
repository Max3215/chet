package com.qmcs.common.util;

import com.google.common.collect.Maps;
import com.qmcs.common.util.CommonUtil;

import java.util.Map;

/**
 * 
 * @author suyl
 * @version
 */
public class MapUtils {

	public static Map<String, Object> paramsData = Maps.newHashMap();

	public static void saveMapData(String key, Object obj) {
		paramsData.put(key, obj);
	}

	public static Object getMapData(String key) {
		return paramsData.get(key);
	}

	/**
	 * 更新用户信息
	 */
	public static void removeMapData(String key){
		paramsData.remove(key);
	}


}
