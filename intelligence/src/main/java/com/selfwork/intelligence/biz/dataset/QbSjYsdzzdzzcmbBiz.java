package com.selfwork.intelligence.biz.dataset;

import com.selfwork.intelligence.biz.BaseBiz;
import com.selfwork.intelligence.mapper.QbSjYsdzzdzzcmbPOMapper;
import com.selfwork.intelligence.model.po.QbSjYsdzzdzzcmbPOWithBLOBs;
import com.selfwork.intelligence.model.vo.dataquality.ColumnsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QbSjYsdzzdzzcmbBiz extends BaseBiz implements IBaseQbBiz<QbSjYsdzzdzzcmbPOWithBLOBs> {



    @Autowired
    private QbSjYsdzzdzzcmbPOMapper qbSjYsdzzdzzcmb;

    @Override
    public List<QbSjYsdzzdzzcmbPOWithBLOBs> getListByBatchNO(String batchNO) {
        return qbSjYsdzzdzzcmb.getListByBatchNO(batchNO);
    }

    @Override
    public List<ColumnsVo> getColumns() {
        return null;
    }
}
