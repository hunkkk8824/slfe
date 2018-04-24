package com.selfwork.intelligence.mapper;

import com.selfwork.intelligence.model.QbSjRgmbPO;

public interface QbSjRgmbPOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(QbSjRgmbPO record);

    int insertSelective(QbSjRgmbPO record);

    QbSjRgmbPO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(QbSjRgmbPO record);

    int updateByPrimaryKey(QbSjRgmbPO record);
}