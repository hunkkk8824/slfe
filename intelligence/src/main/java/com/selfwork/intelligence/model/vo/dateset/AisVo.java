package com.selfwork.intelligence.model.vo.dateset;

import com.selfwork.intelligence.model.po.AisPO;

public class AisVo extends AisPO{
    //上报时间
    private String etaStr;

    private String shipStatusStr;

    private String shipTypeStr;

    public String getEtaStr() {
        return etaStr;
    }

    public void setEtaStr(String etaStr) {
        this.etaStr = etaStr;
    }

    public String getShipStatusStr() {
        return shipStatusStr;
    }

    public void setShipStatusStr(String shipStatusStr) {
        this.shipStatusStr = shipStatusStr;
    }

    public String getShipTypeStr() {
        return shipTypeStr;
    }

    public void setShipTypeStr(String shipTypeStr) {
        this.shipTypeStr = shipTypeStr;
    }
}
