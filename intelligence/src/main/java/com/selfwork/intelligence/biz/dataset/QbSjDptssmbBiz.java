package com.selfwork.intelligence.biz.dataset;

import com.selfwork.intelligence.biz.BaseBiz;
import com.selfwork.intelligence.mapper.QbSjDptssmbPOMapper;
import com.selfwork.intelligence.model.QbSjDptssmbPO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QbSjDptssmbBiz extends BaseBiz implements IBaseQbBiz<QbSjDptssmbPO> {

    @Autowired
    private QbSjDptssmbPOMapper qbSjDptssmb;

    @Override
    public List<QbSjDptssmbPO> getListByBatchNO(String batchNO) {
        return qbSjDptssmb.getListByBatchNO(batchNO);
    }
}
