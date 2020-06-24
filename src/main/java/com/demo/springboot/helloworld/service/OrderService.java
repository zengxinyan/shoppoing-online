package com.demo.springboot.helloworld.service;

import com.demo.springboot.helloworld.common.domain.Ordered;
import com.demo.springboot.helloworld.common.domain.OrderedExample;
import com.demo.springboot.helloworld.mapper.OrderedMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderedMapper orderedMapper;

    public Ordered createOrder(int userId) {
        Ordered order = new Ordered();
        order.setUserId(userId);
        order.setStatus("待付款");
        orderedMapper.insert(order);
        OrderedExample orderedExample = new OrderedExample();
        orderedExample.createCriteria().andTotalIsNull();
        Ordered ordered = orderedMapper.selectByExample(orderedExample).get(0);
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

    public List<Ordered> getOrder(int userId) {
        return orderedMapper.getOrder(userId);
    }

    public void orderAddReceive(int orderId, int receiveId) {
        Ordered ordered = orderedMapper.selectByPrimaryKey(orderId);
        ordered.setReceiveId(receiveId);
        orderedMapper.updateByPrimaryKeySelective(ordered);
    }
}
