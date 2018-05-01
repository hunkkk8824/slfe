package com.selfwork.intelligence.biz.impl;


import com.selfwork.intelligence.biz.*;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 批处理借口
 * @Author zzc
 */
@Service
public class BatchServiceImpl implements IBatchService {

    private <T> T executeBatch(List list, int batchSize, IBatchCallBack callBack, T defaultObject){
        if(!CollectionUtils.isEmpty(list)){
            if(batchSize <= 0){//小于0,默认值取 1000
                batchSize = 1000;
            }
            if(batchSize > 3000){//最大值取 3000
                batchSize = 3000;
            }
            int count = 0;
            int total = list.size();
            if (total > batchSize) { //如果总数超过批次数，分批次，加零头操作
                int quotient  = total / batchSize;
                int remainder = total % batchSize;
                List subList;
                for (int i = 0; i <= quotient; i++) {
                    if(i == quotient){
                        if(remainder <= 0){
                            break;
                        }else{
                            subList = list.subList(quotient * batchSize,  (quotient * batchSize) + remainder);
                            count   = count + remainder;
                        }
                    }else{
                        subList = list.subList(i * batchSize, (i + 1) * batchSize);
                        count   = count + batchSize;
                    }
                    if(callBack instanceof IBatchInsertCallBack){
                        callBack.doBatch(subList,   IBatchCallBack.INSERT);
                    }else if(callBack instanceof IBatchUpdateCallBack){
                        callBack.doBatch(subList,   IBatchCallBack.UPDATE);
                    }else if(callBack instanceof IBatchQueryCallback){
                        ((List)defaultObject).addAll((List)callBack.doBatch(subList, IBatchCallBack.QUERY));
                    }
                }
            } else {//总数小于等于批次数，一次操作
                if(callBack       instanceof IBatchInsertCallBack){
                    callBack.doBatch(list,   IBatchCallBack.INSERT);
                    count = total;
                }else if(callBack instanceof IBatchUpdateCallBack){
                    callBack.doBatch(list,   IBatchCallBack.UPDATE);
                    count = total;
                }else if(callBack instanceof IBatchQueryCallback){
                    defaultObject = (T)callBack.doBatch(list,  IBatchCallBack.QUERY);
                }
            }
            if(callBack instanceof IBatchInsertCallBack ||callBack instanceof IBatchUpdateCallBack){
                defaultObject = (T)Boolean.valueOf(count == total);
            }
        }
        return defaultObject;
    }

    public <R> boolean insertObjectByBatch(List<R> list,int batchInsertSize,  IBatchCallBack<R,Integer,IBatchCallBack.Insert> callBack) {
        return  executeBatch(list,batchInsertSize,callBack, Boolean.TRUE);
    }

    public <Id, T> List<T> queryObjectByBatch(List<Id> ids,int batchQuerySize,IBatchCallBack<Id,List<T>,IBatchCallBack.Query> callBack) {
        return  executeBatch(ids, batchQuerySize, callBack, new ArrayList<T>());
    }

    public <R> boolean updateObjectByBatch(List<R> list, int batchUpdateSize, IBatchCallBack<R, Integer, IBatchCallBack.Update> callBack) {
        return  executeBatch(list,batchUpdateSize,callBack, Boolean.TRUE);
    }
}