package com.selfwork.intelligence.biz.dataset;

import com.selfwork.intelligence.biz.BaseBiz;
import com.selfwork.intelligence.biz.IBatchInsertCallBack;
import com.selfwork.intelligence.biz.IBatchService;
import com.selfwork.intelligence.mapper.ScoutQbTableBdPOMapper;
import com.selfwork.intelligence.model.po.QbSjRhmbPO;
import com.selfwork.intelligence.model.po.ScoutQbTableBdPO;
import com.selfwork.intelligence.model.vo.dataquality.ColumnsVo;
import com.selfwork.intelligence.model.vo.dateset.LocationDto;
import com.selfwork.intelligence.model.vo.dateset.QueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

//动向情报
@Service
public class ScoutQbTableBdBiz extends BaseBiz implements IBaseQbBiz<ScoutQbTableBdPO> {


    @Autowired
    private ScoutQbTableBdPOMapper scoutQbTableBd;

    @Autowired
    private IBatchService batchService;

    public boolean batchInsert(List<ScoutQbTableBdPO> list) {
        return batchService.insertObjectByBatch(list, 500, new IBatchInsertCallBack<ScoutQbTableBdPO>() {
            @Override
            public Integer doBatch(List<ScoutQbTableBdPO> list, Insert insert) {
                return insertList(list);
            }
        });
    }

    private Integer insertList(List<ScoutQbTableBdPO> list) {
        return scoutQbTableBd.insertList(list);
    }

    @Override
    public List<ScoutQbTableBdPO> getListByBatchNO(String batchNO) {
        return scoutQbTableBd.getListByBatchNO(batchNO);
    }

    @Override
    public List<ScoutQbTableBdPO> getList(QueryVo queryVo) {
        return null;
    }

    @Override
    public List<LocationDto> getLocations(QueryVo queryVo) {
        return null;
    }

    @Override
    public List<ColumnsVo> getColumns() {
        List<ColumnsVo> list = new ArrayList<>();

        list.add(new ColumnsVo("infoSource", "信源"));
        list.add(new ColumnsVo("sendUnit", "发报单位"));
        list.add(new ColumnsVo("recvUnit", "收报单位"));
        list.add(new ColumnsVo("sendTime", "发报时间"));
        list.add(new ColumnsVo("streamNo", "流水号"));
        list.add(new ColumnsVo("gramType", "报文类型"));
        list.add(new ColumnsVo("secretGrade", "密级"));
        list.add(new ColumnsVo("writeTime", "抄收时间"));
        list.add(new ColumnsVo("sendGramTime", "发文时间"));
        list.add(new ColumnsVo("sendGramSerial", "发文编号"));
        list.add(new ColumnsVo("author", "编者"));
        list.add(new ColumnsVo("signatory", "签发人"));
        list.add(new ColumnsVo("caption", "标题"));
        list.add(new ColumnsVo("contentLen", "正文长度"));
        list.add(new ColumnsVo("content", "正文"));
        list.add(new ColumnsVo("subject", "主题词"));
        list.add(new ColumnsVo("eigenvalue", "统计码"));
        list.add(new ColumnsVo("fjDepict", "附件描述"));
        list.add(new ColumnsVo("fjType", "附件类型"));
        list.add(new ColumnsVo("fjName", "附件名称"));
        list.add(new ColumnsVo("fjLen", "附件长度"));
        list.add(new ColumnsVo("fjContent", "附件内容"));
        list.add(new ColumnsVo("gramStream", "来报流水号"));
        list.add(new ColumnsVo("receiptPerson", "回执人"));
        list.add(new ColumnsVo("receiptStatus", "回执情况"));
        list.add(new ColumnsVo("errorCause", "错误原因"));
        list.add(new ColumnsVo("friority", "报文优先级"));
        list.add(new ColumnsVo("timeZoneValue", "时区"));
        list.add(new ColumnsVo("readFlag", "已阅标识"));
        list.add(new ColumnsVo("replayFlag", "回复标识"));
        list.add(new ColumnsVo("wdId", "文电id"));
        list.add(new ColumnsVo("sendUunitId", "发报单位id"));
        list.add(new ColumnsVo("editContent", "编辑后报文"));

        return list;
    }
}
