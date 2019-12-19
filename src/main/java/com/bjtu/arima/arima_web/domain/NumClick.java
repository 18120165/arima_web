package com.bjtu.arima.arima_web.domain;

public class NumClick {
    private int RelTime;

    private int NumFollower;

    public void setRelTime(int RelTime){
        this.RelTime = RelTime;
    }
    public int getRelTime(){
        return this.RelTime;
    }
    public void setNumFollower(int NumFollower){
        this.NumFollower = NumFollower;
    }
    public int getNumFollower(){
        return this.NumFollower;
    }

    @Override
    public String toString(){
        return "NumClick{" +
                "RelTime='" + RelTime + '\'' +
                ", NumFollower='" + NumFollower + '\'' +
                '}';
    }
}

