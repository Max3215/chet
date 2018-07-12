package com.qmcs.chet.interceptor;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * pc商家用户登录拦截
 * Created by suyl on 2017/8/23.
 */
public class AppLoginInterceptor extends HandlerInterceptorAdapter {

    private List<String> includeAppUrls;

    public List<String> getIncludeAppUrls() {
        return includeAppUrls;
    }

    public void setIncludeAppUrls(List<String> excludeAppUrls) {
        this.includeAppUrls = excludeAppUrls;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        // /下面这句话不要动，就这样放着。你在处理你的业务逻辑之后，spring会将你的请求和响应继续往容器传或者往客户端进行传递
        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
