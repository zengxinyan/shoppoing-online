package com.demo.springboot.helloworld.mapper;

import com.demo.springboot.helloworld.common.domain.Cart_goods;
import com.demo.springboot.helloworld.common.domain.Cart_goodsExample;
import com.demo.springboot.helloworld.common.domain.Cart_goodsKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Cart_goodsMapper {
    long countByExample(Cart_goodsExample example);

    int deleteByExample(Cart_goodsExample example);

    int deleteByPrimaryKey(Cart_goodsKey key);

    int insert(Cart_goods record);

    int insertSelective(Cart_goods record);

    List<Cart_goods> selectByExample(Cart_goodsExample example);

    Cart_goods selectByPrimaryKey(Cart_goodsKey key);

    int updateByExampleSelective(@Param("record") Cart_goods record, @Param("example") Cart_goodsExample example);

    int updateByExample(@Param("record") Cart_goods record, @Param("example") Cart_goodsExample example);

    int updateByPrimaryKeySelective(Cart_goods record);

    int updateByPrimaryKey(Cart_goods record);
}