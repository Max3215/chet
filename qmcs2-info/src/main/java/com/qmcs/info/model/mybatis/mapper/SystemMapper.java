package com.qmcs.info.model.mybatis.mapper;

import com.qmcs.info.model.mybatis.model.System;
import com.qmcs.info.model.mybatis.model.SystemCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SystemMapper {
    long countByExample(SystemCriteria example);

    int deleteByExample(SystemCriteria example);

    int deleteByPrimaryKey(Integer sysId);

    int insert(System record);

    int insertSelective(System record);

    List<System> selectByExample(SystemCriteria example);

    System selectByPrimaryKey(Integer sysId);

    int updateByExampleSelective(@Param("record") System record, @Param("example") SystemCriteria example);

    int updateByExample(@Param("record") System record, @Param("example") SystemCriteria example);

    int updateByPrimaryKeySelective(System record);

    int updateByPrimaryKey(System record);

    int insertBatch(@Param("recordColl") java.util.Collection<System> recordColl);

    int insertBatchSel(@Param("recordColl") java.util.Collection<System> recordColl);

    System selectByExampleForOne(SystemCriteria example);

    int updateByPrimaryKeySelectiveVer(System record);

    int updateByPrimaryKeyVer(System record);

    /**
     * 登录名查找
     * @param username
     * @return
     */
    System selectByUsername(@Param("username") String username);
    System selectByUsernameAndIdNot(@Param("username") String username,@Param("sysId")Integer id);
}