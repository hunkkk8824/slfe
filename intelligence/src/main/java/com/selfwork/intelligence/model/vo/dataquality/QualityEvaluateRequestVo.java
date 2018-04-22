package com.selfwork.intelligence.model.vo.dataquality;

public class QualityEvaluateRequestVo {

    private Integer id;

    //'质量评定：0 未评定1 差2 良3 优',
    private Short quality;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Short getQuality() {
        return quality;
    }

    public void setQuality(Short quality) {
        this.quality = quality;
    }
}
