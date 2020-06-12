package com.demo.springboot.helloworld.common.domain;

public class Ordered_goods extends Ordered_goodsKey {
    private Integer quantity;

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}