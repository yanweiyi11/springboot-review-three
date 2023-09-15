package com.springboot.execption;

import com.springboot.domain.ResponseResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class MyControllerAdvice {

    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public ResponseResult handleException(Exception ex) {
        // 获取异常信息，存入ResponseResult的msg属性
        String message = ex.getMessage();
        ResponseResult result = new ResponseResult(300, message);
        // 把ResponseResult作为返回值返回，要求到时候转换为Json存入响应体中
        return result;
    }
}
