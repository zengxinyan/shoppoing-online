package com.demo.springboot.helloworld.service;

import com.demo.springboot.helloworld.common.domain.Receive;
import com.demo.springboot.helloworld.common.domain.ReceiveExample;
import com.demo.springboot.helloworld.mapper.ReceiveMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReceiveService {

    @Autowired
    ReceiveMapper receiveMapper;

    public List<Receive> getReceive(int userId) {
        ReceiveExample receiveExample = new ReceiveExample();
        receiveExample.createCriteria().andUserIdEqualTo(userId);
        return receiveMapper.selectByExample(receiveExample);
    }

    public void delReceive(int id) {
        receiveMapper.deleteByPrimaryKey(id);
    }

    public void insertReceive(Receive receive) {
        receiveMapper.insert(receive);
    }

    public void updateReceive(Receive receive) {
        receiveMapper.updateByPrimaryKeySelective(receive);
    }

    public Receive selectReceive(int receiveId) {
        return receiveMapper.selectByPrimaryKey(receiveId);
    }
}
