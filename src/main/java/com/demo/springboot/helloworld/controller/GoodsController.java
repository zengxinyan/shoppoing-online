package com.demo.springboot.helloworld.controller;

import com.demo.springboot.helloworld.common.utils.Result;
import com.demo.springboot.helloworld.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GoodsController {
    @Autowired
    private GoodsService goodsService;

    @RequestMapping("/getAllGoods")
    @ResponseBody
    public Object getAllGoods(@RequestParam(defaultValue = "1") int pageNo, @RequestParam(defaultValue = "10")int pageSize){
        System.out.println("1111111");
        return Result.success(goodsService.findAllGoods(pageNo,pageSize),"分页 查询book 对象");
    }

    @RequestMapping("/getHotGoods")
    @ResponseBody
    public Object getHotGoods(@RequestParam(defaultValue = "1") int pageNo, @RequestParam(defaultValue = "10")int pageSize){
        return Result.success(goodsService.findHotGoods(pageNo,pageSize),"分页 查询book 对象");
    }

    @RequestMapping("/getDiscountGoods")
    @ResponseBody
    public Object getDiscountGoods(@RequestParam(defaultValue = "1") int pageNo, @RequestParam(defaultValue = "10")int pageSize){
        return Result.success(goodsService.findDiscountGoods(pageNo,pageSize),"分页 查询book 对象");
    }
}
