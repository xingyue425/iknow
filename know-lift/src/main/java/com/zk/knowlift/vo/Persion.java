package com.zk.knowlift.vo;

import java.util.Objects;

public class Persion {

    private String userName;//乘客名称
    private Integer isUp;//乘客是想去的上下0下1上
    private Integer homeNum;//乘客想去的楼层
    private Integer nowNum;

    public Persion(String userName,int nowNum,int homeNum){
        this.userName=userName;
        this.isUp=(homeNum>nowNum)?1:0;
        this.homeNum=homeNum;
        this.nowNum=nowNum;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getIsUp() {
        return isUp;
    }

    public void setIsUp(Integer isUp) {
        this.isUp = isUp;
    }

    public Integer getHomeNum() {
        return homeNum;
    }

    public void setHomeNum(Integer homeNum) {
        homeNum = homeNum;
    }

    public Integer getNowNum() {
        return nowNum;
    }

    public void setNowNum(Integer nowNum) {
        this.nowNum = nowNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Persion persion = (Persion) o;
        return Objects.equals(userName, persion.userName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName);
    }
}
