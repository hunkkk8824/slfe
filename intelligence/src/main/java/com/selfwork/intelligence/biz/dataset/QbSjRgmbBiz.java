package com.selfwork.intelligence.biz.dataset;

import com.selfwork.intelligence.biz.BaseBiz;
import com.selfwork.intelligence.mapper.QbSjRgmbPOMapper;
import com.selfwork.intelligence.model.QbSjRgmbPO;
import com.selfwork.intelligence.model.vo.dataquality.ColumnsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QbSjRgmbBiz extends BaseBiz implements IBaseQbBiz<QbSjRgmbPO> {
    @Autowired
    private QbSjRgmbPOMapper qbSjRgmb;
    @Override
    public List<QbSjRgmbPO> getListByBatchNO(String batchNO) {
        return qbSjRgmb.getListByBatchNO(batchNO);
    }

    @Override
    public List<ColumnsVo> getColumns() {
        List<ColumnsVo> list=new ArrayList<>();
        list.add(new ColumnsVo("",""));
        return list;
    }

}
