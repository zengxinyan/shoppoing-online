package com.demo.springboot.helloworld.service;

import com.demo.springboot.helloworld.common.domain.Category;
import com.demo.springboot.helloworld.common.domain.Goods;
import com.demo.springboot.helloworld.common.domain.GoodsExample;
import com.demo.springboot.helloworld.mapper.GoodsMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsService {

    @Autowired
    GoodsMapper goodsMapper;
    public PageInfo<Goods> findAllGoods(int pageNo, int pageSize){
        PageHelper.startPage(pageNo,pageSize);
        List<Goods> goods = goodsMapper.selectByExample(null);
        return new PageInfo<>(goods);
    }

    public PageInfo<Goods> findHotGoods(int pageNo, int pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        GoodsExample goodsExample = new GoodsExample();
        goodsExample.createCriteria().andIshotEqualTo(true);
        List<Goods> goods = goodsMapper.selectByExample(goodsExample);
        return new PageInfo<>(goods);
    }

    public PageInfo<Goods> findDiscountGoods(int pageNo, int pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        GoodsExample goodsExample = new GoodsExample();
        goodsExample.createCriteria().andIsdiscountEqualTo(true);
        List<Goods> goods = goodsMapper.selectByExample(goodsExample);
        return new PageInfo<>(goods);
    }

    public PageInfo<Goods> findCategoryGoods(int id,int pageNo, int pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        GoodsExample goodsExample = new GoodsExample();
        goodsExample.createCriteria().andCategoryIdEqualTo(id);
        List<Goods> goods = goodsMapper.selectByExample(goodsExample);
        return new PageInfo<>(goods);
    }
}
