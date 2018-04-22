package com.selfwork.intelligence.biz;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.selfwork.intelligence.common.BeanUtils;
import com.selfwork.intelligence.common.DateUtils;
import com.selfwork.intelligence.common.enums.AuditStatusEnum;
import com.selfwork.intelligence.common.enums.ImportStatusEnum;
import com.selfwork.intelligence.common.enums.QualityEvaluateEnum;
import com.selfwork.intelligence.mapper.ResourceEtlLogPOMapper;
import com.selfwork.intelligence.mapper.ResourcePOMapper;
import com.selfwork.intelligence.model.po.ResourceEtlLogPO;
import com.selfwork.intelligence.model.po.ResourcePO;
import com.selfwork.intelligence.model.vo.ResourceEtlLogVo;
import com.selfwork.intelligence.model.vo.dataquality.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.sql.Date;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class DataQualityBiz extends BaseBiz {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ResourcePOMapper resourcePOMapper;

    @Autowired
    private ResourceEtlLogPOMapper resourceEtlLogPOMapper;

    public PageInfo<ResourceEtlLogVo> selectByResourceId(ResourceEtlLogQueryVo vo) {
        try {


            this.startPage(vo);
            Integer resourceId = vo.getResourceId();
            List<ResourceEtlLogPO> items = resourceEtlLogPOMapper.selectByResourceId(resourceId);

            if (CollectionUtils.isEmpty(items)) {
                logger.error("获取资源导入日志失败，返回数据为空");
                return null;
            }

            List<ResourceEtlLogVo> res = BeanUtils.copyList(items, ResourceEtlLogVo.class);

            res.stream().forEach(m -> {
                m.setCreateTimeStr(DateUtils.getFormatDateTime(m.getCreateTime()));
            });

            return new PageInfo<>(res);
        } catch (Exception e) {
            logger.error("获取资源导入日志失败：" + e.getMessage(), e);
        }

        return null;

    }

    public PageInfo<DataQualitVo> findPage(DataQualityQueryVo queryVo) {
        try {

            // 查询
            this.startPage(queryVo);
            List<ResourcePO> list = resourcePOMapper.findList(queryVo);
            if (CollectionUtils.isEmpty(list)) {
                logger.error("获取资源分页信息失败");
                return null;
            }


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
                m.setQualityStr(m.getQuality() == null ? "" : QualityEvaluateEnum.getEnum(m.getQuality().intValue()).getDisplayName());
            });

            return new PageInfo<>(res);
        } catch (Exception e) {
            logger.error("数据转换错误", e);
            return null;
        }


    }

    public void audit(AuditRequestVo vo) {

        ResourcePO record = new ResourcePO();
        record.setAuditStatus(vo.getAuditStatus());
        record.setId(vo.getResourceId());
        resourcePOMapper.updateByPrimaryKeySelective(record);

    }

    public void evaluateQuality(QualityEvaluateRequestVo vo) {
        ResourcePO record = new ResourcePO();
        record.setQuality(vo.getQuality());
        record.setId(vo.getResourceId());
        resourcePOMapper.updateByPrimaryKeySelective(record);
    }

    public void cancelResource(CancelResourceRequestVo vo) {
        ResourcePO record = new ResourcePO();
        record.setIsCancel(true);
        record.setId(vo.getResourceId());
        resourcePOMapper.updateByPrimaryKeySelective(record);
    }
}
