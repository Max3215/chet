package com.qmcs.info.model.mybatis.mapper;

import com.qmcs.info.model.mybatis.model.Order;
import com.qmcs.info.model.mybatis.model.OrderCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderMapper {
    long countByExample(OrderCriteria example);

    int deleteByExample(OrderCriteria example);

    int deleteByPrimaryKey(Long orderId);

    int insert(Order record);

    int insertSelective(Order record);

    List<Order> selectByExample(OrderCriteria example);

    Order selectByPrimaryKey(Long orderId);

    int updateByExampleSelective(@Param("record") Order record, @Param("example") OrderCriteria example);

    int updateByExample(@Param("record") Order record, @Param("example") OrderCriteria example);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    int insertBatch(@Param("recordColl") java.util.Collection<Order> recordColl);

    int insertBatchSel(@Param("recordColl") java.util.Collection<Order> recordColl);

    Order selectByExampleForOne(OrderCriteria example);

    int updateByPrimaryKeySelectiveVer(Order record);

    int updateByPrimaryKeyVer(Order record);
    
    Order selectByOrderNo(String orderNo);
}