package com.zk.knowobjectpool.task;

import com.zk.knowobjectpool.service.SftpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Component
public class SftpScheduling {

    @Autowired
    private SftpService sftpService;

    @Scheduled(cron = "0/5 * * * * ?")
    public void listFile(){

        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss ");
        System.out.println(String.format("------------%s--------------",sdf.format(d)));
        List<String> files=sftpService.listFiles();
        if(files!=null && files.size()>0) {
            for (String item:files) {
                System.out.println(item);
            }
        }else{
            System.out.println("失去连接或是没有获取到内容");
        }
        System.out.println("--------------------------");
    }
}
