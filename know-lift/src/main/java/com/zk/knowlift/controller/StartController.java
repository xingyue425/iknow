package com.zk.knowlift.controller;

import com.zk.knowlift.factory.PersionProducer;
import com.zk.knowlift.vo.Building;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StartController {

    @RequestMapping("/start")
    public String startALift(){

        Building building=new Building("zk集团大厦");
        building.openLift();
        PersionProducer producer=new PersionProducer(building);
        Thread producerThread=new Thread(producer);
        producerThread.start();
        try {
            Thread.sleep(60*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "end";
    }
}
