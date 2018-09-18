package com.selfwork.intelligence.mapper;

import com.selfwork.intelligence.model.po.LdbzmbhdglPO;
import com.selfwork.intelligence.model.vo.dateset.LocationDto;
import com.selfwork.intelligence.model.vo.dateset.QbSjYsdzztmmbQueryReq;
import com.selfwork.intelligence.model.vo.dateset.QueryVo;

import java.util.List;

/**
 * Created by zzc on 2018/9/17.
 */
public interface LdbzmbhdglMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LdbzmbhdglPO record);

    int insertSelective(LdbzmbhdglPO record);

    LdbzmbhdglPO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LdbzmbhdglPO record);

    int updateByPrimaryKey(LdbzmbhdglPO record);

    List<LdbzmbhdglPO> getListByBatchNO(String batchNO);

    List<LdbzmbhdglPO> getBaseInfoList(QbSjYsdzztmmbQueryReq req);

    List<LdbzmbhdglPO> getList(QueryVo queryVo);

    List<LocationDto> getLocations(QueryVo queryVo);

    Integer insertList(List<LdbzmbhdglPO> list);
}
