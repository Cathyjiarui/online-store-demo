package com.example.onlinestoredemo.service.impl;

import com.example.onlinestoredemo.config.CacheKeyManager;
import com.example.onlinestoredemo.model.entity.VideoBanner;
import com.example.onlinestoredemo.mapper.VideoBannerMapper;
import com.example.onlinestoredemo.service.VideoBannerService;
import com.example.onlinestoredemo.utils.BaseCache;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * @ClassName VideoBannerServiceImpl
 * @Description 轮播图实现类
 * @Author ZhangJia
 * @Date 2020/9/10
 * @Version 1.0
 **/
@Slf4j
@Service
public class VideoBannerServiceImpl implements VideoBannerService {

    @Autowired
    private VideoBannerMapper bannerMapper;

    @Autowired
    private BaseCache baseCache;

    @Override
    public List<VideoBanner> listBanner() {

        try {
            Object cacheObj = baseCache.getTenMinuteCache().get(CacheKeyManager.INDEX_BANNER_KEY, () -> {
                List<VideoBanner> bannerList = bannerMapper.listBanner();
                log.info("数据库查询数据");
                return bannerList;
            });
            if(cacheObj instanceof List){
                List<VideoBanner> bannerList = (List<VideoBanner>) cacheObj;
                return bannerList;
            }
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }
}
