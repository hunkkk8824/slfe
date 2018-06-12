package com.selfwork.intelligence.mapper;

import com.selfwork.intelligence.model.po.QbSjYsdzzjgmbPO;
import com.selfwork.intelligence.model.vo.dateset.LocationDto;
import com.selfwork.intelligence.model.vo.dateset.QbSjYsdzzjgmbQueryReq;
import com.selfwork.intelligence.model.vo.dateset.QueryVo;

import java.util.List;

public interface QbSjYsdzzjgmbPOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(QbSjYsdzzjgmbPO record);

    int insertSelective(QbSjYsdzzjgmbPO record);

    QbSjYsdzzjgmbPO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(QbSjYsdzzjgmbPO record);

    int updateByPrimaryKeyWithBLOBs(QbSjYsdzzjgmbPO record);

    int updateByPrimaryKey(QbSjYsdzzjgmbPO record);

    List<QbSjYsdzzjgmbPO> getListByBatchNO(String batchNO);

    List<QbSjYsdzzjgmbPO> getBaseInfoList(QbSjYsdzzjgmbQueryReq req);

    List<QbSjYsdzzjgmbPO> getList(QueryVo queryVo);

    List<LocationDto> getLocations(QueryVo queryVo);
}