package com.selfwork.intelligence.model.vo.dataquality;

import com.selfwork.intelligence.model.po.ResourcePO;


public class DataQualitVo extends ResourcePO {
    private String isCancelStr;
    private String auditTimeStr;
    private String auditStatusStr;
    private String commitTimeStr;
    private String importStatusStr;
    private String qualityStr;


    public String getIsCancelStr() {
        return isCancelStr;
    }

    public void setIsCancelStr(String isCancelStr) {
        this.isCancelStr = isCancelStr;
    }

    public String getAuditTimeStr() {
        return auditTimeStr;
    }

    public void setAuditTimeStr(String auditTimeStr) {
        this.auditTimeStr = auditTimeStr;
    }

    public String getAuditStatusStr() {
        return auditStatusStr;
    }

    public void setAuditStatusStr(String auditStatusStr) {
        this.auditStatusStr = auditStatusStr;
    }

    public String getCommitTimeStr() {
        return commitTimeStr;
    }

    public void setCommitTimeStr(String commitTimeStr) {
        this.commitTimeStr = commitTimeStr;
    }

    public String getImportStatusStr() {
        return importStatusStr;
    }

    public void setImportStatusStr(String importStatusStr) {
        this.importStatusStr = importStatusStr;
    }

    public String getQualityStr() {
        return qualityStr;
    }

    public void setQualityStr(String qualityStr) {
        this.qualityStr = qualityStr;
    }
}
