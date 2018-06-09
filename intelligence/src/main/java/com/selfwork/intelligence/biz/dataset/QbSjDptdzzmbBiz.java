package com.selfwork.intelligence.biz.dataset;

import com.selfwork.intelligence.biz.BaseBiz;
import com.selfwork.intelligence.common.BeanUtils;
import com.selfwork.intelligence.common.DateUtils;
import com.selfwork.intelligence.mapper.QbSjDptdzzmbPOMapper;
import com.selfwork.intelligence.model.QbSjDptdzzmbPOWithBLOBs;
import com.selfwork.intelligence.model.vo.dateset.QbSjDptdzzmbPOWithBLOBsVO;
import com.selfwork.intelligence.model.vo.dataquality.ColumnsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//情报_数据_多平台电子战目标
@Service
public class QbSjDptdzzmbBiz extends BaseBiz implements IBaseQbBiz<QbSjDptdzzmbPOWithBLOBsVO> {

    @Autowired
    private QbSjDptdzzmbPOMapper qbSjDptdzzmb;

    @Override
    public List<QbSjDptdzzmbPOWithBLOBsVO> getListByBatchNO(String batchNO) {
        List<QbSjDptdzzmbPOWithBLOBs> pos = qbSjDptdzzmb.getListByBatchNO(batchNO);

        return pos.parallelStream().map(po -> {
            QbSjDptdzzmbPOWithBLOBsVO item = new QbSjDptdzzmbPOWithBLOBsVO();
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
        list.add(new ColumnsVo("xdsd", "相对速度"));
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
        list.add(new ColumnsVo("scfs", "目标生成方式"));
        list.add(new ColumnsVo("hjzlwl", "航迹质量wl"));
        list.add(new ColumnsVo("xwc", "x轴误差"));
        list.add(new ColumnsVo("ywc", "y轴误差"));
        list.add(new ColumnsVo("zwc", "z轴误差"));
        list.add(new ColumnsVo("xywc", "xy轴协方差"));
        list.add(new ColumnsVo("splx", "射频类型"));
        list.add(new ColumnsVo("spz", "射频值"));
        list.add(new ColumnsVo("ldxh", "雷达型号"));
        list.add(new ColumnsVo("ldyt", "雷达用途"));
        list.add(new ColumnsVo("txsmzq", "天线扫描周期"));
        list.add(new ColumnsVo("smfs", "天线扫描方式"));
        list.add(new ColumnsVo("jhfs", "极化方式"));
        list.add(new ColumnsVo("plfw", "雷达使用的电磁波的频率范围"));
        list.add(new ColumnsVo("cpccs", "重频参差数"));
        list.add(new ColumnsVo("cpddl", "重频抖动量"));
        list.add(new ColumnsVo("cphdl", "重频滑动量"));
        list.add(new ColumnsVo("cplx", "脉冲重复频率类型"));
        list.add(new ColumnsVo("cfpl", "重复频率"));
        list.add(new ColumnsVo("mckdlx", "脉冲宽度类型"));
        list.add(new ColumnsVo("mckdz", "脉冲宽度值"));
        list.add(new ColumnsVo("mcfd", "脉冲幅度"));
        list.add(new ColumnsVo("phdzcd", "批号对照表长度"));
        list.add(new ColumnsVo("spzcd", "射频值长度"));
        list.add(new ColumnsVo("cfplcd", "重复频率长度"));
        list.add(new ColumnsVo("mckdzcd", "脉冲宽度值长度"));
        return list;
    }
}
