package com.selfwork.intelligence.mapper;

import com.selfwork.intelligence.model.QbSjDptdzzmbPO;
import com.selfwork.intelligence.model.QbSjDptdzzmbPOWithBLOBs;
import java.util.*;

public interface QbSjDptdzzmbPOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(QbSjDptdzzmbPOWithBLOBs record);

    int insertSelective(QbSjDptdzzmbPOWithBLOBs record);

    QbSjDptdzzmbPOWithBLOBs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(QbSjDptdzzmbPOWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(QbSjDptdzzmbPOWithBLOBs record);

    int updateByPrimaryKey(QbSjDptdzzmbPO record);

    List<QbSjDptdzzmbPOWithBLOBs> getListByBatchNO(String batchNO);
}