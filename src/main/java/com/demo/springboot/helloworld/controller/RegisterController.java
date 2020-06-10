package com.demo.springboot.helloworld.controller;

import com.demo.springboot.helloworld.common.domain.User;
import com.demo.springboot.helloworld.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegisterController {
    @Autowired
    private UserService userService;

    @RequestMapping("/register")
    public String register(){
        return "/register/register.html";
    }

    @RequestMapping("/success")
    public String success(User user){
        userService.insert(user);
        return  "index";
    }
}
