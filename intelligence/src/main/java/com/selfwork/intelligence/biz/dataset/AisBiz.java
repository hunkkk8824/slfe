package com.selfwork.intelligence.biz.dataset;

import com.selfwork.intelligence.biz.BaseBiz;
import com.selfwork.intelligence.common.BeanUtils;
import com.selfwork.intelligence.mapper.AisPOMapper;
import com.selfwork.intelligence.model.po.AisPO;
import com.selfwork.intelligence.model.vo.dateset.AisQueryReq;
import com.selfwork.intelligence.model.vo.dateset.AisVo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AisBiz extends BaseBiz {
    @Autowired
    private AisPOMapper aisPOMapper;

    /**
     * 查询AIS信息列表
     * @param req
     * @return
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    public List<AisVo> getAisInfoList(AisQueryReq req) throws IllegalAccessException, InstantiationException{
        List<AisPO> pos = aisPOMapper.getAisInfoList(req);
        return BeanUtils.copyList(pos,AisVo.class);
    }
}
