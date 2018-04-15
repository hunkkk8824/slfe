package com.selfwork.intelligence.mapper;

import com.selfwork.intelligence.model.po.VehiclePO;

import java.util.List;

public interface VehiclePOMapper {

    List<VehiclePO> selectAll();
    int deleteByPrimaryKey(Integer vehicleid);

    int insert(VehiclePO record);

    int insertSelective(VehiclePO record);

    VehiclePO selectByPrimaryKey(Integer vehicleid);

    int updateByPrimaryKeySelective(VehiclePO record);

    int updateByPrimaryKey(VehiclePO record);
}