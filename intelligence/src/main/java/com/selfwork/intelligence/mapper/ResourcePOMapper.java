package com.selfwork.intelligence.mapper;

import com.selfwork.intelligence.model.po.ResourcePO;
import com.selfwork.intelligence.model.vo.dataquality.AuditRequestVo;
import com.selfwork.intelligence.model.vo.dataquality.DataQualitVo;
import com.selfwork.intelligence.model.vo.dataquality.DataQualityQueryVo;
import com.selfwork.intelligence.model.vo.dataquality.QualityEvaluateRequestVo;

import java.util.List;

public interface ResourcePOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ResourcePO record);

    int insertSelective(ResourcePO record);

    ResourcePO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ResourcePO record);

    int updateByPrimaryKey(ResourcePO record);

    List<ResourcePO> findList(DataQualityQueryVo queryVo);

}