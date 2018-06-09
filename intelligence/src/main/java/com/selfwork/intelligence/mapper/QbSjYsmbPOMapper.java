package com.selfwork.intelligence.mapper;

import com.selfwork.intelligence.model.po.QbSjYsmbPO;
import com.selfwork.intelligence.model.vo.dateset.QbSjYsmbQueryReq;

import java.util.List;

public interface QbSjYsmbPOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(QbSjYsmbPO record);

    int insertSelective(QbSjYsmbPO record);

    QbSjYsmbPO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(QbSjYsmbPO record);

    int updateByPrimaryKey(QbSjYsmbPO record);

    List<QbSjYsmbPO> getListByBatchNO(String batchNO);

    List<QbSjYsmbPO> getBaseInfoList(QbSjYsmbQueryReq req);
}