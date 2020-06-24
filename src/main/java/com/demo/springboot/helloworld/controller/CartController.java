package com.demo.springboot.helloworld.controller;

import com.demo.springboot.helloworld.common.domain.Cart;
import com.demo.springboot.helloworld.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;

@Controller
public class CartController {

    @Autowired
    private CartService cartService;

    @RequestMapping("/getCartGoods")
    @ResponseBody
    public Cart getCartGoods(int cartId){
        return cartService.findCartGoods(cartId);
    }

    @RequestMapping("/updateCart")
    @ResponseBody
    public void updateCart(int cartId, int num, BigDecimal price,int flag){
        cartService.updateCart(cartId,num,price,flag);
    }

    @RequestMapping("/cartGoods")
    public String cartGoods(int cartId, Model model){
        Cart cart = cartService.findCartGoods(cartId);
        model.addAttribute("cartId",cartId);
        return "/goods/cartGoods";
    }

}
