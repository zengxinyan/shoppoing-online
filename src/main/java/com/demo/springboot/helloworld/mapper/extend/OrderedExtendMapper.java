package com.demo.springboot.helloworld.mapper.extend;

import com.demo.springboot.helloworld.common.domain.Ordered;

import java.util.List;

public interface OrderedExtendMapper {

    Ordered selectOrder(int orderId);

    List<Ordered> getOrder(int userId);

}
