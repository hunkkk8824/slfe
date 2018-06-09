package com.selfwork.intelligence.mapper;

import com.selfwork.intelligence.model.po.QbSjYsdzztmmbPO;
import com.selfwork.intelligence.model.vo.dateset.QbSjYsdzztmmbQueryReq;

import java.util.List;

public interface QbSjYsdzztmmbPOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(QbSjYsdzztmmbPO record);

    int insertSelective(QbSjYsdzztmmbPO record);

    QbSjYsdzztmmbPO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(QbSjYsdzztmmbPO record);

    int updateByPrimaryKey(QbSjYsdzztmmbPO record);

    List<QbSjYsdzztmmbPO> getListByBatchNO(String batchNO);

    List<QbSjYsdzztmmbPO> getBaseInfoList(QbSjYsdzztmmbQueryReq req);
}