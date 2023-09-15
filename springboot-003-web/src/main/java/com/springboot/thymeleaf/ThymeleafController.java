package com.springboot.thymeleaf;

import com.springboot.domain.User;
import com.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ThymeleafController {
    @Autowired
    private UserService userService;
    @RequestMapping("/thymeleaf/users")
    public String users(Model model) {
        // 获取数据
        List<User> users = userService.findAll();
        // 往域中存数据
        model.addAttribute("users", users);
        model.addAttribute("msg", "hello thymeleaf");
        // 跳转
        return "table-standard";
    }

}
