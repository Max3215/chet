package com.qmcs.sms.api.impl;

import com.qmcs.common.http.HttpClientUtils;
import com.qmcs.sms.api.SmsService;
import com.qmcs.sms.constants.Constants;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * 短信接口实现
 * Created by suyl on 2017/5/26.
 */
@Service
public class SmsServiceImpl implements SmsService{

    @Override
    public Map<String, Object> sendSms(String phone, String content) {
        Map<String,Object> params = new HashMap<String,Object>();
        //提交账户
        params.put("sname", Constants.SMS_SNAME);
        //提交账户的密码
        params.put("spwd", Constants.SMS_SPWD);
        //企业代码（扩展号，不确定请赋值空）
        params.put("scorpid", Constants.SMS_SCORPID);
        //产品编号
        params.put("sprdid", Constants.SMS_SPRDID);
        //接收号码
        params.put("sdst", phone);
        //接信息内容, UTF-8编码，通常为70汉字以内，具体由平台内部决定
        params.put("smsg", content);
        return HttpClientUtils.sendPostRequest(Constants.SMS_HTTP_URL + Constants.SMS_G_SUBMIT,params,Constants.SMS_CODE);
    }

    @Override
    public Map<String, Object> sendSchedulerSms(String phone, String content, String sbegindate) {
        Map<String,Object> params = new HashMap<String,Object>();
        //提交账户
        params.put("sname", Constants.SMS_SNAME);
        //提交账户的密码
        params.put("spwd", Constants.SMS_SPWD);
        //企业代码（扩展号，不确定请赋值空）
        params.put("scorpid", Constants.SMS_SCORPID);
        //产品编号
        params.put("sprdid", Constants.SMS_SPRDID);
        //起始发送时间,格式为"yyyy-MM-ddHH:mm:ss”，要求大于当前时间并且小于当前时间+31天。
        params.put("sbegindate",sbegindate);
        //接收号码
        params.put("sdst", phone);
        //接信息内容, UTF-8编码，通常为70汉字以内，具体由平台内部决定
        params.put("smsg", content);
        return HttpClientUtils.sendPostRequest(Constants.SMS_HTTP_URL + Constants.SMS_G_SCHEDULERSUBMIT,params,Constants.SMS_CODE);
    }
}
