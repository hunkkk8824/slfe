package com.selfwork.intelligence.mapper;

import com.selfwork.intelligence.model.po.ExchangerEtlPO;
import com.selfwork.intelligence.model.vo.exchangeConfig.ExchangeEtlQueryVo;

import java.util.List;

public interface ExchangerEtlPOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ExchangerEtlPO record);

    int insertSelective(ExchangerEtlPO record);

    ExchangerEtlPO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ExchangerEtlPO record);

    int updateByPrimaryKey(ExchangerEtlPO record);

    List<ExchangerEtlPO> findList(ExchangeEtlQueryVo queryVo);
}