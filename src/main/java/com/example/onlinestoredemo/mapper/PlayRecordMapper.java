package com.example.onlinestoredemo.mapper;

import com.example.onlinestoredemo.model.entity.PlayRecord;

/**
 * @ClassName PlayRecordMapper
 * @Description 播放记录Mapper
 * @Author ZhangJia
 * @Date 2020/9/16
 * @Version 1.0
 **/
public interface PlayRecordMapper {

    /**
     * 添加播放记录
     * @param playRecord 播放记录
     * @return int
     */
    int saveRecord(PlayRecord playRecord);
}
