package com.example.onlinestoredemo.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @ClassName Video
 * @Description 视频对象
 * @Author ZhangJia
 * @Date 2020/9/10
 * @Version 1.0
 **/
@Data
public class Video {

    /**
     * 主键ID
     */
    private Integer id;

    /**
     * 视频标题
     */
    private String title;

    /**
     * 概述
     */
    private String summary;

    /**
     * 封面图
     */
    @JsonProperty("cover_img")
    private String coverImg;

    /**
     * 价格,分
     */
    private Integer price;

    /**
     * 创建时间
     */
    @JsonProperty("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    /**
     * 默认8.7，最高10分
     */
    private Double point;

    /**
     * 视频章信息
     */
    @JsonProperty("chapter_list")
    private List<Chapter> chapterList;
}
