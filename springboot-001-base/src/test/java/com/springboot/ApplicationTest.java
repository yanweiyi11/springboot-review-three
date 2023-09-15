package com.springboot;

import com.springboot.controller.HelloController;
import org.junit.jupiter.api.Test;
import com.springboot.domain.User;
import com.springboot.mapper.UserMapper;
// import org.junit.Test;
// import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

// classes属性来指定启动类
@SpringBootTest
// @RunWith(SpringRunner.class)
public class ApplicationTest {

    @Autowired
    private HelloController helloController;

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testMapper(){
        List<User> userList = userMapper.findAll();
        System.out.println(userList);
    }

    @Test
    public void testJunit(){
        System.out.println(1);
        System.out.println(helloController);
    }
}
