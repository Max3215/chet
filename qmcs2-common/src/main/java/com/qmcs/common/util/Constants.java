package com.qmcs.common.util;

/**
 * 系统常量定义
 */
public interface Constants {

    /**
     * 默认的用户信息
     */
    String DEFAULT_USER_INFO_SESSION = "userinfo_session";

    /**
     * 用户商家信息
     */
    String USER_BUSINESS_SESSION = "suer_business_session";

    /**
     * 默认的用户菜单
     */
    String DEFAULT_USER_MENU_SESSION = "menus";

    /**
     * 默认过期时间 Session 存储键
     */
    String DEFAULT_EXPIRED_TIME_SESSION = "expired_time_session";

    /**
     * 默认过期时间为 30分钟
     */
    Long DEFAULT_EXPIRED_TIME = 1000 * 60 * 60 * 1L;

    /**
     * 开通区域
     */
    String OPEN_AREA = "open_area";

    /**
     * 系统设置
     */
    String SETTING = "qmcs_setting";

    /**
     * 地区管理版本号
     */
    String OPEN_AREA_VERSION = "version";

    /**
     * 最大距离  30km
     */
    Integer maxDistance = 30;

    /**
     * 最大重量 20 kg
     */
    Integer maxGoodsWeight = 20;

}
