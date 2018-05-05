package com.selfwork.intelligence.model.vo.dateset;

import com.selfwork.intelligence.model.po.QbSjYsdzzdzzcmbPO;

public class QbSjYsdzzdzzcmbVO extends QbSjYsdzzdzzcmbPO {

    //接收时间
    private String jssjStr;

    //上报时间
    private String sbsjStr;

    public String getJssjStr() {
        return jssjStr;
    }

    public void setJssjStr(String jssjStr) {
        this.jssjStr = jssjStr;
    }

    public String getSbsjStr() {
        return sbsjStr;
    }

    public void setSbsjStr(String sbsjStr) {
        this.sbsjStr = sbsjStr;
    }
}
