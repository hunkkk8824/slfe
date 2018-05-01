package com.selfwork.intelligence.biz;

import java.util.List;

/**
 * 分批查询
 * @param <R,T> R：请求值 T：返回值
 */
public interface IBatchQueryCallback<R,T> extends IBatchCallBack<R,List<T>,IBatchCallBack.Query> {

    /**
     * 批量操作
     *
     * @param  list 参数集合
     * @return 返回值集合
     */
    List<T> doBatch(List<R> list, Query query);
}