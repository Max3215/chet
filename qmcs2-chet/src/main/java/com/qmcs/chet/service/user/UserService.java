package com.qmcs.chet.service.user;

import com.qmcs.common.page.QueryPage;
import com.qmcs.info.model.mybatis.model.User;
import com.qmcs.chet.base.service.BaseService;

import java.util.List;
import java.util.Map;

/**
 * com.qmcs.chet.service.user
 *
 * @auther lb
 * @create 2017/11/3 15:12
 */

public interface UserService extends BaseService {

    /**
     * 查找用户信息
     * @param userId
     * @return
     */
    User queryUserById(final Long userId);

    int updateUser(User user);

    /**
     * 根据二维码查找用户
     * @param code
     * @return
     */
    User selectUserByQrCode(String code);

    /**
     * 根据openID查找用户
     * @param openId
     * @return
     */
    User selectUserByOpenId(String openId);

    int insertUser(User user);

    /**
     * 查询用户列表
     * @param queryPage
     * @param phone
     * @return
     */
    Map<String,Object> selectUserList(QueryPage queryPage,String username, String phone,Integer isBind);
}
