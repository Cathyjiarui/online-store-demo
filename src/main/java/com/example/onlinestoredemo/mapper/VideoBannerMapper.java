package com.example.onlinestoredemo.mapper;

import com.example.onlinestoredemo.model.entity.VideoBanner;

import java.util.List;

/**
 * @ClassName VideobannerMapper
 * @Description 轮播图mapper
 * @Author ZhangJia
 * @Date 2020/9/10
 * @Version 1.0
 **/
public interface VideoBannerMapper {

    List<VideoBanner> listBanner();
}
