package com.qmcs.chet.front.controller.payment;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.qmcs.common.code.Code;
import com.qmcs.common.restful.ReturnAppData;
import com.qmcs.common.util.CommonUtil;
import com.qmcs.info.model.mybatis.model.Order;
import com.qmcs.chet.service.order.OrderService;
import com.qmcs.chet.service.payment.PaymentService;
import com.qmcs.chet.util.wechat.WeChatCallback;
import com.qmcs.chet.util.wechat.WecahtConstans;
import com.qmcs.chet.util.wechat.WechatUtil;
import com.wxpay.sdk.WXPay;
import com.wxpay.sdk.WXPayConfigImpl;
import com.wxpay.sdk.WXPayConstants;
import com.wxpay.sdk.WXPayUtil;

/**
 * com.qmcs.chet.controller.payment
 *
 * @auther lb
 * @create 2017/12/25 11:47
 */
@Controller
@Scope("prototype")
@RequestMapping(value = "/payment")
public class PaymentController {
	
	private static  final transient Logger log = Logger.getLogger(PaymentController.class);
	
	@Autowired
	private OrderService orderService;

	@Autowired
    private PaymentService paymentService;
	
	@RequestMapping(value = "/dopay",method = RequestMethod.POST)
    @ResponseBody
    public String payment(Long orderId) throws Exception {
        if(CommonUtil.isEmpty(orderId)){
            return JSON.toJSONString(new ReturnAppData<String>(Code.PARAMETER_SHORTAGE.getCode(),"订单ID不能为空"));
        }
        Order order = orderService.selectOrder(orderId);
        if(CommonUtil.isEmpty(order))
            return JSON.toJSONString(new ReturnAppData<String>(Code.PARAMETER_ERROR.getCode(),"该订单不存在,请验证订单ID"));

        if(1 == order.getOrderStatus())
            return JSON.toJSONString(new ReturnAppData<String>(Code.PARAMETER_ERROR.getCode(),"该订单已支付无需重复下单"));

        String nonce_str =  WXPayUtil.generateNonceStr();
        String notify_url = WecahtConstans.NOTIFY_URL;
        String total_fee = WechatUtil.yuanTransformationCent(order.getOrderTotalPrice());

        Map<String,String> signMap = new HashMap<>();
        signMap.put("appid", WecahtConstans.APPID);
        signMap.put("body", WecahtConstans.BODY);
        signMap.put("mch_id", WecahtConstans.MCHID);
        signMap.put("nonce_str",nonce_str);
        signMap.put("openid", order.getOrderOpenId());
        signMap.put("out_trade_no", order.getOrderNo());
        signMap.put("total_fee",total_fee);
        signMap.put("spbill_create_ip", WecahtConstans.SPBILL_CREATE_IP);
        signMap.put("notify_url", notify_url);
        signMap.put("trade_type", WecahtConstans.TRADE_TYPE_JSAPI);

        String sign = WXPayUtil.generateSignature(signMap, WecahtConstans.KEY);
        signMap.put("sign",sign);
        log.info("Max-----统一下单发送数据：" + signMap);
        WXPayConfigImpl config = WXPayConfigImpl.getInstance();
        WXPay wxPay = new WXPay(config,notify_url,true,false);
        Map<String, String> returnMap = wxPay.unifiedOrder(signMap);

        log.info("Max------统一下单返回数据:" + returnMap);
        if(!WXPayConstants.SUCCESS.equals(returnMap.get("return_code"))){
            return JSON.toJSONString(new ReturnAppData<String>(Code.SYS_ERROR.getCode(),"系统异常.微信订单生成失败.尝试重新下单"));
        }

        String prepay_id = returnMap.get("prepay_id"); // 预支付ID
        Map<String,String> resultSignMap = new HashMap<>();
        String noncestr = WXPayUtil.generateNonceStr();
        String timestamp = String.valueOf(WXPayUtil.getCurrentTimestamp());
        resultSignMap.put("appId", WecahtConstans.APPID);
        resultSignMap.put("package","prepay_id=" + prepay_id);
        resultSignMap.put("signType","MD5");
        resultSignMap.put("timeStamp",timestamp);
        resultSignMap.put("nonceStr",noncestr);

        log.info("Max------返回前端签名数据:" + resultSignMap);
        String resultSign = WXPayUtil.generateSignature(resultSignMap, WecahtConstans.KEY);
        resultSignMap.put("sign",resultSign);
        log.info("Max------返回前端数据：" + resultSignMap);

        return JSON.toJSONString(new ReturnAppData<Map>(Code.SUCCESS,resultSignMap));
    }
	
	@RequestMapping(value = "/result",produces="text/xml;charset=UTF-8")
	@ResponseBody
	public String payResult(HttpServletRequest request){
        WeChatCallback callbackData = WechatUtil.getWeChatCallbackData(request);
        if(CommonUtil.isEmpty(callbackData))
            return WechatUtil.getFailInformation();

        String orderNo = callbackData.getOut_trade_no();
        Order order = orderService.selectByOrderNo(orderNo);
        if (CommonUtil.isEmpty(order))
        	return WechatUtil.getFailInformation();
        
        // 返回状态码 与 业务结果同时成功则表明交易成功
        if(!"SUCCESS".equals(callbackData.getResult_code()) && !"SUCCESS".equals(callbackData.getReturn_code())){
        	return WechatUtil.getFailInformation();
		}

        boolean b = paymentService.updateOrderStatus(callbackData);
        if (b)
            return WechatUtil.getSuccessInformation();

        return WechatUtil.getFailInformation();
    }
	
	
}
