package com.selfwork.intelligence.mapper;

import com.selfwork.intelligence.model.QbSjRgmbPO;
import com.selfwork.intelligence.model.vo.dateset.QbSjRgmbQueryReq;

import java.util.List;

public interface QbSjRgmbPOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(QbSjRgmbPO record);

    int insertSelective(QbSjRgmbPO record);

    QbSjRgmbPO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(QbSjRgmbPO record);

    int updateByPrimaryKey(QbSjRgmbPO record);

    List<QbSjRgmbPO> getListByBatchNO(String batchNO);

    List<QbSjRgmbPO> getBaseInfoList(QbSjRgmbQueryReq req);
}