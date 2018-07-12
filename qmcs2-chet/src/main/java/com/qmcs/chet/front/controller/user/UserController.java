package com.qmcs.chet.front.controller.user;

import com.alibaba.fastjson.JSON;
import com.qmcs.common.code.Code;
import com.qmcs.common.restful.ReturnAppData;
import com.qmcs.common.util.CommonUtil;
import com.qmcs.info.model.mybatis.model.User;
import com.qmcs.chet.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * com.qmcs.chet.controller.user
 *
 * @auther lb
 * @create 2017/12/21 16:26
 */
@Controller
@Scope("prototype")
@RequestMapping(value = "/user",produces = "text/html;charset=UTF-8",method = RequestMethod.POST)
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 个人信息
     * @param openId
     * @return
     */
    @RequestMapping("/getDetail")
    @ResponseBody
    public String userDetail(String openId){
        if(CommonUtil.isEmpty(openId)) {
            return JSON.toJSONString(new ReturnAppData<>(Code.PARAMETER_SHORTAGE));
        }
        User user = userService.selectUserByOpenId(openId);
        if (CommonUtil.isEmpty(user))
            return JSON.toJSONString(new ReturnAppData<>(Code.DATA_NULL_ERROR));

        return JSON.toJSONString(new ReturnAppData<User>(Code.SUCCESS,user));
    }

    /**
     * 修改个人信息
     * @param openId
     * @param userName
     * @param carCode
     * @param telphone
     * @return
     */
    @RequestMapping("/editCarCode")
    @ResponseBody
    public String editCarCode(String openId,String userName,String carCode,String telphone){
        String msg = check(openId,userName,carCode,telphone);
        if(null != msg)
            return  msg;

        User user = userService.selectUserByOpenId(openId);
        if (null == user)
            return JSON.toJSONString(new ReturnAppData<>(Code.DATA_NULL_ERROR));

        user.setUserCarCode(carCode);
        user.setUserName(userName);
        user.setUserTelphone(telphone);
//        user.setUserIsBind(0);
        userService.updateUser(user);
        return JSON.toJSONString(new ReturnAppData<>(Code.SUCCESS));
    }

    /**
     * 二维码验证
     * @param qrCode
     * @return
     */
    @RequestMapping("/checkCode")
    @ResponseBody
    public String checkCode(String qrCode,String openId){
        if (CommonUtil.isEmpty(qrCode))
            return JSON.toJSONString(new ReturnAppData<>(Code.QR_CODE_INVALID));

        User user = userService.selectUserByQrCode(qrCode);
        if(CommonUtil.isEmpty(user))
            return JSON.toJSONString(new ReturnAppData<>(Code.SUCCESS));

        User openUser = userService.selectUserByOpenId(openId);
        if (null == openUser)
            return JSON.toJSONString(new ReturnAppData<>(Code.DATA_NULL_ERROR));

        if(user.getUserId() != openUser.getUserId())
            return JSON.toJSONString(new ReturnAppData<>(Code.QRCODE_ERROR));

        return JSON.toJSONString(new ReturnAppData<User>(Code.SUCCESS));
    }

    /**
     * 绑定信息
     * @param openId
     * @param userName
     * @param carCode
     * @param telphone
     * @return
     */
    @RequestMapping("/bind")
    @ResponseBody
    public String bindCarCode(String openId,String userName,String carCode,String telphone,String qrCode){
        String msg = check(openId,userName,carCode,telphone,qrCode);
        if(null != msg)
            return  msg;

        User user = userService.selectUserByOpenId(openId);
        if (null == user)
            return JSON.toJSONString(new ReturnAppData<>(Code.DATA_NULL_ERROR));

        User qrUser = userService.selectUserByQrCode(qrCode);
        if(null != qrUser && qrUser.getUserId() != user.getUserId())
            return JSON.toJSONString(new ReturnAppData<>(Code.QRCODE_ERROR));

        user.setUserCarCode(carCode);
        user.setUserName(userName);
        user.setUserTelphone(telphone);

        user.setUserQrCode(qrCode);
        user.setUserIsBind(1);
        userService.updateUser(user);
        return JSON.toJSONString(new ReturnAppData<>(Code.SUCCESS));
    }

    /**
     * 参数检查
     * @param openId
     * @param userName
     * @param carCode
     * @param telphone
     * @return
     */
    private String check(String openId, String userName, String carCode, String telphone,String qrCode) {
        if(CommonUtil.isEmpty(openId))
            return JSON.toJSONString(new ReturnAppData<>(Code.PARAMETER_SHORTAGE));
        if(CommonUtil.isEmpty(userName))
            return JSON.toJSONString(new ReturnAppData<>(Code.PARAMETER_SHORTAGE));
        if(CommonUtil.isEmpty(carCode))
            return JSON.toJSONString(new ReturnAppData<>(Code.PARAMETER_SHORTAGE));
        if(CommonUtil.isEmpty(telphone))
            return JSON.toJSONString(new ReturnAppData<>(Code.PARAMETER_SHORTAGE));
        if(CommonUtil.isEmpty(qrCode))
            return JSON.toJSONString(new ReturnAppData<>(Code.PARAMETER_SHORTAGE));
        if(qrCode.length() != 15 || !qrCode.contains("NCT")){
            return JSON.toJSONString(new ReturnAppData<>(Code.PARAMETER_SHORTAGE));
        }
        return null;
    }
    private String check(String openId, String userName, String carCode, String telphone) {
        if(CommonUtil.isEmpty(openId))
            return JSON.toJSONString(new ReturnAppData<>(Code.PARAMETER_SHORTAGE));
        if(CommonUtil.isEmpty(userName))
            return JSON.toJSONString(new ReturnAppData<>(Code.PARAMETER_SHORTAGE));
        if(CommonUtil.isEmpty(carCode))
            return JSON.toJSONString(new ReturnAppData<>(Code.PARAMETER_SHORTAGE));
        if(CommonUtil.isEmpty(telphone))
            return JSON.toJSONString(new ReturnAppData<>(Code.PARAMETER_SHORTAGE));

        return null;
    }


}
