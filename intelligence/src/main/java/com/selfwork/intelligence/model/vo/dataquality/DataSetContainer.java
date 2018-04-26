package com.selfwork.intelligence.model.vo.dataquality;

import com.selfwork.intelligence.biz.dataset.IBaseQbBiz;

import java.util.List;

public class DataSetContainer<T> {

    private String dateSetCode;

    private List<ColumnsVo> columns;
    private IBaseQbBiz<T> baseQbBiz;

    public String getDateSetCode() {
        return dateSetCode;
    }

    public void setDateSetCode(String dateSetCode) {
        this.dateSetCode = dateSetCode;
    }

    public List<ColumnsVo> getColumns() {
        return columns;
    }

    public void setColumns(List<ColumnsVo> columns) {
        this.columns = columns;
    }

    public IBaseQbBiz<T> getBaseQbBiz() {
        return baseQbBiz;
    }

    public void setBaseQbBiz(IBaseQbBiz<T> baseQbBiz) {
        this.baseQbBiz = baseQbBiz;
    }
}
