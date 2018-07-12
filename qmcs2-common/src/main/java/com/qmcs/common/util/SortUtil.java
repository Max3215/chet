package com.qmcs.common.util;

import com.alibaba.fastjson.JSON;

import java.util.*;

/**
 * Created by zhoudu on 2017-08-04.
 * 参数排序
 */
public class SortUtil {

    /**
     * 排序
     * @param map
     * @return 返回
     */
    public static String sort( final Map<String,Object> map){
        Set<String> keys = map.keySet();
        LinkedHashMap maps = new LinkedHashMap();
        List<String> list = null;
        for (String s: keys){
            list.add(s);
        }
        if (null != list )
            Collections.sort(list);
        for (String s: list){
            maps.put(s,map.get(s));
        }
        return JSON.toJSONString(maps);
    }
}
