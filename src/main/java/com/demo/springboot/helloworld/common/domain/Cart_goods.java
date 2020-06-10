package com.demo.springboot.helloworld.common.domain;

public class Cart_goods extends Cart_goodsKey {
    private Integer quantity;

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}