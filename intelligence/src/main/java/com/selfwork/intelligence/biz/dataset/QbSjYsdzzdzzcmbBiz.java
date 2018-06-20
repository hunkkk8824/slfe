package com.selfwork.intelligence.biz.dataset;

import com.selfwork.intelligence.biz.BaseBiz;
import com.selfwork.intelligence.biz.IBatchInsertCallBack;
import com.selfwork.intelligence.biz.IBatchService;
import com.selfwork.intelligence.common.BeanUtils;
import com.selfwork.intelligence.common.DateUtils;
import com.selfwork.intelligence.mapper.QbSjYsdzzdzzcmbPOMapper;
import com.selfwork.intelligence.model.po.QbSjYsdzzdzzcmbPO;
import com.selfwork.intelligence.model.po.QbSjYsdzzdzzcmbPOWithBLOBs;
import com.selfwork.intelligence.model.vo.dataquality.ColumnsVo;
import com.selfwork.intelligence.model.vo.dateset.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//情报_数据_电子战电子侦察目标
@Service
public class QbSjYsdzzdzzcmbBiz extends BaseBiz implements IBaseQbBiz<QbSjYsdzzdzzcmbPOWithBLOBsVO> {


    @Autowired
    private QbSjYsdzzdzzcmbPOMapper qbSjYsdzzdzzcmb;

    @Autowired
    private IBatchService batchService;

    public boolean batchInsert(List<QbSjYsdzzdzzcmbPOWithBLOBs> list) {
        return batchService.insertObjectByBatch(list, 500, new IBatchInsertCallBack<QbSjYsdzzdzzcmbPOWithBLOBs>() {
            @Override
            public Integer doBatch(List<QbSjYsdzzdzzcmbPOWithBLOBs> list, Insert insert) {
                return insertList(list);
            }
        });
    }

    private Integer insertList(List<QbSjYsdzzdzzcmbPOWithBLOBs> list) {
        return qbSjYsdzzdzzcmb.insertList(list);
    }

    @Override
    public List<QbSjYsdzzdzzcmbPOWithBLOBsVO> getListByBatchNO(String batchNO) {

        List<QbSjYsdzzdzzcmbPOWithBLOBs> pos = qbSjYsdzzdzzcmb.getListByBatchNO(batchNO);

        return pos.parallelStream().map(po -> {
            QbSjYsdzzdzzcmbPOWithBLOBsVO item = new QbSjYsdzzdzzcmbPOWithBLOBsVO();
            BeanUtils.copy(po, item);
            item.setJssjStr(DateUtils.getFormatDateTime(po.getJssj()));
            item.setSbsjStr(DateUtils.getFormatDateTime(po.getSbsj()));
            return item;
        }).collect(Collectors.toList());
    }

    @Override
    public List<QbSjYsdzzdzzcmbPOWithBLOBsVO> getList(QueryVo queryVo) {

        List<QbSjYsdzzdzzcmbPOWithBLOBs> pos = qbSjYsdzzdzzcmb.getList(queryVo);

        return pos.parallelStream().map(po -> {
            QbSjYsdzzdzzcmbPOWithBLOBsVO item = new QbSjYsdzzdzzcmbPOWithBLOBsVO();
            BeanUtils.copy(po, item);
            item.setJssjStr(DateUtils.getFormatDateTime(po.getJssj()));
            item.setSbsjStr(DateUtils.getFormatDateTime(po.getSbsj()));
            return item;
        }).collect(Collectors.toList());
    }

    @Override
    public List<LocationDto> getLocations(QueryVo queryVo) {
        return qbSjYsdzzdzzcmb.getLocations(queryVo);
    }

