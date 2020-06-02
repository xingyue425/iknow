package com.zk.knowprop.controller;

import com.zk.knowprop.config.SystemConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private SystemConfig systemConfig;

    @RequestMapping("/hello")
    public String sayHello(){
        return systemConfig.getUser();
    }
}
