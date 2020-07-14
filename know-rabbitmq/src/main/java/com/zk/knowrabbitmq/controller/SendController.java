package com.zk.knowrabbitmq.controller;

import com.zk.knowrabbitmq.sender.RabbitSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SendController {

    @Autowired
    private RabbitSender rabbitSender;

    @RequestMapping("/send")
    public String sendMessage(){
        try {
            rabbitSender.send("hahahha",null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "success";
    }
}
