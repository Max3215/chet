package com.qmcs.info.model.mybatis.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class Order implements Serializable {
    private Long orderId;

    private String orderNo;

    private Long orderUserId;

    private String orderOpenId;

    private Integer orderNumber;

    private Integer orderStatus;

    private BigDecimal orderGoodsPrice;

    private BigDecimal orderTotalPrice;

    private BigDecimal orderPostPrice;

    private String orderUserName;

    private String orderUserTelphone;

    private String orderAddress;

    private String orderQmcsNo;

    private String orderRemark;

    private static final long serialVersionUID = 1L;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    public Long getOrderUserId() {
        return orderUserId;
    }

    public void setOrderUserId(Long orderUserId) {
        this.orderUserId = orderUserId;
    }

    public String getOrderOpenId() {
        return orderOpenId;
    }

    public void setOrderOpenId(String orderOpenId) {
        this.orderOpenId = orderOpenId == null ? null : orderOpenId.trim();
    }

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public BigDecimal getOrderGoodsPrice() {
        return orderGoodsPrice;
    }

    public void setOrderGoodsPrice(BigDecimal orderGoodsPrice) {
        this.orderGoodsPrice = orderGoodsPrice;
    }

    public BigDecimal getOrderTotalPrice() {
        return orderTotalPrice;
    }

    public void setOrderTotalPrice(BigDecimal orderTotalPrice) {
        this.orderTotalPrice = orderTotalPrice;
    }

    public BigDecimal getOrderPostPrice() {
        return orderPostPrice;
    }

    public void setOrderPostPrice(BigDecimal orderPostPrice) {
        this.orderPostPrice = orderPostPrice;
    }

    public String getOrderUserName() {
        return orderUserName;
    }

    public void setOrderUserName(String orderUserName) {
        this.orderUserName = orderUserName == null ? null : orderUserName.trim();
    }

    public String getOrderUserTelphone() {
        return orderUserTelphone;
    }

    public void setOrderUserTelphone(String orderUserTelphone) {
        this.orderUserTelphone = orderUserTelphone == null ? null : orderUserTelphone.trim();
    }

    public String getOrderAddress() {
        return orderAddress;
    }

    public void setOrderAddress(String orderAddress) {
        this.orderAddress = orderAddress == null ? null : orderAddress.trim();
    }

    public String getOrderQmcsNo() {
        return orderQmcsNo;
    }

    public void setOrderQmcsNo(String orderQmcsNo) {
        this.orderQmcsNo = orderQmcsNo == null ? null : orderQmcsNo.trim();
    }

    public String getOrderRemark() {
        return orderRemark;
    }

    public void setOrderRemark(String orderRemark) {
        this.orderRemark = orderRemark == null ? null : orderRemark.trim();
    }
}