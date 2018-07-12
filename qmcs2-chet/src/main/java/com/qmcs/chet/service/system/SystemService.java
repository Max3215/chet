package com.qmcs.chet.service.system;

import com.qmcs.info.model.mybatis.model.System;

/**
 * com.qmcs.chet.service.system
 *  后端管理员
 * @auther lb
 * @create 2018/3/29 14:36
 */
public interface SystemService {

    /**
     * 添加
     * @param system
     * @return
     */
    int insertSystem(System system);

    /**
     * 用户名查询
     * @param username
     * @return
     */
    System selectSystemByUsername(String username);

    /**
     * 修改信息
     * @param system
     * @return
     */
    int updateSystem(System system);


    System selectUsernameAndIdNot(String username,Integer id);
    System selectById(Integer id);


}
