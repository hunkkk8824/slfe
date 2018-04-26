package com.selfwork.intelligence.biz.dataset;

import com.selfwork.intelligence.biz.BaseBiz;
import com.selfwork.intelligence.mapper.QbSjYsmbPOMapper;
import com.selfwork.intelligence.model.po.QbSjYsmbPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QbSjYsmbBiz extends BaseBiz implements IBaseQbBiz<QbSjYsmbPO> {



    @Autowired
    private QbSjYsmbPOMapper qbSjYsmb;

    @Override
    public List<QbSjYsmbPO> getListByBatchNO(String batchNO) {
        return qbSjYsmb.getListByBatchNO(batchNO);
    }
}
