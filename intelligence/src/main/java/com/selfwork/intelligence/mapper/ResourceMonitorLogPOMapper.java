package com.selfwork.intelligence.mapper;

import com.selfwork.intelligence.model.po.ResourceMonitorLogPO;

public interface ResourceMonitorLogPOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ResourceMonitorLogPO record);

    int insertSelective(ResourceMonitorLogPO record);

    ResourceMonitorLogPO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ResourceMonitorLogPO record);

    int updateByPrimaryKey(ResourceMonitorLogPO record);
}