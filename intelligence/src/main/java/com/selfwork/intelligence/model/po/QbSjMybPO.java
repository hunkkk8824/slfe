package com.selfwork.intelligence.model.po;

public class QbSjMybPO {
    private Integer id;

    private String batchNo;

    private Long mylx;

    private Long xxgslx;

    private Long xxlx;

    private Long mybh;

    private String mymc;

    private Long nbbh;

    private Long bbh;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo == null ? null : batchNo.trim();
    }

    public Long getMylx() {
        return mylx;
    }

    public void setMylx(Long mylx) {
        this.mylx = mylx;
    }

    public Long getXxgslx() {
        return xxgslx;
    }

    public void setXxgslx(Long xxgslx) {
        this.xxgslx = xxgslx;
    }

    public Long getXxlx() {
        return xxlx;
    }

    public void setXxlx(Long xxlx) {
        this.xxlx = xxlx;
    }

    public Long getMybh() {
        return mybh;
    }

    public void setMybh(Long mybh) {
        this.mybh = mybh;
    }

    public String getMymc() {
        return mymc;
    }

    public void setMymc(String mymc) {
        this.mymc = mymc == null ? null : mymc.trim();
    }

    public Long getNbbh() {
        return nbbh;
    }

    public void setNbbh(Long nbbh) {
        this.nbbh = nbbh;
    }

    public Long getBbh() {
        return bbh;
    }

    public void setBbh(Long bbh) {
        this.bbh = bbh;
    }
}