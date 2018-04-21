package com.selfwork.intelligence.mapper;

import com.selfwork.intelligence.model.po.ExchangerPO;

public interface ExchangerPOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ExchangerPO record);

    int insertSelective(ExchangerPO record);

    ExchangerPO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ExchangerPO record);

    int updateByPrimaryKey(ExchangerPO record);
}