package com.demo.springboot.helloworld.controller;

import com.demo.springboot.helloworld.common.domain.Category;
import com.demo.springboot.helloworld.common.domain.Goods;
import com.demo.springboot.helloworld.common.utils.Result;
import com.demo.springboot.helloworld.service.GoodsService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class GoodsController {
    @Autowired
    private GoodsService goodsService;

    @RequestMapping("/getSearchGoods")
    @ResponseBody
    public Object getSearchGoods(@RequestParam String searchString,@RequestParam String sortName,@RequestParam String sortOrder,@RequestParam(defaultValue = "1") int pageNo, @RequestParam(defaultValue = "10")int pageSize){
        PageInfo<Goods> goods = goodsService.findSearchGoods(searchString,sortName,sortOrder,pageNo,pageSize);
        return Result.success(goods ,"分页 查询book 对象");
    }

    @RequestMapping("/getAllGoods")
    @ResponseBody
    public Object getAllGoods(@RequestParam String sortName,@RequestParam String sortOrder,@RequestParam(defaultValue = "1") int pageNo, @RequestParam(defaultValue = "10")int pageSize){
        PageInfo<Goods> goods = goodsService.findAllGoods(sortName,sortOrder,pageNo,pageSize);
        return Result.success(goods ,"分页 查询book 对象");
    }

    @RequestMapping("/getHotGoods")
    @ResponseBody
    public Object getHotGoods(@RequestParam String sortName,@RequestParam String sortOrder,@RequestParam(defaultValue = "1") int pageNo, @RequestParam(defaultValue = "10")int pageSize){
        System.out.println("hot");
        return Result.success(goodsService.findHotGoods(sortName,sortOrder,pageNo,pageSize),"分页 查询book 对象");
    }

    @RequestMapping("/getDiscountGoods")
    @ResponseBody
    public Object getDiscountGoods(@RequestParam String sortName,@RequestParam String sortOrder,@RequestParam(defaultValue = "1") int pageNo, @RequestParam(defaultValue = "10")int pageSize){
        return Result.success(goodsService.findDiscountGoods(sortName,sortOrder,pageNo,pageSize),"分页 查询book 对象");
    }

    @RequestMapping("/getCategoryGoods")
    @ResponseBody
    public Object getCategoryGoods(@RequestParam String sortName,@RequestParam String sortOrder,@RequestParam int id,@RequestParam(defaultValue = "1") int pageNo, @RequestParam(defaultValue = "10")int pageSize){
        return Result.success(goodsService.findCategoryGoods(sortName,sortOrder,id,pageNo,pageSize),"分页 查询book 对象");
    }
}
