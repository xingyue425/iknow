package com.zk.knowlift.factory;

import com.zk.knowlift.vo.Building;
import com.zk.knowlift.vo.Persion;

import java.util.Random;

public class PersionProducer implements Runnable{

    private Building building;
    private static int PERSION_INDEX=1;//每次启动从1开始

    private static Random random;

    static {
        random=new Random(100);
    }

    public PersionProducer(Building building){
        this.building=building;
    }

    @Override
    public void run() {

        while (true){

            //校验大厦的开关是不是已经打开了
            if(!building.isOpen()){
                System.out.println(String.format("大厦%s已经关闭，没有新的乘客，电梯关闭！",building.getName()));
                return;
            }
            int nowNum=getNowNum();
            Persion persion=new Persion(getPersionName(),nowNum,getHomeNum(nowNum));
            //将这个人添加到楼层队列中
            building.addPerion(persion);
            //沉默随机的时间
            try {
                Thread.sleep(getSleepTime());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
    private int getSleepTime(){
        Double sleepTime=Math.random()*10*1000;//1-100之间的小数 *1000
        System.out.println(String.format("生产线程沉默%s",sleepTime.intValue()));
        return sleepTime.intValue();
    }
    private String getPersionName(){

        String persionName=PERSION_INDEX+"同志";
        PERSION_INDEX++;
        return persionName;
    }
    private int getFloor(){
        int val=Math.abs(random.nextInt()%(Building.MAX_HORSE_HIGH-1));
        return ++val;
    }
    private int getNowNum(){

        return getFloor();
    }
    private int getHomeNum(int nowNum){

        int homeNum=getFloor();
        while (homeNum==nowNum){
            homeNum=getFloor();
        }
        return homeNum;
    }
}
