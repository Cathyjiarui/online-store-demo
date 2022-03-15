package com.example.onlinestoredemo.controller;

import com.example.onlinestoredemo.model.entity.Video;
import com.example.onlinestoredemo.service.VideoService;
import com.example.onlinestoredemo.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName VideoController
 * @Description 视频服务
 * @Author ZhangJia
 * @Date 2020/9/10
 * @Version 1.0
 **/
@RestController
@RequestMapping("api/v1/pub/video")
public class VideoController {

    @Autowired
    private VideoService videoService;

    /**
     * 视频列表
     * @return com.example.onlinestoredemo.utils.JsonData
     * @Exception
     **/
    @GetMapping("list")
    public JsonData list(){
        List<Video> listVideo = videoService.listVideo();
        return JsonData.buildSuccess(listVideo);
    }

    /**
     * 查询视频详情
     * @param videoId 视频ID
     * @return com.example.onlinestoredemo.utils.JsonData
     * @Exception
     **/
    @GetMapping("find_detail_by_id")
    public JsonData findDetailById(@RequestParam(value = "video_id", required = true) int videoId){
        Video video = videoService.findDetailById(videoId);
        return JsonData.buildSuccess(video);
    }
}
