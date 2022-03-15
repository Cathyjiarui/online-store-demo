package com.example.onlinestoredemo.mapper;

import com.example.onlinestoredemo.model.entity.User;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName UserMapper
 * @Description 用户
 * @Author ZhangJia
 * @Date 2020/9/11
 * @Version 1.0
 **/
public interface UserMapper {

    /**
     * 根据电话查询用户信息
     * @param phone 用户电话
     * @return com.example.onlinestoredemo.domain.User
     * @Exception
     **/
    User findByPhone(@Param("phone") String phone);

    /**
     * 保存用户信息
     * @param user 用户信息
     * @return int
     * @Exception
     **/
    int saveUser(User user);

    /**
     * 根据电话和密码查询用户信息
     * @param phone 电话
     * @param pwd 密码
     * @return java.lang.String
     * @Exception
     **/
    User findByPhoneAndPwd(@Param("phone") String phone, @Param("pwd") String pwd);

    /**
     * 根据用户ID查询用户信息
     * @param userId 用户ID
     * @return com.example.onlinestoredemo.model.entity.User
     * @Exception
     **/
    User findByUserId(@Param("user_id") Integer userId);
}
