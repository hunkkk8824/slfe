package com.selfwork.intelligence.biz.dataset;

import com.selfwork.intelligence.biz.BaseBiz;
import com.selfwork.intelligence.biz.IBatchCallBack;
import com.selfwork.intelligence.biz.IBatchInsertCallBack;
import com.selfwork.intelligence.biz.IBatchService;
import com.selfwork.intelligence.mapper.QbSjRhmbPOMapper;
import com.selfwork.intelligence.model.po.QbSjRhmbPO;
import com.selfwork.intelligence.model.vo.dataquality.ColumnsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QbSjRhmbBiz extends BaseBiz implements IBaseQbBiz<QbSjRhmbPO> {

    @Autowired
    private QbSjRhmbPOMapper qbSjRhmb;

    @Autowired
    private IBatchService batchService;

    @Override
    public List<QbSjRhmbPO> getListByBatchNO(String batchNO) {
        return qbSjRhmb.getListByBatchNO(batchNO);
    }

    @Override
    public List<ColumnsVo> getColumns() {
        List<ColumnsVo> list=new ArrayList<>();
        list.add(new ColumnsVo("",""));
        return list;
    }

    public boolean batchInsert(List<QbSjRhmbPO> list) {
        return batchService.insertObjectByBatch(list, 500, new IBatchInsertCallBack<QbSjRhmbPO>() {
            @Override
            public Integer doBatch(List<QbSjRhmbPO> list, Insert insert) {
                return insertList(list);
            }
        });
    }

    private Integer insertList(List<QbSjRhmbPO> list) {
        return qbSjRhmb.insertList(list);
    }
}
