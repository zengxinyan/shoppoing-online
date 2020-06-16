package com.demo.springboot.helloworld.common.domain.extend;

import com.demo.springboot.helloworld.common.domain.Goods;

import java.util.List;

public class CartExtend {

    private List<Goods> goodsList;

    public List<Goods> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<Goods> goodsList) {
        this.goodsList = goodsList;
    }

}
