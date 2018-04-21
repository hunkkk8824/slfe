package com.selfwork.intelligence.model.vo.dataquality;

import com.selfwork.intelligence.model.vo.BaseQueryVo;

public class DataQualityQueryVo extends BaseQueryVo {

    /**资源编码**/
    private String code;

    /**
     *质量评定 QualityEvaluateEnum
     * **/
    private Integer quality;

    /**
     *审核状态：AuditStatusEnum
     * **/
    private Integer auditStatus;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getQuality() {
        return quality;
    }

    public void setQuality(Integer quality) {
        this.quality = quality;
    }

    public Integer getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(Integer auditStatus) {
        this.auditStatus = auditStatus;
    }


}
