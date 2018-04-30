package com.selfwork.intelligence.biz.dataset;

import com.selfwork.intelligence.biz.BaseBiz;
import com.selfwork.intelligence.mapper.QbSjYsdzztmmbPOMapper;
import com.selfwork.intelligence.model.po.QbSjYsdzztmmbPO;
import com.selfwork.intelligence.model.vo.dataquality.ColumnsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QbSjYsdzztmmbBiz  extends BaseBiz implements IBaseQbBiz<QbSjYsdzztmmbPO> {


    @Autowired
    private QbSjYsdzztmmbPOMapper qbSjYsdzztmmb;

    @Override
    public List<QbSjYsdzztmmbPO> getListByBatchNO(String batchNO) {
        return qbSjYsdzztmmb.getListByBatchNO(batchNO);
    }

    @Override
    public List<ColumnsVo> getColumns() {
        return null;
    }
}
