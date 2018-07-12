package com.qmcs.common.util;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * 获取手机端header
 * Created by suyl on 2017/6/2.
 */
public class HeaderUtils {

    public static Map<String, Object> getHeadersInfo(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<String, Object>();
        Enumeration headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String key = (String) headerNames.nextElement();
            String value = request.getHeader(key);
            map.put(key, value);
        }
        return map;
    }


}
