package com.example.onlinestoredemo.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

/**
 * @ClassName videoOrder
 * @Description 订单对象
 * @Author ZhangJia
 * @Date 2020/9/10
 * @Version 1.0
 **/
@Data
public class VideoOrder {

    /**
     * 主键ID
     */
    private Integer id;

    /**
     * 订单唯一标识
     */
    @JsonProperty("out_trade_no")
    private String outTradeNo;

    /**
     * 0表示未支付，1表示已支付
     */
    private Integer state;

    /**
     * 订单生成时间
     */
    @JsonProperty("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    /**
     * 支付金额，单位分
     */
    @JsonProperty("total_fee")
    private Integer totalFee;

    /**
     * 视频主键
     */
    @JsonProperty("video_id")
    private Integer videoId;

    /**
     * 视频标题
     */
    @JsonProperty("video_title")
    private String videoTitle;

    /**
     * 视频图片
     */
    @JsonProperty("video_img")
    private String videoImg;

    /**
     * 用户id
     */
    @JsonProperty("user_id")
    private Integer userId;
}
