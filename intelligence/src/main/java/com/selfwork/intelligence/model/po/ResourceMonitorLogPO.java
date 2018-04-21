package com.selfwork.intelligence.model.po;

import java.util.Date;

public class ResourceMonitorLogPO {
    private Integer id;

    private String resourceId;

    private String resourceCode;

    private String resourceName;

    private String sourceExchangerCode;

    private String sourceExchangerName;

    private String operator;

    private String operatorName;

    private Short operatorType;

    private Date operatorTime;

    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId == null ? null : resourceId.trim();
    }

    public String getResourceCode() {
        return resourceCode;
    }

    public void setResourceCode(String resourceCode) {
        this.resourceCode = resourceCode == null ? null : resourceCode.trim();
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName == null ? null : resourceName.trim();
    }

    public String getSourceExchangerCode() {
        return sourceExchangerCode;
    }

    public void setSourceExchangerCode(String sourceExchangerCode) {
        this.sourceExchangerCode = sourceExchangerCode == null ? null : sourceExchangerCode.trim();
    }

    public String getSourceExchangerName() {
        return sourceExchangerName;
    }

    public void setSourceExchangerName(String sourceExchangerName) {
        this.sourceExchangerName = sourceExchangerName == null ? null : sourceExchangerName.trim();
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName == null ? null : operatorName.trim();
    }

    public Short getOperatorType() {
        return operatorType;
    }

    public void setOperatorType(Short operatorType) {
        this.operatorType = operatorType;
    }

    public Date getOperatorTime() {
        return operatorTime;
    }

    public void setOperatorTime(Date operatorTime) {
        this.operatorTime = operatorTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}