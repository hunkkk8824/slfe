package com.selfwork.intelligence.mapper;

import com.selfwork.intelligence.model.po.QbSjYsdzzdzzcmbPO;
import com.selfwork.intelligence.model.po.QbSjYsdzzdzzcmbPOWithBLOBs;
import com.selfwork.intelligence.model.vo.dateset.LocationDto;
import com.selfwork.intelligence.model.vo.dateset.QbSjYsdzzdzzcmbQueryReq;
import com.selfwork.intelligence.model.vo.dateset.QueryVo;

import java.util.List;

public interface QbSjYsdzzdzzcmbPOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(QbSjYsdzzdzzcmbPOWithBLOBs record);

    int insertSelective(QbSjYsdzzdzzcmbPOWithBLOBs record);

    QbSjYsdzzdzzcmbPOWithBLOBs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(QbSjYsdzzdzzcmbPOWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(QbSjYsdzzdzzcmbPOWithBLOBs record);

    int updateByPrimaryKey(QbSjYsdzzdzzcmbPO record);

    List<QbSjYsdzzdzzcmbPOWithBLOBs> getListByBatchNO(String batchNO);

    List<QbSjYsdzzdzzcmbPO> getBaseInfoList(QbSjYsdzzdzzcmbQueryReq req);

    List<QbSjYsdzzdzzcmbPOWithBLOBs> getList(QueryVo queryVo);

    List<LocationDto> getLocations(QueryVo queryVo);

    Integer insertList(List<QbSjYsdzzdzzcmbPOWithBLOBs> list);
}