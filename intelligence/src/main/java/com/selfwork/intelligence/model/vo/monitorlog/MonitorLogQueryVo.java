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
    private Date startTime;
    /**
     * 结束时间
     */
    private Date endTime;

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
