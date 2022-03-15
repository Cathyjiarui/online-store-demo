package com.example.onlinestoredemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author Zhangjia
 */
@SpringBootApplication
@MapperScan("com.example.onlinestoredemo.mapper")
@EnableTransactionManagement
public class OnlineStoreDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(OnlineStoreDemoApplication.class, args);
    }

}
