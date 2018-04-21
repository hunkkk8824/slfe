package com.selfwork.intelligence.mapper;

import com.selfwork.intelligence.model.po.QbSjYsdzzdzzcmbPO;
import com.selfwork.intelligence.model.po.QbSjYsdzzdzzcmbPOWithBLOBs;

public interface QbSjYsdzzdzzcmbPOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(QbSjYsdzzdzzcmbPOWithBLOBs record);

    int insertSelective(QbSjYsdzzdzzcmbPOWithBLOBs record);

    QbSjYsdzzdzzcmbPOWithBLOBs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(QbSjYsdzzdzzcmbPOWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(QbSjYsdzzdzzcmbPOWithBLOBs record);

    int updateByPrimaryKey(QbSjYsdzzdzzcmbPO record);
}