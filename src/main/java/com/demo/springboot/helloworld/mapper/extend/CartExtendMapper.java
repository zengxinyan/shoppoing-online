package com.demo.springboot.helloworld.mapper.extend;

import com.demo.springboot.helloworld.common.domain.Cart;
import com.demo.springboot.helloworld.common.domain.Goods;

import java.util.List;

public interface CartExtendMapper {

    Cart selectById(int cartId);

}
