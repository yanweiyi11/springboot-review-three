package com.springboot.controller;

import com.springboot.domain.ResponseResult;
import com.springboot.domain.User;
import com.springboot.resolver.CurrentUserId;
import com.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
// @CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/findAll")
    public ResponseResult<List<User>> findAll(@CurrentUserId String userId) {
        // 调用service
        List<User> list = userService.findAll();
        return new ResponseResult<>(200, list);
    }

    @RequestMapping("/insertUser")
    public ResponseResult insertUser(){
        userService.insertUser();
        return new ResponseResult(200, "添加成功");
    }



}
