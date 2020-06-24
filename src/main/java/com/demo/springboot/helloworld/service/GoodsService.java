package com.demo.springboot.helloworld.service;

import com.demo.springboot.helloworld.common.domain.Goods;
import com.demo.springboot.helloworld.common.domain.GoodsExample;
import com.demo.springboot.helloworld.mapper.GoodsMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GoodsService {

    @Autowired
    GoodsMapper goodsMapper;

    public PageInfo<Goods> findAllGoods(String sortName,String sortOrder,int pageNo, int pageSize){
        PageHelper.startPage(pageNo,pageSize);
        GoodsExample goodsExample = new GoodsExample();
        goodsExample.setOrderByClause(sortName+' '+sortOrder);
        List<Goods> goods = goodsMapper.selectByExample(goodsExample);
        return new PageInfo<>(goods);
    }

    public PageInfo<Goods> findHotGoods(String sortName,String sortOrder,int pageNo, int pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        GoodsExample goodsExample = new GoodsExample();
        goodsExample.setOrderByClause(sortName+' '+sortOrder);
        goodsExample.createCriteria().andIshotEqualTo(true);
        List<Goods> goods = goodsMapper.selectByExample(goodsExample);
        return new PageInfo<>(goods);
    }

    public PageInfo<Goods> findDiscountGoods(String sortName,String sortOrder,int pageNo, int pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        GoodsExample goodsExample = new GoodsExample();
        goodsExample.setOrderByClause(sortName+' '+sortOrder);
        goodsExample.createCriteria().andIsdiscountEqualTo(true);
        List<Goods> goods = goodsMapper.selectByExample(goodsExample);
        return new PageInfo<>(goods);
    }

    public PageInfo<Goods> findCategoryGoods(String sortName,String sortOrder,int id,int pageNo, int pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        GoodsExample goodsExample = new GoodsExample();
        goodsExample.setOrderByClause(sortName+' '+sortOrder);
        goodsExample.createCriteria().andCategoryIdEqualTo(id);
        List<Goods> goods = goodsMapper.selectByExample(goodsExample);
        return new PageInfo<>(goods);
    }

    public PageInfo<Goods> findSearchGoods(String searchString,String sortName,String sortOrder, int pageNo, int pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        GoodsExample goodsExample = new GoodsExample();
        goodsExample.setOrderByClause(sortName+' '+sortOrder);
        GoodsExample.Criteria criteria = goodsExample.createCriteria();
        if(searchString != null && searchString.length() > 0){
            String s ="";
            for(int i=0;i<searchString.length();i++) {
                s = "%" + searchString.charAt(i) + "%";
                goodsExample.or(goodsExample.createCriteria().andNameLike(s));
                goodsExample.or(goodsExample.createCriteria().andDescriptionLike(s));
            }
        }
        List<Goods> goods = goodsMapper.selectByExample(goodsExample);
        return new PageInfo<>(goods);
    }

    public Goods getGoodsInfo(int goodsId) {
        List<Goods> goodsList = new ArrayList<>();
        GoodsExample goodsExample = new GoodsExample();
        goodsExample.createCriteria().andIdEqualTo(goodsId);
        goodsList = goodsMapper.selectByExample(goodsExample);
        return goodsList.get(0);
    }

    public Goods getGoods(int goodsId) {
        return goodsMapper.selectByPrimaryKey(goodsId);
    }
}
