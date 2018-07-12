package com.qmcs.common.util;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;

import org.apache.shiro.subject.Subject;

/**
 * 得到shiro的session
 * Created by suyl on 2017/5/24.
 */
public class ShiroSessionUtils {

    public static Session getShiroSession(){
        Subject subject = SecurityUtils.getSubject();
        System.out.println("Session默认超时时间为[" + subject.getSession().getTimeout() + "]毫秒");
        return subject.getSession();
    }
}
