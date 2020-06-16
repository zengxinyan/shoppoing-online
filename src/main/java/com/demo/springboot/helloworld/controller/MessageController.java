package com.demo.springboot.helloworld.controller;


import com.demo.springboot.helloworld.common.domain.Message;
import com.demo.springboot.helloworld.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MessageController {

    @Autowired
    private MessageService messageService;

    @RequestMapping("/getAllMessage")
    @ResponseBody
    public List<Message> getAllMessage(){
        System.out.println("a");
        return messageService.findAllMessage();
    }

}
