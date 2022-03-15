package com.example.onlinestoredemo.service.impl;

import com.example.onlinestoredemo.model.entity.User;
import com.example.onlinestoredemo.mapper.UserMapper;
import com.example.onlinestoredemo.service.UserService;
import com.example.onlinestoredemo.utils.CommonUtils;
import com.example.onlinestoredemo.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;
import java.util.Random;

/**
 * @ClassName UserServiceImpl
 * @Description 用户service实现
 * @Author ZhangJia
 * @Date 2020/9/11
 * @Version 1.0
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findByPhone(String phone) {
        return userMapper.findByPhone(phone);
    }

    @Override
    public int saveUser(Map<String, String> userInfo) {
        User user = parseToUser(userInfo);
        if (user != null){
            return userMapper.saveUser(user);
        }else {
            return -1;
        }
    }

    @Override
    public String findByPhoneAndPwd(String phone, String pwd) {
        User user = userMapper.findByPhoneAndPwd(phone,CommonUtils.MD5(pwd));
        if (user == null) {
            return null;
        }else {
            String token = JwtUtils.geneJsonWebToken(user);
            return token;
        }
    }

    @Override
    public User findByUserId(Integer userId) {
        User user = userMapper.findByUserId(userId);
        return user;
    }

    /**
     * 解析User对象
     * @param userInfo user用户的数据
     * @return com.example.onlinestoredemo.domain.User
     * @Exception
     **/
    private User parseToUser(Map<String, String> userInfo) {
        if(userInfo.containsKey("phone") && userInfo.containsKey("pwd") && userInfo.containsKey("name")){
            User user = new User();
            user.setCreateTime(new Date());
            user.setName(userInfo.get("name"));
            user.setPhone(userInfo.get("phone"));
            String pwd = userInfo.get("pwd");
            user.setPwd(CommonUtils.MD5(pwd));
            user.setHeadImg(getRandomImg());
            return user;
        }else {
            return null;
        }
    }

    /**
     * CDN上的头像
     */
    private static final String [] headImg = {
            "https://xd-video-pc-img.oss-cnbeijing.aliyuncs.com/xdclass_pro/default/head_img/12.jpeg",
            "https://xd-video-pc-img.oss-cnbeijing.aliyuncs.com/xdclass_pro/default/head_img/11.jpeg",
            "https://xd-video-pc-img.oss-cnbeijing.aliyuncs.com/xdclass_pro/default/head_img/13.jpeg",
            "https://xd-video-pc-img.oss-cnbeijing.aliyuncs.com/xdclass_pro/default/head_img/14.jpeg",
            "https://xd-video-pc-img.oss-cnbeijing.aliyuncs.com/xdclass_pro/default/head_img/15.jpeg"
    };

    /**
     * 获取随机头像
     * @return java.lang.String
     * @Exception
     **/
    private String getRandomImg(){
        int size = headImg.length;
        Random random = new Random();
        int index = random.nextInt(size);
        return headImg[index];
    }
}
