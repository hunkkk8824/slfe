package com.selfwork.intelligence.biz.dataset;


import java.util.List;

public interface IBaseQbBiz<T> {

    List<T> getListByBatchNO(String batchNO);
}
