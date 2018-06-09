package com.selfwork.intelligence.model.vo.dateset;

import java.util.Date;

public class QbSjJztsmbQueryReq {

    //军民标识
    private Integer jmbz;


    //发报时间
    private Date fbsjStartTime;
    private Date fbsjEndTime;


    public Date getFbsjStartTime() {
        return fbsjStartTime;
    }

    public void setFbsjStartTime(Date fbsjStartTime) {
        this.fbsjStartTime = fbsjStartTime;
    }

    public Date getFbsjEndTime() {
        return fbsjEndTime;
    }

    public void setFbsjEndTime(Date fbsjEndTime) {
        this.fbsjEndTime = fbsjEndTime;
    }

    public Integer getJmbz() {
        return jmbz;
    }

    public void setJmbz(Integer jmbz) {
        this.jmbz = jmbz;
    }


}
