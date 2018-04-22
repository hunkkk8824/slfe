package com.selfwork.intelligence.model.vo.monitorlog;

import com.selfwork.intelligence.model.vo.BaseQueryVo;

import java.util.Date;

public class MonitorLogQueryVo extends BaseQueryVo {
    /**
     * 资源名称
     */
    private String resourceName;

    /**
     * 开始时间
     */
    private String startTime;
    /**
     * 结束时间
     */
    private String endTime;

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
