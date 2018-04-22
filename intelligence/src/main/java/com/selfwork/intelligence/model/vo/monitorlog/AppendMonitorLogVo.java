package com.selfwork.intelligence.model.vo.monitorlog;

import com.selfwork.intelligence.common.enums.OperatorTypeEnum;

import java.util.Date;

public class AppendMonitorLogVo {

    private String resourceId;

    private String resourceCode;

    private String resourceName;

    private String sourceExchangerCode;

    private String sourceExchangerName;

    private String operator;

    private String operatorName;

    private OperatorTypeEnum operatorType;

    private Date operatorTime;

    private String remark;

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public String getResourceCode() {
        return resourceCode;
    }

    public void setResourceCode(String resourceCode) {
        this.resourceCode = resourceCode;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getSourceExchangerCode() {
        return sourceExchangerCode;
    }

    public void setSourceExchangerCode(String sourceExchangerCode) {
        this.sourceExchangerCode = sourceExchangerCode;
    }

    public String getSourceExchangerName() {
        return sourceExchangerName;
    }

    public void setSourceExchangerName(String sourceExchangerName) {
        this.sourceExchangerName = sourceExchangerName;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public OperatorTypeEnum getOperatorType() {
        return operatorType;
    }

    public void setOperatorType(OperatorTypeEnum operatorType) {
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
        this.remark = remark;
    }
}
