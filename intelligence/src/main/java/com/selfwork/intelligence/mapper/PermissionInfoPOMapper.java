package com.selfwork.intelligence.mapper;

import com.selfwork.intelligence.model.po.PermissionInfoPO;
import com.selfwork.intelligence.model.vo.role.RoleInfoQueryVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PermissionInfoPOMapper {

    List<PermissionInfoPO> getPermissionsByUserId(Integer userId);
    int deleteByPrimaryKey(Integer permissionid);

    int insert(PermissionInfoPO record);

    int insertSelective(PermissionInfoPO record);

    PermissionInfoPO selectByPrimaryKey(Integer permissionid);

    int updateByPrimaryKeySelective(PermissionInfoPO record);

    int updateByPrimaryKey(PermissionInfoPO record);

    List<PermissionInfoPO> getPermissionsByRoleId(Integer roleId);

    List<PermissionInfoPO> findValidList(RoleInfoQueryVo vo);

    List<PermissionInfoPO> listByUserId(@Param("userId") Integer userId, @Param("permissionType") Integer permissionType);
}