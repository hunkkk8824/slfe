package com.selfwork.intelligence.biz.dataset;

import com.selfwork.intelligence.biz.BaseBiz;
import com.selfwork.intelligence.biz.IBatchInsertCallBack;
import com.selfwork.intelligence.biz.IBatchService;
import com.selfwork.intelligence.common.BeanUtils;
import com.selfwork.intelligence.common.DateUtils;
import com.selfwork.intelligence.mapper.QbSjJztsmbPOMapper;
import com.selfwork.intelligence.model.QbSjJztsmbPO;
import com.selfwork.intelligence.model.vo.dataquality.ColumnsVo;
import com.selfwork.intelligence.model.vo.dateset.LocationDto;
import com.selfwork.intelligence.model.vo.dateset.QbSjJztsmbQueryReq;
import com.selfwork.intelligence.model.vo.dateset.QbSjJztsmbVO;
import com.selfwork.intelligence.model.vo.dateset.QueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//情报_数据_技侦态势目标
@Service
public class QbSjJztsmbBiz extends BaseBiz implements IBaseQbBiz<QbSjJztsmbVO> {

    @Autowired
    private QbSjJztsmbPOMapper qbSjJztsmb;

    @Autowired
    private IBatchService batchService;

    public boolean batchInsert(List<QbSjJztsmbPO> list) {
        return batchService.insertObjectByBatch(list, 500, new IBatchInsertCallBack<QbSjJztsmbPO>() {
            @Override
            public Integer doBatch(List<QbSjJztsmbPO> list, Insert insert) {
                return insertList(list);
            }
        });
    }

    private Integer insertList(List<QbSjJztsmbPO> list) {
        return qbSjJztsmb.insertList(list);
    }

    @Override
    public List<QbSjJztsmbVO> getListByBatchNO(String batchNO) {

        List<QbSjJztsmbPO> pos = qbSjJztsmb.getListByBatchNO(batchNO);

        return pos.parallelStream().map(po -> {
            QbSjJztsmbVO item = new QbSjJztsmbVO();
            BeanUtils.copy(po, item);
            item.setFbsjStr(DateUtils.getFormatDateTime(po.getFbsj()));
            item.setHqsjStr(DateUtils.getFormatDateTime(po.getHqsj()));
            return item;
        }).collect(Collectors.toList());
    }

    @Override
    public List<QbSjJztsmbVO> getList(QueryVo queryVo) {

        List<QbSjJztsmbPO> pos = qbSjJztsmb.getList(queryVo);

        return pos.parallelStream().map(po -> {
            QbSjJztsmbVO item = new QbSjJztsmbVO();
            BeanUtils.copy(po, item);
            item.setFbsjStr(DateUtils.getFormatDateTime(po.getFbsj()));
            item.setHqsjStr(DateUtils.getFormatDateTime(po.getHqsj()));
            return item;
        }).collect(Collectors.toList());
    }

    @Override
    public List<LocationDto> getLocations(QueryVo queryVo) {
        return qbSjJztsmb.getLocations(queryVo);
    }

