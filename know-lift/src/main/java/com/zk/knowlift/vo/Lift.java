package com.zk.knowlift.vo;

import java.util.HashSet;
import java.util.Set;
//假设写死电梯就是23层高跟楼高一样
public class Lift implements Runnable{

    //几号电梯
    private String liftNum;
    //电梯的实时方向 0代表静止不动1代表向上2代表向下
    private Integer isUp;
    //电梯上有多少人
    private Set<Persion> persions;
    //电梯目前所在楼层
    private Integer floor;
    //该电梯最高可达楼层
    private Integer MAX_FLOOR;
    //该电梯所属的大厦
    private Building building;

    public Lift(String liftNum,Building building){
        this.liftNum=liftNum;
        isUp=0;//默认静止不动
        persions=new HashSet<Persion>();//电梯里没人
        floor=1;//在一楼
        MAX_FLOOR=Building.MAX_HORSE_HIGH;//默认跟楼房一样高
        this.building=building;
    }

    @Override
    public void run() {
        while (true){
            if(!isFree()){
                //电梯里面还有人,那就需要先把电梯里面的人送完才可以
                if(isUp==1){
                    //电梯向上
                    floor++;
                    System.out.println(String.format("电梯%s目前到达%s电梯运行方向%s目前电梯上共有%s",
                            liftNum,floor,"向上",persions.size()));
                }else if(isUp==2){
                    //电梯向下
                    System.out.println(String.format("电梯%s目前停留在%s电梯运行方向%s目前电梯上共有%s",
                            liftNum,floor,"向下",persions.size()));
                }else{
                    //说明刚有进电梯的
                }
            }else if(!building.isFree()){
                //有楼层有人在等电梯
            }else{
                try {
                    //如果空闲呢就等待10秒钟然后再执行
                    Thread.sleep(10*1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private boolean isFree(){

        return (persions==null) || (persions.size()==0);
    }
}
