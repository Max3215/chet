package com.qmcs.info.model.mybatis.mapper;

import com.qmcs.info.model.mybatis.model.Token;
import com.qmcs.info.model.mybatis.model.TokenCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TokenMapper {
    long countByExample(TokenCriteria example);

    int deleteByExample(TokenCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(Token record);

    int insertSelective(Token record);

    List<Token> selectByExample(TokenCriteria example);

    Token selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Token record, @Param("example") TokenCriteria example);

    int updateByExample(@Param("record") Token record, @Param("example") TokenCriteria example);

    int updateByPrimaryKeySelective(Token record);

    int updateByPrimaryKey(Token record);

    int insertBatch(@Param("recordColl") java.util.Collection<Token> recordColl);

    int insertBatchSel(@Param("recordColl") java.util.Collection<Token> recordColl);

    Token selectByExampleForOne(TokenCriteria example);

    int updateByPrimaryKeySelectiveVer(Token record);

    int updateByPrimaryKeyVer(Token record);
    
    Token selectEndOne();
    
}