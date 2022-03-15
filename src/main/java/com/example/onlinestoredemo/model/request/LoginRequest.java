package com.example.onlinestoredemo.model.request;

import lombok.Data;

/**
 * @ClassName LoginRequest
 * @Description 登录 Request
 * @Author ZhangJia
 * @Date 2020/9/11
 * @Version 1.0
 **/
@Data
public class LoginRequest {

    private String phone;

    private String pwd;
}
