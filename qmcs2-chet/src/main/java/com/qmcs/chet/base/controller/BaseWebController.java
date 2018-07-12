package com.qmcs.chet.base.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BaseWebController extends BaseController {
	
	/**
	 * 通用异常处理
	 * @param t
	 * @param request
	 * @param response
	 */
	@ExceptionHandler(value = Throwable.class)
	public ModelAndView exceptionHandler(Throwable t, HttpServletRequest request, HttpServletResponse response) {
		
		log.error(t.getMessage(), t);
		
		return super.forwardPage("/error");
	}
}
