package com.demo.springboot.helloworld.controller;

import com.demo.springboot.helloworld.common.domain.Cart;
import com.demo.springboot.helloworld.service.CartService;
import com.demo.springboot.helloworld.service.Cart_GoodsService;
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
    //private Cart_GoodsService cart_goodsService;


    @RequestMapping("/getCartGoods")
    @ResponseBody
    public Cart getCartGoods(int cartId){
        //System.out.println("abbb");
        return cartService.findCartGoods(cartId);
    }

    @RequestMapping("/updateCart")
    @ResponseBody
    public void updateCart(int cartId, int num, BigDecimal price,int flag){
        //System.out.println(price);
        cartService.updateCart(cartId,num,price,flag);
    }

    @RequestMapping("/cartGoods")
    public String cartGoods(int cartId, Model model){
        //System.out.println(price);
        Cart cart = new Cart();
        cart = cartService.findCartGoods(cartId);
        model.addAttribute("cartId",cartId);
        //List<Integer> quantity = new ArrayList<>();
        //model.addAttribute("quantity",quantity);
        return "/goods/cartGoods";
    }

}
