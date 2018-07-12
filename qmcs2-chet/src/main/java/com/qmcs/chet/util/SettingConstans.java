package com.qmcs.chet.util;

import com.qmcs.common.util.DateUtil;

import java.util.Date;

/**
 * com.qmcs.chet.util
 *
 * @auther 公司常量
 * @create 2017/12/22 16:30
 */
public interface SettingConstans {

    /**
     * 寄件人姓名
     */
    String SENDERNAME = "重庆标远科技发展有限公司";

    /**
     * 寄件人电话
     */
    String SENDERTEL = "4006607997 ";

    /**
     * 寄件人区域ID
     */
    Integer SENDAREAID = 500103010;

    /**
     * 寄件人地址
     */
    String SENDADDR = "重庆市|重庆|渝中区|解放碑街道|新华路388号创汇·首座|九楼907";

    /**
     * 经度
     */
    Double SENDING = 106.577805;

    /**
     * 纬度
     */
    Double SENDLAT = 29.553872;

    /**
     * 文件尺寸
     */
    Integer GOODSSIZE = 20;

    /**
     * 重量
     */
    Integer GOODSWEIGHT = 5;

    /**
     * 文件类型
     */
    Integer GOODSTYPE = 1;

    /**
     * 取件时间 当前时间3小时候
     */
    Long REQUIREDTIME = DateUtil.changeHours(new Date(),3).getTime();

    /**
     * 起购数量
     */
    Integer MIXNUMBER = 5;

    /**
     * 单个数量
     */
    Double PRICE = 1.0;


}
