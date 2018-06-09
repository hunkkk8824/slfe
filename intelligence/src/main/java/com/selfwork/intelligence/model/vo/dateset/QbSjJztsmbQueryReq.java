package com.selfwork.intelligence.model.vo.dateset;

import java.util.Date;

public class QbSjJztsmbQueryReq {

    //军民标识
    private Integer jmbz;


    //发报时间
    private String fbsjStartTime;
    private String fbsjEndTime;


    public String getFbsjStartTime() {
        return fbsjStartTime;
    }

    public void setFbsjStartTime(String fbsjStartTime) {
        this.fbsjStartTime = fbsjStartTime;
    }

    public String getFbsjEndTime() {
        return fbsjEndTime;
    }

    public void setFbsjEndTime(String fbsjEndTime) {
        this.fbsjEndTime = fbsjEndTime;
    }

    public Integer getJmbz() {
        return jmbz;
    }

    public void setJmbz(Integer jmbz) {
        this.jmbz = jmbz;
    }


}
