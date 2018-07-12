package com.qmcs.common.code;

/**
 * Created by zhoudu on 2017/5/18.
 *  定义错误码 分为ERROR 和INFO
 *
 *  ERROR 为错误
 *  INFO 为交互提示信息
 *
 *
 */
public enum Code {

    SYS_ERROR(0,"系统错误"),

    SUCCESS(200,"SUCCESS"),

    PARAMETER_SHORTAGE(300,"参数不足"),

    PARAMETER_ERROR(301,"参数错误"),

    CARCODE_ERROR(302,"车牌号已绑定"),

    QRCODE_ERROR(303,"车贴已使用"),

    PATH_ERROR(304,"请求的路径不存在"),

    REQUEST_METHOD_ERROR(305,"请求的HTTP METHOD不支持，请检查是否选择了正确的POST/GET方式"),

    REQUEST_METHOD_GET_ERROR(306,"不是GET请求"),

    DATA_NULL_ERROR(307,"没有数据"),
    QR_CODE_INVALID(308,"无效二维码"),
    USER_IS_BIND(309,"用户已绑定"),
    DATA_NULL_INFO(3305,"数据丢失了"),

    FAIl_SMS(403,"短信发送失败"),

    FAIl_ALIYUNCS(406,"语音提示失败"),

    FAIl_PHONE_CODE(404,"验证码错误"),

    FAIL_LOGOUT(405,"退出系统失败"),

    FAIL_OPERATION(407,"操作失败"),
    NOTICE_ERROR(408,"已发送提醒，请勿频繁操作！"),

    PAY_NUMBER_ERROR(600,"购买数量过少"),

    USER_ACCOUNTS_DISABLED(501,"帐号已禁用"),
    USER_PASSWORD_ERRORD(502,"账号或密码错误"),
    USER_OVERTIME(503,"登录超时，请重新登录"),


    THE_DATE_IS_EMPTY_INFO(13001,"数据库没有数据");




    private int code;
    private String msg;

    Code( int code ,String msg) {
        this.msg = msg;
        this.code = code;
    }


    public String getMsg() {
        return msg;
    }


    public int getCode() {
        return code;
    }


}
