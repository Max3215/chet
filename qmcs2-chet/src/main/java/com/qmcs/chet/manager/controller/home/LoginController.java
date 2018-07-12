package com.qmcs.chet.manager.controller.home;

import com.alibaba.fastjson.JSON;
import com.qmcs.chet.service.system.SystemService;
import com.qmcs.common.code.Code;
import com.qmcs.common.restful.ReturnAppData;
import com.qmcs.common.util.CommonUtil;
import com.qmcs.common.util.security.AES128CBC;
import com.qmcs.common.util.security.MD5;
import com.qmcs.info.model.mybatis.model.System;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * com.qmcs.chet.manager.controller.home
 *
 * @auther lb
 * @create 2018/3/29 14:32
 */
@Controller
@Scope("prototype")
@RequestMapping(value = "/manager",produces = "text/html;charset=UTF-8",method = RequestMethod.POST)
public class LoginController {

    @Autowired
    private SystemService systemService;

    /**
     * 登录
     * @param username
     * @param password
     * @return
     */
    @RequestMapping("/login")
    @ResponseBody
    public String login(HttpServletRequest request,String username, String password){
        if(CommonUtil.isEmpty(username))
            return JSON.toJSONString(new ReturnAppData<>(Code.PARAMETER_SHORTAGE.getCode(),"请输入账号！"));
        if(CommonUtil.isEmpty(password))
            return JSON.toJSONString(new ReturnAppData<>(Code.PARAMETER_SHORTAGE.getCode(),"请输入密码！"));

        System system = systemService.selectSystemByUsername(username);
        if(CommonUtil.isEmpty(system))
            return JSON.toJSONString(new ReturnAppData<>(Code.USER_PASSWORD_ERRORD));

        //加密：AES+MD5
        String aesPwd = null;
        try {
            aesPwd = AES128CBC.Encrypt(password, "0001000300050007");
        } catch (Exception e) {
            e.printStackTrace();
        }
        String md5Pwd = MD5.encode(aesPwd);
        if(!system.getSysPassword().equals(DigestUtils.md5Hex(password))){
            if(!system.getSysPassword().equals(md5Pwd)){
                return JSON.toJSONString(new ReturnAppData<>(Code.USER_PASSWORD_ERRORD));
            }
        }

        HttpSession session = request.getSession();
        session.setAttribute("SYSTEM",system);

        return JSON.toJSONString(new ReturnAppData<>(Code.SUCCESS,system));
    }

    /**
     * 添加
     * @param name
     * @param username
     * @param password
     * @param sex
     * @param age
     * @param birthday
     * @param telphone
     * @param email
     * @return
     */
    @RequestMapping("/addSystem")
    @ResponseBody
    public String addSystem(String name, String username, String password, Integer sex, Integer age, Date birthday,String telphone,String email){
        if(CommonUtil.isEmpty(username) || CommonUtil.isEmpty(password))
            return JSON.toJSONString(new ReturnAppData<>(Code.PARAMETER_SHORTAGE,"账号或密码不能为空"));

        System system = systemService.selectSystemByUsername(username);
        if (CommonUtil.isNotEmpty(system))
            return JSON.toJSONString(new ReturnAppData<>(Code.FAIL_OPERATION.getCode(),"账号已存在"));

        String aesPwd = null;
        try {
            aesPwd = AES128CBC.Encrypt(password, "0001000300050007");
        } catch (Exception e) {
            e.printStackTrace();
        }
        system = new System();
        system.setSysName(name);
        system.setSysUsername(username);
        system.setSysPassword(MD5.encode(aesPwd));
        system.setSysSex(sex);
        system.setSysAge(age);
        system.setSysBirthday(birthday);
        system.setSysPhone(telphone);
        system.setSysEmail(email);
        system.setSysIsDeleted(false);

        systemService.insertSystem(system);

        return JSON.toJSONString(new ReturnAppData<>(Code.SUCCESS));
    }

    /**
     * 修改
     * @param id
     * @param name
     * @param username
     * @param password
     * @param sex
     * @param age
     * @param birthday
     * @param telphone
     * @param email
     * @param isdelete
     * @return
     */
    @RequestMapping("/ehitSystem")
    @ResponseBody
    public String ehitSystem(Integer id,String name, String username, String password, Integer sex, Integer age, Date birthday,String telphone,String email,boolean isdelete){
        if(CommonUtil.isEmpty(username) || CommonUtil.isEmpty(password))
            return JSON.toJSONString(new ReturnAppData<>(Code.PARAMETER_SHORTAGE,"账号或密码不能为空"));

        System otherSystem = systemService.selectUsernameAndIdNot(username,id);
        if (CommonUtil.isNotEmpty(otherSystem))
            return JSON.toJSONString(new ReturnAppData<>(Code.FAIL_OPERATION.getCode(),"账号已存在"));

        System system = systemService.selectById(id);
        if(CommonUtil.isEmpty(system))
            return JSON.toJSONString(new ReturnAppData<>(Code.FAIL_OPERATION.getCode(),"查询账号异常"));

        String aesPwd = null;
        try {
            aesPwd = AES128CBC.Encrypt(password, "0001000300050007");
        } catch (Exception e) {
            e.printStackTrace();
        }
        system.setSysName(name);
        system.setSysUsername(username);
        system.setSysPassword(MD5.encode(aesPwd));
        system.setSysSex(sex);
        system.setSysAge(age);
        system.setSysBirthday(birthday);
        system.setSysPhone(telphone);
        system.setSysEmail(email);
        system.setSysIsDeleted(isdelete);

        systemService.updateSystem(system);

        return JSON.toJSONString(new ReturnAppData<>(Code.SUCCESS));
    }


    /**
     * 退出登录
     * @param request
     * @return
     */
    @RequestMapping("/logout")
    @ResponseBody
    public String logout(HttpServletRequest request){
        request.getSession().removeAttribute("SYSTEM");
        return JSON.toJSONString(new ReturnAppData<>(Code.SUCCESS));
    }


}
