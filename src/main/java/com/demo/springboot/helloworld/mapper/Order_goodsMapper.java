package com.demo.springboot.helloworld.mapper;

import com.demo.springboot.helloworld.common.domain.Order_goods;
import com.demo.springboot.helloworld.common.domain.Order_goodsExample;
import com.demo.springboot.helloworld.common.domain.Order_goodsKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Order_goodsMapper {
    long countByExample(Order_goodsExample example);

    int deleteByExample(Order_goodsExample example);

    int deleteByPrimaryKey(Order_goodsKey key);

    int insert(Order_goods record);

    int insertSelective(Order_goods record);

    List<Order_goods> selectByExample(Order_goodsExample example);

    Order_goods selectByPrimaryKey(Order_goodsKey key);

    int updateByExampleSelective(@Param("record") Order_goods record, @Param("example") Order_goodsExample example);

    int updateByExample(@Param("record") Order_goods record, @Param("example") Order_goodsExample example);

    int updateByPrimaryKeySelective(Order_goods record);

    int updateByPrimaryKey(Order_goods record);
}