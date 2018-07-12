package com.qmcs.sms.api;

import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 短信发送接口
 * Created by suyl on 2017/5/26.
 */
public interface SmsService {

    /**
     * 发送短信接口
     * @param phone 接收号码间用英文半角逗号“,”隔开，触发产品一次只能提交一个,其他产品一次不能超过10万个号码
     * @param content 信息内容, UTF-8编码，通常为70汉字以内，具体由平台内部决定
     * @return
     */
    public Map<String,Object> sendSms(String phone,String content);

    /**
     * 定时发送短信
     * @param phone 接收号码间用英文半角逗号“,”隔开，触发产品一次只能提交一个,其他产品一次不能超过10万个号码
     * @param content 信息内容, UTF-8编码，通常为70汉字以内，具体由平台内部决定
     * @param sbegindate 起始发送时间,格式为"yyyy-MM-ddHH:mm:ss”，要求大于当前时间并且小于当前时间+31天。
     * @return
     */
    public Map<String,Object> sendSchedulerSms(String phone,String content,String sbegindate);
}
