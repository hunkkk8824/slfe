package com.selfwork.intelligence.model.vo.dateset;

import java.util.Date;

public class QbSjRgmbQueryReq {

    //军民标识
    private Integer jmbz;

    //机舰名
    private String jjm;

    //机弦号
    private String jxh;

    //上报收时间
    private String sbsjStartTime;
    private String sbsjEndTime;

    //区域对角线
    private double startLongitude;
    private double startLatitude;
    private double endLongitude;
    private double endLatitude;

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


    public Integer getJmbz() {
        return jmbz;
    }

    public void setJmbz(Integer jmbz) {
        this.jmbz = jmbz;
    }

    public double getStartLongitude() {
        return startLongitude;
    }

    public void setStartLongitude(double startLongitude) {
        this.startLongitude = startLongitude;
    }

    public double getStartLatitude() {
        return startLatitude;
    }

    public void setStartLatitude(double startLatitude) {
        this.startLatitude = startLatitude;
    }

    public double getEndLongitude() {
        return endLongitude;
    }

    public void setEndLongitude(double endLongitude) {
        this.endLongitude = endLongitude;
    }

    public double getEndLatitude() {
        return endLatitude;
    }

    public void setEndLatitude(double endLatitude) {
        this.endLatitude = endLatitude;
    }
}
