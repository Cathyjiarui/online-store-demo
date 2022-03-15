package com.example.onlinestoredemo.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

/**
 * @ClassName VideoBanner
 * @Description 轮播图对象
 * @Author ZhangJia
 * @Date 2020/9/10
 * @Version 1.0
 **/
@Data
public class VideoBanner {

    /**
     * 主键ID
     */
    private Integer id;

    /**
     * 跳转地址
     */
    private String url;

    /**
     * 图片地址
     */
    private String img;

    /**
     * 创建时间
     */
    @JsonProperty("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    /**
     * 数字越小排越前
     */
    private Integer weight;
}
