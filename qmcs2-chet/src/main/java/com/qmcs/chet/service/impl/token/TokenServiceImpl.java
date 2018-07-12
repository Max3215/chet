package com.qmcs.chet.service.impl.token;

import com.qmcs.common.util.CommonUtil;
import com.qmcs.common.util.DateUtil;
import com.qmcs.info.model.mybatis.mapper.TokenMapper;
import com.qmcs.info.model.mybatis.model.Token;
import com.qmcs.info.model.mybatis.model.User;
import com.qmcs.chet.service.token.TokenService;
import com.qmcs.chet.util.http.HttpUtil;
import com.qmcs.chet.util.wechat.WecahtConstans;
import com.qmcs.chet.util.wechat.WechatUtil;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;


/**
 * com.qmcs.chet.service.impl.token
 *
 * @auther lb
 * @create 2017/12/21 17:21
 */
@Service
public class TokenServiceImpl implements TokenService{

    private static final String URL = "https://api.chet.qq.com/cgi-bin/message/template/send?access_token="; // 推送接口地址

    @Autowired
    private TokenMapper tokenMapper;

    private static  final transient Logger log = Logger.getLogger(TokenServiceImpl.class);

    @Override
    public int insertToken(Token token) {
        return tokenMapper.insert(token);
    }

    @Override
    public String getExpiresToken() {
        Token token = tokenMapper.selectEndOne();
        if (CommonUtil.isEmpty(token)) {
            return getAccessToken();
        }
        // 判断token有效性
        long time = token.getCreatetime().getTime();
        long nowtime = new Date().getTime();

        if((nowtime - time)/1000 > 7100)
            return getAccessToken();

        return token.getAccessToken();
    }

    @Override
    public String getJsApiTicket() {
        // 获取一个有效的access_token
        String access_token = getExpiresToken();
        if(CommonUtil.isEmpty(access_token))
            return null;

        String param = "access_token=" + access_token + "&type=jsapi";
        JSONObject result = HttpUtil.doHttpGet(WecahtConstans.JSAPI_TICKET_URL, param);
        if(CommonUtil.isEmpty(result) || CommonUtil.isEmpty(result.get("ticket")))
            return null;

        return (String) result.get("ticket");
    }

    @Override
    public String getJsSdkSignature(String url,String nonce_str,Long timestamp) {
        String ticket = getJsApiTicket();
        if(CommonUtil.isEmpty(ticket))
            return null;

        String signature = "";
        //注意这里参数名必须全部小写，且必须有序
        String signStr = "jsapi_ticket=" + ticket +
                "&noncestr=" + nonce_str +
                "&timestamp=" + timestamp +
                "&url=" + url;
        try{
            MessageDigest crypt = MessageDigest.getInstance("SHA-1");
            crypt.reset();
            crypt.update(signStr.getBytes("UTF-8"));
            signature = WechatUtil.byteToHex(crypt.digest());
        }catch (NoSuchAlgorithmException e){
            e.printStackTrace();
            return null;
        }catch (UnsupportedEncodingException e){
            e.printStackTrace();
            return null;
        }
        return signature;
    }

    @Override
    public String sendWxMessage(User user) {

        String token = getExpiresToken();
        JSONObject json=new JSONObject();
        JSONObject text=new JSONObject();
        JSONObject keyword1=new JSONObject();
        JSONObject keyword2=new JSONObject();
        JSONObject keyword3=new JSONObject();
        JSONObject first=new JSONObject();
        JSONObject remark=new JSONObject();
        json.put("touser",user.getUserOpenId());
        json.put("template_id","L4R-sKDMho_15TIjCRf9CCulk4p3HeED64mYcTj7soQ"); // 模板ID  公众号-模板信息-我的模板查看
        first.put("value",user.getUserCarCode() + "车友，有车主着急的发起挪车请求，请挪挪您的爱车吧！");
        keyword1.put("value",user.getUserCarCode() );
//        keyword2.put("value","重庆市" );
        keyword3.put("value", DateUtil.formatDate(new Date()));
        remark.put("value", "客服热线：400-660-7997，祝您生活愉快。");
        text.put("keyword1", keyword1);
        text.put("keyword2", keyword2);
        text.put("keyword3", keyword3);
        text.put("first", first);
        text.put("remark",remark);
        json.put("data", text);
        return HttpUtil.sendPostJSON(URL + token, json.toString());
    }


    /**
     * 获取新的access_token
     * @return
     */
    public String getAccessToken() {
        String param = "grant_type=client_credential&appid=" + WecahtConstans.APPID + "&secret=" + WecahtConstans.APPSECRET;
        JSONObject result = HttpUtil.doHttpGet(WecahtConstans.ACCESS_TOKEN_URL, param);
        log.info("Max----------获取access_token返回：" + result.toString());
        if(CommonUtil.isEmpty(result) || CommonUtil.isEmpty(result.get("access_token")))
            return null;
        String access_token = (String) result.get("access_token");
        Token token = new Token();
        token.setAccessToken(access_token);
        token.setExpiresIn((Integer)result.get("expires_in"));
        token.setCreatetime(new Date());
        tokenMapper.insert(token);
        return access_token;
    }
}
