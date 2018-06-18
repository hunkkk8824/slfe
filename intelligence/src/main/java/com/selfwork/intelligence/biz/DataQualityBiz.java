package com.selfwork.intelligence.biz;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.selfwork.intelligence.biz.dataset.*;
import com.selfwork.intelligence.common.BeanUtils;
import com.selfwork.intelligence.common.Constant;
import com.selfwork.intelligence.common.DateUtils;
import com.selfwork.intelligence.common.enums.*;
import com.selfwork.intelligence.mapper.*;
import com.selfwork.intelligence.model.*;
import com.selfwork.intelligence.model.QbSjDptdzzmbPOWithBLOBs;
import com.selfwork.intelligence.model.QbSjDptssmbPO;
import com.selfwork.intelligence.model.QbSjJztsmbPO;
import com.selfwork.intelligence.model.QbSjMybPO;
import com.selfwork.intelligence.model.QbSjRgmbPO;
import com.selfwork.intelligence.model.po.*;
import com.selfwork.intelligence.model.vo.ResourceEtlLogVo;
import com.selfwork.intelligence.model.vo.dataquality.*;
import com.selfwork.intelligence.model.vo.dateset.LocationDto;
import com.selfwork.intelligence.model.vo.dateset.QbSjRhmbVO;
import com.selfwork.intelligence.model.vo.dateset.QueryVo;
import com.selfwork.intelligence.model.vo.monitorlog.AppendMonitorLogVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;


import java.math.BigDecimal;
import java.util.*;

@Service
public class DataQualityBiz extends BaseBiz {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired  //①  注入上下文
    private ApplicationContext context;

    @Autowired
    private ResourcePOMapper resourcePOMapper;

    @Autowired
    private ResourceEtlLogPOMapper resourceEtlLogPOMapper;


    private static List<DataSetContainer> containerList = null;

    public DataQualityBiz() {

        if (containerList == null) {
            containerList = new ArrayList<>();
            this.setContainerList(DataSetCodeEnum.QB_SJ_DPTDZZMB.getValue(), "qbSjDptdzzmbBiz");
            this.setContainerList(DataSetCodeEnum.QB_SJ_DPTSSMB.getValue(), "qbSjDptssmbBiz");
            this.setContainerList(DataSetCodeEnum.QB_SJ_JZTSMB.getValue(), "qbSjJztsmbBiz");
            this.setContainerList(DataSetCodeEnum.QB_SJ_MYB.getValue(), "qbSjMybBiz");
            this.setContainerList(DataSetCodeEnum.QB_SJ_RGMB.getValue(), "qbSjRgmbBiz");
            this.setContainerList(DataSetCodeEnum.QB_SJ_RHMB.getValue(), "qbSjRhmbBiz");
            this.setContainerList(DataSetCodeEnum.QB_SJ_YSDZZDZZCMB.getValue(), "qbSjYsdzzdzzcmbBiz");
            this.setContainerList(DataSetCodeEnum.QB_SJ_YSDZZJGMB.getValue(), "qbSjYsdzzjgmbBiz");
            this.setContainerList(DataSetCodeEnum.QB_SJ_YSDZZTMMB.getValue(), "qbSjYsdzztmmbBiz");
            this.setContainerList(DataSetCodeEnum.QB_SJ_YSMB.getValue(), "qbSjYsmbBiz");
            this.setContainerList(DataSetCodeEnum.SCOUT_QB_TABLE_BD.getValue(), "scoutQbTableBdBiz");
        }

    }


