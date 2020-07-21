package com.zk.knowprop.controller;

import com.zk.knowprop.config.RedisProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisController {

    @Autowired
    private RedisProperty redisProperties;

    @RequestMapping("/redis")
    public String getPro(){

        return redisProperties.getNodes();
    }
}
