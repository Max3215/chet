package com.qmcs.common.OSSupload;

/**
 * Created by CC on 2017/6/12.
 * chenchao
 * STS临时授权参数对象
 */
public class AliyunOSSVO {

    private String bucketName;//上传bucketName
    private String accessKeyId;//临时授权KeyId
    private String accessKeySecret;//临时授权KeySecret
    private String securityToken;//临时授权Token
    private String expiration;//过期时间
    private String endpoint;//访问地址
    private String saveDirectory;//存储对象名称
    private String callbackUrl;//回调RUL
    private String callbackBody;//回调格式

    public AliyunOSSVO() {
    }

    public AliyunOSSVO(String bucketName, String accessKeyId, String accessKeySecret, String securityToken, String expiration, String endpoint, String saveDirectory, String callbackUrl, String callbackBody) {
        this.bucketName = bucketName;
        this.accessKeyId = accessKeyId;
        this.accessKeySecret = accessKeySecret;
        this.securityToken = securityToken;
        this.expiration = expiration;
        this.endpoint = endpoint;
        this.saveDirectory = saveDirectory;
        this.callbackUrl = callbackUrl;
        this.callbackBody = callbackBody;
    }

    public String getBucketName() {
        return bucketName;
    }

    public void setBucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    public String getAccessKeyId() {
        return accessKeyId;
    }

    public void setAccessKeyId(String accessKeyId) {
        this.accessKeyId = accessKeyId;
    }

    public String getAccessKeySecret() {
        return accessKeySecret;
    }

    public void setAccessKeySecret(String accessKeySecret) {
        this.accessKeySecret = accessKeySecret;
    }

    public String getSecurityToken() {
        return securityToken;
    }

    public void setSecurityToken(String securityToken) {
        this.securityToken = securityToken;
    }

    public String getExpiration() {
        return expiration;
    }

    public void setExpiration(String expiration) {
        this.expiration = expiration;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getSaveDirectory() {
        return saveDirectory;
    }

    public void setSaveDirectory(String saveDirectory) {
        this.saveDirectory = saveDirectory;
    }

    public String getCallbackUrl() {
        return callbackUrl;
    }

    public void setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
    }

    public String getCallbackBody() {
        return callbackBody;
    }

    public void setCallbackBody(String callbackBody) {
        this.callbackBody = callbackBody;
    }
}



