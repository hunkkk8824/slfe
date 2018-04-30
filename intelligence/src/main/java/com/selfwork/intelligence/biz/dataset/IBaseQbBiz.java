package com.selfwork.intelligence.biz.dataset;


import com.selfwork.intelligence.model.vo.dataquality.ColumnsVo;

import java.util.List;

public interface IBaseQbBiz<T> {

    List<T> getListByBatchNO(String batchNO);

    List<ColumnsVo> getColumns();
}
