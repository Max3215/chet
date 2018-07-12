package com.qmcs.chet.base.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class BaseController {
	
	protected static Log log = LogFactory.getLog(BaseController.class);
	
	protected HttpServletRequest request = null;
	
	protected HttpServletResponse response = null;
	
	/**
	 * 绑定参数前缀
	 * @param binder
	 */
	@InitBinder("queryPage")    
    public void initBinderQueryPage(WebDataBinder binder) {    
		binder.setFieldDefaultPrefix("queryPage.");    
    }
	
	/**
	 * 注入请求
	 * @param request
	 * @param response
	 */
	@ModelAttribute
	protected void setReqAndRes(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) {
		this.request = request;
		this.response = response;
		
		String base = request.getContextPath();
		modelMap.addAttribute("base", base);
	}
	
	/**
	 * 获取当前session
	 * @return 返回session
	 */
	protected HttpSession getSession() {
		return request.getSession();
	}
	
	/**
	 * 获取某个session值列表
	 * @param key 需要获取的session
	 * @return
	 */
	protected Object getAttribute(String key) {
		HttpSession session = getSession();
		return session.getAttribute(key);
	}
	
	/**
	 * 设置session值
	 * @param key 需要获取的session
	 */
	protected void setAttribute(String key, Object obj) {
		HttpSession session = getSession();
		session.setAttribute(key, obj);
	}
	
	/**
	 * 删除session值
	 * @param key 需要删除的session KEY
	 */
	protected void removeAttribute(String key) {
		HttpSession session = getSession();
		session.removeAttribute(key);
	}
	
	/**
	 * 生成 ModelandView  供返回页面 
	 * @param page
	 * @return
	 */
	protected ModelAndView forwardPage(String page) {
		return new ModelAndView(page);
	}
}
