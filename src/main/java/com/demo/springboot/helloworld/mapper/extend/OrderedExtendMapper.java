package com.demo.springboot.helloworld.mapper.extend;

import com.demo.springboot.helloworld.common.domain.Ordered;
import com.sun.org.apache.xpath.internal.operations.Or;

import java.util.List;

public interface OrderedExtendMapper {

    Ordered selectOrder(int orderId);

    List<Ordered> getOrder(int userId);

}
