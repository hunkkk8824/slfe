package com.selfwork.intelligence.biz;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.selfwork.intelligence.common.BeanUtils;
import com.selfwork.intelligence.common.DateUtils;
import com.selfwork.intelligence.common.enums.AuditStatusEnum;
import com.selfwork.intelligence.common.enums.ImportStatusEnum;
import com.selfwork.intelligence.mapper.ResourcePOMapper;
import com.selfwork.intelligence.model.po.ResourcePO;
import com.selfwork.intelligence.model.vo.dataquality.DataQualitVo;
import com.selfwork.intelligence.model.vo.dataquality.DataQualityQueryVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DataQualityBiz extends BaseBiz {

    public final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ResourcePOMapper resourcePOMapper;

    public PageInfo<DataQualitVo> findPage(DataQualityQueryVo queryVo) {
        // 查询
        int pageNumber = queryVo.getPageNumber();
        int pageSize = queryVo.getLimit();
        PageHelper.startPage(pageNumber, pageSize);
        List<ResourcePO> list = resourcePOMapper.findList(queryVo);
        if (null == list || list.size() == 0) {
            logger.error("获取资源分页信息失败");
            return null;
        }

        try {

            List<DataQualitVo> res = BeanUtils.copyList(list, DataQualitVo.class);

            if (CollectionUtils.isEmpty(res)) {
                logger.error("BeanUtils.copyList 返回为空");
                return null;
            }

            res.forEach(m -> {
                m.setAuditStatusStr(m.getAuditStatus() == null ? "" : AuditStatusEnum.getEnum(m.getAuditStatus().intValue()).getDisplayName());
                m.setAuditTimeStr(DateUtils.getFormatDateTime(m.getAuditTime()));
                m.setCommitTimeStr(DateUtils.getFormatDateTime(m.getCommitTime()));
                m.setImportStatusStr(m.getImportStatus() == null ? "" : ImportStatusEnum.getEnum(m.getImportStatus().intValue()).getDisplayName());
                m.setIsCancelStr(m.getIsCancel() != null && m.getIsCancel() ? "是" : "否");
            });

            return new PageInfo<>(res);
        } catch (Exception e) {
            logger.error("数据转换错误", e);
            return null;
        }

    }
}
