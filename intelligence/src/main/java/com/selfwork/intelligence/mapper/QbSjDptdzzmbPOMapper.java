package com.selfwork.intelligence.mapper;

import com.selfwork.intelligence.model.QbSjDptdzzmbPO;
import com.selfwork.intelligence.model.QbSjDptdzzmbPOWithBLOBs;
import com.selfwork.intelligence.model.vo.dateset.LocationDto;
import com.selfwork.intelligence.model.vo.dateset.QbSjDptdzzmbQueryReq;
import com.selfwork.intelligence.model.vo.dateset.QbSjYsdzzdzzcmbStatiscVo;
import com.selfwork.intelligence.model.vo.dateset.QueryVo;

import java.util.*;

public interface QbSjDptdzzmbPOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(QbSjDptdzzmbPOWithBLOBs record);

    int insertSelective(QbSjDptdzzmbPOWithBLOBs record);

    QbSjDptdzzmbPOWithBLOBs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(QbSjDptdzzmbPOWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(QbSjDptdzzmbPOWithBLOBs record);

    int updateByPrimaryKey(QbSjDptdzzmbPO record);

    List<QbSjDptdzzmbPOWithBLOBs> getListByBatchNO(String batchNO);

    List<QbSjDptdzzmbPO> getBaseInfoList(QbSjDptdzzmbQueryReq req);

    List<QbSjDptdzzmbPOWithBLOBs> getList(QueryVo queryVo);

    List<LocationDto> getLocations(QueryVo queryVo);

    List<QbSjYsdzzdzzcmbStatiscVo> getStatisicInfoList(QbSjDptdzzmbQueryReq req);

    Integer insertList(List<QbSjDptdzzmbPOWithBLOBs> list);
}