package com.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class HelloController {

    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }

    @RequestMapping("/testPath")
    public String testPath(){
        return "testPath";
    }

    @RequestMapping(value = "/testMethod", method = RequestMethod.GET)
    public String testMethod(){
        System.out.println("testMethod处理了请求");
        return "testMethod";
    }

}
