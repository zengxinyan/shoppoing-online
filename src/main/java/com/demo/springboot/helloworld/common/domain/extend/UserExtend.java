package com.demo.springboot.helloworld.common.domain.extend;

import com.demo.springboot.helloworld.common.domain.Cart;

public class UserExtend {

    private Cart cart;

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
