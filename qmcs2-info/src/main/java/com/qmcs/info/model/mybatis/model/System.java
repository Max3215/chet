package com.qmcs.info.model.mybatis.model;

import java.io.Serializable;
import java.util.Date;

public class System implements Serializable {
    private Integer sysId;

    private String sysName;

    private String sysUsername;

    private String sysPassword;

    private Integer sysSex;

    private Integer sysAge;

    private Date sysBirthday;

    private String sysPhone;

    private String sysEmail;

    private Boolean sysIsDeleted;

    private String deptid;

    private String parentid;

    private Date creataDate;

    private static final long serialVersionUID = 1L;

    public Integer getSysId() {
        return sysId;
    }

    public void setSysId(Integer sysId) {
        this.sysId = sysId;
    }

    public String getSysName() {
        return sysName;
    }

    public void setSysName(String sysName) {
        this.sysName = sysName == null ? null : sysName.trim();
    }

    public String getSysUsername() {
        return sysUsername;
    }

    public void setSysUsername(String sysUsername) {
        this.sysUsername = sysUsername == null ? null : sysUsername.trim();
    }

    public String getSysPassword() {
        return sysPassword;
    }

    public void setSysPassword(String sysPassword) {
        this.sysPassword = sysPassword == null ? null : sysPassword.trim();
    }

    public Integer getSysSex() {
        return sysSex;
    }

    public void setSysSex(Integer sysSex) {
        this.sysSex = sysSex;
    }

    public Integer getSysAge() {
        return sysAge;
    }

    public void setSysAge(Integer sysAge) {
        this.sysAge = sysAge;
    }

    public Date getSysBirthday() {
        return sysBirthday;
    }

    public void setSysBirthday(Date sysBirthday) {
        this.sysBirthday = sysBirthday;
    }

    public String getSysPhone() {
        return sysPhone;
    }

    public void setSysPhone(String sysPhone) {
        this.sysPhone = sysPhone == null ? null : sysPhone.trim();
    }

    public String getSysEmail() {
        return sysEmail;
    }

    public void setSysEmail(String sysEmail) {
        this.sysEmail = sysEmail == null ? null : sysEmail.trim();
    }

    public Boolean getSysIsDeleted() {
        return sysIsDeleted;
    }

    public void setSysIsDeleted(Boolean sysIsDeleted) {
        this.sysIsDeleted = sysIsDeleted;
    }

    public String getDeptid() {
        return deptid;
    }

    public void setDeptid(String deptid) {
        this.deptid = deptid == null ? null : deptid.trim();
    }

    public String getParentid() {
        return parentid;
    }

    public void setParentid(String parentid) {
        this.parentid = parentid == null ? null : parentid.trim();
    }

    public Date getCreataDate() {
        return creataDate;
    }

    public void setCreataDate(Date creataDate) {
        this.creataDate = creataDate;
    }
}