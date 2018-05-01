package com.selfwork.intelligence.biz;

import java.util.List;

/**
 * 分批插入
 * @param <R> R：请求值
 */
public interface IBatchInsertCallBack<R> extends IBatchCallBack<R,Integer,IBatchCallBack.Insert>  {

    /**
     * 批量操作
     *
     * @param  list
     * @return 成功数
     */
    Integer doBatch(List<R> list, Insert insert);
}