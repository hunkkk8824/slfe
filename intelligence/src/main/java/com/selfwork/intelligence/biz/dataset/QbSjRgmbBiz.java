package com.selfwork.intelligence.biz.dataset;

import com.selfwork.intelligence.biz.BaseBiz;
import com.selfwork.intelligence.biz.IBatchInsertCallBack;
import com.selfwork.intelligence.biz.IBatchService;
import com.selfwork.intelligence.common.BeanUtils;
import com.selfwork.intelligence.common.DateUtils;
import com.selfwork.intelligence.mapper.QbSjRgmbPOMapper;
import com.selfwork.intelligence.model.QbSjRgmbPO;
import com.selfwork.intelligence.model.vo.dataquality.ColumnsVo;
import com.selfwork.intelligence.model.vo.dateset.LocationDto;
import com.selfwork.intelligence.model.vo.dateset.QbSjRgmbQueryReq;
import com.selfwork.intelligence.model.vo.dateset.QbSjRgmbVO;
import com.selfwork.intelligence.model.vo.dateset.QueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//情报_数据_人工目标
@Service
public class QbSjRgmbBiz extends BaseBiz implements IBaseQbBiz<QbSjRgmbVO> {
    @Autowired
    private QbSjRgmbPOMapper qbSjRgmb;

    @Autowired
    private IBatchService batchService;

    public boolean batchInsert(List<QbSjRgmbPO> list) {
        return batchService.insertObjectByBatch(list, 500, new IBatchInsertCallBack<QbSjRgmbPO>() {
            @Override
            public Integer doBatch(List<QbSjRgmbPO> list, Insert insert) {
                return insertList(list);
            }
        });
    }

    private Integer insertList(List<QbSjRgmbPO> list) {
        return qbSjRgmb.insertList(list);
    }

    @Override
    public List<QbSjRgmbVO> getListByBatchNO(String batchNO) {
        List<QbSjRgmbPO> pos = qbSjRgmb.getListByBatchNO(batchNO);

        return pos.parallelStream().map(po -> {
            QbSjRgmbVO item = new QbSjRgmbVO();
            BeanUtils.copy(po, item);
            item.setJssjStr(DateUtils.getFormatDateTime(po.getJssj()));
            item.setSbsjStr(DateUtils.getFormatDateTime(po.getSbsj()));
            return item;
        }).collect(Collectors.toList());
    }

    @Override
    public List<QbSjRgmbVO> getList(QueryVo queryVo) {
        List<QbSjRgmbPO> pos = qbSjRgmb.getList(queryVo);

        return pos.parallelStream().map(po -> {
            QbSjRgmbVO item = new QbSjRgmbVO();
            BeanUtils.copy(po, item);
            item.setJssjStr(DateUtils.getFormatDateTime(po.getJssj()));
            item.setSbsjStr(DateUtils.getFormatDateTime(po.getSbsj()));
            return item;
        }).collect(Collectors.toList());
    }

    @Override
    public List<LocationDto> getLocations(QueryVo queryVo) {
        return qbSjRgmb.getLocations(queryVo);
    }

    @Override
    public List<ColumnsVo> getColumns() {
        List<ColumnsVo> list = new ArrayList<>();
        list.add(new ColumnsVo("ph", "批号"));
        list.add(new ColumnsVo("ptbh", "平台编号"));
        list.add(new ColumnsVo("ptmc", "平台名称"));
        list.add(new ColumnsVo("cgqbh", "传感器编号"));
        list.add(new ColumnsVo("xylx", "信源类型"));
        list.add(new ColumnsVo("jlbh", "j链编号"));
        list.add(new ColumnsVo("zt", "状态"));
        list.add(new ColumnsVo("mbs", "目标数"));
        list.add(new ColumnsVo("ws", "维数"));
        list.add(new ColumnsVo("sx", "属性"));
        list.add(new ColumnsVo("sxzxd", "属性置信度"));
        list.add(new ColumnsVo("zl", "种类"));
        list.add(new ColumnsVo("zlzxs", "种类置信度"));
        list.add(new ColumnsVo("lx", "类型"));
        list.add(new ColumnsVo("lxzxd", "类型置信度"));
        list.add(new ColumnsVo("gj", "国籍"));
        list.add(new ColumnsVo("gjzxd", "国籍置信度"));
        list.add(new ColumnsVo("dt", "动态"));
        list.add(new ColumnsVo("dtzxd", "动态置信度"));
        list.add(new ColumnsVo("jmbz", "军民"));
        list.add(new ColumnsVo("jmbzzxd", "军民标识置信度"));
        list.add(new ColumnsVo("ztbz", "状态标识"));
        list.add(new ColumnsVo("rw", "任务"));
        list.add(new ColumnsVo("bd", "编队"));
        list.add(new ColumnsVo("zq", "周期"));
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
        list.add(new ColumnsVo("bz", "备注"));
        list.add(new ColumnsVo("jssjStr", "接收时间&emsp; &emsp; &emsp; &emsp; &emsp; &emsp; "));
        list.add(new ColumnsVo("sbsjStr", "上报时间&emsp; &emsp; &emsp; &emsp; &emsp; &emsp; "));
        list.add(new ColumnsVo("ptxh", "平台型号"));
        list.add(new ColumnsVo("kytw", "可阅台位"));
        list.add(new ColumnsVo("dxx", "点信息"));
        list.add(new ColumnsVo("gljz", "关联键值"));
        list.add(new ColumnsVo("kytwcd", "可阅台位长度"));
        list.add(new ColumnsVo("dxxcd", "点信息长度"));

        return list;
    }
    public List<QbSjRgmbVO> getBaseInfoList(QbSjRgmbQueryReq req) throws IllegalAccessException, InstantiationException {
        List<QbSjRgmbPO> pos = qbSjRgmb.getBaseInfoList(req);
        return BeanUtils.copyList(pos, QbSjRgmbVO.class);
    }
}
