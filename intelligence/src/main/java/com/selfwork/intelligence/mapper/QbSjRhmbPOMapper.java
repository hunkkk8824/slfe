package com.selfwork.intelligence.mapper;

import com.selfwork.intelligence.model.po.QbSjRhmbPO;

import java.util.List;

public interface QbSjRhmbPOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(QbSjRhmbPO record);

    int insertSelective(QbSjRhmbPO record);

    QbSjRhmbPO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(QbSjRhmbPO record);

    int updateByPrimaryKey(QbSjRhmbPO record);

    List<QbSjRhmbPO> getListByBatchNO(String batchNO);

    Integer insertList(List<QbSjRhmbPO> list);
}