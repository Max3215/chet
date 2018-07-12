package com.qmcs.sms.constants;

/**
 * 旧短信公共变量
 * Created by hh on 2017/5/26.
 */
public class MonoConstants {

    /**
     * 短信路径
     */
    public static String SMS_HTTP_URL = "http://sms.cqmono.cn/api/MsgSend.asmx";

    /**
     * 登录名称
     */
    public static String SMS_USER_CODE = "cqby";

    /**
     * 登录密码
     */
    public static String SMS_USER_PASS = "cqby_123";

    /**
     * 留空即可，兼容用的
     */
    public static String SMS_CHANNAL = "channal";

    /**
     * 签名
     */
    public static String SMS_SIGN = "【全民传送】";


    /**
     * 余额查询
     */
    public static String SMS_GETBALANCE = "/GetBalance";

    /**
     * 短信发送
     */
    public static String SMS_SENDMSG = "/SendMsg";

    public static String SMS_CODE = "utf-8";

}
