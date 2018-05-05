package com.selfwork.intelligence.biz.dataset;

import com.selfwork.intelligence.biz.BaseBiz;
import com.selfwork.intelligence.common.BeanUtils;
import com.selfwork.intelligence.common.DateUtils;
import com.selfwork.intelligence.mapper.QbSjYsdzzjgmbPOMapper;
import com.selfwork.intelligence.model.po.QbSjYsdzzjgmbPO;
import com.selfwork.intelligence.model.vo.dataquality.ColumnsVo;
import com.selfwork.intelligence.model.vo.dateset.QbSjYsdzzjgmbVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class QbSjYsdzzjgmbBiz extends BaseBiz implements IBaseQbBiz<QbSjYsdzzjgmbVO> {

    @Autowired
    private QbSjYsdzzjgmbPOMapper qbSjYsdzzjgmb;

    @Override
    public List<QbSjYsdzzjgmbVO> getListByBatchNO(String batchNO) {

        List<QbSjYsdzzjgmbPO> pos = qbSjYsdzzjgmb.getListByBatchNO(batchNO);

        return pos.parallelStream().map(po -> {
            QbSjYsdzzjgmbVO item = new QbSjYsdzzjgmbVO();
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
        list.add(new ColumnsVo("fwwc", "方位误差"));
        list.add(new ColumnsVo("fwkxd", "方位可信度"));
        list.add(new ColumnsVo("yj", "仰角"));
        list.add(new ColumnsVo("mccfpltz", "脉冲重复频率特征"));
        list.add(new ColumnsVo("bmtz", "编码特征"));
        list.add(new ColumnsVo("wxylx", "威胁源类型"));
        list.add(new ColumnsVo("gdgrys", "无源光电干扰样式建议"));
        list.add(new ColumnsVo("ttbh", "探头编号"));
        list.add(new ColumnsVo("bc", "波长"));
        list.add(new ColumnsVo("ztlb", "载体类别"));
        list.add(new ColumnsVo("ztlx", "载体类型"));
        list.add(new ColumnsVo("ptxh ", "平台型号"));
        list.add(new ColumnsVo("jxh", "机舷号"));
        list.add(new ColumnsVo("jjm", "舰名"));
        list.add(new ColumnsVo("bmtzcd", "编码特征长度"));
        return list;

    }
}
