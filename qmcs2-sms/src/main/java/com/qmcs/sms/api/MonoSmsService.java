package com.qmcs.sms.api;

import java.util.Map;

/**
 * 旧短信调用接口
 * Created by suyl on 2017/5/27.
 */
public interface MonoSmsService {

    /**
     * 余额查询
     * @return
     */
    Map<String,Object> getBalance();

    /**
     * 短信发送
     * @param desNo：手机号码。每次只能提交1个号码。Msg：短信内容，Channel：留空即可，兼容用的。
     * @return
     */
    Map<String,Object> sendSms(String desNo,String msg);
}
