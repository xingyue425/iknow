package com.zk.knowlift.factory;

import com.zk.knowlift.vo.Building;
import com.zk.knowlift.vo.Lift;

public class LiftFactory {

    private static int LIFT_NUM_SEQ=1;


    public static Lift createLift(int liftHigh, Building building){

        String liftName=getLiftName();
        Lift lift=new Lift(liftName,building);
        return lift;
    }
    //生成一个电梯的名称
    private static String getLiftName(){
        String liftName=String.format("%s号电梯",LIFT_NUM_SEQ);
        LIFT_NUM_SEQ++;
        return liftName;
    }
}
