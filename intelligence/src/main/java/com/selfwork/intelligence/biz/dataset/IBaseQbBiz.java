package com.selfwork.intelligence.biz.dataset;


import com.selfwork.intelligence.model.vo.dataquality.ColumnsVo;
import com.selfwork.intelligence.model.vo.dateset.LocationDto;
import com.selfwork.intelligence.model.vo.dateset.QbSjDptdzzmbQueryReq;
import com.selfwork.intelligence.model.vo.dateset.QbSjYsdzzdzzcmbVO;
import com.selfwork.intelligence.model.vo.dateset.QueryVo;

import java.util.List;

public interface IBaseQbBiz<T> {

    List<T> getListByBatchNO(String batchNO);

    List<ColumnsVo> getColumns();

    public List<T> getList(QueryVo queryVo);

    List<LocationDto> getLocations(QueryVo queryVo);
}
