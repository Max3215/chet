package com.qmcs.common.restful;


import java.io.Serializable;

/**
 * Title  :街道
 * Create : 2017/5/25
 * Author ：chen
 */

public class Street implements Serializable {

    private int areaCode;
    private String areaName;
    private int areaParentCode;
    private int areaType;

    public Street(int areaCode, String areaName, int areaParentCode, int areaType) {
        this.areaCode = areaCode;
        this.areaName = areaName;
        this.areaParentCode = areaParentCode;
        this.areaType = areaType;
    }

    public int getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(int areaCode) {
        this.areaCode = areaCode;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public int getAreaParentCode() {
        return areaParentCode;
    }

    public void setAreaParentCode(int areaParentCode) {
        this.areaParentCode = areaParentCode;
    }

    public int getAreaType() {
        return areaType;
    }

    public void setAreaType(int areaType) {
        this.areaType = areaType;
    }

}
