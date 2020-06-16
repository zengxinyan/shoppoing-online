package com.demo.springboot.helloworld.common.domain.extend;

import com.demo.springboot.helloworld.common.domain.Cart;

import java.util.List;

public class GoodsExtend {

    private List<Cart> cartList;

    public List<Cart> getCartList() {
        return cartList;
    }

    public void setCartList(List<Cart> cartList) {
        this.cartList = cartList;
    }
}
