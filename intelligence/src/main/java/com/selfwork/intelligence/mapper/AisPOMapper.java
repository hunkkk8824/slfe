package com.selfwork.intelligence.mapper;

import com.selfwork.intelligence.model.po.AisPO;
import com.selfwork.intelligence.model.vo.dateset.AisQueryReq;

import java.util.List;

public interface AisPOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AisPO record);

    int insertSelective(AisPO record);

    AisPO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AisPO record);

    int updateByPrimaryKey(AisPO record);

    List<AisPO> getAisInfoList(AisQueryReq req);
}