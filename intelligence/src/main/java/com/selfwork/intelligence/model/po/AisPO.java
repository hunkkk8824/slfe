package com.selfwork.intelligence.model.po;

import java.math.BigDecimal;
import java.util.Date;

public class AisPO {
    private Integer id;

    private Integer navStatus;

    private BigDecimal rot;

    private BigDecimal sog;

    private String posAcc;

    private BigDecimal longitude;

    private BigDecimal latitude;

    private Integer cog;

    private Integer trueHead;

    private Date eta;

    private String destid;

    private String srcid;

    private BigDecimal distance;

    private BigDecimal speed;

    private BigDecimal draught;

    private Integer shipType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNavStatus() {
        return navStatus;
    }

    public void setNavStatus(Integer navStatus) {
        this.navStatus = navStatus;
    }

    public BigDecimal getRot() {
        return rot;
    }

    public void setRot(BigDecimal rot) {
        this.rot = rot;
    }

    public BigDecimal getSog() {
        return sog;
    }

    public void setSog(BigDecimal sog) {
        this.sog = sog;
    }

    public String getPosAcc() {
        return posAcc;
    }

    public void setPosAcc(String posAcc) {
        this.posAcc = posAcc == null ? null : posAcc.trim();
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public Integer getCog() {
        return cog;
    }

    public void setCog(Integer cog) {
        this.cog = cog;
    }

    public Integer getTrueHead() {
        return trueHead;
    }

    public void setTrueHead(Integer trueHead) {
        this.trueHead = trueHead;
    }

    public Date getEta() {
        return eta;
    }

    public void setEta(Date eta) {
        this.eta = eta;
    }

    public String getDestid() {
        return destid;
    }

    public void setDestid(String destid) {
        this.destid = destid == null ? null : destid.trim();
    }

    public String getSrcid() {
        return srcid;
    }

    public void setSrcid(String srcid) {
        this.srcid = srcid == null ? null : srcid.trim();
    }

    public BigDecimal getDistance() {
        return distance;
    }

    public void setDistance(BigDecimal distance) {
        this.distance = distance;
    }

    public BigDecimal getSpeed() {
        return speed;
    }

    public void setSpeed(BigDecimal speed) {
        this.speed = speed;
    }

    public BigDecimal getDraught() {
        return draught;
    }

    public void setDraught(BigDecimal draught) {
        this.draught = draught;
    }

    public Integer getShipType() {
        return shipType;
    }

    public void setShipType(Integer shipType) {
        this.shipType = shipType;
    }
}