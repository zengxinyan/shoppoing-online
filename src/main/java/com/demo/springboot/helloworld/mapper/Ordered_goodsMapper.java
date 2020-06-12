package com.demo.springboot.helloworld.mapper;

import com.demo.springboot.helloworld.common.domain.Ordered_goods;
import com.demo.springboot.helloworld.common.domain.Ordered_goodsExample;
import com.demo.springboot.helloworld.common.domain.Ordered_goodsKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Ordered_goodsMapper {
    long countByExample(Ordered_goodsExample example);

    int deleteByExample(Ordered_goodsExample example);

    int deleteByPrimaryKey(Ordered_goodsKey key);

    int insert(Ordered_goods record);

    int insertSelective(Ordered_goods record);

    List<Ordered_goods> selectByExample(Ordered_goodsExample example);

    Ordered_goods selectByPrimaryKey(Ordered_goodsKey key);

    int updateByExampleSelective(@Param("record") Ordered_goods record, @Param("example") Ordered_goodsExample example);

    int updateByExample(@Param("record") Ordered_goods record, @Param("example") Ordered_goodsExample example);

    int updateByPrimaryKeySelective(Ordered_goods record);

    int updateByPrimaryKey(Ordered_goods record);
}