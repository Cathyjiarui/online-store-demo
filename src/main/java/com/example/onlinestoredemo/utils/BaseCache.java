package com.example.onlinestoredemo.utils;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName BaseCache
 * @Description 本地缓存
 * @Author ZhangJia
 * @Date 2020/9/16
 * @Version 1.0
 **/
@Component
public class BaseCache {

    private Cache<String, Object> tenMinuteCache = CacheBuilder.newBuilder()
            //设置缓存初始大小，合理设置，后续扩容
            .initialCapacity(10)
            //最大值
            .maximumSize(100)
            //并发数
            .concurrencyLevel(5)
            //过期时间(10分钟)
            .expireAfterWrite(600, TimeUnit.SECONDS)
            //统计缓存命中率
            .recordStats()
            .build();

    private Cache<String, Object> oneHourCache = CacheBuilder.newBuilder()
            //设置缓存初始大小，合理设置，后续扩容
            .initialCapacity(20)
            //最大值
            .maximumSize(100)
            //并发数
            .concurrencyLevel(5)
            //过期时间(1小时)
            .expireAfterWrite(3600, TimeUnit.SECONDS)
            //统计缓存命中率
            .recordStats()
            .build();

    public Cache<String, Object> getTenMinuteCache() {
        return tenMinuteCache;
    }

    public void setTenMinuteCache(Cache<String, Object> tenMinuteCache) {
        this.tenMinuteCache = tenMinuteCache;
    }

    public Cache<String, Object> getOneHourCache() {
        return oneHourCache;
    }

    public void setOneHourCache(Cache<String, Object> oneHourCache) {
        this.oneHourCache = oneHourCache;
    }
}
