package com.qmcs.sms.util;

import com.qmcs.common.util.CommonUtil;
import com.qmcs.sms.constants.MonoConstants;

/**
 * 短信模板
 * Created by suyl on 2017/6/3.
 */
public class SmsTemplate {

    /**
     * 新版本短信验证码模板
     * @param code
     * @return
     */
    public static String SmsAuthenticationTemplate(String code){
        return "尊敬的用户，您的验证码为"+code+"，请在5分钟内使用。如非本人操作，请忽略本信息。"+ MonoConstants.SMS_SIGN+"";
    }

    /**
     * 旧版本短信验证码模板
     * @param code
     * @return
     */
    public static String OldSmsAuthenticationTemplate(String code){
        return "尊敬的用户，您的验证码为"+code+"，请在10分钟内使用。如非本人操作，请忽略本信息。"+ MonoConstants.SMS_SIGN+"";
    }

    public static String smsNoticeforChet(String carCode){
        return "尊敬的用户,您的汽车[" + carCode + "]有挪车提示，请及时处理。如您已经处理，请忽略本信息。" +  MonoConstants.SMS_SIGN +"";
    }

}
