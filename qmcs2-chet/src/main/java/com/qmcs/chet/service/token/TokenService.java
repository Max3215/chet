package com.qmcs.chet.service.token;

import com.qmcs.info.model.mybatis.model.Token;
import com.qmcs.info.model.mybatis.model.User;

/**
 * com.qmcs.chet.service.token
 *
 * @auther lb
 * @create 2017/12/21 17:19
 */
public interface TokenService {

    /**
     * 保存token
     * @param token
     * @return
     */
    int insertToken(Token token);

    /**
     * 获取有效Token
     * @return
     */
    String getExpiresToken();

    /**
     * 获取ticket
     * @return
     */
    String getJsApiTicket();

    /**
     * 获取JSSDK签名
     * @param url
     * @param nonce_str
     * @param timestamp
     * @return
     */
    String getJsSdkSignature(String url,String nonce_str,Long timestamp);

    /**
     * 公众号推送挪车信息
     * @param user
     * @return
     */
    String sendWxMessage(User user);

}
