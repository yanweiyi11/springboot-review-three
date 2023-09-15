package com.springboot.controller;

import com.springboot.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class HelloController {

    @Value("${name}")
    private String name;

    @Value("${date}")
    private Date date;

    @Value("${student.age}")
    private Integer age;

    @Autowired
    private Student stu;

    @RequestMapping("/test")
    public String test() {
        return "test";
    }

    @RequestMapping("/hello")
    public String hello() {
        return "Hello! SpringBoot!";
    }
}