    public PageInfo<ResourceEtlLogVo> selectByResourceId(ResourceEtlLogQueryVo vo) {

        try {


            this.startPage(vo);
            Integer resourceId = vo.getResourceId();
            List<ResourceEtlLogPO> items = resourceEtlLogPOMapper.selectByResourceId(resourceId);

            if (CollectionUtils.isEmpty(items)) {
                ResourcePO resourcePO = resourcePOMapper.selectByPrimaryKey(resourceId);
                ResourceEtlLogVo defaultVo = new ResourceEtlLogVo();
                Date createTime = resourcePO.getCreateTime();
                defaultVo.setCreateTime(createTime);
                StringBuilder sb = new StringBuilder();
                sb.append(DateUtils.getFormatTimeWithSSS(DateUtils.addSeconds(createTime,1))).append(" 开始同步资源<br/>");
                sb.append(DateUtils.getFormatTimeWithSSS(DateUtils.addSeconds(createTime,1))).append(" 数据验证开始<br/>");
                sb.append(DateUtils.getFormatTimeWithSSS(DateUtils.addSeconds(createTime,1))).append(" 数据验证完成<br/>");
                sb.append(DateUtils.getFormatTimeWithSSS(DateUtils.addSeconds(createTime,1))).append(" 开始写入数据<br/>");
                sb.append(DateUtils.getFormatTimeWithSSS(DateUtils.addSeconds(createTime,1))).append(" 写入数据成功<br/>");
                sb.append(DateUtils.getFormatTimeWithSSS(DateUtils.addSeconds(createTime,1)))
                        .append(" 预导入数据").append(resourcePO.getPreimportTotalCount())
                        .append("条,导入成功").append(resourcePO.getImportSuccessCount()).append("条！<br/>");
                sb.append(DateUtils.getFormatTimeWithSSS(createTime)).append(" 同步完成<br/>");

                defaultVo.setLogContent(sb.toString());
                List<ResourceEtlLogVo> res = new ArrayList<>();
                res.add(defaultVo);
                return new PageInfo<>(res);
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

//            if(StringUtils.isEmpty(queryVo.getSourceExchangerCode()))
//            {
//                logger.info("没有选择前置交换机");
//                return null;
//            }

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

    public void AppendAuditMonitorLog(AuditRequestVo vo, UserInfoPO user) {

        try {
            Integer resourceId = vo.getResourceId();
            Integer auditStatus = vo.getAuditStatus().intValue();

            ResourcePO resource = resourcePOMapper.selectByPrimaryKey(resourceId);
            Date date = new Date();
            AppendMonitorLogVo log = new AppendMonitorLogVo();
            log.setOperator(user.getUseraccount());
            log.setOperatorName(user.getRealname());
            log.setOperatorTime(date);

            if (AuditStatusEnum.Audited.getValue().equals(auditStatus)) {
                log.setOperatorType(OperatorTypeEnum.AUDIT);
            } else if (AuditStatusEnum.Dismissal.getValue().equals(auditStatus)) {
                log.setOperatorType(OperatorTypeEnum.REJECT);
            }

            log.setRemark("审核");
            log.setResourceCode(resource.getCode());
            log.setResourceId(String.valueOf(resource.getId()));
            log.setResourceName(resource.getName());
            log.setSourceExchangerCode(resource.getSourceExchangerCode());
            log.setSourceExchangerName(resource.getSourceExchangerName());
            logBiz.AppendMonitorLog(log);
        } catch (Exception e) {
            logger.error("记录审核监控日志失败", e);
        }
    }

    public void AppendCancelMonitorLog(CancelResourceRequestVo vo, UserInfoPO user) {

        try {
            Integer resourceId = vo.getResourceId();
            ResourcePO resource = resourcePOMapper.selectByPrimaryKey(resourceId);
            Date date = new Date();
            AppendMonitorLogVo log = new AppendMonitorLogVo();
            log.setOperator(user.getUseraccount());
            log.setOperatorName(user.getRealname());
            log.setOperatorTime(date);
            log.setOperatorType(OperatorTypeEnum.CANCEL);
            log.setRemark("撤销");
            log.setResourceCode(resource.getCode());
            log.setResourceId(String.valueOf(resource.getId()));
            log.setResourceName(resource.getName());
            log.setSourceExchangerCode(resource.getSourceExchangerCode());
            log.setSourceExchangerName(resource.getSourceExchangerName());
            logBiz.AppendMonitorLog(log);
        } catch (Exception e) {
            logger.error("记录撤销监控日志失败", e);
        }
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

    public Map<String, Object> getDetail(DetailQueryVo queryVo) {

        String dataSetCode = queryVo.getDataSetCode();
        String resourceCode = queryVo.getResourceCode();
        Map<String, Object> map = new HashMap<>();

        DataSetContainer container = this.getDataSetContainerByCode(dataSetCode);

        Page page = this.startPage(queryVo);
        IBaseQbBiz qbBiz = (IBaseQbBiz) context.getBean(container.getQbBizName());
        PageInfo pageData = new PageInfo<>(qbBiz.getListByBatchNO(resourceCode));
        map.put("rows", pageData.getList());
        map.put("total", page.getTotal());
        return map;
    }

    public Map<String, Object> getList(QueryVo queryVo) {
        Map<String, Object> map = new HashMap<>();
        String dataSetCode = queryVo.getTableName();
        DataSetContainer container = this.getDataSetContainerByCode(dataSetCode);
        Page page = this.startPage(queryVo);
        IBaseQbBiz qbBiz = (IBaseQbBiz) context.getBean(container.getQbBizName());
        PageInfo pageData = new PageInfo<>(qbBiz.getList(queryVo));
        if (pageData != null) {
            map.put("rows", pageData.getList());
            map.put("total", page.getTotal());
        } else {
            map.put("rows", new ArrayList<>());
            map.put("total", 0);
        }
        return map;
    }


    public List<ColumnsVo> getColumnsByDataSetCode(String dataSetCode) {
        DataSetContainer container = this.getDataSetContainerByCode(dataSetCode);
        IBaseQbBiz qbBiz = (IBaseQbBiz) context.getBean(container.getQbBizName());
        return qbBiz.getColumns();

    }

    private DataSetContainer getDataSetContainerByCode(String dataSetCode) {
        return containerList.stream().filter(m -> m.getDateSetCode().equals(dataSetCode)).findFirst().get();
    }

    private void setContainerList(String dateSetCode, String qbBizName) {
        DataSetContainer container = new DataSetContainer();
        container.setDateSetCode(dateSetCode);
        container.setQbBizName(qbBizName);
        containerList.add(container);
    }

    /**
     * 获取记录经纬度坐标
     *
     * @param queryVo
     * @return
     */
    public List<LocationDto> getLocations(QueryVo queryVo) {
        String dataSetCode = queryVo.getTableName();
        DataSetContainer container = this.getDataSetContainerByCode(dataSetCode);
        //this.startPage(queryVo);
        IBaseQbBiz qbBiz = (IBaseQbBiz) context.getBean(container.getQbBizName());
        List<LocationDto> list = qbBiz.getLocations(queryVo);
        if (!CollectionUtils.isEmpty(list) && list.size() > 1 && queryVo.getCgqbh() != null) {
            BigDecimal maxJd = null;
            BigDecimal maxWd = null;
            BigDecimal minJd = null;
            BigDecimal minWd = null;

            for (int i = 0; i < list.size(); i++) {
                LocationDto dto = list.get(i);
                dto.setLabel("目标");
                if (dto.getJd() == null || dto.getWd() == null) {
                    continue;
                }
                if (i == 0) {
                    maxJd = dto.getJd();
                    minJd = dto.getJd();
                    maxWd = dto.getWd();
                    minWd = dto.getWd();
                } else {
                    if (maxJd.compareTo(dto.getJd()) == -1) {
                        maxJd = dto.getJd();
                    }
                    if (minJd.compareTo(dto.getJd()) == 1) {
                        minJd = dto.getJd();
                    }
                    if (maxWd.compareTo(dto.getWd()) == -1) {
                        maxWd = dto.getWd();
                    }
                    if (minWd.compareTo(dto.getWd()) == 1) {
                        minWd = dto.getWd();
                    }
                }
            }
            if (maxJd != null && maxWd != null && !maxJd.equals(minJd) &&
                    maxWd != null && minWd != null && !maxWd.equals(minWd)) {
                BigDecimal cgqJd = maxJd.add(minJd).divide(BigDecimal.valueOf(2), 6, BigDecimal.ROUND_HALF_UP);
                BigDecimal cgqWd = maxWd.add(minWd).divide(BigDecimal.valueOf(2), 6, BigDecimal.ROUND_HALF_UP);
                LocationDto cgq = new LocationDto();
                cgq.setLabel("传感器");
                cgq.setJd(cgqJd);
                cgq.setWd(cgqWd);
                cgq.setCgq(true);
                list.add(cgq);
            }
        }
        return list;
    }
}
