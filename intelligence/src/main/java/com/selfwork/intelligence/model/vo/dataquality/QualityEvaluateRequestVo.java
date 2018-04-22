package com.selfwork.intelligence.model.vo.dataquality;

public class QualityEvaluateRequestVo {

    private Integer resourceId;

    //'质量评定：0 未评定1 差2 良3 优',
    private Short quality;


    public Integer getResourceId() {
        return resourceId;
    }

    public void setResourceId(Integer resourceId) {
        this.resourceId = resourceId;
    }

    public Short getQuality() {
        return quality;
    }

    public void setQuality(Short quality) {
        this.quality = quality;
    }
}
