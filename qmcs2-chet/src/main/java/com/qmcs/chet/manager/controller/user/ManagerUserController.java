package com.qmcs.chet.manager.controller.user;

import com.alibaba.fastjson.JSON;
import com.qmcs.chet.service.user.UserService;
import com.qmcs.common.code.Code;
import com.qmcs.common.page.QueryPage;
import com.qmcs.common.restful.ReturnAppData;
import com.qmcs.common.util.CommonUtil;
import com.qmcs.info.model.mybatis.model.System;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * com.qmcs.chet.manager.controller.user
 *
 * @auther lb
 * @create 2018/3/29 16:50
 */
@Controller
@Scope("prototype")
@RequestMapping(value = "/manager",produces = "text/html;charset=UTF-8",method = RequestMethod.POST)
public class ManagerUserController {

    @Autowired
    private UserService userService;

    /**
     * 用户列表
     * @param request
     * @param page
     * @param size
     * @param username
     * @param phone
     * @param isBind
     * @return
     */
    @RequestMapping("/userList")
    @ResponseBody
    public String userList(HttpServletRequest request,Integer page,Integer size,String username,String phone,Integer isBind){
        System system = (System)request.getSession().getAttribute("SYSTEM");
        if(CommonUtil.isEmpty(system))
            return JSON.toJSONString(new ReturnAppData<>(Code.USER_OVERTIME));

        if(CommonUtil.isEmpty(page))
            page = 1;

        if(CommonUtil.isEmpty(size))
            size = 20;

        QueryPage queryPage = new QueryPage();
        queryPage.setTargetPage(page);
        queryPage.setPageSize(size);

        Map<String, Object> resultMap = userService.selectUserList(queryPage, username, phone, isBind);
        return JSON.toJSONString(new ReturnAppData<Map>(Code.SUCCESS,resultMap));
    }

}
