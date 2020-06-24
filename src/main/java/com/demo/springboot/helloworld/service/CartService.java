package com.demo.springboot.helloworld.service;

import com.demo.springboot.helloworld.common.domain.*;
import com.demo.springboot.helloworld.mapper.CartMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CartService {

    @Autowired
    private CartMapper cartMapper;

    public Cart findCartGoods(int cartId) {
        Cart cart = cartMapper.selectById(cartId);
        return cart;
    }

    public void updateCart(int cartId, int num, BigDecimal price,int flag) {
        Cart cart =  cartMapper.selectByPrimaryKey(cartId);
        int quantity = 0;
        quantity = cart.getQuantity();
        BigDecimal total = cart.getTotal();
        if(flag==1){
            quantity += num;
            for(int i=0;i<num;i++){
                total = total.add(price);
            }
        }
        else{
            quantity -= num;
            for(int i=0;i<num;i++){
                total = total.subtract(price);
            }
        }
        cart.setQuantity(quantity);
        cart.setTotal(total);
        cartMapper.updateByPrimaryKeySelective(cart);
    }

    public void insert(Integer id) {
        Cart cart = new Cart();
        cart.setTotal(new BigDecimal(0));
        cart.setQuantity(0);
        cart.setUserId(id);
        cartMapper.insert(cart);
    }

    public int findCart(int userId){
        CartExample cartExample = new CartExample();
        cartExample.createCriteria().andUserIdEqualTo(userId);
        return cartMapper.selectByExample(cartExample).get(0).getId();
    }
}
