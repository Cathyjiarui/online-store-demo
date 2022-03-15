package com.example.onlinestoredemo.mapper;

import com.example.onlinestoredemo.model.entity.Episode;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName EpisodeMapper
 * @Description 集mapper
 * @Author ZhangJia
 * @Date 2020/9/16
 * @Version 1.0
 **/
public interface EpisodeMapper {

    /**
     * 根据视频ID查询第一集信息
     * @param videoId 视频ID
     * @return com.example.onlinestoredemo.model.entity.Episode
     * @Exception
     **/
    Episode findFirstEpisodeByVideoId(@Param("video_id") Integer videoId);
}
