package com.qmcs.info.model.mybatis.mapper;

import com.qmcs.info.model.mybatis.model.PayResult;
import com.qmcs.info.model.mybatis.model.PayResultCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PayResultMapper {
    long countByExample(PayResultCriteria example);

    int deleteByExample(PayResultCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(PayResult record);

    int insertSelective(PayResult record);

    List<PayResult> selectByExample(PayResultCriteria example);

    PayResult selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PayResult record, @Param("example") PayResultCriteria example);

    int updateByExample(@Param("record") PayResult record, @Param("example") PayResultCriteria example);

    int updateByPrimaryKeySelective(PayResult record);

    int updateByPrimaryKey(PayResult record);

    int insertBatch(@Param("recordColl") java.util.Collection<PayResult> recordColl);

    int insertBatchSel(@Param("recordColl") java.util.Collection<PayResult> recordColl);

    PayResult selectByExampleForOne(PayResultCriteria example);

    int updateByPrimaryKeySelectiveVer(PayResult record);

    int updateByPrimaryKeyVer(PayResult record);
}