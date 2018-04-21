package com.selfwork.intelligence.mapper;

import com.selfwork.intelligence.model.po.QbSjYsmbPO;

public interface QbSjYsmbPOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(QbSjYsmbPO record);

    int insertSelective(QbSjYsmbPO record);

    QbSjYsmbPO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(QbSjYsmbPO record);

    int updateByPrimaryKey(QbSjYsmbPO record);
}