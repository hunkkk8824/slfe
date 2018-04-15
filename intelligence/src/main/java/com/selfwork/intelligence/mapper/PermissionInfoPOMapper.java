package com.selfwork.intelligence.mapper;

import com.selfwork.intelligence.model.po.PermissionInfoPO;
import java.util.List;

public interface PermissionInfoPOMapper {

    List<PermissionInfoPO> getPermissionsByUserId(Integer userId);
    int deleteByPrimaryKey(Integer permissionid);

    int insert(PermissionInfoPO record);

    int insertSelective(PermissionInfoPO record);

    PermissionInfoPO selectByPrimaryKey(Integer permissionid);

    int updateByPrimaryKeySelective(PermissionInfoPO record);

    int updateByPrimaryKey(PermissionInfoPO record);
}