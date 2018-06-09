package com.selfwork.intelligence.model.vo.dateset;

import java.util.Date;

public class QbSjYsdzztmmbQueryReq {

    //上报收时间
    private Date sbsjStartTime;
    private Date sbsjEndTime;


    //机舰名
    private String jjm;

    //机弦号
    private String jxh;

    public String getJjm() {
        return jjm;
    }

    public void setJjm(String jjm) {
        this.jjm = jjm;
    }

    public String getJxh() {
        return jxh;
    }

    public void setJxh(String jxh) {
        this.jxh = jxh;
    }

    public Date getSbsjStartTime() {
        return sbsjStartTime;
    }

    public void setSbsjStartTime(Date sbsjStartTime) {
        this.sbsjStartTime = sbsjStartTime;
    }

    public Date getSbsjEndTime() {
        return sbsjEndTime;
    }

    public void setSbsjEndTime(Date sbsjEndTime) {
        this.sbsjEndTime = sbsjEndTime;
    }

}
