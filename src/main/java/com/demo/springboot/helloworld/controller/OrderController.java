package com.demo.springboot.helloworld.controller;


import com.demo.springboot.helloworld.common.domain.Ordered;
import com.demo.springboot.helloworld.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.List;

@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping("/buyGoods")
    public String buyGoods(int orderId, Model model){
        model.addAttribute("orderId",orderId);
        return "goods/buyGoods";
    }

    @RequestMapping("/createOrder")
    @ResponseBody
    public Ordered createOrder(int userId){
        Ordered ordered = orderService.createOrder(userId);
        return ordered;
    }

    @RequestMapping("/updateOrder")
    @ResponseBody
    public Ordered updateOrder(int orderId,BigDecimal total){
        return orderService.updateOrder(orderId,total);
    }

    @RequestMapping("/selectOrder")
    @ResponseBody
    public Ordered selectOrder(int orderId){
        return orderService.selectOrder(orderId);
    }

    @RequestMapping("/toOrder")
    public String toOrder(){
        return "goods/order";
    }

    @RequestMapping("/toOrderInfo")
    public String toOrderInfo(int orderId,Model model){
        model.addAttribute("orderId",orderId);
        return "goods/orderInfo";
    }

    @RequestMapping("/getOrder")
    @ResponseBody
    public List<Ordered> getOrder(int userId){
        List<Ordered> orderedList = orderService.getOrder(userId);
        return orderedList;
    }

    @RequestMapping("/orderAddReceive")
    @ResponseBody
    public void orderAddReceive(int orderId,int receiveId){
        orderService.orderAddReceive(orderId,receiveId);
    }

}
