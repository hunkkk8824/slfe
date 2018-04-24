package com.selfwork.intelligence.mapper;

import com.selfwork.intelligence.model.QbSjJztsmbPO;

public interface QbSjJztsmbPOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(QbSjJztsmbPO record);

    int insertSelective(QbSjJztsmbPO record);

    QbSjJztsmbPO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(QbSjJztsmbPO record);

    int updateByPrimaryKeyWithBLOBs(QbSjJztsmbPO record);

    int updateByPrimaryKey(QbSjJztsmbPO record);
}