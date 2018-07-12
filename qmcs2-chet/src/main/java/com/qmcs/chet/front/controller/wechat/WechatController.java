package com.qmcs.chet.front.controller.wechat;

import com.alibaba.fastjson.JSON;
import com.qmcs.common.code.Code;
import com.qmcs.common.restful.ReturnAppData;
import com.qmcs.common.util.CommonUtil;
import com.qmcs.info.model.mybatis.model.User;
import com.qmcs.chet.service.token.TokenService;
import com.qmcs.chet.service.user.UserService;
import com.qmcs.chet.util.http.HttpUtil;
import com.qmcs.chet.util.wechat.WeChatCallback;
import com.qmcs.chet.util.wechat.WecahtConstans;
import com.qmcs.chet.util.wechat.WechatUtil;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * com.qmcs.chet.controller.wechat
 *
 * @auther Administrator
 * @create 2017/12/22 10:57
 */
@Controller
@Scope("prototype")
@RequestMapping(value = "/wecaht")
public class WechatController {

    private static  final transient Logger log = Logger.getLogger(WechatController.class);

    private static  final  String token = "11VUDBJor1yGUEk75Bos37U8SFY2nl";

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UserService userService;

    @RequestMapping("/notice")
    @ResponseBody
    public String wxNotice(HttpServletRequest request){

        log.info("Max--------微信消息推送通知");
        log.info("Max----------微信推送信息：" + request.getParameterMap());
        WeChatCallback weChatCallback = WechatUtil.getWeChatCallbackData(request);

        log.info("Max--------微信推送消息：" + weChatCallback.toString());
        String openId = weChatCallback.getFromUserName();
        User user = userService.selectUserByOpenId(openId);
        if (null == user) {
            String access_token = tokenService.getExpiresToken();
            String param = "?access_token=" + access_token + "&openid=" + openId + "&lang=zh_CN";
            JSONObject result = HttpUtil.doHttpGet(WecahtConstans.USER_INFO_URL, param);
            if (CommonUtil.isEmpty(result) || CommonUtil.isEmpty(result.get("access_token")))
                return JSON.toJSONString(new ReturnAppData<>(Code.PARAMETER_ERROR.getCode(), "获取用户信息失败"));

            user = new User();
            user.setUserWxName((String) result.get("nickname"));
            user.setUserWxImg((String) result.get("headimgurl"));
            user.setUserOpenId(openId);
            user.setUserIsBind(0);
            user.setUserIsDelete(false);
            userService.insertUser(user);
        }

        return "";
    }

}
