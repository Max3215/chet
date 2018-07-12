package com.qmcs.chet.front.controller.base;

import com.alibaba.fastjson.JSON;
import com.qmcs.info.model.mybatis.model.User;
import com.qmcs.chet.base.exception.AppException;
import com.qmcs.chet.base.exception.PCBusinessException;
import com.qmcs.common.code.Code;
import com.qmcs.common.restful.ReturnAppData;
import com.qmcs.common.util.CommonUtil;
import com.qmcs.common.util.Constants;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/** 公共配置Controller
 * Created by suyl on 2017/8/23.
 */
public class BaseController {

    protected Map<String , Object> map = new HashMap<String,Object>();

    @Autowired
    private HttpServletRequest request;

    private static Log log = LogFactory.getLog(BaseController.class);

    /**
     * 得到Map中的用户信息
     * @return
     */
    public User getSessionUser(){
        return (User) request.getSession().getAttribute(Constants.DEFAULT_USER_INFO_SESSION);
    }

    /**
     * 得到session对象
     * @return
     */
    public HttpSession getSession(){
        return request.getSession();
    }

    /**
     * 通用异常处理
     * @param t
     * @param request
     * @param response
     */
    @ExceptionHandler(value = Throwable.class)
    @ResponseBody
    public String exceptionHandler(Throwable t, HttpServletRequest request, HttpServletResponse response) {
        Map<String, String[]> parameterMap = request.getParameterMap();

        ReturnAppData rd = new ReturnAppData();
        if (t instanceof HttpMessageNotReadableException) {
            rd.setCode(Code.FAIL_OPERATION.getCode());
            rd.setMsg(Code.FAIL_OPERATION.getMsg());
        } else if (t instanceof AppException) {
            if(CommonUtil.isNotEmpty(((AppException) t).getExceptionMsg())){
                rd.setMsg(((AppException) t).getExceptionMsg());
            }else {
                rd.setMsg(Code.FAIL_OPERATION.getMsg());
            }
            rd.setCode(Code.FAIL_OPERATION.getCode());
        }else if( t instanceof PCBusinessException){
            PCBusinessException pcBusinessException = (PCBusinessException)t;
            rd.setCode(pcBusinessException.getCode());
            rd.setMsg(pcBusinessException.getExceptionMsg());
        } else {
            rd.setCode(Code.FAIL_OPERATION.getCode());
            rd.setMsg(Code.FAIL_OPERATION.getMsg());
            log.error(t.getMessage(), t);
        }
        return JSON.toJSONString(rd);
    }

}
