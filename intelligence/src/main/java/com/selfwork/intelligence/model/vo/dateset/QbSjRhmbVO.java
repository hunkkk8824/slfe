package com.selfwork.intelligence.model.vo.dateset;

import com.selfwork.intelligence.common.DateUtils;
import com.selfwork.intelligence.model.po.QbSjRhmbPO;

import java.util.Date;

public class QbSjRhmbVO extends QbSjRhmbPO {

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
