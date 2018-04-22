package com.selfwork.intelligence.model.vo.dataquality;

import com.selfwork.intelligence.model.vo.BaseQueryVo;

public class ResourceEtlLogQueryVo extends BaseQueryVo{

    private Integer resourceId;

    public Integer getResourceId() {
        return resourceId;
    }

    public void setResourceId(Integer resourceId) {
        this.resourceId = resourceId;
    }
}
