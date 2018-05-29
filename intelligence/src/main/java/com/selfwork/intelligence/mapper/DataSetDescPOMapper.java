package com.selfwork.intelligence.mapper;

import com.selfwork.intelligence.model.DataSetDescPO;

public interface DataSetDescPOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DataSetDescPO record);

    int insertSelective(DataSetDescPO record);

    DataSetDescPO selectByPrimaryKey(Integer id);
    DataSetDescPO selectByDataSetCode(String dataSetCode);

    int updateByPrimaryKeySelective(DataSetDescPO record);

    int updateByPrimaryKeyWithBLOBs(DataSetDescPO record);

    int updateByPrimaryKey(DataSetDescPO record);
}