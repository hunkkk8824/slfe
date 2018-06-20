package com.selfwork.intelligence.mapper;

import com.selfwork.intelligence.model.po.ScoutQbTableBdPO;

import java.util.List;

public interface ScoutQbTableBdPOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ScoutQbTableBdPO record);

    int insertSelective(ScoutQbTableBdPO record);

    ScoutQbTableBdPO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ScoutQbTableBdPO record);

    int updateByPrimaryKeyWithBLOBs(ScoutQbTableBdPO record);

    int updateByPrimaryKey(ScoutQbTableBdPO record);

    List<ScoutQbTableBdPO> getListByBatchNO(String batchNO);

    Integer insertList(List<ScoutQbTableBdPO> list);
}