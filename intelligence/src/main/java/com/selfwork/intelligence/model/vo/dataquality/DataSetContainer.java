package com.selfwork.intelligence.model.vo.dataquality;

import com.selfwork.intelligence.biz.dataset.IBaseQbBiz;

import java.util.List;

public class DataSetContainer<T> {

    /**
     * 数据集编码:表名称
     * **/
    private String dateSetCode;

    /**
     * 数据集biz name
     * **/
    private String qbBizName;

    public String getDateSetCode() {
        return dateSetCode;
    }

    public void setDateSetCode(String dateSetCode) {
        this.dateSetCode = dateSetCode;
    }

    public String getQbBizName() {
        return qbBizName;
    }

    public void setQbBizName(String qbBizName) {
        this.qbBizName = qbBizName;
    }
}
