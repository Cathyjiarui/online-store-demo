package com.example.onlinestoredemo.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @ClassName Chapter
 * @Description 章对象
 * @Author ZhangJia
 * @Date 2020/9/10
 * @Version 1.0
 **/
@Data
public class Chapter {

    /**
     * 主键ID
     */
    private Integer id;

    /**
     * 视频主键
     */
    @JsonProperty("video_id")
    private Integer videoId;

    /**
     * 章节名称
     */
    private String title;

    /**
     * 章节顺序
     */
    private Integer ordered;

    /**
     * 创建时间
     */
    @JsonProperty("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    /**
     * 章的集信息
     */
    @JsonProperty("episode_list")
    List<Episode> episodeList;
}
