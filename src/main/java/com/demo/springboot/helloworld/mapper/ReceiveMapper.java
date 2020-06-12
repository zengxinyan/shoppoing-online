package com.demo.springboot.helloworld.mapper;

import com.demo.springboot.helloworld.common.domain.Receive;
import com.demo.springboot.helloworld.common.domain.ReceiveExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ReceiveMapper {
    long countByExample(ReceiveExample example);

    int deleteByExample(ReceiveExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Receive record);

    int insertSelective(Receive record);

    List<Receive> selectByExample(ReceiveExample example);

    Receive selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Receive record, @Param("example") ReceiveExample example);

    int updateByExample(@Param("record") Receive record, @Param("example") ReceiveExample example);

    int updateByPrimaryKeySelective(Receive record);

    int updateByPrimaryKey(Receive record);
}