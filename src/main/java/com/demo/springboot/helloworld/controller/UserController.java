package com.demo.springboot.helloworld.controller;

import com.demo.springboot.helloworld.common.domain.User;
import com.demo.springboot.helloworld.service.CartService;
import com.demo.springboot.helloworld.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;;

@Controller

public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private CartService cartService;

    @RequestMapping("/tologin")
    public String tologin(){
        return "/register/login";
    }

    @RequestMapping("/login")
    public String login(User user, Model model) {
        User userInDB = userService.login(user);

        if (userInDB == null) {
            System.out.println("用户名不存在");
        }
        else {
            String passwordInDB = userInDB.getPassword();
            if (passwordInDB.equals(user.getPassword())) {
                System.out.println("登录成功");
                model.addAttribute("user",userInDB);
                return "/views/starter.html";
            } else {
                System.out.println("密码错误");
            }
        }
        return "/register/fail_login";
    }

    @RequestMapping("/register")
    public String register(){
        return "/register/register.html";
    }

    @RequestMapping("/registerSuccess")
    public String success(User user){
        userService.insert(user);
        User user1 = new User();
        user1 = userService.login(user);
        cartService.insert(user1.getId());
        int cartId = cartService.findCart(user1.getId());
        user1.setCartId(cartId);
        userService.update(user1);
        return  "/register/login";
    }

    @RequestMapping("/signOut")
    public String signOut(){
        return "index";
    }

    @RequestMapping("/selectById")
    @ResponseBody
    public User selectById(int id){
        return userService.selectById(id);
    }

}
