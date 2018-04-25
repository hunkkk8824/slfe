package com.selfwork.intelligence.biz;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.selfwork.intelligence.common.BeanUtils;
import com.selfwork.intelligence.common.Constant;
import com.selfwork.intelligence.common.DateUtils;
import com.selfwork.intelligence.common.enums.AuditStatusEnum;
import com.selfwork.intelligence.common.enums.ImportStatusEnum;
import com.selfwork.intelligence.common.enums.OperatorTypeEnum;
import com.selfwork.intelligence.common.enums.QualityEvaluateEnum;
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
import com.selfwork.intelligence.model.vo.monitorlog.AppendMonitorLogVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;

@Service
public class DataQualityBiz extends BaseBiz {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private static Map<String, List<ColumnsVo>> columnsMap = new HashMap<>();

    public DataQualityBiz() {
        columnsMap.put(Constant.QbSjDptdzzmb, new ArrayList<>());
        columnsMap.put(Constant.QbSjDptssmb, new ArrayList<>());
        columnsMap.put(Constant.QbSjJztsmb, new ArrayList<>());
        columnsMap.put(Constant.QbSjMyb, new ArrayList<>());
        columnsMap.put(Constant.QbSjRgmb, new ArrayList<>());
        columnsMap.put(Constant.QbSjRhmb, new ArrayList<>());
        columnsMap.put(Constant.QbSjYsdzzdzzcmb, new ArrayList<>());
        columnsMap.put(Constant.QbSjYsdzzjgmb, new ArrayList<>());
        columnsMap.put(Constant.QbSjYsdzztmmb, new ArrayList<>());
        columnsMap.put(Constant.QbSjYsmb, new ArrayList<>());
        columnsMap.put(Constant.ScoutQbTableBd, new ArrayList<>());
    }

    @Autowired
    private ResourcePOMapper resourcePOMapper;

    @Autowired
    private ResourceEtlLogPOMapper resourceEtlLogPOMapper;


    @Autowired
    private QbSjDptdzzmbPOMapper qbSjDptdzzmb;
    @Autowired
    private QbSjDptssmbPOMapper qbSjDptssmb;
    @Autowired
    private QbSjJztsmbPOMapper qbSjJztsmb;
    @Autowired
    private QbSjMybPOMapper qbSjMyb;
    @Autowired
    private QbSjRgmbPOMapper qbSjRgmb;
    @Autowired
    private QbSjRhmbPOMapper qbSjRhmb;
    @Autowired
    private QbSjYsdzzdzzcmbPOMapper qbSjYsdzzdzzcmb;
    @Autowired
    private QbSjYsdzzjgmbPOMapper qbSjYsdzzjgmb;
    @Autowired
    private QbSjYsdzztmmbPOMapper qbSjYsdzztmmb;
    @Autowired
    private QbSjYsmbPOMapper qbSjYsmb;
    @Autowired
    private ScoutQbTableBdPOMapper scoutQbTableBd;

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
        this.startPage(queryVo);

        if (Constant.ScoutQbTableBd.equalsIgnoreCase(dataSetCode)) {
            PageInfo<ScoutQbTableBdPO> pageData = new PageInfo<>(scoutQbTableBd.getListByBatchNO(resourceCode));
            map.put("rows", pageData.getList());
            map.put("total", pageData.getTotal());
            map.put("columns", columnsMap.get(Constant.ScoutQbTableBd));
        } else if (Constant.QbSjYsmb.equalsIgnoreCase(dataSetCode)) {
            PageInfo<QbSjYsmbPO> pageData = new PageInfo<>(qbSjYsmb.getListByBatchNO(resourceCode));
            map.put("rows", pageData.getList());
            map.put("total", pageData.getTotal());
            map.put("columns", columnsMap.get(Constant.QbSjYsmb));
        } else if (Constant.QbSjYsdzztmmb.equalsIgnoreCase(dataSetCode)) {
            PageInfo<QbSjYsdzztmmbPO> pageData = new PageInfo<>(qbSjYsdzztmmb.getListByBatchNO(resourceCode));
            map.put("rows", pageData.getList());
            map.put("total", pageData.getTotal());
            map.put("columns", columnsMap.get(Constant.QbSjYsdzztmmb));
        } else if (Constant.QbSjYsdzzjgmb.equalsIgnoreCase(dataSetCode)) {
            PageInfo<QbSjYsdzzjgmbPO> pageData = new PageInfo<>(qbSjYsdzzjgmb.getListByBatchNO(resourceCode));
            map.put("rows", pageData.getList());
            map.put("total", pageData.getTotal());
            map.put("columns", columnsMap.get(Constant.QbSjYsdzzjgmb));
        } else if (Constant.QbSjYsdzzdzzcmb.equalsIgnoreCase(dataSetCode)) {
            PageInfo<QbSjYsdzzdzzcmbPOWithBLOBs> pageData = new PageInfo<>(qbSjYsdzzdzzcmb.getListByBatchNO(resourceCode));
            map.put("rows", pageData.getList());
            map.put("total", pageData.getTotal());
            map.put("columns", columnsMap.get(Constant.QbSjYsdzzdzzcmb));
        } else if (Constant.QbSjRhmb.equalsIgnoreCase(dataSetCode)) {
            PageInfo<QbSjRhmbPO> pageData = new PageInfo<>(qbSjRhmb.getListByBatchNO(resourceCode));
            map.put("rows", pageData.getList());
            map.put("total", pageData.getTotal());
            map.put("columns", columnsMap.get(Constant.QbSjRhmb));
        } else if (Constant.QbSjRgmb.equalsIgnoreCase(dataSetCode)) {
            PageInfo<QbSjRgmbPO> pageData = new PageInfo<>(qbSjRgmb.getListByBatchNO(resourceCode));
            map.put("rows", pageData.getList());
            map.put("total", pageData.getTotal());
            map.put("columns", columnsMap.get(Constant.QbSjRgmb));
        } else if (Constant.QbSjMyb.equalsIgnoreCase(dataSetCode)) {
            PageInfo<QbSjMybPO> pageData = new PageInfo<>(qbSjMyb.getListByBatchNO(resourceCode));
            map.put("rows", pageData.getList());
            map.put("total", pageData.getTotal());
            map.put("columns", columnsMap.get(Constant.QbSjMyb));
        } else if (Constant.QbSjJztsmb.equalsIgnoreCase(dataSetCode)) {
            PageInfo<QbSjJztsmbPO> pageData = new PageInfo<>(qbSjJztsmb.getListByBatchNO(resourceCode));
            map.put("rows", pageData.getList());
            map.put("total", pageData.getTotal());
            map.put("columns", columnsMap.get(Constant.QbSjJztsmb));
        } else if (Constant.QbSjDptssmb.equalsIgnoreCase(dataSetCode)) {
            PageInfo<QbSjDptssmbPO> pageData = new PageInfo<>(qbSjDptssmb.getListByBatchNO(resourceCode));
            map.put("rows", pageData.getList());
            map.put("total", pageData.getTotal());
            map.put("columns", columnsMap.get(Constant.QbSjDptssmb));
        } else if (Constant.QbSjDptdzzmb.equalsIgnoreCase(dataSetCode)) {
            PageInfo<QbSjDptdzzmbPOWithBLOBs> pageData = new PageInfo<>(qbSjDptdzzmb.getListByBatchNO(resourceCode));
            map.put("rows", pageData.getList());
            map.put("total", pageData.getTotal());
            map.put("columns", columnsMap.get(Constant.QbSjDptdzzmb));
        }

        return map;

    }


}
