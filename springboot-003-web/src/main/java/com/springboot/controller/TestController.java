package com.springboot.controller;

import com.springboot.domain.ResponseResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
public class TestController {

    @RequestMapping("/test")
    public String test() {
        return "test";
    }

    @RequestMapping("/test2")
    public ResponseResult test(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        System.out.println(request);
        return new ResponseResult<>(200, "success");
    }
}
