package com.selfwork.intelligence.model.vo.dataquality;

import com.selfwork.intelligence.biz.dataset.IBaseQbBiz;

import java.util.List;

public class DataSetContainer<T> {

    /**
     * 数据集编码:表名称
     * **/
    private String dateSetCode;

    private IBaseQbBiz<T> baseQbBiz;

    public String getDateSetCode() {
        return dateSetCode;
    }

    public void setDateSetCode(String dateSetCode) {
        this.dateSetCode = dateSetCode;
    }

    public IBaseQbBiz<T> getBaseQbBiz() {
        return baseQbBiz;
    }

    public void setBaseQbBiz(IBaseQbBiz<T> baseQbBiz) {
        this.baseQbBiz = baseQbBiz;
    }
}
