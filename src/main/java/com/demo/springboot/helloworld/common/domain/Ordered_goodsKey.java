package com.demo.springboot.helloworld.common.domain;

public class Ordered_goodsKey {
    private Integer orderedId;

    private Integer goodsId;

    public Integer getOrderedId() {
        return orderedId;
    }

    public void setOrderedId(Integer orderedId) {
        this.orderedId = orderedId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }
}