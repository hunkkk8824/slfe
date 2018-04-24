package com.selfwork.intelligence.mapper;

import com.selfwork.intelligence.model.QbSjDptssmbPO;

public interface QbSjDptssmbPOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(QbSjDptssmbPO record);

    int insertSelective(QbSjDptssmbPO record);

    QbSjDptssmbPO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(QbSjDptssmbPO record);

    int updateByPrimaryKeyWithBLOBs(QbSjDptssmbPO record);

    int updateByPrimaryKey(QbSjDptssmbPO record);
}