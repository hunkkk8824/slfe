package com.selfwork.intelligence.biz;

import java.util.List;

/**
 * 分批更新
 *
 * @param <R> R：请求值
 */
public interface IBatchUpdateCallBack<R> extends IBatchCallBack<R,Integer,IBatchCallBack.Update>  {

    /**
     * 批量操作
     *
     * @param  list
     * @return 成功数
     */
    Integer doBatch(List<R> list, Update update);
}