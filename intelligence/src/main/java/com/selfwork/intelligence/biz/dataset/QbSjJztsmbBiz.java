package com.selfwork.intelligence.biz.dataset;

import com.selfwork.intelligence.biz.BaseBiz;
import com.selfwork.intelligence.mapper.QbSjJztsmbPOMapper;
import com.selfwork.intelligence.model.QbSjJztsmbPO;
import com.selfwork.intelligence.model.vo.dataquality.ColumnsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QbSjJztsmbBiz extends BaseBiz implements IBaseQbBiz<QbSjJztsmbPO> {

    @Autowired
    private QbSjJztsmbPOMapper qbSjJztsmb;

    @Override
    public List<QbSjJztsmbPO> getListByBatchNO(String batchNO) {
        return qbSjJztsmb.getListByBatchNO(batchNO);
    }

    @Override
    public List<ColumnsVo> getColumns() {
        return null;
    }
}
