package com.qmcs.info.model.mybatis.model;

import java.io.Serializable;

public class User implements Serializable {
    private Long userId;

    private String userName;

    private String userOpenId;

    private String userTelphone;

    private String userCarCode;

    private String userQrCode;

    private Boolean userIsDelete;

    private String userRamark;

    private String userWxName;

    private String userWxImg;

    private Integer userIsBind;

    private static final long serialVersionUID = 1L;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserOpenId() {
        return userOpenId;
    }

    public void setUserOpenId(String userOpenId) {
        this.userOpenId = userOpenId == null ? null : userOpenId.trim();
    }

    public String getUserTelphone() {
        return userTelphone;
    }

    public void setUserTelphone(String userTelphone) {
        this.userTelphone = userTelphone == null ? null : userTelphone.trim();
    }

    public String getUserCarCode() {
        return userCarCode;
    }

    public void setUserCarCode(String userCarCode) {
        this.userCarCode = userCarCode == null ? null : userCarCode.trim();
    }

    public String getUserQrCode() {
        return userQrCode;
    }

    public void setUserQrCode(String userQrCode) {
        this.userQrCode = userQrCode == null ? null : userQrCode.trim();
    }

    public Boolean getUserIsDelete() {
        return userIsDelete;
    }

    public void setUserIsDelete(Boolean userIsDelete) {
        this.userIsDelete = userIsDelete;
    }

    public String getUserRamark() {
        return userRamark;
    }

    public void setUserRamark(String userRamark) {
        this.userRamark = userRamark == null ? null : userRamark.trim();
    }

    public String getUserWxName() {
        return userWxName;
    }

    public void setUserWxName(String userWxName) {
        this.userWxName = userWxName == null ? null : userWxName.trim();
    }

    public String getUserWxImg() {
        return userWxImg;
    }

    public void setUserWxImg(String userWxImg) {
        this.userWxImg = userWxImg == null ? null : userWxImg.trim();
    }

    public Integer getUserIsBind() {
        return userIsBind;
    }

    public void setUserIsBind(Integer userIsBind) {
        this.userIsBind = userIsBind;
    }
}