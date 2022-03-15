package com.example.onlinestoredemo.config;

/**
 * @ClassName CacheKeyManager
 * @Description 缓存key管理类
 * @Author ZhangJia
 * @Date 2020/9/16
 * @Version 1.0
 **/
public class CacheKeyManager {

    /**
     * 首页轮播图缓存key
     */
    public static final String INDEX_BANNER_KEY = "index:banner:list";

    /**
     * 首页视频列表缓存key
     */
    public static final String INDEX_VIDEO_LIST = "index:video:list";

    /**
     * 视频详情缓存key，%s为视频ID
     */
    public static final String VIDEO_DETAIL = "video:detail:%s";
}
