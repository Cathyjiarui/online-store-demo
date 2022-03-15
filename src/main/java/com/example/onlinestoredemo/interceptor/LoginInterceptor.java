package com.example.onlinestoredemo.interceptor;

import com.example.onlinestoredemo.utils.JsonData;
import com.example.onlinestoredemo.utils.JwtUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @ClassName LoginInterceptor
 * @Description 登录拦截类
 * @Author ZhangJia
 * @Date 2020/9/11
 * @Version 1.0
 **/
public class LoginInterceptor implements HandlerInterceptor {

    /**
     * 进入到controller之前的方法
     * @param request 请求
     * @param response 响应
     * @param handler 项目
     * @return boolean
     * @Exception 
     **/
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        try {
            String accessToken = request.getHeader("token");
            if (accessToken == null) {
                accessToken = request.getParameter("token");
            }
            if(StringUtils.isNotBlank(accessToken)){
                Claims claims = JwtUtils.checkJwt(accessToken);
                if (claims == null) {
                    //提示登录过期
                    sendJsonMessage(response, JsonData.buildError("登录过期，请重新登录"));
                    return false;
                }
                Integer id = (Integer) claims.get("id");
                String name = (String) claims.get("name");
                request.setAttribute("user_id", id);
                request.setAttribute("name", name);
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        sendJsonMessage(response,JsonData.buildError("登录过期，请重新登录"));
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

    /**
     * 响应json数据给前端
     * @param response 数据
     * @param obj 响应JsonData
     * @return void
     * @Exception 
     **/
    public static void sendJsonMessage(HttpServletResponse response, Object obj){
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            response.setContentType("application/json; charset=utf-8");
            PrintWriter printWriter = response.getWriter();
            printWriter.print(objectMapper.writeValueAsString(obj));
            printWriter.close();
            response.flushBuffer();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
