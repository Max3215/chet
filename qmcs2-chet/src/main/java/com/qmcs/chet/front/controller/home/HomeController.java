package com.qmcs.chet.front.controller.home;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSON;
import com.qmcs.common.code.Code;
import com.qmcs.common.restful.ReturnAppData;
import com.qmcs.common.util.CommonUtil;
import com.qmcs.info.model.mybatis.model.User;
import com.qmcs.chet.service.token.TokenService;
import com.qmcs.chet.service.user.UserService;
import com.qmcs.chet.util.http.HttpUtil;
import com.qmcs.chet.util.wechat.WecahtConstans;
import com.qmcs.chet.util.wechat.WechatUtil;

import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * com.qmcs.chet.controller.home
 *
 * @auther lb
 * @create 2017/12/20 20:05
 */
@Controller
@Scope("prototype")
public class HomeController {

    @Autowired
    private UserService userService;

    @Autowired
    private TokenService tokenService;

    private static  final transient Logger log = Logger.getLogger(HomeController.class);

    @RequestMapping(value = "/scanCodeSign",method = RequestMethod.POST)
    @ResponseBody
    public String scanCodeSign(){
        String url = "http://chet.qmcs-china.com/";
        log.info("Max---------获取JSSDK签名，页面地址：" + url);
        String nonce_str = WechatUtil.generateUUID();
        Long timestamp = WechatUtil.getCurrentTimestamp();

        String signature = tokenService.getJsSdkSignature(url, nonce_str, timestamp);
        if(CommonUtil.isEmpty(signature))
            return JSON.toJSONString(new ReturnAppData<>(Code.SYS_ERROR));

        Map<String,Object> map = new HashMap<>();
        map.put("appId",WecahtConstans.APPID);
        map.put("signature",signature);
        map.put("timestamp",timestamp);
        map.put("nonceStr",nonce_str);
        log.info("Max--------返回数据：" + map);
        return JSON.toJSONString(new ReturnAppData<Map>(Code.SUCCESS,map));
    }



    /**
     * 微信扫一扫  绑定用
     * @param map
     * @return
     */
    @RequestMapping("/bindCode")
    public String scanQRCode(ModelMap map){
        String url = "http://chet.qmcs-china.com/bindCode";
        log.info("Max---------获取JSSDK签名，页面地址：" + url);

        String nonce_str = WechatUtil.generateUUID();
        Long timestamp = WechatUtil.getCurrentTimestamp();

        String signature = tokenService.getJsSdkSignature(url, nonce_str, timestamp);
        if(CommonUtil.isEmpty(signature))
            return "redirect:/";

//        String redirectUrl = "http://chet.qmcs-china.com/#/carBind";
        map.put("appId",WecahtConstans.APPID);
        map.put("signature",signature);
        map.put("timestamp",timestamp);
        map.put("nonceStr",nonce_str);
//        map.put("redirectUrl", redirectUrl);
        log.info("Max--------返回数据：" + map);
        return "/scanQRCode.jsp";
    }

    /**
     * 微信扫一扫 提醒用
     * @param map
     * @return
     */
    @RequestMapping("/scanCode")
    public String scanCode(String openId,ModelMap map){
        String url = "http://chet.qmcs-china.com/scanCode?openId=" + openId;
        log.info("Max---------获取JSSDK签名，页面地址：" + url);

        String nonce_str = WechatUtil.generateUUID();
        Long timestamp = WechatUtil.getCurrentTimestamp();

        String signature = tokenService.getJsSdkSignature(url, nonce_str, timestamp);
        if(CommonUtil.isEmpty(signature))
            return "redirect:/";

//        String redirectUrl = "http://chet.qmcs-china.com/#/scanResult";
        map.put("appId",WecahtConstans.APPID);
        map.put("signature",signature);
        map.put("timestamp",timestamp);
        map.put("nonceStr",nonce_str);
//        map.put("redirectUrl", redirectUrl);
        map.put("openId", openId);
        log.info("Max--------返回数据：" + map);
        return "/record.jsp";
    }

    @RequestMapping(value = "/home" ,method = RequestMethod.GET)
    public String redirec(HttpServletRequest req, String openId){
        log.info("Max----------进入车贴项目，openId:" +openId);
        String access_token = tokenService.getExpiresToken();
        log.info("Max----------有效access_token:" + access_token);
        String userInfo_param = "access_token=" + access_token + "&openid=" + openId + "&lang=zh_CN";
        JSONObject userInfoResult = HttpUtil.doHttpGet(WecahtConstans.USER_INFO_URL, userInfo_param);
        log.info("Max----------获取用户信息返回信息：" +userInfoResult);
        if (CommonUtil.isNotEmpty(userInfoResult.get("errcode")))
            return "redirect:http://chet.qmcs-china.com/#/handlerResult";

        User user = userService.selectUserByOpenId(openId);
        String nichName  = (String)userInfoResult.get("nickname");
        if (null == user) {
            user = new User();
            user.setUserOpenId(openId);
            user.setUserWxName(nichName);
            user.setUserWxImg((String) userInfoResult.get("headimgurl"));
            
            user.setUserIsBind(0);
            user.setUserIsDelete(false);
            userService.insertUser(user);
        }else{
            user.setUserWxName(nichName);
            user.setUserWxImg((String) userInfoResult.get("headimgurl"));
            userService.updateUser(user);
        }


        return "redirect:http://chet.qmcs-china.com/#/me?openId=" + openId;
    }


}
