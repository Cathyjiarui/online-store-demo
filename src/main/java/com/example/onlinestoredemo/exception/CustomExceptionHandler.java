package com.example.onlinestoredemo.exception;

import com.example.onlinestoredemo.utils.JsonData;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName CustomExceptionHandler
 * @Description 异常处理类
 * @Author ZhangJia
 * @Date 2020/9/10
 * @Version 1.0
 **/
@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public JsonData handler(Exception e){

        if (e instanceof CustomizeException){
            CustomizeException customizeException = (CustomizeException) e;
            return JsonData.buildError(customizeException.getCode(), customizeException.getMsg());
        }else {
            return JsonData.buildError("未知错误");
        }
    }
}
