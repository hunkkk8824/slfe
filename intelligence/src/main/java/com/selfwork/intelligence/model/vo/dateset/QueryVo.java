package com.selfwork.intelligence.model.vo.dateset;

import com.selfwork.intelligence.model.vo.BaseQueryVo;

/**
 * Created by zzc on 2018/6/10.
 */
public class QueryVo extends BaseQueryVo {

    private String tableName;
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

    /**
     * 平台名称
     */
    private Integer ptmc;

    //（机舰名）
    private String jjm;

    //JXH（机弦号）
    private String jxh;

    //JMBZ（军民标识）
    private Integer jmbz;

    //上报收时间
    private String sbsjStartTime;
    private String sbsjEndTime;

    //发报时间
    private String fbsjStartTime;
    private String fbsjEndTime;

    // 目标活动规律
    private Double startLongitude;
    private Double startLatitude;
    private Double endLongitude;
    private Double endLatitude;

    public Double getStartLongitude() {
        return startLongitude;
    }

    public void setStartLongitude(Double startLongitude) {
        this.startLongitude = startLongitude;
    }

    public Double getStartLatitude() {
        return startLatitude;
    }

    public void setStartLatitude(Double startLatitude) {
        this.startLatitude = startLatitude;
    }

    public Double getEndLongitude() {
        return endLongitude;
    }

    public void setEndLongitude(Double endLongitude) {
        this.endLongitude = endLongitude;
    }

    public Double getEndLatitude() {
        return endLatitude;
    }

    public void setEndLatitude(Double endLatitude) {
        this.endLatitude = endLatitude;
    }

    public Integer getPtmc() {
        return ptmc;
    }

    public void setPtmc(Integer ptmc) {
        this.ptmc = ptmc;
    }

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



    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
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
