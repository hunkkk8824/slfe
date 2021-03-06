package com.selfwork.intelligence.mapper;

import com.selfwork.intelligence.model.QbSjDptssmbPO;
import com.selfwork.intelligence.model.vo.dateset.LocationDto;
import com.selfwork.intelligence.model.vo.dateset.QbSjDptssmbQueryReq;
import com.selfwork.intelligence.model.vo.dateset.QbSjDptssmbVO;
import com.selfwork.intelligence.model.vo.dateset.QueryVo;

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

    List<QbSjDptssmbVO> getList(QueryVo queryVo);

    List<LocationDto> getLocations(QueryVo queryVo);

    Integer insertList(List<QbSjDptssmbPO> list);
}