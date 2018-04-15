package com.selfwork.intelligence.model.po;

import java.util.Date;

public class VehiclePO {
    private Integer vehicleid;

    private String vehiclecode;

    private String platenum;

    private String platecolorcode;

    private String platecolorname;

    private String simnum;

    private Integer provinceid;

    private String provincename;

    private Integer cityid;

    private String cityname;

    private Integer districtid;

    private String districtname;

    private Integer companyid;

    private String companyname;

    private Integer vehicletypeid;

    private String vehicletypecode;

    private String vehicletypename;

    private Integer terminaltypeid;

    private String terminaltypename;

    private String terminalmodel;

    private Integer operatorid;

    private String operatorname;

    private String platformcode;

    private Integer vehicleoperatetypeid;

    private String vehicleoperatetypecode;

    private String vehicleoperatetypename;

    private Date createtime;

    private String createuserid;

    private Date lastmodifytime;

    private String lastmodifyuserid;

    private Boolean valid;

    private Integer operstate;

    public Integer getVehicleid() {
        return vehicleid;
    }

    public void setVehicleid(Integer vehicleid) {
        this.vehicleid = vehicleid;
    }

    public String getVehiclecode() {
        return vehiclecode;
    }

    public void setVehiclecode(String vehiclecode) {
        this.vehiclecode = vehiclecode == null ? null : vehiclecode.trim();
    }

    public String getPlatenum() {
        return platenum;
    }

    public void setPlatenum(String platenum) {
        this.platenum = platenum == null ? null : platenum.trim();
    }

    public String getPlatecolorcode() {
        return platecolorcode;
    }

    public void setPlatecolorcode(String platecolorcode) {
        this.platecolorcode = platecolorcode == null ? null : platecolorcode.trim();
    }

    public String getPlatecolorname() {
        return platecolorname;
    }

    public void setPlatecolorname(String platecolorname) {
        this.platecolorname = platecolorname == null ? null : platecolorname.trim();
    }

    public String getSimnum() {
        return simnum;
    }

    public void setSimnum(String simnum) {
        this.simnum = simnum == null ? null : simnum.trim();
    }

    public Integer getProvinceid() {
        return provinceid;
    }

    public void setProvinceid(Integer provinceid) {
        this.provinceid = provinceid;
    }

    public String getProvincename() {
        return provincename;
    }

    public void setProvincename(String provincename) {
        this.provincename = provincename == null ? null : provincename.trim();
    }

    public Integer getCityid() {
        return cityid;
    }

    public void setCityid(Integer cityid) {
        this.cityid = cityid;
    }

    public String getCityname() {
        return cityname;
    }

    public void setCityname(String cityname) {
        this.cityname = cityname == null ? null : cityname.trim();
    }

    public Integer getDistrictid() {
        return districtid;
    }

    public void setDistrictid(Integer districtid) {
        this.districtid = districtid;
    }

    public String getDistrictname() {
        return districtname;
    }

    public void setDistrictname(String districtname) {
        this.districtname = districtname == null ? null : districtname.trim();
    }

    public Integer getCompanyid() {
        return companyid;
    }

    public void setCompanyid(Integer companyid) {
        this.companyid = companyid;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname == null ? null : companyname.trim();
    }

    public Integer getVehicletypeid() {
        return vehicletypeid;
    }

    public void setVehicletypeid(Integer vehicletypeid) {
        this.vehicletypeid = vehicletypeid;
    }

    public String getVehicletypecode() {
        return vehicletypecode;
    }

    public void setVehicletypecode(String vehicletypecode) {
        this.vehicletypecode = vehicletypecode == null ? null : vehicletypecode.trim();
    }

    public String getVehicletypename() {
        return vehicletypename;
    }

    public void setVehicletypename(String vehicletypename) {
        this.vehicletypename = vehicletypename == null ? null : vehicletypename.trim();
    }

    public Integer getTerminaltypeid() {
        return terminaltypeid;
    }

    public void setTerminaltypeid(Integer terminaltypeid) {
        this.terminaltypeid = terminaltypeid;
    }

    public String getTerminaltypename() {
        return terminaltypename;
    }

    public void setTerminaltypename(String terminaltypename) {
        this.terminaltypename = terminaltypename == null ? null : terminaltypename.trim();
    }

    public String getTerminalmodel() {
        return terminalmodel;
    }

    public void setTerminalmodel(String terminalmodel) {
        this.terminalmodel = terminalmodel == null ? null : terminalmodel.trim();
    }

    public Integer getOperatorid() {
        return operatorid;
    }

    public void setOperatorid(Integer operatorid) {
        this.operatorid = operatorid;
    }

    public String getOperatorname() {
        return operatorname;
    }

    public void setOperatorname(String operatorname) {
        this.operatorname = operatorname == null ? null : operatorname.trim();
    }

    public String getPlatformcode() {
        return platformcode;
    }

    public void setPlatformcode(String platformcode) {
        this.platformcode = platformcode == null ? null : platformcode.trim();
    }

    public Integer getVehicleoperatetypeid() {
        return vehicleoperatetypeid;
    }

    public void setVehicleoperatetypeid(Integer vehicleoperatetypeid) {
        this.vehicleoperatetypeid = vehicleoperatetypeid;
    }

    public String getVehicleoperatetypecode() {
        return vehicleoperatetypecode;
    }

    public void setVehicleoperatetypecode(String vehicleoperatetypecode) {
        this.vehicleoperatetypecode = vehicleoperatetypecode == null ? null : vehicleoperatetypecode.trim();
    }

    public String getVehicleoperatetypename() {
        return vehicleoperatetypename;
    }

    public void setVehicleoperatetypename(String vehicleoperatetypename) {
        this.vehicleoperatetypename = vehicleoperatetypename == null ? null : vehicleoperatetypename.trim();
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

    public Integer getOperstate() {
        return operstate;
    }

    public void setOperstate(Integer operstate) {
        this.operstate = operstate;
    }
}