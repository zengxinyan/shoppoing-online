package com.demo.springboot.helloworld.service;

import com.demo.springboot.helloworld.common.domain.Ordered;
import com.demo.springboot.helloworld.common.domain.OrderedExample;
import com.demo.springboot.helloworld.mapper.OrderedMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class OrderService {

    @Autowired
    private OrderedMapper orderedMapper;

    public Ordered createOrder(int userId) {
        Ordered order = new Ordered();
        order.setUserId(userId);
        order.setStatus("待提交");
        orderedMapper.insert(order);
        Ordered ordered = new Ordered();
        OrderedExample orderedExample = new OrderedExample();
        orderedExample.createCriteria().andTotalIsNull();
        //orderedExample.or().andStatusEqualTo("noId");
        ordered = orderedMapper.selectByExample(orderedExample).get(0);
        return ordered;
    }

    public Ordered updateOrder(int orderId,BigDecimal total) {
        Ordered ordered = orderedMapper.selectOrder(orderId);
        ordered.setTotal(total);
        orderedMapper.updateByPrimaryKeySelective(ordered);
        return ordered;
    }

    public Ordered selectOrder(int orderId) {
        return orderedMapper.selectOrder(orderId);
    }
}
