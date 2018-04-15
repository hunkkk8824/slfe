package com.selfwork.intelligence.model.po;

import java.util.Date;

public class UserRoleRelationPO {
    private Integer userrolerelationid;

    private Integer userid;

    private Integer roleid;

    private Date createtime;

    private String createuserid;

    public Integer getUserrolerelationid() {
        return userrolerelationid;
    }

    public void setUserrolerelationid(Integer userrolerelationid) {
        this.userrolerelationid = userrolerelationid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getCreateuserid() {
        return createuserid;
    }

    public void setCreateuserid(String createuserid) {
        this.createuserid = createuserid == null ? null : createuserid.trim();
    }
}