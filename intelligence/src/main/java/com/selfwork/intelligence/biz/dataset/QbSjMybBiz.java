package com.selfwork.intelligence.biz.dataset;

import com.selfwork.intelligence.biz.BaseBiz;
import com.selfwork.intelligence.common.BeanUtils;
import com.selfwork.intelligence.common.DateUtils;
import com.selfwork.intelligence.mapper.QbSjMybPOMapper;
import com.selfwork.intelligence.model.QbSjMybPO;
import com.selfwork.intelligence.model.vo.dataquality.ColumnsVo;
import com.selfwork.intelligence.model.vo.dateset.LocationDto;
import com.selfwork.intelligence.model.vo.dateset.QbSjMybVO;
import com.selfwork.intelligence.model.vo.dateset.QueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//情报_数据_密语
@Service
public class QbSjMybBiz extends BaseBiz implements IBaseQbBiz<QbSjMybVO> {

    @Autowired
    private QbSjMybPOMapper qbSjMyb;

    @Override
    public List<QbSjMybVO> getListByBatchNO(String batchNO) {

        List<QbSjMybPO> pos = qbSjMyb.getListByBatchNO(batchNO);

        return pos.parallelStream().map(po -> {
            QbSjMybVO item = new QbSjMybVO();
            BeanUtils.copy(po, item);
            return item;
        }).collect(Collectors.toList());
    }

    @Override
    public List<QbSjMybVO> getList(QueryVo queryVo) {
        return null;
    }

    @Override
    public List<LocationDto> getLocations(QueryVo queryVo) {
        return null;
    }

    @Override
    public List<ColumnsVo> getColumns() {
        List<ColumnsVo> list = new ArrayList<>();
        list.add(new ColumnsVo("mylx", "密语类型"));
        list.add(new ColumnsVo("xxgslx", "信息格式类型"));
        list.add(new ColumnsVo("xxlx", "信息类型"));
        list.add(new ColumnsVo("mybh", "密语编号"));
        list.add(new ColumnsVo("mymc", "密语名称"));
        list.add(new ColumnsVo("nbbh", "内部编号"));
        list.add(new ColumnsVo("bbh", "版本号"));

        return list;
    }
}
