package com.demo.springboot.helloworld.service;

import com.demo.springboot.helloworld.common.domain.OrderedExample;
import com.demo.springboot.helloworld.common.domain.Ordered_goods;
import com.demo.springboot.helloworld.common.domain.Ordered_goodsExample;
import com.demo.springboot.helloworld.mapper.Ordered_goodsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Order_GoodsService {

    @Autowired
    private Ordered_goodsMapper ordered_goodsMapper;


    public void createOrderGoods(int orderId, int goodsId, int quantity) {
        Ordered_goods ordered_goods = new Ordered_goods();
        ordered_goods.setOrderedId(orderId);
        ordered_goods.setGoodsId(goodsId);
        ordered_goods.setQuantity(quantity);
        ordered_goodsMapper.insert(ordered_goods);
    }

    public int selectOrderGoods(int orderId, int goodsId) {
        Ordered_goodsExample ordered_goodsExample = new Ordered_goodsExample();
        ordered_goodsExample.createCriteria().andOrderedIdEqualTo(orderId).andGoodsIdEqualTo(goodsId);
        int quantity = ordered_goodsMapper.selectByExample(ordered_goodsExample).get(0).getQuantity();
        System.out.println("数量"+quantity);
        return quantity;
    }
}
