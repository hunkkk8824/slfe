package com.selfwork.intelligence.biz;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.selfwork.intelligence.model.vo.BaseQueryVo;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseBiz {


    @Autowired
    protected MonitorLogBiz logBiz;

    protected Page startPage(BaseQueryVo vo) {
        return PageHelper.startPage(vo.getPageNumber(), vo.getLimit());
    }
}
