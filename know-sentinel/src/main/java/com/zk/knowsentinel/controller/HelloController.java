package com.zk.knowsentinel.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@ResponseBody
public class HelloController {

    @RequestMapping("/hello")
    @SentinelResource(value = "hello", blockHandler = "helloError")
    public String sayHello(){

        return "success";
    }

    public String helloError(BlockException ex){
        return "error";
    }
}
