package com.qmcs.common.OSSupload;

/**
 * Created by CC on 2017/6/12.
 * 阿里云OSS使用到的静态常量
 * chenchao
 */
public class AliyunOSSConstant {

    /**
     *  WEB端
     * 直传的AccesskeyS测试获得拥有权限如下:
     * 1.直接上传文件
     * 2.获取图片路径
     */
    //=============================直传的AccesskeyS=================================
    //阿里云OSS的API的外网域名
    //public static final String ENDPOINT = "oss-cn-beijing.aliyuncs.com";
    //阿里云OSS的API的密钥Access Key ID
    //public static final String ACCESS_KEY_ID = "LTAIu8K8tbU0Q3gr";
    //阿里云OSS的API的密钥Access Key Secret
    //public static final String ACCESS_KEY_SECRET = "uMe0Sw2v9YXV57qzSTMVuiv7qInzjK";
    //==============================================================================


    /**
     * APP端
     * STS授权的AccesskeyS测试获得拥有权限如下:
     */
    //=============================STS授权的AccesskeyS===============================
    //阿里云OSS的API的外网域名
    //public static final String STS_ENDPOINT = "http://oss-cn-beijing.aliyuncs.com";
    public static final String STS_ENDPOINT = "http://oss.qmcs-china.com";
    //阿里云OSS的API的密钥Access Key ID
    public static final String STS_ACCESS_KEY_ID = "";
    //阿里云OSS的API的密钥Access Key Secret
    public static final String STS_ACCESS_KEY_SECRET = "";
    //===============================================================================

    /**
     * 阿里云OSS的API的bucket名称
     */
    //======================阿里云OSS的API的bucket名称=================================
    //bucket
    public static final String BACKET_NAME = "qmcsimg";
    //================================================================================

    /**
     * 顶级目录
     */
    //=======================================================

    //线上测试
    public static final String TOP = "top/";

    //=======================================================


    /**
     * 模块存放路径
     * 没有的自己加
     */
    //===============================模块文件存放路径==================================
    //------------------------------一级目录------------------------------------------
   

    /**
     * STS授权参数
     */
    //=================================其他参数=======================================
    //RoleArn 需要在 RAM 控制台上获取 用来控制读写操作
    //写操作
    public static final String ROLEARN_WRITE = "";
    //读操作
    public static final String ROLEARN_READ = "";
    //临时凭证的时间控制(S:秒) -- 图片上传的临时授权时间为900(s) * 2 = 30分钟
    public static final Integer DURATION_SECONDS_UPLOAD = 900 * 2;
    //临时凭证的时间控制(S:秒) -- 图片展示的临时授权时间为900(s) * 2 = 30分钟
    public static final Integer DURATION_SECONDS_IMAGESLIST = 900 * 2;
    //===============================================================================

    /**
     * 回调接口参数
     */
    //===============================================================================

    //回调获取的参数格式
    public static final String CALLBACKBODY = "{\"bucket\":${bucket},\"object\":${object},\"mimeType\":${mimeType},\"size\":${size}}";
    //===============================================================================




}
