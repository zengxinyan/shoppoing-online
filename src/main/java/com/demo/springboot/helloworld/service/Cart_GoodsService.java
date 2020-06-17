package com.demo.springboot.helloworld.service;

import com.demo.springboot.helloworld.common.domain.Cart_goods;
import com.demo.springboot.helloworld.common.domain.Cart_goodsExample;
import com.demo.springboot.helloworld.common.domain.Goods;
import com.demo.springboot.helloworld.mapper.Cart_goodsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public void updateCartGoods(int cartId, int goodsId, int num) {
        List<Cart_goods> cart_goodsList = new ArrayList<>();
        Cart_goodsExample cart_goodsExample = new Cart_goodsExample();
        cart_goodsExample.createCriteria().andCartIdEqualTo(cartId);
        cart_goodsList = cart_goodsMapper.selectByExample(cart_goodsExample);
        for(int i=0;i<cart_goodsList.size();i++){
            if(cart_goodsList.get(i).getGoodsId()==goodsId){
                int quantity = cart_goodsList.get(i).getQuantity() + num;
                cart_goodsList.get(i).setQuantity(quantity);
                cart_goodsMapper.updateByPrimaryKeySelective(cart_goodsList.get(i));
                break;
            }
            if(i==cart_goodsList.size()-1){
                Cart_goods cart_goods = new Cart_goods();
                cart_goods.setQuantity(num);
                cart_goods.setCartId(cartId);
                cart_goods.setGoodsId(goodsId);
                cart_goodsMapper.insert(cart_goods);
                break;
            }
        }
    }

}
