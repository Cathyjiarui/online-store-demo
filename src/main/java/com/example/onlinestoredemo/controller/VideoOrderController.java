package com.example.onlinestoredemo.controller;

import com.example.onlinestoredemo.model.entity.VideoOrder;
import com.example.onlinestoredemo.model.request.VideoOrderRequest;
import com.example.onlinestoredemo.service.VideoOrderService;
import com.example.onlinestoredemo.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @ClassName VideoOrderController
 * @Description 用户订单服务
 * @Author ZhangJia
 * @Date 2020/9/15
 * @Version 1.0
 **/
@RestController
@RequestMapping("/api/v1/pri/order")
public class VideoOrderController {

    @Autowired
    private VideoOrderService videoOrderService;

    /**
     * 下单接口
     * @return com.example.onlinestoredemo.utils.JsonData
     * @Exception
     **/
    @PostMapping("save")
    public JsonData saveOrder(@RequestBody VideoOrderRequest videoOrderRequest, HttpServletRequest request){
        Integer userId = (Integer) request.getAttribute("user_id");
        int rows = videoOrderService.save(userId, videoOrderRequest.getVideoId());
        return rows == 0 ? JsonData.buildError("下单失败") : JsonData.buildSuccess("下单成功");
    }

    /**
     * 查询用户订单详情
     * @return com.example.onlinestoredemo.utils.JsonData
     * @Exception
     **/
    @GetMapping("list")
    public JsonData listOrder(HttpServletRequest request){
        Integer userId = (Integer) request.getAttribute("user_id");
        List<VideoOrder> videoOrderList = videoOrderService.listOrderByUserId(userId);
        return JsonData.buildSuccess(videoOrderList);
    }
}
