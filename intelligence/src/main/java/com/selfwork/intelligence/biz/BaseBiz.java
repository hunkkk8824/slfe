package com.selfwork.intelligence.biz;

import com.github.pagehelper.PageHelper;
import com.selfwork.intelligence.model.vo.BaseQueryVo;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseBiz {


    @Autowired
    protected MonitorLogBiz logBiz;

    protected void startPage(BaseQueryVo vo) {
        PageHelper.startPage(vo.getPageNumber(), vo.getLimit());
    }
}
