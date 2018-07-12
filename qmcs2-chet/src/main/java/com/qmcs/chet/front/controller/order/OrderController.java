package com.qmcs.chet.front.controller.order;

import com.alibaba.fastjson.JSON;
import com.qmcs.common.code.Code;
import com.qmcs.common.restful.ReturnAppData;
import com.qmcs.common.util.ArithUtil;
import com.qmcs.common.util.CommonUtil;
import com.qmcs.info.model.mybatis.model.Order;
import com.qmcs.info.model.mybatis.model.User;
import com.qmcs.chet.service.order.OrderService;
import com.qmcs.chet.service.user.UserService;
import com.qmcs.chet.util.http.HttpUtil;
import com.qmcs.chet.util.SettingConstans;
import com.qmcs.chet.util.wechat.WecahtConstans;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;

/**
 * com.qmcs.chet.controller.order
 *
 * @auther lb
 * @create 2017/12/22 15:41
 */

@Controller
@Scope("prototype")
@RequestMapping(value = "/order",produces = "text/html;charset=UTF-8",method = RequestMethod.POST)
public class OrderController {
  

    @Autowired
    private UserService userService;

    @Autowired
    private OrderService orderService;


    @RequestMapping("/getFee")
    @ResponseBody
    public String orderFee(){

        String param = "weight=5&distance=3";
        JSONObject jsonObject = HttpUtil.doHttpPost(WecahtConstans.ORDER_FEE_URL, param);
        System.err.println(jsonObject);

        return JSON.toJSONString(new ReturnAppData<>(Code.SUCCESS));
    }


    /**
     * 申请车贴
     * @param username
     * @param telphone
     * @param address
     * @param qmcsNo
     * @param price
     * @param postPrice
     * @param openId
     * @param number
     * @return
     */
    @RequestMapping("/createOrder")
    @ResponseBody
    public String createOrder(final String username,final String telphone,
                              final String address,String qmcsNo,double price,double postPrice, 
                              String openId,Integer number){

        String msg = check(username,telphone,address,qmcsNo,price,postPrice,openId,number);
        if(null != msg)
            return msg;

        User user = userService.selectUserByOpenId(openId);
        if (CommonUtil.isEmpty(user))
            return JSON.toJSONString(new ReturnAppData<>(Code.DATA_NULL_ERROR));

        Order order = new Order();
        order.setOrderOpenId(openId);
        order.setOrderUserId(user.getUserId());
        order.setOrderNumber(number);
        order.setOrderStatus(0);
        order.setOrderUserName(username);
        order.setOrderAddress(address);
        order.setOrderUserTelphone(telphone);
        order.setOrderNo(qmcsNo);
        order.setOrderGoodsPrice(new BigDecimal(price));
        order.setOrderPostPrice(new BigDecimal(postPrice));
        order.setOrderTotalPrice(new BigDecimal(ArithUtil.add(price,postPrice)));
        order.setOrderQmcsNo(qmcsNo);
        orderService.insertOrder(order);

        return JSON.toJSONString(new ReturnAppData<Order>(Code.SUCCESS,order));
    }


    private String check(String username, String telphone, String address, String qmcsNo, double price, double postPrice, String openId, Integer number) {
        if (CommonUtil.isEmpty(username))
            return JSON.toJSONString(new ReturnAppData(Code.PARAMETER_SHORTAGE));
        if (CommonUtil.isEmpty(telphone))
            return JSON.toJSONString(new ReturnAppData(Code.PARAMETER_SHORTAGE));
        if (CommonUtil.isEmpty(address))
            return JSON.toJSONString(new ReturnAppData(Code.PARAMETER_SHORTAGE));
        if (CommonUtil.isEmpty(qmcsNo))
            return JSON.toJSONString(new ReturnAppData(Code.PARAMETER_SHORTAGE));
        if (price <= 0)
            return JSON.toJSONString(new ReturnAppData(Code.PARAMETER_SHORTAGE));
        if (postPrice <= 0)
            return JSON.toJSONString(new ReturnAppData(Code.PARAMETER_SHORTAGE));
        if (CommonUtil.isEmpty(openId))
            return JSON.toJSONString(new ReturnAppData(Code.PARAMETER_SHORTAGE));
        if (CommonUtil.isEmpty(number))
            return JSON.toJSONString(new ReturnAppData(Code.PARAMETER_SHORTAGE));
        if (number < SettingConstans.MIXNUMBER)
            return JSON.toJSONString(new ReturnAppData(Code.PAY_NUMBER_ERROR));

        return null;
    }



}
