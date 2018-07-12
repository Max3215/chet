package com.qmcs.common.util.callback;

import com.qmcs.common.util.CommonUtil;

import java.io.InputStream;
import java.util.Properties;

/**
 * 正式,测试环境回调
 * Created by suyl on 2017/8/11.
 */
public class CallbackUtil {

    /**
     * 测试环境
     */
    private final static String test_callback_propertis = "test_callback.properties";

    /**
     * 正式环境
     */
    private final static String formal_callback_propertis = "formal_callback.properties";

    private static Properties pro;

    /**
     * 快递100,阿里云图片服务器,微信支付回调
     * @param key
     * @return
     */
    public static Object getProperties(String key){
        if(CommonUtil.isEmpty(pro)){
            pro = new Properties();
            InputStream in = null;
            ClassLoader loader = CallbackUtil.class.getClassLoader();
            try {
                if(CommonUtil.isEmpty(loader)){
                    in = ClassLoader.getSystemResourceAsStream(formal_callback_propertis);
                }else {
                    in = loader.getResourceAsStream(formal_callback_propertis);
                }
                pro.load(in);
                in.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return pro.get(key);
    }

}
