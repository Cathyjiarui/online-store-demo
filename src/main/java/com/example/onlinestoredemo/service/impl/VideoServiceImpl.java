package com.example.onlinestoredemo.service.impl;

import com.example.onlinestoredemo.config.CacheKeyManager;
import com.example.onlinestoredemo.model.entity.Video;
import com.example.onlinestoredemo.mapper.VideoMapper;
import com.example.onlinestoredemo.model.entity.VideoOrder;
import com.example.onlinestoredemo.service.VideoService;
import com.example.onlinestoredemo.utils.BaseCache;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * @ClassName VideoServiceImpl
 * @Description 视频service实现类
 * @Author ZhangJia
 * @Date 2020/9/10
 * @Version 1.0
 **/
@Slf4j
@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    private VideoMapper videoMapper;

    @Autowired
    private BaseCache baseCache;

    @Override
    public List<Video> listVideo() {

        try {
            Object cacheObj = baseCache.getTenMinuteCache().get(CacheKeyManager.INDEX_VIDEO_LIST, () -> {
                List<Video> videoList = videoMapper.listVideo();
                log.info("数据库查询数据");
                return videoList;
            });
            if (cacheObj instanceof List){
                List<Video> videoList = (List<Video>) cacheObj;
                return videoList;
            }
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        //可以返回兜底数据，业务系统降级
        return null;
    }

    @Override
    public Video findDetailById(int videoId) {

        //单独构建每一个缓存key，每个视频的key不一样
        String videoCacheKey = String.format(CacheKeyManager.VIDEO_DETAIL, videoId);
        try{
            Object cacheObj = baseCache.getOneHourCache().get(videoCacheKey, () -> {
                Video video = videoMapper.findDetailById(videoId);
                return video;
            });
            if (cacheObj instanceof Video){
                Video video = (Video) cacheObj;
                return video;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
