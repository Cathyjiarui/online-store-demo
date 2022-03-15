package com.example.onlinestoredemo.service;

import com.example.onlinestoredemo.model.entity.Video;

import java.util.List;

/**
 * @ClassName VideoService
 * @Description 视频service
 * @Author ZhangJia
 * @Date 2020/9/10
 * @Version 1.0
 **/
public interface VideoService {

    /**
     * 查询所有视频
     * @return java.util.List<com.example.onlinestoredemo.domain.Video>
     * @Exception 
     **/
    List<Video> listVideo();

    Video findDetailById(int videoId);
}
