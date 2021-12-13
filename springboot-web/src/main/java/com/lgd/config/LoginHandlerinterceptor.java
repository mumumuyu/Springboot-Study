package com.lgd.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginHandlerinterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object username = request.getSession().getAttribute("userLogin");
        if(username == null){
            request.setAttribute("msg","您为非法用户，请登录");
            request.getRequestDispatcher("/index").forward(request,response);
            return false;
        }
        return true;
    }
}
