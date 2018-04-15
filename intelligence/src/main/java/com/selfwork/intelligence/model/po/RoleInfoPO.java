package com.selfwork.intelligence.model.po;

import java.util.Date;

public class RoleInfoPO {
    private Integer roleid;

    private String rolecode;

    private String rolename;

    private String productcode;

    private Date createtime;

    private String createuserid;

    private Date lastmodifytime;

    private String lastmodifyuserid;

    private Boolean valid;

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public String getRolecode() {
        return rolecode;
    }

    public void setRolecode(String rolecode) {
        this.rolecode = rolecode == null ? null : rolecode.trim();
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename == null ? null : rolename.trim();
    }

    public String getProductcode() {
        return productcode;
    }

    public void setProductcode(String productcode) {
        this.productcode = productcode == null ? null : productcode.trim();
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

    public Date getLastmodifytime() {
        return lastmodifytime;
    }

    public void setLastmodifytime(Date lastmodifytime) {
        this.lastmodifytime = lastmodifytime;
    }

    public String getLastmodifyuserid() {
        return lastmodifyuserid;
    }

    public void setLastmodifyuserid(String lastmodifyuserid) {
        this.lastmodifyuserid = lastmodifyuserid == null ? null : lastmodifyuserid.trim();
    }

    public Boolean getValid() {
        return valid;
    }

    public void setValid(Boolean valid) {
        this.valid = valid;
    }
}