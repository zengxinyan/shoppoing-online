package com.demo.springboot.helloworld.mapper;

import com.demo.springboot.helloworld.common.domain.Ordered;
import com.demo.springboot.helloworld.common.domain.OrderedExample;
import java.util.List;

import com.demo.springboot.helloworld.mapper.extend.OrderedExtendMapper;
import org.apache.ibatis.annotations.Param;

public interface OrderedMapper extends OrderedExtendMapper {
    long countByExample(OrderedExample example);

    int deleteByExample(OrderedExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Ordered record);

    int insertSelective(Ordered record);

    List<Ordered> selectByExample(OrderedExample example);

    Ordered selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Ordered record, @Param("example") OrderedExample example);

    int updateByExample(@Param("record") Ordered record, @Param("example") OrderedExample example);

    int updateByPrimaryKeySelective(Ordered record);

    int updateByPrimaryKey(Ordered record);
}