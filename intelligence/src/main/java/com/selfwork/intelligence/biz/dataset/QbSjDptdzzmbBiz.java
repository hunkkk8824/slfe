package com.selfwork.intelligence.biz.dataset;

import com.selfwork.intelligence.biz.BaseBiz;
import com.selfwork.intelligence.mapper.QbSjDptdzzmbPOMapper;
import com.selfwork.intelligence.model.QbSjDptdzzmbPOWithBLOBs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QbSjDptdzzmbBiz extends BaseBiz implements IBaseQbBiz<QbSjDptdzzmbPOWithBLOBs> {

    @Autowired
    private QbSjDptdzzmbPOMapper qbSjDptdzzmb;

    @Override
    public List<QbSjDptdzzmbPOWithBLOBs> getListByBatchNO(String batchNO) {
        return qbSjDptdzzmb.getListByBatchNO(batchNO);
    }
}
