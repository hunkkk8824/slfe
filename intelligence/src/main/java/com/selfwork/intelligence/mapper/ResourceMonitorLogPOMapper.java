package com.selfwork.intelligence.mapper;

import com.selfwork.intelligence.model.po.ResourceMonitorLogPO;
import com.selfwork.intelligence.model.vo.monitorlog.MonitorLogQueryVo;

import java.util.List;

public interface ResourceMonitorLogPOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ResourceMonitorLogPO record);

    int insertSelective(ResourceMonitorLogPO record);

    ResourceMonitorLogPO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ResourceMonitorLogPO record);

    int updateByPrimaryKey(ResourceMonitorLogPO record);

    List<ResourceMonitorLogPO> findList(MonitorLogQueryVo queryVo);
}