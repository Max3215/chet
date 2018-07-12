package com.qmcs.chet.service.order;

import com.qmcs.info.model.mybatis.model.Order;

/**
 * com.qmcs.chet.service.order
 *
 * @auther lb
 * @create 2017/12/22 18:19
 */
public interface OrderService {


    int insertOrder(Order order);

    Order selectOrder(Long orderId);
    
    Order selectByOrderNo(String orderNo);
    
    int updateOrder(Order order);
}
