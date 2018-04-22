package com.selfwork.intelligence.mapper;

import com.selfwork.intelligence.model.po.ResourceEtlLogPO;
import java.util.*;

public interface ResourceEtlLogPOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ResourceEtlLogPO record);

    int insertSelective(ResourceEtlLogPO record);

    ResourceEtlLogPO selectByPrimaryKey(Integer id);

    List<ResourceEtlLogPO> selectByResourceId(Integer resourceId);

    int updateByPrimaryKeySelective(ResourceEtlLogPO record);

    int updateByPrimaryKeyWithBLOBs(ResourceEtlLogPO record);

    int updateByPrimaryKey(ResourceEtlLogPO record);
}