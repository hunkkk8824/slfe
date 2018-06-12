package com.selfwork.intelligence.mapper;

import com.selfwork.intelligence.model.po.QbSjRhmbPO;
import com.selfwork.intelligence.model.vo.dateset.LocationDto;
import com.selfwork.intelligence.model.vo.dateset.QbSjRhmbQueryReq;
import com.selfwork.intelligence.model.vo.dateset.QueryVo;

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

    List<QbSjRhmbPO> getBaseInfoList(QbSjRhmbQueryReq req);

    List<QbSjRhmbPO> getList(QueryVo queryVo);

    List<LocationDto> getLocations(QueryVo queryVo);
}