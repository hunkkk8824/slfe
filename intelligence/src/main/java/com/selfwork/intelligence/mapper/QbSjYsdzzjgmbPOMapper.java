package com.selfwork.intelligence.mapper;

import com.selfwork.intelligence.model.po.QbSjYsdzzjgmbPO;

public interface QbSjYsdzzjgmbPOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(QbSjYsdzzjgmbPO record);

    int insertSelective(QbSjYsdzzjgmbPO record);

    QbSjYsdzzjgmbPO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(QbSjYsdzzjgmbPO record);

    int updateByPrimaryKeyWithBLOBs(QbSjYsdzzjgmbPO record);

    int updateByPrimaryKey(QbSjYsdzzjgmbPO record);
}