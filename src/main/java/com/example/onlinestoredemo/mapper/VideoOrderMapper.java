package com.example.onlinestoredemo.mapper;

import com.example.onlinestoredemo.model.entity.VideoOrder;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName VideoOrderMapper
 * @Description 用户订单mapper
 * @Author ZhangJia
 * @Date 2020/9/15
 * @Version 1.0
 **/
public interface VideoOrderMapper {

    /**
     * 查询用户是否购买过此商品
     * @param userId 用户ID
     * @param videoId 视频ID
     * @param state 状态
     * @return com.example.onlinestoredemo.model.entity.VideoOrder
     * @Exception 
     **/
    VideoOrder findByUserIdAndVideoIdAndState(@Param("user_id") Integer userId, @Param("video_id") Integer videoId, @Param("state") Integer state);

    /**
     * 下单
     * @param videoOrder 用户订单
     * @return int
     * @Exception
     **/
    int saveOrder(VideoOrder videoOrder);

    /**
     * 根据用户ID查询订单信息
     * @param userId 用户ID
     * @return java.util.List<com.example.onlinestoredemo.model.entity.VideoOrder>
     * @Exception
     **/
    List<VideoOrder> listOrderByUserId(@Param("user_id") Integer userId);
}
