package com.selfwork.intelligence.model.vo.dateset;

import com.selfwork.intelligence.model.po.ScoutQbTableBdPO;

import java.util.Date;

public class ScoutQbTableBdVO extends ScoutQbTableBdPO {

    private String writeTimeStr;
    private String sendGramTimeStr;
    private String sendTimeStr;

    public String getWriteTimeStr() {
        return writeTimeStr;
    }

    public void setWriteTimeStr(String writeTimeStr) {
        this.writeTimeStr = writeTimeStr;
    }

    public String getSendGramTimeStr() {
        return sendGramTimeStr;
    }

    public void setSendGramTimeStr(String sendGramTimeStr) {
        this.sendGramTimeStr = sendGramTimeStr;
    }

    public String getSendTimeStr() {
        return sendTimeStr;
    }

    public void setSendTimeStr(String sendTimeStr) {
        this.sendTimeStr = sendTimeStr;
    }
}
