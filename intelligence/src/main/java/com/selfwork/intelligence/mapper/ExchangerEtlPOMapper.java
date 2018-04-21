package com.selfwork.intelligence.mapper;

import com.selfwork.intelligence.model.po.ExchangerEtlPO;

public interface ExchangerEtlPOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ExchangerEtlPO record);

    int insertSelective(ExchangerEtlPO record);

    ExchangerEtlPO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ExchangerEtlPO record);

    int updateByPrimaryKey(ExchangerEtlPO record);
}