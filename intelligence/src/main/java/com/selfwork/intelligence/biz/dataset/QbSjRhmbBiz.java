package com.selfwork.intelligence.biz.dataset;

import com.selfwork.intelligence.biz.BaseBiz;
import com.selfwork.intelligence.mapper.QbSjRhmbPOMapper;
import com.selfwork.intelligence.model.po.QbSjRhmbPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QbSjRhmbBiz extends BaseBiz implements IBaseQbBiz<QbSjRhmbPO> {

    @Autowired
    private QbSjRhmbPOMapper qbSjRhmb;

    @Override
    public List<QbSjRhmbPO> getListByBatchNO(String batchNO) {
        return qbSjRhmb.getListByBatchNO(batchNO);
    }
}
