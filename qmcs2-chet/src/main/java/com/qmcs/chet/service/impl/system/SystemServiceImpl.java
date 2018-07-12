package com.qmcs.chet.service.impl.system;

import com.qmcs.chet.service.system.SystemService;
import com.qmcs.info.model.mybatis.mapper.SystemMapper;
import com.qmcs.info.model.mybatis.model.System;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * com.qmcs.chet.service.impl.system
 *
 * @auther lb
 * @create 2018/3/29 15:41
 */
@Service
public class SystemServiceImpl implements SystemService{


    @Autowired
    private SystemMapper systemMapper;

    @Override
    public int insertSystem(System system) {
        return systemMapper.insertSelective(system);
    }

    @Override
    public System selectSystemByUsername(String username) {
        return systemMapper.selectByUsername(username);
    }

    @Override
    public int updateSystem(System system) {
        return systemMapper.updateByPrimaryKeySelective(system);
    }

    @Override
    public System selectUsernameAndIdNot(String username, Integer id) {
        return systemMapper.selectByUsernameAndIdNot(username,id);
    }

    @Override
    public System selectById(Integer id) {
        return systemMapper.selectByPrimaryKey(id);
    }
}
