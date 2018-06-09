package com.selfwork.intelligence.mapper;

import com.selfwork.intelligence.model.po.AisPO;

public interface AisPOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AisPO record);

    int insertSelective(AisPO record);

    AisPO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AisPO record);

    int updateByPrimaryKey(AisPO record);
}