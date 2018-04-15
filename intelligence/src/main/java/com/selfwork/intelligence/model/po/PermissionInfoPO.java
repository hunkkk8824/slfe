package com.selfwork.intelligence.model.po;

import java.util.Date;

public class PermissionInfoPO {
    private Integer permissionid;

    private String permissionname;

    private String permissioncode;

    private Short permissiontype;

    private Integer parentid;

    private Boolean isindexdisplay;

    private String menuurl;

    private String productcode;

    private Date createtime;

    private String createuserid;

    private Date lastmodifytime;

    private String lastmodifyuserid;

    private Boolean valid;

    private String menuicon;

    public Integer getPermissionid() {
        return permissionid;
    }

    public void setPermissionid(Integer permissionid) {
        this.permissionid = permissionid;
    }

    public String getPermissionname() {
        return permissionname;
    }

    public void setPermissionname(String permissionname) {
        this.permissionname = permissionname == null ? null : permissionname.trim();
    }

    public String getPermissioncode() {
        return permissioncode;
    }

    public void setPermissioncode(String permissioncode) {
        this.permissioncode = permissioncode == null ? null : permissioncode.trim();
    }

    public Short getPermissiontype() {
        return permissiontype;
    }

    public void setPermissiontype(Short permissiontype) {
        this.permissiontype = permissiontype;
    }

    public Integer getParentid() {
        return parentid;
    }

    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }

    public Boolean getIsindexdisplay() {
        return isindexdisplay;
    }

    public void setIsindexdisplay(Boolean isindexdisplay) {
        this.isindexdisplay = isindexdisplay;
    }

    public String getMenuurl() {
        return menuurl;
    }

    public void setMenuurl(String menuurl) {
        this.menuurl = menuurl == null ? null : menuurl.trim();
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

    public String getMenuicon() {
        return menuicon;
    }

    public void setMenuicon(String menuicon) {
        this.menuicon = menuicon == null ? null : menuicon.trim();
    }
}