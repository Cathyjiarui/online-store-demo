package com.example.onlinestoredemo.service;

import com.example.onlinestoredemo.model.entity.VideoBanner;

import java.util.List;

/**
 * @ClassName VideoBannerService
 * @Description 轮播图service
 * @Author ZhangJia
 * @Date 2020/9/10
 * @Version 1.0
 **/
public interface VideoBannerService {

    /**
     * 轮播图列表
     * @return java.util.List<com.example.onlinestoredemo.domain.VideoBanner>
     * @Exception
     **/
    List<VideoBanner> listBanner();
}
