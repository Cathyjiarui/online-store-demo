package com.example.onlinestoredemo.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

/**
 * @ClassName User
 * @Description 用户对象
 * @Author ZhangJia
 * @Date 2020/9/10
 * @Version 1.0
 **/
@Data
public class User {

    /**
     * 主键ID
     */
    private Integer id;

    /**
     * 昵称
     */
    private String name;

    /**
     * 密码
     */
    @JsonIgnore
    private String pwd;

    /**
     * 头像
     */
    @JsonProperty("head_img")
    private String headImg;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 创建时间
     */
    @JsonProperty("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
}
