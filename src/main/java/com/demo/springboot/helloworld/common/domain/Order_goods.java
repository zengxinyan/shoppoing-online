package com.demo.springboot.helloworld.common.domain;

public class Order_goods extends Order_goodsKey {
    private Integer quantity;

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}