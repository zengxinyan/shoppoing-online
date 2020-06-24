package com.demo.springboot.helloworld.mapper.extend;

import com.demo.springboot.helloworld.common.domain.Ordered;

public interface OrderedExtendMapper {

    Ordered selectOrder(int orderId);

}
