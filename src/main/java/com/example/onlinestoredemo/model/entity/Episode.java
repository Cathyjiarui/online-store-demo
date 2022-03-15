package com.example.onlinestoredemo.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

/**
 * @ClassName Episode
 * @Description 集对象
 * @Author ZhangJia
 * @Date 2020/9/10
 * @Version 1.0
 **/
@Data
public class Episode {

    /**
     * 主键ID
     */
    private Integer id;

    /**
     * 集标题
     */
    private String title;

    /**
     * 第几集,全局顺序
     */
    private Integer num;

    /**
     * 顺序，章里面的顺序
     */
    private Integer ordered;

    /**
     * 播放地址
     */
    @JsonProperty("play_url")
    private String playUrl;

    /**
     * 章节主键id
     */
    @JsonProperty("chapter_id")
    private Integer chapterId;

    /**
     * 0表示免费，1表示首付
     */
    private Integer free;

    /**
     * 视频id
     */
    @JsonProperty("video_id")
    private Integer videoId;

    /**
     * 创建时间
     */
    @JsonProperty("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
}
