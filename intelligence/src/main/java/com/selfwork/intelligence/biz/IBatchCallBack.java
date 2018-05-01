package com.selfwork.intelligence.biz;

import java.util.List;

/**
 * 批量操作回调接口
 *
 * @param <R,T> R：请求值 T：返回值
 */
public interface IBatchCallBack<R, T,Op extends IBatchCallBack.Operator> {

     Insert INSERT = new Insert();

     Update UPDATE = new Update();

     Query  QUERY  = new Query();

     final class Insert implements Operator{
        private Insert(){}
     }

     final class Update implements Operator{
         private Update(){}
     }

     final class Query  implements Operator{
         private Query(){}
     }

     interface Operator {

     }

    /**
     * 批量处理
     *
     * @param list
     * @return
     */
     T doBatch(List<R> list, Op op);

}