package com.selfwork.intelligence.biz.dataset;

import com.selfwork.intelligence.biz.BaseBiz;
import com.selfwork.intelligence.common.BeanUtils;
import com.selfwork.intelligence.common.DateUtils;
import com.selfwork.intelligence.mapper.QbSjDptssmbPOMapper;
import com.selfwork.intelligence.model.QbSjDptssmbPO;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.selfwork.intelligence.model.vo.dataquality.ColumnsVo;
import com.selfwork.intelligence.model.vo.dateset.QbSjDptssmbVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//情报_数据_多平台水声目标
@Service
public class QbSjDptssmbBiz extends BaseBiz implements IBaseQbBiz<QbSjDptssmbVO> {

    @Autowired
    private QbSjDptssmbPOMapper qbSjDptssmb;

    @Override
    public List<QbSjDptssmbVO> getListByBatchNO(String batchNO) {

        List<QbSjDptssmbPO> pos = qbSjDptssmb.getListByBatchNO(batchNO);

        return pos.parallelStream().map(po -> {
            QbSjDptssmbVO item = new QbSjDptssmbVO();
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
        list.add(new ColumnsVo("jssjStr", "接收时间&emsp; &emsp; &emsp; &emsp; &emsp; &emsp; "));
        list.add(new ColumnsVo("sbsjStr", "上报时间&emsp; &emsp; &emsp; &emsp; &emsp; &emsp; "));
        list.add(new ColumnsVo("ptlx", "平台类型"));
        list.add(new ColumnsVo("qbbzgx", "情报报知关系"));
        list.add(new ColumnsVo("hjzt", "航迹状态"));
        list.add(new ColumnsVo("hjzl", "航迹质量"));
        list.add(new ColumnsVo("dwzt", "定位状态"));
        list.add(new ColumnsVo("jd", "经度"));
        list.add(new ColumnsVo("wd", "纬度"));
        list.add(new ColumnsVo("gd", "高度"));
        list.add(new ColumnsVo("jl", "距离"));
        list.add(new ColumnsVo("fw", "方位"));
        list.add(new ColumnsVo("yj", "仰角"));
        list.add(new ColumnsVo("jdhx", "绝对航向"));
        list.add(new ColumnsVo("jdhs", "绝对航速"));
        list.add(new ColumnsVo("jdzfxsd", "绝对z方向速度"));
        list.add(new ColumnsVo("xdhx", "相对航向"));
        list.add(new ColumnsVo("xdhs", "相对航速"));
        list.add(new ColumnsVo("xdzfxsd", "相对z方向速度"));
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
        list.add(new ColumnsVo("jmbz", "军民标识"));
        list.add(new ColumnsVo("jmbzzxd", "军民标识置信度"));
        list.add(new ColumnsVo("phdz", "批号对照表"));
        list.add(new ColumnsVo("xpzs", "线谱总数目"));
        list.add(new ColumnsVo("xppjqd", "线谱平均强度"));
        list.add(new ColumnsVo("zxpl", "最小频率"));
        list.add(new ColumnsVo("xpdxzxpl", "线谱等效中心频率"));
        list.add(new ColumnsVo("phdzcd", "批号对照表长度"));
        return list;
    }
}
