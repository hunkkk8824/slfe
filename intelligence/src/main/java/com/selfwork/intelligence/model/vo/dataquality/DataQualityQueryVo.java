package com.selfwork.intelligence.model.vo.dataquality;

import com.selfwork.intelligence.model.vo.BaseQueryVo;

public class DataQualityQueryVo extends BaseQueryVo {

    /**来源交换机编码**/
    private String sourceExchangerCode;


    /**数据集编码**/
    private String dataSetCode;

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

    public String getDataSetCode() {
        return dataSetCode;
    }

    public void setDataSetCode(String dataSetCode) {
        this.dataSetCode = dataSetCode;
    }

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

    public String getSourceExchangerCode() {
        return sourceExchangerCode;
    }

    public void setSourceExchangerCode(String sourceExchangerCode) {
        this.sourceExchangerCode = sourceExchangerCode;
    }
}
