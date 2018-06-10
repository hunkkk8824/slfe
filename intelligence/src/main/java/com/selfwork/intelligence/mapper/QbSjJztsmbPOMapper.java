package com.selfwork.intelligence.mapper;

import com.selfwork.intelligence.model.QbSjJztsmbPO;
import com.selfwork.intelligence.model.vo.dateset.QbSjJztsmbQueryReq;
import com.selfwork.intelligence.model.vo.dateset.QueryVo;

import java.util.List;

public interface QbSjJztsmbPOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(QbSjJztsmbPO record);

    int insertSelective(QbSjJztsmbPO record);

    QbSjJztsmbPO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(QbSjJztsmbPO record);

    int updateByPrimaryKeyWithBLOBs(QbSjJztsmbPO record);

    int updateByPrimaryKey(QbSjJztsmbPO record);

    List<QbSjJztsmbPO> getListByBatchNO(String batchNO);

    List<QbSjJztsmbPO> getBaseInfoList(QbSjJztsmbQueryReq req);

    List<QbSjJztsmbPO> getList(QueryVo queryVo);
}