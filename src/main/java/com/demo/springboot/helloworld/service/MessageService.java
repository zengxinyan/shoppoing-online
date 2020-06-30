package com.demo.springboot.helloworld.service;

import com.demo.springboot.helloworld.common.domain.Message;
import com.demo.springboot.helloworld.mapper.MessageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    @Autowired
    private MessageMapper messageMapper;

    public List<Message> findAllMessage() {
        return messageMapper.selectByExample(null);
    }
}
