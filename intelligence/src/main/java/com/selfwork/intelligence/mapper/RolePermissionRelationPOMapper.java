package com.selfwork.intelligence.mapper;

import com.selfwork.intelligence.model.po.RolePermissionRelationPO;

public interface RolePermissionRelationPOMapper {
    int deleteByPrimaryKey(Integer rolepermissionrelationid);

    int insert(RolePermissionRelationPO record);

    int insertSelective(RolePermissionRelationPO record);

    RolePermissionRelationPO selectByPrimaryKey(Integer rolepermissionrelationid);

    int updateByPrimaryKeySelective(RolePermissionRelationPO record);

    int updateByPrimaryKey(RolePermissionRelationPO record);

    void deleteByRoleId(Integer userId);
}