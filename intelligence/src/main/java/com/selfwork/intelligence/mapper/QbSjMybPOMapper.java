package com.selfwork.intelligence.mapper;

import com.selfwork.intelligence.model.QbSjMybPO;

import java.util.List;

public interface QbSjMybPOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(QbSjMybPO record);

    int insertSelective(QbSjMybPO record);

    QbSjMybPO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(QbSjMybPO record);

    int updateByPrimaryKey(QbSjMybPO record);
    List<QbSjMybPO> getListByBatchNO(String batchNO);
}