package com.selfwork.intelligence.mapper;

import com.selfwork.intelligence.model.po.DatasetPO;

public interface DatasetPOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DatasetPO record);

    int insertSelective(DatasetPO record);

    DatasetPO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DatasetPO record);

    int updateByPrimaryKey(DatasetPO record);
}