package com.bjtu.arima.arima_web.domain;

import java.sql.Date;

import java.util.List;

public class ActiveRequest {

    private int PubInfoTopicID;

    private int PublisherInf;

    private String TopicName;

    private Date PublishTime;

    private List<NumRetweet> NumRetweet ;

    private List<NumComment> NumComment ;

    public int getPubInfoTopicID() {
        return this.PubInfoTopicID;
    }

    public void setPubInfoTopicID(int pubInfoTopicID) {
        PubInfoTopicID = pubInfoTopicID;
    }

    public void setPublisherInf(int PublisherInf){
        this.PublisherInf = PublisherInf;
    }
    public int getPublisherInf(){
        return this.PublisherInf;
    }
    public void setTopicName(String TopicName){
        this.TopicName = TopicName;
    }
    public String getTopicName(){
        return this.TopicName;
    }
    public void setPublishTime(Date PublishTime){
        this.PublishTime = PublishTime;
    }
    public Date getPublishTime(){
        return this.PublishTime;
    }
    public void setNumRetweet(List<NumRetweet> NumRetweet){
        this.NumRetweet = NumRetweet;
    }
    public List<NumRetweet> getNumRetweet(){
        return this.NumRetweet;
    }
    public void setNumComment(List<NumComment> NumComment){
        this.NumComment = NumComment;
    }
    public List<NumComment> getNumComment(){
        return this.NumComment;
    }

    @Override
    public String toString() {
        return "ActiveRequest{" +
                "PubInfoTopicID='" + PubInfoTopicID + '\'' +
                ", PublisherInf='" + PublisherInf + '\'' +
                ", TopicName='" + TopicName + '\'' +
                ", PublishTime='" + PublishTime + '\'' +
                ", NumRetweet='" + NumRetweet.toString() + '\'' +
                ", NumComment='" + NumComment.toString() + '\'' +
                '}';
    }
}