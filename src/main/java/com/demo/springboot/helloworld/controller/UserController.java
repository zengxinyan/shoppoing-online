package com.demo.springboot.helloworld.controller;

import com.demo.springboot.helloworld.common.domain.User;
import com.demo.springboot.helloworld.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class UserController {
    @Autowired

    private UserService userService;

    @RequestMapping("/login")

    public String login(User user) {
        User userInDB = userService.login(user);
        if (userInDB == null) {
            System.out.println("用户名不存在");
        } else {
            String passwordInDB = userInDB.getPassword();
            if (passwordInDB.equals(user.getPassword())) {
                System.out.println("登录成功");
                return "/views/starter.html";
            } else {
                System.out.println("密码错误");
            }
        }
        return "/register/fail_login";
    }
}
