package com.selfwork.intelligence.biz;

import java.util.List;

/**
 * 批量操做服务
 *
 */
public interface IBatchService {

    /**
     * 分批写入
     *
     * @param list            全量数据集
     * @param batchInsertSize 批量写入数量
     * @param callback        插入回调接口
     * @return 写入笔数
     */
   <R> boolean  insertObjectByBatch(List<R> list, int batchInsertSize, IBatchCallBack<R, Integer, IBatchCallBack.Insert> callback);


    /**
     * 分批查询
     *
     * @param ids  id集合
     * @param batchQuerySize
     * @param callback 查询回调接口
     * @param <Id,T>
     * @return
     */
   <Id,T> List<T> queryObjectByBatch(List<Id> ids, int batchQuerySize, IBatchCallBack<Id, List<T>, IBatchCallBack.Query> callback);


    /**
     * 分批更新
     *
     * @param list            全量数据集
     * @param batchUpdateSize 批量更新数量
     * @param callBack        更新回调接口
     * @return 写入笔数
     */
    <R> boolean  updateObjectByBatch(List<R> list, int batchUpdateSize, IBatchCallBack<R, Integer, IBatchCallBack.Update> callBack);

}
