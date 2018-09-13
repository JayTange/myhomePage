package com.wargod.interceptor;

import com.wargod.util.Commons;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 页面拦截器
 *
 * @author tangj
 */
@Component
public class BaseInterceptor implements HandlerInterceptor{

    @Autowired
    private Commons commons;

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        request.setAttribute("commons", commons);
    }
}
