package com.demo.springboot.helloworld.controller;


import com.demo.springboot.helloworld.common.domain.Receive;
import com.demo.springboot.helloworld.service.ReceiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ReceiveController {

    @Autowired
    ReceiveService receiveService;

    @RequestMapping("/receive")
    public String receive(int userId, Model model){
        model.addAttribute("receive",receiveService.getReceive(userId));
        model.addAttribute("userId",userId);
        return "/goods/receive";
    }

    @RequestMapping("/delReceive")
    @ResponseBody
    public void delReceive(int id){
        receiveService.delReceive(id);
    }

    @RequestMapping("/insertReceive")
    @ResponseBody
    public void insertReceive(Receive receive){
        receiveService.insertReceive(receive);
    }

    @RequestMapping("/updateReceive")
    @ResponseBody
    public void updateReceive(Receive receive){
        receiveService.updateReceive(receive);
    }

    @RequestMapping("/getReceive")
    @ResponseBody
    public List<Receive> getReceive(int userId){
        return receiveService.getReceive(userId);
    }

}
