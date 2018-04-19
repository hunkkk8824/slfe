package com.selfwork.intelligence.model.vo.role;

import com.selfwork.intelligence.model.po.PermissionInfoPO;

import java.util.List;

public class UpdateRolePermissionsRequest {
    private String createUserId;
    private Integer roleId;
    private List<PermissionInfoPO> permissions;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public List<PermissionInfoPO> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<PermissionInfoPO> permissions) {
        this.permissions = permissions;
    }

    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }
}
