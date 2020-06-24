package com.demo.springboot.helloworld.common.domain.extend;

import com.demo.springboot.helloworld.common.domain.Goods;
import com.demo.springboot.helloworld.common.domain.Ordered_goods;

import java.util.List;

public class OrderedExtend {

    private List<Goods> goodsList;

    public List<Goods> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<Goods> goodsList) {
        this.goodsList = goodsList;
    }
}
