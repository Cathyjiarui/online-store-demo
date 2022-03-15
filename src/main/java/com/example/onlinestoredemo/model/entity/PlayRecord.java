package com.example.onlinestoredemo.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

/**
 * @ClassName PlayRecord
 * @Description 播放记录对象
 * @Author ZhangJia
 * @Date 2020/9/16
 * @Version 1.0
 **/
@Data
public class PlayRecord {

    /**
     * 主键ID
     */
    private Integer id;

    /**
     * 用户ID
     */
    @JsonProperty("user_id")
    private Integer userId;

    /**
     * 视频ID
     */
    @JsonProperty("video_id")
    private Integer videoId;

    /**
     * 当前播放第⼏集
     */
    @JsonProperty("current_num")
    private Integer currentNum;

    /**
     * 当前播放第⼏集视频id
     */
    @JsonProperty("episode_id")
    private Integer episodeId;

    /**
     * 创建时间
     */
    @JsonProperty("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
}
