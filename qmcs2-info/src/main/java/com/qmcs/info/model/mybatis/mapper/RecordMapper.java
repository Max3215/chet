package com.qmcs.info.model.mybatis.mapper;

import com.qmcs.info.model.mybatis.model.Record;
import com.qmcs.info.model.mybatis.model.RecordCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RecordMapper {
    long countByExample(RecordCriteria example);

    int deleteByExample(RecordCriteria example);

    int deleteByPrimaryKey(Long recordId);

    int insert(Record record);

    int insertSelective(Record record);

    List<Record> selectByExample(RecordCriteria example);

    Record selectByPrimaryKey(Long recordId);

    int updateByExampleSelective(@Param("record") Record record, @Param("example") RecordCriteria example);

    int updateByExample(@Param("record") Record record, @Param("example") RecordCriteria example);

    int updateByPrimaryKeySelective(Record record);

    int updateByPrimaryKey(Record record);

    int insertBatch(@Param("recordColl") java.util.Collection<Record> recordColl);

    int insertBatchSel(@Param("recordColl") java.util.Collection<Record> recordColl);

    Record selectByExampleForOne(RecordCriteria example);

    int updateByPrimaryKeySelectiveVer(Record record);

    int updateByPrimaryKeyVer(Record record);

    List<Record> selectRecordListByUserId(@Param("userId")Long userId,@Param("limitStart")int limitStart ,@Param("pageSize")int pageSize);

    Record selectUserEndOne(@Param("userId")Long userId,@Param("openId")String openId);
}