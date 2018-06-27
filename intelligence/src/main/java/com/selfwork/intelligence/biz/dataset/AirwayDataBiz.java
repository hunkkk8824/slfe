package com.selfwork.intelligence.biz.dataset;

import com.selfwork.intelligence.biz.BaseBiz;
import com.selfwork.intelligence.mapper.AirwayDataMapper;
import com.selfwork.intelligence.model.po.AirwayDataPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirwayDataBiz extends BaseBiz {

    @Autowired
    AirwayDataMapper airwayDataMapper;

    public List<AirwayDataPO> getList() {

        return airwayDataMapper.getList();
    }
}
