package com.selfwork.intelligence.mapper;

import com.selfwork.intelligence.model.po.ResourcePO;
import com.selfwork.intelligence.model.vo.dataquality.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ResourcePOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ResourcePO record);

    int insertSelective(ResourcePO record);

    ResourcePO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ResourcePO record);

    int updateByPrimaryKey(ResourcePO record);

    List<ResourcePO> findList(DataQualityQueryVo queryVo);

    List<ResourcePO> findPrepareResource();

    /**
     *
     * @param datasetCode 表名
     * @param batchNo 批次号
     * @return
     */
    Integer countByBatchNo(@Param("tableName") String datasetCode, @Param("batchNo") String batchNo);

    Integer countByCondition(QuantityQueryVo queryVo);
}