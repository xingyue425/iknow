package com.zk.knowtest.controller;

import com.zk.config.sftp.SftpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloController {

    @Autowired
    private SftpService sftpService;

    @RequestMapping("/hello")
    public String sayHello(){

        List<String> files=sftpService.listFiles("award/");
        return "success:"+files.size();
    }
}
