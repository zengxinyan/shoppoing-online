package com.demo.springboot.helloworld.service;

import com.demo.springboot.helloworld.common.domain.*;
import com.demo.springboot.helloworld.mapper.CartMapper;
import com.demo.springboot.helloworld.mapper.Cart_goodsMapper;
import com.demo.springboot.helloworld.mapper.GoodsMapper;
import com.demo.springboot.helloworld.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartMapper cartMapper;

    public Cart findCartGoods(int cartId) {
        Cart cart = cartMapper.selectById(cartId);
        //System.out.println(cartList.get(1).getGoodsList().get(0).getName());
        System.out.println(cart.getGoodsList().get(1).getDescription());
        return cart;
    }

    public void updateCart(int cartId, int num, BigDecimal price) {
        Cart cart = new Cart();
        cart = cartMapper.selectByPrimaryKey(cartId);
        int quantity = cart.getQuantity()+num;
        BigDecimal total = cart.getTotal();
        for(int i=0;i<num;i++){
            total = total.add(price);
        }
        cart.setQuantity(quantity);
        cart.setTotal(total);
        //System.out.println(total);
        //cartMapper.updateByPrimaryKeySelective(cart);
        cartMapper.updateByPrimaryKeySelective(cart);
    }



}
