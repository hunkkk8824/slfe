package com.selfwork.intelligence.mapper;

import com.selfwork.intelligence.model.QbSjMybPO;

public interface QbSjMybPOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(QbSjMybPO record);

    int insertSelective(QbSjMybPO record);

    QbSjMybPO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(QbSjMybPO record);

    int updateByPrimaryKey(QbSjMybPO record);
}