    @Override
    public List<ColumnsVo> getColumns() {
        List<ColumnsVo> list = new ArrayList<>();
        list.add(new ColumnsVo("ph", "批号"));
        list.add(new ColumnsVo("ptbh", "平台编号"));
        list.add(new ColumnsVo("ptmc", "平台名称"));
        list.add(new ColumnsVo("ptlx", "平台类型"));
        list.add(new ColumnsVo("cgqbh", "传感器编号"));
        list.add(new ColumnsVo("xylx", "信源类型"));
        list.add(new ColumnsVo("hjzt", "航迹状态"));
        list.add(new ColumnsVo("hjzl", "航迹质量"));
        list.add(new ColumnsVo("jssjStr", "接收时间&emsp; &emsp; &emsp; &emsp; &emsp; &emsp; "));
        list.add(new ColumnsVo("sbsjStr", "上报时间&emsp; &emsp; &emsp; &emsp; &emsp; &emsp; "));
        list.add(new ColumnsVo("zcxxly", "侦察信息来源"));
        list.add(new ColumnsVo("sx", "属性"));
        list.add(new ColumnsVo("gj", "国籍"));
        list.add(new ColumnsVo("jd", "经度"));
        list.add(new ColumnsVo("wd", "维度"));
        list.add(new ColumnsVo("gd", "高度"));
        list.add(new ColumnsVo("jl", "距离"));
        list.add(new ColumnsVo("fw", "方位"));
        list.add(new ColumnsVo("yj", "仰角"));
        list.add(new ColumnsVo("jlwc", "距离误差"));
        list.add(new ColumnsVo("fwwc", "方位误差"));
        list.add(new ColumnsVo("yjwc", "仰角误差"));
        list.add(new ColumnsVo("cpccs", "重频参差数"));
        list.add(new ColumnsVo("cpddl", "重频抖动量"));
        list.add(new ColumnsVo("cphdl", "重频滑动量"));
        list.add(new ColumnsVo("cplx", "脉冲重复频率类型"));
        list.add(new ColumnsVo("cfpl", "重复频率"));
        list.add(new ColumnsVo("ldxh", "雷达型号"));
        list.add(new ColumnsVo("ldyt", "雷达用途"));
        list.add(new ColumnsVo("txsmzq", "天线扫描周期"));
        list.add(new ColumnsVo("txsmfs", "天线扫描方式"));
        list.add(new ColumnsVo("jhfs", "极化方式"));
        list.add(new ColumnsVo("plfw", "雷达使用的电磁波的频率范围"));
        list.add(new ColumnsVo("wxdj", "威胁等级"));
        list.add(new ColumnsVo("kxd", "可信度"));
        list.add(new ColumnsVo("dgngrms", "多功能干扰设备有源干扰模式"));
        list.add(new ColumnsVo("dgngrys", "多功能干扰设备有源干扰样式建议"));
        list.add(new ColumnsVo("hmbgrms", "毫米波有源干扰设备有源干扰模式"));
        list.add(new ColumnsVo("hmbgrys", "毫米波有源干扰设备有源干扰样式建议"));
        list.add(new ColumnsVo("xbdgrys", "x波段设备有源干扰样式建议"));
        list.add(new ColumnsVo("wygdgrys", "无源光电干扰样式建议"));
        list.add(new ColumnsVo("grdk", "建议干扰带宽"));
        list.add(new ColumnsVo("dgnfpzt", "多功能干扰分配状态"));
        list.add(new ColumnsVo("hmbfpzt", "毫米波干扰分配状态"));
        list.add(new ColumnsVo("xsbfpzt", "x设备干扰分配状态"));
        list.add(new ColumnsVo("splx", "射频类型"));
        list.add(new ColumnsVo("spz", "射频值"));
        list.add(new ColumnsVo("mbzp", "目标载频"));
        list.add(new ColumnsVo("zpjbl", "目标载频变量"));
        list.add(new ColumnsVo("mckdlx", "脉冲宽度类型"));
        list.add(new ColumnsVo("mckdz", "脉冲宽度值"));
        list.add(new ColumnsVo("mcfd", "脉冲幅度"));
        list.add(new ColumnsVo("mnlx", "脉内类型"));
        list.add(new ColumnsVo("zmcgs", "子脉冲个数"));
        list.add(new ColumnsVo("zmckd", "子脉冲宽度"));
        list.add(new ColumnsVo("qspl", "起始频率"));
        list.add(new ColumnsVo("zzpl", "终止频率"));
        list.add(new ColumnsVo("zdpp", "最大频幅"));
        list.add(new ColumnsVo("qsxw", "起始相位"));
        list.add(new ColumnsVo("smzq", "扫描周期"));
        list.add(new ColumnsVo("zbkdsj", "主瓣宽度时间"));
        list.add(new ColumnsVo("zbdpwzsj", "主瓣零电平位置时间"));
        list.add(new ColumnsVo("zfbdpc", "主副瓣电平差"));
        list.add(new ColumnsVo("yfwfzsj", "第一副瓣峰值位置时间"));
        list.add(new ColumnsVo("spjcz", "射频精测值"));
        list.add(new ColumnsVo("spjcjfc", "射频精测均方差"));
        list.add(new ColumnsVo("mcjcz", "脉冲重复间隔精测值"));
        list.add(new ColumnsVo("mcjcjfc", "脉冲重复间隔精测均方差"));
        list.add(new ColumnsVo("jcmcs", "精测脉冲个数"));
        list.add(new ColumnsVo("ptxh", "平台型号"));
        list.add(new ColumnsVo("jxh", "机弦号"));
        list.add(new ColumnsVo("jjm", "舰名"));
        list.add(new ColumnsVo("cfplcd", "重复频率长度"));
        list.add(new ColumnsVo("spzcd", "射频值长度"));
        list.add(new ColumnsVo("mckdzcd", "脉冲宽度值长度"));

        return list;
    }

    public List<QbSjYsdzzdzzcmbVO> getBaseInfoList(QbSjYsdzzdzzcmbQueryReq req) throws IllegalAccessException, InstantiationException {
        List<QbSjYsdzzdzzcmbPO> pos = qbSjYsdzzdzzcmb.getBaseInfoList(req);
        return BeanUtils.copyList(pos, QbSjYsdzzdzzcmbVO.class);
    }
}
