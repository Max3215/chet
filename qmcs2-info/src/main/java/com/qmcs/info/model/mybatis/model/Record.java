package com.qmcs.info.model.mybatis.model;

import java.io.Serializable;

public class Record implements Serializable {
    private Long recordId;

    private Long recordUserId;

    private String recordCount;

    private Integer recordType;

    private Long recordTime;

    private String recordReturnNo;

    private String recordOpenId;

    private static final long serialVersionUID = 1L;

    public Long getRecordId() {
        return recordId;
    }

    public void setRecordId(Long recordId) {
        this.recordId = recordId;
    }

    public Long getRecordUserId() {
        return recordUserId;
    }

    public void setRecordUserId(Long recordUserId) {
        this.recordUserId = recordUserId;
    }

    public String getRecordCount() {
        return recordCount;
    }

    public void setRecordCount(String recordCount) {
        this.recordCount = recordCount == null ? null : recordCount.trim();
    }

    public Integer getRecordType() {
        return recordType;
    }

    public void setRecordType(Integer recordType) {
        this.recordType = recordType;
    }

    public Long getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(Long recordTime) {
        this.recordTime = recordTime;
    }

    public String getRecordReturnNo() {
        return recordReturnNo;
    }

    public void setRecordReturnNo(String recordReturnNo) {
        this.recordReturnNo = recordReturnNo == null ? null : recordReturnNo.trim();
    }

    public String getRecordOpenId() {
        return recordOpenId;
    }

    public void setRecordOpenId(String recordOpenId) {
        this.recordOpenId = recordOpenId == null ? null : recordOpenId.trim();
    }
}