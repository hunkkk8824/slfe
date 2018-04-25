package com.selfwork.intelligence.model.vo.dataquality;

import com.selfwork.intelligence.model.vo.BaseQueryVo;

public class DetailQueryVo extends BaseQueryVo {
    private String dataSetCode;
    private String resourceCode;

    public String getDataSetCode() {
        return dataSetCode;
    }

    public void setDataSetCode(String dataSetCode) {
        this.dataSetCode = dataSetCode;
    }

    public String getResourceCode() {
        return resourceCode;
    }

    public void setResourceCode(String resourceCode) {
        this.resourceCode = resourceCode;
    }
}
