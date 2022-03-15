package com.example.onlinestoredemo.service;

import com.example.onlinestoredemo.model.entity.User;

import java.util.Map;

/**
 * @ClassName UserService
 * @Description 用户service
 * @Author ZhangJia
 * @Date 2020/9/11
 * @Version 1.0
 **/
public interface UserService {

    /**
     * 根据电话查询用户信息
     * @param phone 用户电话
     * @return com.example.onlinestoredemo.domain.User
     * @Exception
     **/
    User findByPhone(String phone);
    
    /**
     * 新增用户
     * @param userInfo 用户信息
     * @return int
     * @Exception 
     **/
    int saveUser(Map<String, String> userInfo);

    /**
     * 根据电话和密码查询用户信息
     * @param phone 电话
     * @param pwd 密码
     * @return java.lang.String
     * @Exception
     **/
    String findByPhoneAndPwd(String phone, String pwd);

    /**
     * 根据用户ID查询用户信息
     * @param userId 用户ID
     * @return com.example.onlinestoredemo.model.entity.User
     * @Exception
     **/
    User findByUserId(Integer userId);
}
