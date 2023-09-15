package com.springboot.controller;

import com.springboot.domain.User;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
public class UserController {
    @RequestMapping("/testRquestParam")
    public String testRquestParam(@RequestParam(value = "id", required = false, defaultValue = "123") Integer uid,
                                  String name,
                                  String[] likes) {
        System.out.println("testRquestParam");
        System.out.println(uid);
        System.out.println(name);
        System.out.println(Arrays.toString(likes));
        return "testRquestParam";
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String insertUser(@RequestBody List<User> user) {
        System.out.println(user);
        return "insertUser";
    }

    @RequestMapping("/testRequestParam")
    public String testRequestParam(User user) {
        System.out.println(user);
        return "testRequestParam";
    }
}
