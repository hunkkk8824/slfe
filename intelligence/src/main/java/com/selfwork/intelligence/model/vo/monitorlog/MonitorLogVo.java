package com.selfwork.intelligence.model.vo.monitorlog;

import com.selfwork.intelligence.model.po.ResourceMonitorLogPO;

/**
 * 监控日志VO
 */
public class MonitorLogVo extends ResourceMonitorLogPO {
    private String operatorTimeStr;
    private String operatorTypeStr;

    public String getOperatorTimeStr() {
        return operatorTimeStr;
    }

    public void setOperatorTimeStr(String operatorTimeStr) {
        this.operatorTimeStr = operatorTimeStr;
    }

    public String getOperatorTypeStr() {
        return operatorTypeStr;
    }

    public void setOperatorTypeStr(String operatorTypeStr) {
        this.operatorTypeStr = operatorTypeStr;
    }
}
