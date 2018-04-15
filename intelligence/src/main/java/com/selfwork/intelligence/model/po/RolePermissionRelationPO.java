package com.selfwork.intelligence.model.po;

import java.util.Date;

public class RolePermissionRelationPO {
    private Integer rolepermissionrelationid;

    private Integer roleid;

    private Integer permissionid;

    private Date createtime;

    private String createuserid;

    public Integer getRolepermissionrelationid() {
        return rolepermissionrelationid;
    }

    public void setRolepermissionrelationid(Integer rolepermissionrelationid) {
        this.rolepermissionrelationid = rolepermissionrelationid;
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public Integer getPermissionid() {
        return permissionid;
    }

    public void setPermissionid(Integer permissionid) {
        this.permissionid = permissionid;
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