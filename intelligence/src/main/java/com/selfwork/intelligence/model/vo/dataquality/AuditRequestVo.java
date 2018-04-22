package com.selfwork.intelligence.model.vo.dataquality;

public class AuditRequestVo {
    private Integer id;

    //审核状态：0 待审核 1 已审核 2 已驳回
    private Short auditStatus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Short getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(Short auditStatus) {
        this.auditStatus = auditStatus;
    }
}
