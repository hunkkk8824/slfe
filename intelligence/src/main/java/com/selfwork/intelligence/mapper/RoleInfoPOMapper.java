package com.selfwork.intelligence.mapper;

import com.selfwork.intelligence.model.po.RoleInfoPO;
import com.selfwork.intelligence.model.vo.role.RoleInfoQueryVo;

import java.util.List;

public interface RoleInfoPOMapper {

    List<RoleInfoPO> findList(RoleInfoQueryVo vo);

    List<RoleInfoPO> getRolesByUserId(Integer userId);
    int deleteByPrimaryKey(Integer roleid);

    int insert(RoleInfoPO record);

    int insertSelective(RoleInfoPO record);

    RoleInfoPO selectByPrimaryKey(Integer roleid);

    int updateByPrimaryKeySelective(RoleInfoPO record);

    int updateByPrimaryKey(RoleInfoPO record);
}