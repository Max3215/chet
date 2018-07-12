package com.qmcs.sms.api.impl;

import com.qmcs.common.http.HttpClientUtils;
import com.qmcs.sms.api.MonoSmsService;
import com.qmcs.sms.constants.MonoConstants;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * 旧短信实现
 * Created by suyl on 2017/5/27.
 */
@Service
public class MonoServiceImpl implements MonoSmsService{

    @Override
    public Map<String, Object> getBalance() {
        Map<String,Object> params = new HashMap<String,Object>();
        //登录名称
        params.put("userCode", MonoConstants.SMS_USER_CODE);
        //登录密码
        params.put("userPass", MonoConstants.SMS_USER_PASS);
        return HttpClientUtils.sendPostRequest(MonoConstants.SMS_HTTP_URL+MonoConstants.SMS_GETBALANCE,params,MonoConstants.SMS_CODE);
    }

    @Override
    public Map<String, Object> sendSms(String desNo,String msg) {
        Map<String,Object> params = new HashMap<String,Object>();
        //登录名称
        params.put("userCode", MonoConstants.SMS_USER_CODE);
        //登录密码
        params.put("userPass", MonoConstants.SMS_USER_PASS);
        //手机号码。每次只能提交 1 个号码。
        params.put("DesNo", desNo);
        //短信内容
        params.put("Msg", msg);
        //留空即可，兼容用的
        params.put("Channel", MonoConstants.SMS_CHANNAL);
        return HttpClientUtils.sendPostRequest(MonoConstants.SMS_HTTP_URL+MonoConstants.SMS_SENDMSG,params,MonoConstants.SMS_CODE);
    }
}
