package com.demo.springboot.helloworld.mapper.extend;

import com.demo.springboot.helloworld.common.domain.Cart;

public interface CartExtendMapper {

    Cart selectById(int cartId);

}
