package com.demo.springboot.helloworld.service;

import com.demo.springboot.helloworld.common.domain.Cart_goods;
import com.demo.springboot.helloworld.common.domain.Cart_goodsExample;
import com.demo.springboot.helloworld.common.domain.Goods;
import com.demo.springboot.helloworld.mapper.Cart_goodsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Cart_GoodsService {

    @Autowired
    Cart_goodsMapper cart_goodsMapper;

    public int getQuantity(int cartId, int goodsId) {
        Cart_goodsExample cart_goodsExample = new Cart_goodsExample();
        cart_goodsExample.createCriteria().andCartIdEqualTo(cartId).andGoodsIdEqualTo(goodsId);
        List<Cart_goods> cart_goods = cart_goodsMapper.selectByExample(cart_goodsExample);
        return cart_goods.get(0).getQuantity();
    }
}