    @Override
    public List<ColumnsVo> getColumns() {
        List<ColumnsVo> list = new ArrayList<>();
        list.add(new ColumnsVo("ph", "批号"));
        list.add(new ColumnsVo("ptbh", "平台编号"));
        list.add(new ColumnsVo("ptmc", "平台名称"));
        list.add(new ColumnsVo("cgqbh", "传感器编号"));
        list.add(new ColumnsVo("xylx", "信源类型"));
        list.add(new ColumnsVo("zbl", "子报类"));
        list.add(new ColumnsVo("fbdwbh", "发报单位编号"));
        list.add(new ColumnsVo("fbdwmc", "发报单位名称"));
        list.add(new ColumnsVo("sbdwbh", "收报单位编号"));
        list.add(new ColumnsVo("sbdwmc", "收报单位名称"));
        list.add(new ColumnsVo("fbsjStr", "发报时间&emsp; &emsp; &emsp; &emsp; &emsp; &emsp;"));
        list.add(new ColumnsVo("hqsjStr", "收报时间&emsp; &emsp; &emsp; &emsp; &emsp; &emsp;"));
        list.add(new ColumnsVo("bwlsh", "报文流水号"));
        list.add(new ColumnsVo("sq", "时区"));
        list.add(new ColumnsVo("dlzbx", "地理坐标系类型"));
        list.add(new ColumnsVo("zbxbz", "坐标系标识"));
        list.add(new ColumnsVo("qbhqsd", "情报获取手段"));
        list.add(new ColumnsVo("twbh", "台位编号"));
        list.add(new ColumnsVo("jmbz", "军民标识"));
        list.add(new ColumnsVo("jmbzzxd", "军民标识置信度"));
        list.add(new ColumnsVo("sx", "属性"));
        list.add(new ColumnsVo("sxzxd", "属性置信度"));
        list.add(new ColumnsVo("zl", "种类"));
        list.add(new ColumnsVo("zlzxd", "种类置信度"));
        list.add(new ColumnsVo("lx", "类型"));
        list.add(new ColumnsVo("lxzxd", "类型置信度"));
        list.add(new ColumnsVo("gj", "国籍"));
        list.add(new ColumnsVo("gjzxd", "国籍置信度"));
        list.add(new ColumnsVo("mbsj", "目标时间"));
        list.add(new ColumnsVo("sjsd", "升降速度"));
        list.add(new ColumnsVo("dt", "动态"));
        list.add(new ColumnsVo("hx", "航向"));
        list.add(new ColumnsVo("hs", "航速"));
        list.add(new ColumnsVo("zsd", "z方向目标速度"));
        list.add(new ColumnsVo("fwjsd", "方位角速度"));
        list.add(new ColumnsVo("gdjsd", "高低角速度"));
        list.add(new ColumnsVo("spjsd", "水平加速度"));
        list.add(new ColumnsVo("jsdfx", "水平加速度方向"));
        list.add(new ColumnsVo("czjsd", "垂直加速度"));
        list.add(new ColumnsVo("jd", "经度"));
        list.add(new ColumnsVo("wd", "纬度"));
        list.add(new ColumnsVo("gd", "高度"));
        list.add(new ColumnsVo("jl", "距离"));
        list.add(new ColumnsVo("fw", "方位"));
        list.add(new ColumnsVo("yj", "仰角"));
        list.add(new ColumnsVo("jlwc", "距离误差"));
        list.add(new ColumnsVo("fwwc", "方位误差"));
        list.add(new ColumnsVo("yjwc", "仰角误差"));
        list.add(new ColumnsVo("sjpc", "时间偏差"));
        list.add(new ColumnsVo("wxdj", "威胁等级"));
        list.add(new ColumnsVo("zycd", "重要程度"));
        list.add(new ColumnsVo("hdsj", "活动时间"));
        list.add(new ColumnsVo("hdqy", "活动区域"));
        list.add(new ColumnsVo("rw", "任务"));
        list.add(new ColumnsVo("zy", "作用"));
        list.add(new ColumnsVo("kxd", "可信度"));
        list.add(new ColumnsVo("kkx", "可靠性"));
        list.add(new ColumnsVo("qrxx", "确认信息"));
        list.add(new ColumnsVo("qdjd", "起点基地"));
        list.add(new ColumnsVo("zdjd", "终点基地"));
        list.add(new ColumnsVo("mbjz", "目标军种"));
        list.add(new ColumnsVo("lsdw", "隶属单位"));
        list.add(new ColumnsVo("fh", "番号"));
        list.add(new ColumnsVo("wzsm", "文字说明"));
        list.add(new ColumnsVo("ddsj", "到达时间"));
        list.add(new ColumnsVo("hwlx", "货物类型"));
        list.add(new ColumnsVo("cc", "船长"));
        list.add(new ColumnsVo("ck", "船宽"));
        list.add(new ColumnsVo("cssd", "吃水深度"));
        list.add(new ColumnsVo("imo", "imo号"));
        list.add(new ColumnsVo("zxl", "转向率"));
        list.add(new ColumnsVo("jsx", "jsx名"));
        list.add(new ColumnsVo("hh", "jsx名"));
        list.add(new ColumnsVo("dwzblx", "电子定位装备类型"));
        list.add(new ColumnsVo("skbz", "受控标志"));
        list.add(new ColumnsVo("dhtlk", "导航台类型"));
        list.add(new ColumnsVo("dhbz", "虚拟导航标志"));
        list.add(new ColumnsVo("sbm", ""));
        list.add(new ColumnsVo("aqxx", "安全信息"));
        list.add(new ColumnsVo("pxfs", "判性方式"));
        list.add(new ColumnsVo("hjgl", "航迹管理"));
//        list.add(new ColumnsVo("ph2", "批号2"));
//        list.add(new ColumnsVo("ptbh2", "平台编号2"));
//        list.add(new ColumnsVo("ptmc2", "平台名称2"));
//        list.add(new ColumnsVo("xylx2", "信源类型2"));
//        list.add(new ColumnsVo("twlb", "可阅台位列表"));
//        list.add(new ColumnsVo("hjzt", "航迹状态"));
        list.add(new ColumnsVo("jssb", "接收上报"));
        list.add(new ColumnsVo("twlbcd", "可阅台位列表长度"));

        return list;
    }

    public List<QbSjJztsmbVO> getBaseInfoList(QbSjJztsmbQueryReq req) throws IllegalAccessException, InstantiationException {
        List<QbSjJztsmbPO> pos = qbSjJztsmb.getBaseInfoList(req);
        return BeanUtils.copyList(pos, QbSjJztsmbVO.class);
    }

}
