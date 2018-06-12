package com.selfwork.intelligence.model.vo.dateset;

import java.math.BigDecimal;

/**
 * Created by zzc on 2018/6/13.
 */
public class LocationDto {
    /**
     * 经度
     */
    private BigDecimal jd;

    /**
     * 维度
     */
    private BigDecimal wd;

    /**
     * 描述
     */
    private String label;

    /**
     * 是否是传感器
     */
    private boolean isCgq = false ;

    public BigDecimal getJd() {
        return jd;
    }

    public void setJd(BigDecimal jd) {
        this.jd = jd;
    }

    public BigDecimal getWd() {
        return wd;
    }

    public void setWd(BigDecimal wd) {
        this.wd = wd;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public boolean isCgq() {
        return isCgq;
    }

    public void setCgq(boolean cgq) {
        isCgq = cgq;
    }
}
