package com.selfwork.intelligence.model.po;

import java.util.Date;

public class UserInfoPO {
    private Integer userid;

    private String useraccount;

    private String cellphone;

    private Integer companyid;

    private String organizationname;

    private String nickname;

    private String realname;

    private Short gender;

    private Date birthday;

    private String idnumber;

    private String passwordsalt;

    private String password;

    private String accountpicture;

    private Short accounttype;

    private String productcode;

    private Date createtime;

    private String createuserid;

    private Date lastmodifytime;

    private String lastmodifyuserid;

    private Boolean valid;

    private Short organizationtype;

    private Short isemergencycontact;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUseraccount() {
        return useraccount;
    }

    public void setUseraccount(String useraccount) {
        this.useraccount = useraccount == null ? null : useraccount.trim();
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone == null ? null : cellphone.trim();
    }

    public Integer getCompanyid() {
        return companyid;
    }

    public void setCompanyid(Integer companyid) {
        this.companyid = companyid;
    }

    public String getOrganizationname() {
        return organizationname;
    }

    public void setOrganizationname(String organizationname) {
        this.organizationname = organizationname == null ? null : organizationname.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname == null ? null : realname.trim();
    }

    public Short getGender() {
        return gender;
    }

    public void setGender(Short gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getIdnumber() {
        return idnumber;
    }

    public void setIdnumber(String idnumber) {
        this.idnumber = idnumber == null ? null : idnumber.trim();
    }

    public String getPasswordsalt() {
        return passwordsalt;
    }

    public void setPasswordsalt(String passwordsalt) {
        this.passwordsalt = passwordsalt == null ? null : passwordsalt.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getAccountpicture() {
        return accountpicture;
    }

    public void setAccountpicture(String accountpicture) {
        this.accountpicture = accountpicture == null ? null : accountpicture.trim();
    }

    public Short getAccounttype() {
        return accounttype;
    }

    public void setAccounttype(Short accounttype) {
        this.accounttype = accounttype;
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

    public Short getOrganizationtype() {
        return organizationtype;
    }

    public void setOrganizationtype(Short organizationtype) {
        this.organizationtype = organizationtype;
    }

    public Short getIsemergencycontact() {
        return isemergencycontact;
    }

    public void setIsemergencycontact(Short isemergencycontact) {
        this.isemergencycontact = isemergencycontact;
    }
}