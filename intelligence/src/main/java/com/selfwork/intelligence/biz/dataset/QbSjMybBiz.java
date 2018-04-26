package com.selfwork.intelligence.biz.dataset;

import com.selfwork.intelligence.biz.BaseBiz;
import com.selfwork.intelligence.mapper.QbSjMybPOMapper;
import com.selfwork.intelligence.model.QbSjMybPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QbSjMybBiz extends BaseBiz implements IBaseQbBiz<QbSjMybPO> {

    @Autowired
    private QbSjMybPOMapper qbSjMyb;

    @Override
    public List<QbSjMybPO> getListByBatchNO(String batchNO) {
        return qbSjMyb.getListByBatchNO(batchNO);
    }
}
