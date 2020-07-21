package com.zk.knowobjectpool.service;

import com.zk.knowobjectpool.config.sftp.SftpHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SftpService {

    @Autowired
    private SftpHelper sftpHelper;

    public List<String> listFiles(){

        List<String> files=sftpHelper.listFiles("");
        return files;
    }
}
