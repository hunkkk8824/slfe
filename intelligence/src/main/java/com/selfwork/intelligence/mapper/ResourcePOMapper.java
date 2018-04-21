package com.selfwork.intelligence.mapper;

import com.selfwork.intelligence.model.po.ResourcePO;

public interface ResourcePOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ResourcePO record);

    int insertSelective(ResourcePO record);

    ResourcePO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ResourcePO record);

    int updateByPrimaryKey(ResourcePO record);
}