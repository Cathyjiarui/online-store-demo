package com.example.onlinestoredemo.service;

import com.example.onlinestoredemo.model.entity.VideoOrder;

import java.util.List;

/**
 * @ClassName VideoOrderService
 * @Description 用户订单服务
 * @Author ZhangJia
 * @Date 2020/9/15
 * @Version 1.0
 **/
public interface VideoOrderService {

    /**
     * 下单
     * @param userId 用户ID
     * @param videoId 视频ID
     * @return int
     * @Exception
     **/
    int save(Integer userId, Integer videoId);

    /**
     * 根据用户ID查询订单信息
     * @param userId 用户ID
     * @return java.util.List<com.example.onlinestoredemo.model.entity.VideoOrder>
     * @Exception
     **/
    List<VideoOrder> listOrderByUserId(Integer userId);
}
