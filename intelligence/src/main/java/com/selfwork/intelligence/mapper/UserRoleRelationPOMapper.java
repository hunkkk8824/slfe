package com.selfwork.intelligence.mapper;

import com.selfwork.intelligence.model.po.UserRoleRelationPO;

public interface UserRoleRelationPOMapper {
    int deleteByPrimaryKey(Integer userrolerelationid);

    int insert(UserRoleRelationPO record);

    int insertSelective(UserRoleRelationPO record);

    UserRoleRelationPO selectByPrimaryKey(Integer userrolerelationid);

    int updateByPrimaryKeySelective(UserRoleRelationPO record);

    int updateByPrimaryKey(UserRoleRelationPO record);
}