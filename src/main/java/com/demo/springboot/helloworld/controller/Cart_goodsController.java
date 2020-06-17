package com.demo.springboot.helloworld.controller;

import com.demo.springboot.helloworld.service.Cart_GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Cart_goodsController {

    @Autowired
    private Cart_GoodsService cart_goodsService;

    @RequestMapping("/getQuantity")
    @ResponseBody
    public int getQuantity(int cartId,int goodsId){
        return cart_goodsService.getQuantity(cartId,goodsId);
    }

    @RequestMapping("/updateCartGoods")
    @ResponseBody
    public void updateCartGoods(int cartId, int goodsId, int num) {
        //System.out.println(price);
        cart_goodsService.updateCartGoods(cartId, goodsId, num);
    }

}
