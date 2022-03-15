package com.example.onlinestoredemo.interceptor;

import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName CorsInterceptor
 * @Description 跨域访问设置
 * @Author ZhangJia
 * @Date 2020/9/18
 * @Version 1.0
 **/
public class CorsInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //表示接受任意域名的请求,也可以指定域名
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("origin"));
        //该字段可选，是个布尔值，表示是否可以携带cookie
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Methods", "GET, HEAD, POST, PUT, PATCH, DELETE, OPTIONS");
        response.setHeader("Access-Control-Allow-Headers", "*");
        if (HttpMethod.OPTIONS.toString().equals(request.getMethod())) {
            return true;
        }
        return true;
    }
}
