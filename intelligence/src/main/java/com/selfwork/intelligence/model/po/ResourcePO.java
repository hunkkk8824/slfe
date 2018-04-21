package com.selfwork.intelligence.model.po;

import java.util.Date;

public class ResourcePO {
    private Integer id;

    private String code;

    private String name;

    private String datasetCode;

    private String datasetName;

    private Integer preimportTotalCount;

    private Integer importSuccessCount;

    private Short importStatus;

    private String commitUser;

    private String commitUserName;

    private Date commitTime;

    private String auditUser;

    private String auditUserName;

    private Date auditTime;

    private Short auditStatus;

    private Boolean isCancel;

    private Short quality;

    private String sourceExchangerCode;

    private String sourceExchangerName;

    private String createUser;

    private Date createTime;

    private Date lastModifyTime;

    private String lastModifyUser;

    private Boolean valid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDatasetCode() {
        return datasetCode;
    }

    public void setDatasetCode(String datasetCode) {
        this.datasetCode = datasetCode == null ? null : datasetCode.trim();
    }

    public String getDatasetName() {
        return datasetName;
    }

    public void setDatasetName(String datasetName) {
        this.datasetName = datasetName == null ? null : datasetName.trim();
    }

    public Integer getPreimportTotalCount() {
        return preimportTotalCount;
    }

    public void setPreimportTotalCount(Integer preimportTotalCount) {
        this.preimportTotalCount = preimportTotalCount;
    }

    public Integer getImportSuccessCount() {
        return importSuccessCount;
    }

    public void setImportSuccessCount(Integer importSuccessCount) {
        this.importSuccessCount = importSuccessCount;
    }

    public Short getImportStatus() {
        return importStatus;
    }

    public void setImportStatus(Short importStatus) {
        this.importStatus = importStatus;
    }

    public String getCommitUser() {
        return commitUser;
    }

    public void setCommitUser(String commitUser) {
        this.commitUser = commitUser == null ? null : commitUser.trim();
    }

    public String getCommitUserName() {
        return commitUserName;
    }

    public void setCommitUserName(String commitUserName) {
        this.commitUserName = commitUserName == null ? null : commitUserName.trim();
    }

    public Date getCommitTime() {
        return commitTime;
    }

    public void setCommitTime(Date commitTime) {
        this.commitTime = commitTime;
    }

    public String getAuditUser() {
        return auditUser;
    }

    public void setAuditUser(String auditUser) {
        this.auditUser = auditUser == null ? null : auditUser.trim();
    }

    public String getAuditUserName() {
        return auditUserName;
    }

    public void setAuditUserName(String auditUserName) {
        this.auditUserName = auditUserName == null ? null : auditUserName.trim();
    }

    public Date getAuditTime() {
        return auditTime;
    }

    public void setAuditTime(Date auditTime) {
        this.auditTime = auditTime;
    }

    public Short getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(Short auditStatus) {
        this.auditStatus = auditStatus;
    }

    public Boolean getIsCancel() {
        return isCancel;
    }

    public void setIsCancel(Boolean isCancel) {
        this.isCancel = isCancel;
    }

    public Short getQuality() {
        return quality;
    }

    public void setQuality(Short quality) {
        this.quality = quality;
    }

    public String getSourceExchangerCode() {
        return sourceExchangerCode;
    }

    public void setSourceExchangerCode(String sourceExchangerCode) {
        this.sourceExchangerCode = sourceExchangerCode == null ? null : sourceExchangerCode.trim();
    }

    public String getSourceExchangerName() {
        return sourceExchangerName;
    }

    public void setSourceExchangerName(String sourceExchangerName) {
        this.sourceExchangerName = sourceExchangerName == null ? null : sourceExchangerName.trim();
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastModifyTime() {
        return lastModifyTime;
    }

    public void setLastModifyTime(Date lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }

    public String getLastModifyUser() {
        return lastModifyUser;
    }

    public void setLastModifyUser(String lastModifyUser) {
        this.lastModifyUser = lastModifyUser == null ? null : lastModifyUser.trim();
    }

    public Boolean getValid() {
        return valid;
    }

    public void setValid(Boolean valid) {
        this.valid = valid;
    }
}