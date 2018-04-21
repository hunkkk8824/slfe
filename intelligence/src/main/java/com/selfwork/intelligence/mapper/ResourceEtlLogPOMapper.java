package com.selfwork.intelligence.mapper;

import com.selfwork.intelligence.model.po.ResourceEtlLogPO;

public interface ResourceEtlLogPOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ResourceEtlLogPO record);

    int insertSelective(ResourceEtlLogPO record);

    ResourceEtlLogPO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ResourceEtlLogPO record);

    int updateByPrimaryKeyWithBLOBs(ResourceEtlLogPO record);

    int updateByPrimaryKey(ResourceEtlLogPO record);
}