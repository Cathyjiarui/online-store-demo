package com.example.onlinestoredemo.controller;

import com.example.onlinestoredemo.model.entity.VideoBanner;
import com.example.onlinestoredemo.service.VideoBannerService;
import com.example.onlinestoredemo.utils.BaseCache;
import com.example.onlinestoredemo.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName VideoBannerController
 * @Description 视频轮播图服务
 * @Author ZhangJia
 * @Date 2020/9/10
 * @Version 1.0
 **/
@RestController
@RequestMapping("api/v1/pub/video_banner")
public class VideoBannerController {

    @Autowired
    private VideoBannerService videoBannerService;

    @GetMapping("list_banner")
    public JsonData indexBanner(){
        List<VideoBanner> listVideoBanner = videoBannerService.listBanner();
        return JsonData.buildSuccess(listVideoBanner);
    }
}
