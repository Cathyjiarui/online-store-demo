package com.example.onlinestoredemo.mapper;

import com.example.onlinestoredemo.model.entity.Video;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName VideoMapper
 * @Description 视频mapper
 * @Author ZhangJia
 * @Date 2020/9/10
 * @Version 1.0
 **/
public interface VideoMapper {

    /**
     * 查询所有视频信息
     * @return java.util.List<com.example.onlinestoredemo.model.entity.Video>
     * @Exception
     **/
    List<Video> listVideo();

    /**
     * 根据视频ID关联查询视频信息、章、集信息
     * @param videoId 视频ID
     * @return com.example.onlinestoredemo.model.entity.Video
     * @Exception
     **/
    Video findDetailById(@Param("video_id") int videoId);

    /**
     * 根据视频ID查询视频信息
     * @param videoId 视频信息
     * @return com.example.onlinestoredemo.model.entity.Video
     * @Exception
     **/
    Video findById(@Param("video_id") Integer videoId);
}
