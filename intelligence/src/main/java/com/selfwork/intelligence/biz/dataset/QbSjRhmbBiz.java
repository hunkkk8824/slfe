package com.selfwork.intelligence.biz.dataset;

import com.selfwork.intelligence.biz.BaseBiz;
import com.selfwork.intelligence.biz.IBatchCallBack;
import com.selfwork.intelligence.biz.IBatchInsertCallBack;
import com.selfwork.intelligence.biz.IBatchService;
import com.selfwork.intelligence.common.BeanUtils;
import com.selfwork.intelligence.common.DateUtils;
import com.selfwork.intelligence.mapper.QbSjRhmbPOMapper;
import com.selfwork.intelligence.model.po.QbSjRhmbPO;
import com.selfwork.intelligence.model.vo.dataquality.ColumnsVo;
import com.selfwork.intelligence.model.vo.dateset.QbSjRhmbVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class QbSjRhmbBiz extends BaseBiz implements IBaseQbBiz<QbSjRhmbVO> {

    @Autowired
    private QbSjRhmbPOMapper qbSjRhmb;

    @Autowired
    private IBatchService batchService;

    @Override
    public List<QbSjRhmbVO> getListByBatchNO(String batchNO) {
        List<QbSjRhmbPO> pos = qbSjRhmb.getListByBatchNO(batchNO);

        return pos.parallelStream().map(po -> {
            QbSjRhmbVO item = new QbSjRhmbVO();
            BeanUtils.copy(po, item);
            item.setJssjStr(DateUtils.getFormatDateTime(po.getJssj()));
            item.setSbsjStr(DateUtils.getFormatDateTime(po.getSbsj()));
            return item;
        }).collect(Collectors.toList());
    }

    @Override
    public List<ColumnsVo> getColumns() {
        List<ColumnsVo> list = new ArrayList<>();

        list.add(new ColumnsVo("ph", "批号"));
        list.add(new ColumnsVo("ptbh", "平台编号"));
        list.add(new ColumnsVo("ptmc", "平台名称"));
        list.add(new ColumnsVo("cgqbh", "传感器编号"));
        list.add(new ColumnsVo("xylx", "信源类型"));
        list.add(new ColumnsVo("jlbh", "J链编号"));
        list.add(new ColumnsVo("zt", "状态"));
        list.add(new ColumnsVo("mbs", "目标数"));
        list.add(new ColumnsVo("ws", "维数"));
        list.add(new ColumnsVo("sx", "属性"));
        list.add(new ColumnsVo("sxzxd", "属性置信度"));
        list.add(new ColumnsVo("zl", "种类"));
        list.add(new ColumnsVo("zlzxd", "种类置信度"));
        list.add(new ColumnsVo("lx", "类型"));
        list.add(new ColumnsVo("lxzxd", "类型置信度"));
        list.add(new ColumnsVo("gj", "国籍"));
        list.add(new ColumnsVo("gjzxd", "国籍置信度"));
        list.add(new ColumnsVo("dt", "动态"));
        list.add(new ColumnsVo("dtzxd", "动态置信度"));
        list.add(new ColumnsVo("jmbz", "军民标志"));
        list.add(new ColumnsVo("ztbz", "状态标志"));
        list.add(new ColumnsVo("rw", "任务"));
        list.add(new ColumnsVo("bd", "编队"));
        list.add(new ColumnsVo("zq", "周期"));
        list.add(new ColumnsVo("jd", "经度"));
        list.add(new ColumnsVo("wd", "维度"));
        list.add(new ColumnsVo("gd", "高度"));
        list.add(new ColumnsVo("jl", "距离"));
        list.add(new ColumnsVo("fw", "方位"));
        list.add(new ColumnsVo("yj", "仰角"));
        list.add(new ColumnsVo("jdhx", "绝对航向"));
        list.add(new ColumnsVo("jdhs", "绝对航速"));
        list.add(new ColumnsVo("xdsd", "相对速度"));
        list.add(new ColumnsVo("zfxsd", "Z方向速度"));
        list.add(new ColumnsVo("ckjd", "参考经度"));
        list.add(new ColumnsVo("ckwd", "参考纬度"));
        list.add(new ColumnsVo("ckyj", "参考仰角"));
        list.add(new ColumnsVo("jdwc", "经度误差"));
        list.add(new ColumnsVo("wdwc", "纬度误差"));
        list.add(new ColumnsVo("gdwc", "高度误差"));
        list.add(new ColumnsVo("jlwc", "距离误差"));
        list.add(new ColumnsVo("fwwc", "方位误差"));
        list.add(new ColumnsVo("yjwc", "仰角误差"));
        list.add(new ColumnsVo("tywc", "椭圆误差"));
        list.add(new ColumnsVo("tyczwc", "椭圆长轴误差"));
        list.add(new ColumnsVo("tydzwc", "椭圆短轴误差"));
        list.add(new ColumnsVo("wx", "威胁"));
        list.add(new ColumnsVo("wxzxd", "威胁置信度"));
        list.add(new ColumnsVo("sxj", "艏向角"));
        list.add(new ColumnsVo("hjzl", "航迹质量"));
        list.add(new ColumnsVo("jjm", "机舰名"));
        list.add(new ColumnsVo("jxh", "机弦号"));
        list.add(new ColumnsVo("phdz", "批号对照"));
        list.add(new ColumnsVo("sbsd", "识别手段"));
        list.add(new ColumnsVo("sbzxd", "识别置信度"));
        list.add(new ColumnsVo("zdgz", "重点关注"));
        list.add(new ColumnsVo("gwx", "高威胁"));
        list.add(new ColumnsVo("tslb", "态势类别"));
        list.add(new ColumnsVo("mz", "目指"));
        list.add(new ColumnsVo("ydzs", "引导指示"));
        list.add(new ColumnsVo("mbjzzt", "目标交战状态"));
        list.add(new ColumnsVo("mzgzzt", "目标跟踪状态"));
        list.add(new ColumnsVo("qjbj", "旗舰标识"));
        list.add(new ColumnsVo("qh", "群号"));
        list.add(new ColumnsVo("mbyt", "目标意图"));
        list.add(new ColumnsVo("bz", "备注"));
        list.add(new ColumnsVo("jssjStr", "接收时间"));
        list.add(new ColumnsVo("sbsjStr", "上报时间"));
        list.add(new ColumnsVo("ptxh", "平台型号"));
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
