package com.demo.springboot.helloworld.service;

import com.demo.springboot.helloworld.common.domain.*;
import com.demo.springboot.helloworld.mapper.CartMapper;
import com.demo.springboot.helloworld.mapper.Cart_goodsMapper;
import com.demo.springboot.helloworld.mapper.GoodsMapper;
import com.demo.springboot.helloworld.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
