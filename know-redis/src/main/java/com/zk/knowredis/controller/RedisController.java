package com.zk.knowredis.controller;

import com.zk.knowredis.redis.JedisClientCluster;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisController {


    @Autowired
    private JedisClientCluster jedisClientCluster;

    @RequestMapping("/say")
    public String sayHello(){

        jedisClientCluster.set("aaa","jiujiu");
        return "success";
    }
}
