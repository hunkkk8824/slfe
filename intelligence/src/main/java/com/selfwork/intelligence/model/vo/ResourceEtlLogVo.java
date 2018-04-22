package com.selfwork.intelligence.model.vo;

import com.selfwork.intelligence.model.po.ResourceEtlLogPO;

public class ResourceEtlLogVo extends ResourceEtlLogPO {

    private String createTimeStr;

    public String getCreateTimeStr() {
        return createTimeStr;
    }

    public void setCreateTimeStr(String createTimeStr) {
        this.createTimeStr = createTimeStr;
    }
}
