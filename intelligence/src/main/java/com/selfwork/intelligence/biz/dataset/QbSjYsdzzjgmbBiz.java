package com.selfwork.intelligence.biz.dataset;

import com.selfwork.intelligence.biz.BaseBiz;
import com.selfwork.intelligence.mapper.QbSjYsdzzjgmbPOMapper;
import com.selfwork.intelligence.model.po.QbSjYsdzzjgmbPO;
import com.selfwork.intelligence.model.vo.dataquality.ColumnsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QbSjYsdzzjgmbBiz extends BaseBiz implements IBaseQbBiz<QbSjYsdzzjgmbPO> {

    @Autowired
    private QbSjYsdzzjgmbPOMapper qbSjYsdzzjgmb;

    @Override
    public List<QbSjYsdzzjgmbPO> getListByBatchNO(String batchNO) {
        return qbSjYsdzzjgmb.getListByBatchNO(batchNO);
    }

    @Override
    public List<ColumnsVo> getColumns() {
        return null;
    }
}
