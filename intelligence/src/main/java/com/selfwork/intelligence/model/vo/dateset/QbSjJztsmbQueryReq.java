package com.selfwork.intelligence.model.vo.dateset;

import java.util.Date;

public class QbSjJztsmbQueryReq {

    //军民标识
    private Integer jmbz;


    //发报时间
    private String fbsjStartTime;
    private String fbsjEndTime;

    // ******************* zzc ******************
    /**
     * 传感器编号
     */
    private String cgqbh;
    /**
     * 平台编号、平台名称
     */
    private String ptbh;
    /**
     * 平台类型 （有些表没有此字段）
     */
    private Integer ptlx;
    // ******************* zzc ******************


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

    public String getCgqbh() {
        return cgqbh;
    }

    public void setCgqbh(String cgqbh) {
        this.cgqbh = cgqbh;
    }

    public String getPtbh() {
        return ptbh;
    }

    public void setPtbh(String ptbh) {
        this.ptbh = ptbh;
    }

    public Integer getPtlx() {
        return ptlx;
    }

    public void setPtlx(Integer ptlx) {
        this.ptlx = ptlx;
    }
}
