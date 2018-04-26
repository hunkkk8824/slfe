package com.selfwork.intelligence.biz.dataset;

import com.selfwork.intelligence.biz.BaseBiz;
import com.selfwork.intelligence.mapper.ScoutQbTableBdPOMapper;
import com.selfwork.intelligence.model.po.ScoutQbTableBdPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoutQbTableBdBiz extends BaseBiz implements IBaseQbBiz<ScoutQbTableBdPO> {



    @Autowired
    private ScoutQbTableBdPOMapper scoutQbTableBd;

    @Override
    public List<ScoutQbTableBdPO> getListByBatchNO(String batchNO) {
        return scoutQbTableBd.getListByBatchNO(batchNO);
    }
}
