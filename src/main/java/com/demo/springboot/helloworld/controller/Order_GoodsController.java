package com.demo.springboot.helloworld.controller;

import com.demo.springboot.helloworld.service.Order_GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Order_GoodsController {

    @Autowired
    private Order_GoodsService order_goodsService;

    @RequestMapping("/createOrderGoods")
    @ResponseBody
    public void createOrderGoods(int orderId,int goodsId,int quantity){
        order_goodsService.createOrderGoods(orderId,goodsId,quantity);
    }

    @RequestMapping("/selectOrderGoods")
    @ResponseBody
    public int selectOrderGoods(int orderId,int goodsId){
        return order_goodsService.selectOrderGoods(orderId,goodsId);
    }

}
