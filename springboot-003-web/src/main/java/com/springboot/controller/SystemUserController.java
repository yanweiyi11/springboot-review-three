package com.springboot.controller;

import com.springboot.domain.ResponseResult;
import com.springboot.domain.SystemUser;
import com.springboot.service.SystemUserService;
import com.springboot.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/system_user")
public class SystemUserController {

    @Autowired
    private SystemUserService systemUserService;

    @PostMapping("/login")
    public ResponseResult login(@RequestBody SystemUser systemUser) {
        SystemUser login = systemUserService.login(systemUser);
        Map<String, Object> map = new HashMap<>();
        if (login != null){
            String token = JwtUtil.createJWT(UUID.randomUUID().toString(), login.getId().toString(), null);
            map.put("token", token);
        }else {
            return new ResponseResult(300, "用户名或密码错误，请重新登录");
        }
        return new ResponseResult(200, "登陆成功", map);
    }
}
