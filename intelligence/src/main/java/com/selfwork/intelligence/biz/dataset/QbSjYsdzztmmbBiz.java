package com.selfwork.intelligence.biz.dataset;

import com.selfwork.intelligence.biz.BaseBiz;
import com.selfwork.intelligence.common.BeanUtils;
import com.selfwork.intelligence.common.DateUtils;
import com.selfwork.intelligence.mapper.QbSjYsdzztmmbPOMapper;
import com.selfwork.intelligence.model.po.QbSjYsdzztmmbPO;
import com.selfwork.intelligence.model.vo.dataquality.ColumnsVo;
import com.selfwork.intelligence.model.vo.dateset.QbSjYsdzztmmbVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//情报_数据_原始电子战通信目标
@Service
public class QbSjYsdzztmmbBiz extends BaseBiz implements IBaseQbBiz<QbSjYsdzztmmbVO> {


    @Autowired
    private QbSjYsdzztmmbPOMapper qbSjYsdzztmmb;

    @Override
    public List<QbSjYsdzztmmbVO> getListByBatchNO(String batchNO) {

        List<QbSjYsdzztmmbPO> pos = qbSjYsdzztmmb.getListByBatchNO(batchNO);

        return pos.parallelStream().map(po -> {
            QbSjYsdzztmmbVO item = new QbSjYsdzztmmbVO();
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
        list.add(new ColumnsVo("ptlx", "平台类型"));
        list.add(new ColumnsVo("cgqbh", "传感器编号"));
        list.add(new ColumnsVo("xylx", "信息类型"));
        list.add(new ColumnsVo("hjzt", "航迹状态"));
        list.add(new ColumnsVo("hjzl", "航迹质量"));
        list.add(new ColumnsVo("jssjStr", "接收时间&emsp; &emsp; &emsp; &emsp; &emsp; &emsp; "));
        list.add(new ColumnsVo("sbsjStr", "上报时间&emsp; &emsp; &emsp; &emsp; &emsp; &emsp; "));
        list.add(new ColumnsVo("sx", "属性"));
        list.add(new ColumnsVo("gj", "国际"));
        list.add(new ColumnsVo("jd", "经度"));
        list.add(new ColumnsVo("wd", "维度"));
        list.add(new ColumnsVo("gd", "高度"));
        list.add(new ColumnsVo("fw", "方位"));
        list.add(new ColumnsVo("yj", "仰角"));
        list.add(new ColumnsVo("jlwc", "距离误差"));
        list.add(new ColumnsVo("fwwc", "方位误差"));
        list.add(new ColumnsVo("yjwc", "仰角误差"));
        list.add(new ColumnsVo("tzys", "调制样式"));
        list.add(new ColumnsVo("qspl", "起始频率"));
        list.add(new ColumnsVo("zzpl", "终止频率"));
        list.add(new ColumnsVo("zxpl", "中心频率"));
        list.add(new ColumnsVo("xhdk", "信号贷款"));
        list.add(new ColumnsVo("fwkxd", "方位可信度"));
        list.add(new ColumnsVo("syfs", "通信频率使用方式"));
        list.add(new ColumnsVo("xhlx", "信号类型"));
        list.add(new ColumnsVo("tpsd", "调频速度"));
        list.add(new ColumnsVo("sl", "数量"));
        list.add(new ColumnsVo("fsysx", "辐射源属性"));
        list.add(new ColumnsVo("bwlx", "link11报文"));
        list.add(new ColumnsVo("gsfs", "建议干扰方式"));
        list.add(new ColumnsVo("grxhtzfs", "建议干扰信号调制方式"));
        list.add(new ColumnsVo("grxhys", "建议干扰信号样式"));
        list.add(new ColumnsVo("grtxzx", "干扰天线指向"));
        list.add(new ColumnsVo("ttbh", "探头编号"));
        list.add(new ColumnsVo("ptxh ", "平台信号"));
        list.add(new ColumnsVo("ztlb", "载体类别"));
        list.add(new ColumnsVo("ztlx", "载体类型"));
        list.add(new ColumnsVo("ptxh ", "平台型号"));
        list.add(new ColumnsVo("jxh", "机舷号"));
        list.add(new ColumnsVo("jjm", "舰名"));

        return list;


    }
}
