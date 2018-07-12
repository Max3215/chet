package com.qmcs.info.model.mybatis.mapper;

import com.qmcs.info.model.mybatis.model.User;
import com.qmcs.info.model.mybatis.model.UserCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    long countByExample(UserCriteria example);

    int deleteByExample(UserCriteria example);

    int deleteByPrimaryKey(Long userId);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserCriteria example);

    User selectByPrimaryKey(Long userId);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserCriteria example);

    int updateByExample(@Param("record") User record, @Param("example") UserCriteria example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    int insertBatch(@Param("recordColl") java.util.Collection<User> recordColl);

    int insertBatchSel(@Param("recordColl") java.util.Collection<User> recordColl);

    User selectByExampleForOne(UserCriteria example);

    int updateByPrimaryKeySelectiveVer(User record);

    int updateByPrimaryKeyVer(User record);
    
    User selectByCode(String userQrCode);
    
    User selectByOpenId(String userOpenId);

    Integer selectCountUser(@Param("userName") String userName, @Param("phone") String phone,@Param("isBind") Integer isBind);
    List<User> selectUserList(@Param("limitStart") Integer limitStart,@Param("limitEnd") Integer limitEnd,@Param("userName") String userName, @Param("phone") String phone,@Param("isBind") Integer isBind);
}