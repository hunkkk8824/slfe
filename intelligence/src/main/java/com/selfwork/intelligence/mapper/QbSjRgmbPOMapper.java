package com.selfwork.intelligence.mapper;

import com.selfwork.intelligence.model.QbSjRgmbPO;
import com.selfwork.intelligence.model.vo.dateset.LocationDto;
import com.selfwork.intelligence.model.vo.dateset.QbSjRgmbQueryReq;
import com.selfwork.intelligence.model.vo.dateset.QueryVo;

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

    List<QbSjRgmbPO> getList(QueryVo queryVo);

    List<LocationDto> getLocations(QueryVo queryVo);

    Integer insertList(List<QbSjRgmbPO> list);
}