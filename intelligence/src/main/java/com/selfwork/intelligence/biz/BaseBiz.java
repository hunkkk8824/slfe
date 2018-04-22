package com.selfwork.intelligence.biz;

import com.github.pagehelper.PageHelper;
import com.selfwork.intelligence.model.vo.BaseQueryVo;

public class BaseBiz {

    protected void startPage(BaseQueryVo vo){
        PageHelper.startPage(vo.getPageNumber(), vo.getLimit());
    }
}
