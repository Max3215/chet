package com.qmcs.chet.util.wechat;

/**
 * com.qmcs.chet.util.wechat
 *
 * @auther lb
 * @create 2017/12/22 12:55
 */
public interface WecahtConstans {

    String APPID = "";

    String MCHID = "";

    String KEY = "";

    String APPSECRET = "";

    String TRADE_TYPE_JSAPI = "JSAPI";

    String SPBILL_CREATE_IP = "139.224.56.244";

    String BODY = "全民传送微信订单";

    String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token"; // 获取access_token

    String USER_INFO_URL = "https://api.weixin.qq.com/cgi-bin/user/info";  // 获取用户基本信息

    String OPEN_ID_URL = "https://api.weixin.qq.com/sns/oauth2/access_token"; // 获取OpenID

    String JSAPI_TICKET_URL = "https://api.weixin.qq.com/cgi-bin/ticket/getticket"; // 获取jsapi_ticket

    String ORDER_FEE_URL = "http://wxpublic.qmcs-china.com/qmcs2-weixin/order/getPrice"; // 获取邮费价格
    
//    String UPDATE_QMCS_STATUS_URL = "http://wxpublic.qmcs-china.com/qmcs2-weixin/order/editstatus";
    
    String UPDATE_QMCS_STATUS_URL = "http://192.168.0.128:8888/wx/order/editstatus";
    

    String NOTIFY_URL ="http://chet.qmcs-china.com/order"; // 支付回调地址



}
