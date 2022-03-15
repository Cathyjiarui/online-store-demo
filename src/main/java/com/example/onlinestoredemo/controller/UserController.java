package com.example.onlinestoredemo.controller;

import com.example.onlinestoredemo.model.entity.User;
import com.example.onlinestoredemo.model.request.LoginRequest;
import com.example.onlinestoredemo.service.UserService;
import com.example.onlinestoredemo.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @ClassName UserController
 * @Description 用户服务
 * @Author ZhangJia
 * @Date 2020/9/11
 * @Version 1.0
 **/
@RestController
@RequestMapping("api/v1/pri/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 注册接口
     * @param userInfo 用户注册信息
     * @return com.example.onlinestoredemo.utils.JsonData
     * @Exception
     **/
    @PostMapping("register")
    public JsonData register(@RequestBody Map<String, String> userInfo){
        int rows = userService.saveUser(userInfo);
        return rows == 1 ? JsonData.buildSuccess() : JsonData.buildError("注册失败");
    }

    /**
     * 登录接口
     * @param loginRequest 用户登录信息
     * @return com.example.onlinestoredemo.utils.JsonData
     * @Exception
     **/
    @PostMapping("login")
    public JsonData login(@RequestBody LoginRequest loginRequest){
        String token = userService.findByPhoneAndPwd(loginRequest.getPhone(),loginRequest.getPwd());
        return token == null ? JsonData.buildError("登录失败") : JsonData.buildSuccess(token);
    }

    /**
     * 根据用户ID查询用户信息
     * @param request 请求信息
     * @return com.example.onlinestoredemo.utils.JsonData
     * @Exception
     **/
    @GetMapping("find_by_token")
    public JsonData findUserByToken(HttpServletRequest request) {
        Integer userId = (Integer) request.getAttribute("user_id");
        if (userId == null) {
            return JsonData.buildError("查询失败");
        }
        User user = userService.findByUserId(userId);
        return JsonData.buildSuccess(user);
    }
}
