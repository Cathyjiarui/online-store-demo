package com.example.onlinestoredemo.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @ClassName VideoOrderRequest
 * @Description 用户订单返回信息
 * @Author ZhangJia
 * @Date 2020/9/15
 * @Version 1.0
 **/
@Data
public class VideoOrderRequest {

    @JsonProperty("video_id")
    private int videoId;
}
