package com.selfwork.intelligence.model.vo.dateset;

import java.util.Date;

public class QbSjDptssmbQueryReq {

    //军民标识
    private Integer jmbz;


    //上报收时间
    private String sbsjStartTime;
    private String sbsjEndTime;

    public String getSbsjStartTime() {
        return sbsjStartTime;
    }

    public void setSbsjStartTime(String sbsjStartTime) {
        this.sbsjStartTime = sbsjStartTime;
    }

    public String getSbsjEndTime() {
        return sbsjEndTime;
    }

    public void setSbsjEndTime(String sbsjEndTime) {
        this.sbsjEndTime = sbsjEndTime;
    }

    public Integer getJmbz() {
        return jmbz;
    }

    public void setJmbz(Integer jmbz) {
        this.jmbz = jmbz;
    }
}
