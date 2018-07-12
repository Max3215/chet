package com.qmcs.chet.service.impl.payment;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qmcs.common.code.Code;
import com.qmcs.common.util.CommonUtil;
import com.qmcs.common.util.DateUtil;
import com.qmcs.info.model.mybatis.mapper.OrderMapper;
import com.qmcs.info.model.mybatis.mapper.PayResultMapper;
import com.qmcs.info.model.mybatis.model.Order;
import com.qmcs.info.model.mybatis.model.PayResult;
import com.qmcs.chet.service.payment.PaymentService;
import com.qmcs.chet.util.http.HttpUtil;
import com.qmcs.chet.util.wechat.WeChatCallback;
import com.qmcs.chet.util.wechat.WecahtConstans;
import com.wxpay.sdk.WXPayUtil;

import net.sf.json.JSONObject;
/**
 * com.qmcs.chet.service.payment
 *
 * @auther lb
 * @create 2017/12/25 14:38
 */
@Service
public class PaymentServiceImpl implements PaymentService {
	
	@Autowired
	private OrderMapper ordermapper;

	@Autowired
	private PayResultMapper payResultMapper;

	@Override
	public boolean signVerification(WeChatCallback callbackData) {
		String sign = callbackData.getSign(); //保存回调给出的签名
		Map<String,String> signMap = new HashMap<>();
		String signVerification = "";
        signMap.put("appid", WecahtConstans.APPID);
        signMap.put("mch_id", WecahtConstans.MCHID);
        try {
        	signVerification = WXPayUtil.generateSignature(signMap, WecahtConstans.KEY);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
        
		return false;
	}

	@Override
	public boolean updateOrderStatus(WeChatCallback callbackData) {
		String orderNo = callbackData.getOut_trade_no();
		Order order = ordermapper.selectByOrderNo(orderNo);
		if(CommonUtil.isEmpty(order))
			return false;

		String param = "orderNo="+orderNo;
		JSONObject jsonObject = HttpUtil.doHttpPost(WecahtConstans.UPDATE_QMCS_STATUS_URL, param);
		if(Code.SUCCESS.getCode() != Integer.parseInt((String)jsonObject.get("code")))
			return false;
		
	
		PayResult payResult = new PayResult();
		payResult.setOpenId(callbackData.getOpenid());
		payResult.setOrderNo(orderNo);
		payResult.setQmcsNo(orderNo);
//		payResult.setPrepayId(prepayId);
		payResult.setTransactionNo(callbackData.getTransaction_id());
		payResult.setPayTime( DateUtil.parseDate3(callbackData.getTime_end()));
		payResult.setPayStatus(1);
		payResult.setOrderPrice(yuanTransformationCent((String)callbackData.getTotal_fee()));
		payResult.setPayPrice(new BigDecimal(callbackData.getCash_fee()));
		payResult.setPayDiscount(CommonUtil.isEmpty(callbackData.getCoupon_fee())?0:Integer.valueOf(callbackData.getCoupon_fee()));
		payResult.setBankType(callbackData.getBank_type());
		payResult.setCreateTime(new Date());
		
		payResultMapper.insertSelective(payResult);
		// 修改订单状态
		order.setOrderStatus(1);
		ordermapper.updateByPrimaryKeySelective(order);
		
		return true;
	}

	private static BigDecimal yuanTransformationCent(String moeny){
		BigDecimal moenyBigDecimal = new BigDecimal(moeny);
		return moenyBigDecimal;
	}

}
