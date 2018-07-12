package com.qmcs.chet.service.impl.user;

import com.qmcs.common.page.QueryPage;
import com.qmcs.info.model.mybatis.mapper.UserMapper;
import com.qmcs.info.model.mybatis.model.User;
import com.qmcs.chet.service.user.UserService;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * com.qmcs.chet.service.impl.user
 *
 * @auther Administrator
 * @create 2017/11/3 15:13
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserMapper userMapper;

    @Override
    public User queryUserById(Long userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public User selectUserByQrCode(String code) {
        return userMapper.selectByCode(code);
    }

    @Override
    public User selectUserByOpenId(String openId) {
        return userMapper.selectByOpenId(openId);
    }

    @Override
    public int insertUser(User user) {
        return userMapper.insertSelective(user);
    }

    @Override
    public Map<String, Object> selectUserList(QueryPage queryPage, String username, String phone,Integer isBind) {
        Map<String, Object> resultMap = new HashedMap();
        Integer countUser = userMapper.selectCountUser(username, phone, isBind);
        queryPage.setRecordCount(countUser);
        resultMap.put("queryPage",queryPage);
        List<User> userList = null;
        if(countUser > 0) {
            userList = userMapper.selectUserList(queryPage.getLimitStart(),queryPage.getLimitEnd(),username, phone, isBind);
        }
        resultMap.put("userList",userList);
        return resultMap;
    }

    @Override
    public Object exe(String cmd, Object obj) {
        return null;
    }

}
