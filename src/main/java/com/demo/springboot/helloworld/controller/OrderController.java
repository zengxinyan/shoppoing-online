package com.demo.springboot.helloworld.controller;


import com.demo.springboot.helloworld.common.domain.Ordered;
import com.demo.springboot.helloworld.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;

@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping("/buyOne")
    public String buy(int orderId, Model model){
        model.addAttribute("orderId",orderId);
        return "goods/buyOne";
    }

    @RequestMapping("/createOrder")
    @ResponseBody
    public Ordered createOrder(int userId){
        Ordered ordered = orderService.createOrder(userId);
        System.out.println("ID wei:"+ordered.getId());
        return ordered;
    }

    @RequestMapping("/updateOneOrder")
    @ResponseBody
    public Ordered updateOneOrder(int orderId, int quantity, BigDecimal price){
        return orderService.updateOneOrder(orderId,quantity,price);
    }

    @RequestMapping("/selectOrder")
    @ResponseBody
    public Ordered selectOrder(int orderId){
        return orderService.selectOrder(orderId);
    }

}
