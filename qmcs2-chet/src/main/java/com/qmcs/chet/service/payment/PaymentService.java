package com.qmcs.chet.service.payment;

import com.qmcs.chet.util.wechat.WeChatCallback;

/**
 * com.qmcs.chet.service.payment
 *
 * @auther lb
 * @create 2017/12/25 11:32
 */

public interface PaymentService {

    boolean signVerification(WeChatCallback callbackData);

    boolean updateOrderStatus(WeChatCallback callbackData);

}
