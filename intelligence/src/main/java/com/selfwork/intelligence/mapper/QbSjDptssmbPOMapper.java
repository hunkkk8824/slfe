package com.selfwork.intelligence.mapper;

import com.selfwork.intelligence.model.QbSjDptssmbPO;
import com.selfwork.intelligence.model.vo.dateset.QbSjDptssmbQueryReq;

import java.util.List;

public interface QbSjDptssmbPOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(QbSjDptssmbPO record);

    int insertSelective(QbSjDptssmbPO record);

    QbSjDptssmbPO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(QbSjDptssmbPO record);

    int updateByPrimaryKeyWithBLOBs(QbSjDptssmbPO record);

    int updateByPrimaryKey(QbSjDptssmbPO record);

    List<QbSjDptssmbPO> getListByBatchNO(String batchNO);

    List<QbSjDptssmbPO> getBaseInfoList(QbSjDptssmbQueryReq req);
}