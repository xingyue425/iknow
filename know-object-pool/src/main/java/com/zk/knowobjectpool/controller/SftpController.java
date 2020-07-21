package com.zk.knowobjectpool.controller;

import com.zk.knowobjectpool.config.sftp.SftpProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SftpController {

    @Autowired
    private SftpProperties sftpProperties;

    @RequestMapping("/param")
    public String queryPoolParam(){

        return String.valueOf(sftpProperties.getPool().getTestWhileIdle());
    }
}
