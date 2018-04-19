package com.selfwork.intelligence.model.vo.user;

import com.selfwork.intelligence.model.po.RoleInfoPO;

import java.util.List;

public class UpdateUserRolesRequest {
    private String createUserId;
    private Integer userId;
    private List<RoleInfoPO> roles;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public List<RoleInfoPO> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleInfoPO> roles) {
        this.roles = roles;
    }

    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }
}
