package com.zk.knowlift.vo;

import com.zk.knowlift.factory.LiftFactory;

import java.util.*;

public class Building {

    //楼高23层
    public static int MAX_HORSE_HIGH=23;
    //用来保存哪一个楼层有一群人的集合，其实就是抽象的楼的概念
    private Map<Integer, Set<Persion>> persionMap=new HashMap<Integer, Set<Persion>>();
    private boolean open;//控制电梯和人产生的开关，开启以后电梯和人工厂都开始运行，反之
    private String name;//大厦名称
    private List<Lift> lifts;//电梯列表

    public Building(String name){
        //初始化一栋大厦
        this.open=false;//默认关闭
        this.name=name;//大厦名称
        Lift lift= LiftFactory.createLift(MAX_HORSE_HIGH,this);//现在只有一部电梯
        lifts=new ArrayList<Lift>();
        lifts.add(lift);
    }
    //加入该层的等待集合
    public void addPerion(Persion persion){
        //来了一个人等待电梯
        System.out.println(String.format("接收到产生的人名称%s现在在%s楼想去%s楼",
                persion.getUserName(),persion.getNowNum(),persion.getHomeNum()));
        int nowFloor=persion.getNowNum();
        Set<Persion> persions=persionMap.get(nowFloor);
        if(persions==null){
            persions=new HashSet<Persion>();
            persions.add(persion);
        }
        persionMap.put(nowFloor,persions);
    }
    //已经上了电梯，等待集合里面没有这个人了
    public void removePersion(List<Persion> list){
        if(list!=null && list.size()>0){
            for (Persion item:list){
                int nowFloor=item.getNowNum();
                Set<Persion> persions=persionMap.get(nowFloor);
                for(Persion waitPersion:persions){
                    if(waitPersion.equals(item)){
                        persions.remove(waitPersion);
                        break;
                    }
                }
            }
        }
    }

    public void openLift(){
        this.open=true;
    }
    public void closeLift(){
        this.open=false;
    }
    public boolean isOpen(){
        return this.open;
    }
    public String getName(){
        return this.name;
    }
    public boolean isFree(){
        return persionMap.size()==0;
    }
}
