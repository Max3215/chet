package com.qmcs.chet.front.controller.wechat;

import com.alibaba.fastjson.JSON;
import com.qmcs.common.code.Code;
import com.qmcs.common.restful.ReturnAppData;
import com.qmcs.common.util.CommonUtil;
import com.qmcs.chet.service.token.TokenService;
import com.qmcs.chet.util.http.HttpUtil;
import com.qmcs.chet.util.wechat.WecahtConstans;
import com.qmcs.chet.util.wechat.WechatUtil;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

/**
 * com.qmcs.chet.controller.wx
 *
 * @auther lb
 * @create 2017/12/20 15:46
 */
@Controller
public class WxJsSdkController {

    private static  final transient Logger log = Logger.getLogger(WxJsSdkController.class);

    @Autowired
    private TokenService tokenService;


    @RequestMapping("/getSignature")
    @ResponseBody
    public String wxJSADK(String url){
        log.info("Max---------获取JSSDK签名，页面地址：" + url);
        if(CommonUtil.isEmpty(url))
            return JSON.toJSONString(new ReturnAppData<>(Code.PARAMETER_SHORTAGE));

        String access_token = tokenService.getExpiresToken();
        if(CommonUtil.isEmpty(access_token))
            return JSON.toJSONString(new ReturnAppData<>(Code.SYS_ERROR.getCode(),"获取授权签名失败"));

        String param = "access_token=" + access_token + "&type=jsapi";
        JSONObject result = HttpUtil.doHttpGet(WecahtConstans.JSAPI_TICKET_URL, param);
        if(CommonUtil.isEmpty(result) || CommonUtil.isEmpty(result.get("ticket")))
            return JSON.toJSONString(new ReturnAppData<>(Code.SYS_ERROR.getCode(),"获取授权签名失败"));

        String ticket = (String) result.get("ticket");
        String nonce_str = WechatUtil.generateUUID();
        Long timestamp = WechatUtil.getCurrentTimestamp();
        String signature = "";

        //注意这里参数名必须全部小写，且必须有序
        String signStr = "jsapi_ticket=" + ticket +
                "&noncestr=" + nonce_str +
                "&timestamp=" + timestamp +
                "&url=" + url;
        log.info("Max---------签名数据：" + signStr);
        try{
            MessageDigest crypt = MessageDigest.getInstance("SHA-1");
            crypt.reset();
            crypt.update(signStr.getBytes("UTF-8"));
            signature = WechatUtil.byteToHex(crypt.digest());
        }catch (NoSuchAlgorithmException e){
            e.printStackTrace();
            return JSON.toJSONString(new ReturnAppData<>(Code.SYS_ERROR.getCode(),"获取授权签名失败"));
        }catch (UnsupportedEncodingException e){
            e.printStackTrace();
            return JSON.toJSONString(new ReturnAppData<>(Code.SYS_ERROR.getCode(),"获取授权签名失败"));
        }

        Map<String,Object> map = new HashMap<>();
        map.put("appId",WecahtConstans.APPID);
        map.put("signature",signature);
        map.put("timestamp",timestamp);
        map.put("nonceStr",nonce_str);
        log.info("Max--------返回数据：" + map);
        return JSON.toJSONString(new ReturnAppData<Map>(Code.SUCCESS,map));
    }



}
