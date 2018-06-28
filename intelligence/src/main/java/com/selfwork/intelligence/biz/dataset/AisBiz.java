package com.selfwork.intelligence.biz.dataset;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.selfwork.intelligence.biz.BaseBiz;
import com.selfwork.intelligence.common.BeanUtils;
import com.selfwork.intelligence.common.DateUtils;
import com.selfwork.intelligence.common.enums.ShipStatusEnum;
import com.selfwork.intelligence.common.enums.ShipTypeEnum;
import com.selfwork.intelligence.mapper.AisPOMapper;
import com.selfwork.intelligence.model.po.AisPO;
import com.selfwork.intelligence.model.vo.dateset.AisQueryReq;
import com.selfwork.intelligence.model.vo.dateset.AisVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AisBiz extends BaseBiz {
    @Autowired
    private AisPOMapper aisPOMapper;

    public final Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 查询AIS信息列表
     *
     * @param req
     * @return
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    public Map<String, Object> getAisInfoList(AisQueryReq req)  {

        Map<String, Object> map = new HashMap<>();
        Page page = this.startPage(req);
        List<AisPO> pos = aisPOMapper.getAisInfoList(req);
        try {

            List<AisVo> res = BeanUtils.copyList(pos, AisVo.class);

            if (CollectionUtils.isEmpty(res)) {
                logger.error("BeanUtils.copyList 返回为空");
                map.put("rows", new ArrayList());
                map.put("total", 0);
            }

            res.forEach(m -> {
                m.setEtaStr(DateUtils.getFormatDateTime(m.getEta()));
                m.setShipStatusStr(m.getNavStatus() == null ? "" : ShipStatusEnum.getEnum(m.getNavStatus().intValue()).getDisplayName());
                m.setShipTypeStr(m.getShipType() == null ? "" : ShipTypeEnum.getEnum(m.getShipType().intValue()).getDisplayName());

            });
            map.put("rows", res);
            map.put("total", page.getTotal());
            return map;
        } catch (Exception e) {
            logger.error("数据转换错误", e);
            return null;
        }
    }
}
