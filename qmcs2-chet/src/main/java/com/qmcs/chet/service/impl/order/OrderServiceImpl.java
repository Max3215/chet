package com.qmcs.chet.service.impl.order;

import com.qmcs.info.model.mybatis.mapper.OrderMapper;
import com.qmcs.info.model.mybatis.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qmcs.chet.service.order.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderMapper orderMapper;


	@Override
	public int insertOrder(Order order) {
		return orderMapper.insertSelective(order);
	}

	@Override
	public Order selectOrder(Long orderId) {
		return orderMapper.selectByPrimaryKey(orderId);
	}

	@Override
	public Order selectByOrderNo(String orderNo) {
		return orderMapper.selectByOrderNo(orderNo);
	}

	@Override
	public int updateOrder(Order order) {
		return orderMapper.updateByPrimaryKeySelective(order);
	}
}
