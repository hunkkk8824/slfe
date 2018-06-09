package com.selfwork.intelligence.model.vo.dateset;

import java.util.Date;

public class QbSjYsdzzdzzcmbQueryReq {
//
//    //军民标识
//    private Integer jmbz;


    //上报收时间
    private String sbsjStartTime;
    private String sbsjEndTime;


    //机舰名
    private String jjm;

    //机弦号
    private String jxh;

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

//    public Integer getJmbz() {
//        return jmbz;
//    }
//
//    public void setJmbz(Integer jmbz) {
//        this.jmbz = jmbz;
//    }


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
