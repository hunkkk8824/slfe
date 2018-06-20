package com.selfwork.intelligence.biz;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.selfwork.intelligence.biz.dataset.*;
import com.selfwork.intelligence.common.Constant;
import com.selfwork.intelligence.common.DateUtils;
import com.selfwork.intelligence.common.enums.AuditStatusEnum;
import com.selfwork.intelligence.common.enums.DataSetCodeEnum;
import com.selfwork.intelligence.common.enums.ImportStatusEnum;
import com.selfwork.intelligence.common.enums.QualityEvaluateEnum;
import com.selfwork.intelligence.config.ValidateHandler;
import com.selfwork.intelligence.mapper.ResourcePOMapper;
import com.selfwork.intelligence.model.*;
import com.selfwork.intelligence.model.QbSjDptdzzmbPOWithBLOBs;
import com.selfwork.intelligence.model.QbSjDptssmbPO;
import com.selfwork.intelligence.model.QbSjJztsmbPO;
import com.selfwork.intelligence.model.QbSjMybPO;
import com.selfwork.intelligence.model.QbSjRgmbPO;
import com.selfwork.intelligence.model.bo.ValidateResult;
import com.selfwork.intelligence.model.po.*;
import com.selfwork.intelligence.model.vo.BaseResultVo;
import com.selfwork.intelligence.model.vo.dataquality.QuantityQueryVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by zzc on 2018/4/30.
 */
@Service
public class ResourceBiz extends BaseBiz {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ResourcePOMapper resourcePOMapper;

    @Autowired
    private ExChangeConfigBiz exChangeConfigBiz;

    @Autowired
    private DataBiz dataBiz;

    @Autowired
    private ResourceEtlLogBiz resourceEtlLogBiz;

    @Autowired
    private QbSjRhmbBiz qbSjRhmbBiz;

    @Autowired
    private ScoutQbTableBdBiz scoutQbTableBdBiz;

    @Autowired
    private QbSjYsmbBiz qbSjYsmbBiz;

    @Autowired
    private QbSjYsdzztmmbBiz qbSjYsdzztmmbBiz;

    @Autowired
    private QbSjYsdzzjgmbBiz qbSjYsdzzjgmbBiz;

    @Autowired
    private QbSjYsdzzdzzcmbBiz qbSjYsdzzdzzcmbBiz;

    @Autowired
    private QbSjRgmbBiz qbSjRgmbBiz;

    @Autowired
    private QbSjMybBiz qbSjMybBiz;

    @Autowired
    private QbSjJztsmbBiz qbSjJztsmbBiz;

    @Autowired
    private QbSjDptssmbBiz qbSjDptssmbBiz;

    @Autowired
    private QbSjDptdzzmbBiz qbSjDptdzzmbBiz;

    @Autowired
    private ValidateHandler validateHandler;


    /**
     * 申请数据交换
     */
    public BaseResultVo applyDataExchange(ResourcePO po) {
        BaseResultVo resultVo = new BaseResultVo();
        resultVo.setSuccessful(true);
        //数据校验
        if (StringUtils.isEmpty(po.getSourceExchangerCode())) {
            resultVo.setSuccessful(false);
            resultVo.setErrorMsg("校验失败：前置机编码不允许为空");
        } else if (StringUtils.isEmpty(po.getDatasetCode())) {
            resultVo.setSuccessful(false);
            resultVo.setErrorMsg("校验失败：数据集不允许为空");
        } else if (StringUtils.isEmpty(po.getCommitUser())) {
            resultVo.setSuccessful(false);
            resultVo.setErrorMsg("校验失败：申请者不允许为空");
        }
        //校验失败
        if (!resultVo.isSuccessful()) {
            return resultVo;
        }

        try {
            //数据填充
            po.setCommitTime(new Date());
            po.setCreateTime(po.getCommitTime());
            po.setCreateUser(po.getCommitUser());
            po.setLastModifyTime(po.getCommitTime());
            po.setLastModifyUser(po.getCommitUser());

            po.setIsCancel(false);
            po.setValid(true);
            po.setImportStatus(ImportStatusEnum.Difference.getValue().shortValue());
            po.setAuditStatus(AuditStatusEnum.Unaudited.getValue().shortValue());
            //生成批次号
            po.setCode(buildResourceBatch(po));
            if(StringUtils.isEmpty(po.getName())){
                po.setName(po.getCode());
            }
            //插入数据
            resourcePOMapper.insert(po);
        } catch (Exception ex) {
            resultVo.setSuccessful(false);
            resultVo.setErrorMsg("申请入库失败：" + ex.getMessage());
            logger.error("申请入库异常", ex);
        }

        return resultVo;
    }

    /**
     * 生成批次号
     * @param po
     * @return
     */
    private String buildResourceBatch(ResourcePO po) {
        QuantityQueryVo queryVo = new QuantityQueryVo();
        queryVo.setDataSetCode(po.getDatasetCode());
        queryVo.setSourceExchangerCode(po.getSourceExchangerCode());

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = new Date();
        queryVo.setStartTime(formatter.format(startDate));

        Calendar calendar = new GregorianCalendar();
        calendar.setTime(startDate);
        calendar.add(calendar.DATE, 1);
        queryVo.setEndTime(formatter.format(calendar.getTime()));

        Integer count = resourcePOMapper.countByCondition(queryVo);
        formatter = new SimpleDateFormat("yyyyMMdd");
        return MessageFormat.format("{0}-{1}-{2}-{3}", po.getSourceExchangerCode(), po.getDatasetCode(), formatter.format(startDate), ++count);
    }

    /**
     * 获取所有预入库状态resource
     *
     * @return
     */
    public List<ResourcePO> findPrepareResource() {
        return resourcePOMapper.findPrepareResource();
    }

    /**
     * 资源同步
     *
     * @param resource
     */
//    @Transactional
    public void sycnResource(ResourcePO resource) {
        logger.info("开始同步资源,resourceId：" + resource.getId());
        StringBuilder log = new StringBuilder();
        log.append(DateUtils.getCurrTimeStrWithSSS()).append(" 开始同步资源").append("<br/>");
        try {
            // 修改resource状态为执行中
            resource.setImportStatus(ImportStatusEnum.IMPORTING.getValue().shortValue());
            resourcePOMapper.updateByPrimaryKey(resource);
            // 获取交换机信息
            ExchangerPO exchangePo = exChangeConfigBiz.findByCode(resource.getSourceExchangerCode());

            if (exchangePo == null) {
                logger.error("resource 配置交换机信息未找到");
                log.append(DateUtils.getCurrTimeStr()).append(" 配置交换机信息未找到").append("<br/>");
                resourceEtlLogBiz.asynSave(resource.getId(), log.toString());
                return;
            }
            // 创建模板
            JdbcTemplate jdbcTemplate = dataBiz.getJdbcTemplate(exchangePo);

            String datasetCode = resource.getDatasetCode();
            String batchNo = resource.getCode();
            // 获取所有同步数据
            List<Object> list = dataBiz.getDataList(jdbcTemplate, datasetCode);
            Integer total = 0;

            // 无同步数据，resource 状态刷为同步成功，预导入总数：0 成功总数：0
            if (CollectionUtils.isEmpty(list)) {
                logger.info("暂无同步数据", resource);
                log.append(DateUtils.getCurrTimeStrWithSSS()).append(" 暂无同步数据").append("<br/>");
                this.updateResourceSuccess(resource, datasetCode, batchNo, total, log);
                resourceEtlLogBiz.asynSave(resource.getId(), log.toString());
                return;
            }
            total = list.size();

            // 数据验证
            List<Object> validList = this.validateList(datasetCode, list, log);

            // 数据写入
            boolean insert = this.insertData(datasetCode, validList, batchNo, log);

            if (insert) {
                // 批次号写入同步数据
                dataBiz.writeBatchNoBack(jdbcTemplate, datasetCode, batchNo);

                // 更新resource
                this.updateResourceSuccess(resource, datasetCode, batchNo, total, log);
            }
        } catch (Exception e) {
            logger.error("数据同步失败", e);
            log.append(DateUtils.getCurrTimeStrWithSSS()).append(" 数据同步失败").append("<br/>");
            resource.setImportStatus(ImportStatusEnum.Excellent.getValue().shortValue());
            resourcePOMapper.updateByPrimaryKey(resource);
        }
        log.append(DateUtils.getCurrTimeStrWithSSS()).append(" 同步完成");
        logger.info(log.toString());
        resourceEtlLogBiz.asynSave(resource.getId(), log.toString());
    }

    /**
     * 数据验证
     *
     * @param list
     * @param log
     * @return
     */
    private List<Object> validateList(String datasetCode, List<Object> list, StringBuilder log) {
        log.append(DateUtils.getCurrTimeStrWithSSS()).append(" 数据验证开始").append("<br/>");
        List<Object> result = new ArrayList<>();
        for (Object obj : list) {
            JSONObject jsonObject = JSONObject.parseObject(JSON.toJSONString(obj));
            ValidateResult validateResult = validateHandler.validate(datasetCode, jsonObject);
            if (validateResult.isPass()) {
                result.add(obj);
            } else {
                String id = jsonObject.getString("id");
                log.append(DateUtils.getCurrTimeStrWithSSS()).append(" ID[" + id + "],").append(validateResult.getMessage()).append("<br/>");
            }
        }
        log.append(DateUtils.getCurrTimeStrWithSSS()).append(" 数据验证完成").append("<br/>");
        return result;
    }

    /**
     * 同步完成，更新resource状态
     *
     * @param datasetCode
     * @param batchNo
     */
    private void updateResourceSuccess(ResourcePO resource, String datasetCode, String batchNo, Integer total, StringBuilder log) {
        // 查询该批次插入数据
        Integer count = resourcePOMapper.countByBatchNo(datasetCode, batchNo);
        Integer qualityLevel = this.getQualityLevel(count, total);
        resource.setPreimportTotalCount(total);
        resource.setImportSuccessCount(count);
        resource.setImportStatus(ImportStatusEnum.Good.getValue().shortValue());
        resource.setQuality(qualityLevel.shortValue());
        resourcePOMapper.updateByPrimaryKey(resource);

        String result = " 预导入数据" + total + "条,导入成功" + count + "条！";
        log.append(DateUtils.getCurrTimeStr()).append(result).append("<br/>");
    }

    /**
     * 评定级别0 未评定，1 差（0-60） ，2 良 （60-90），3 优 （90+）,
     *
     * @param count
     * @param total
     * @return
     */
    private Integer getQualityLevel(Integer count, Integer total) {
        if (total == 0) {
            return QualityEvaluateEnum.UnAssessed.getValue();
        }

        Double d = Double.valueOf(count) / Double.valueOf(total);

        if (d >= 0 && d < 0.6) {
            return QualityEvaluateEnum.Difference.getValue();
        } else if (d >= 0.6 && d < 0.8) {
            return QualityEvaluateEnum.Good.getValue();
        } else {
            return QualityEvaluateEnum.Excellent.getValue();
        }
    }


    /**
     * 数据写入
     *
     * @param datasetCode
     * @param list
     */
    private boolean insertData(String datasetCode, List<Object> list, String batchNo, StringBuilder log) {
        boolean result = false;
        try {
            log.append(DateUtils.getCurrTimeStrWithSSS()).append(" 开始写入数据").append("<br/>");
            if (DataSetCodeEnum.QB_SJ_RHMB.getValue().equals(datasetCode)) {
                List<QbSjRhmbPO> myList = list.stream().parallel().map(obj -> {
                    QbSjRhmbPO o = (QbSjRhmbPO) obj;
                    o.setBatchNo(batchNo);
                    return o;
                }).collect(Collectors.toList());
                result = qbSjRhmbBiz.batchInsert(myList);
            }else if (DataSetCodeEnum.SCOUT_QB_TABLE_BD.getValue().equals(datasetCode)) {
                List<ScoutQbTableBdPO> myList = list.stream().parallel().map(obj -> {
                    ScoutQbTableBdPO o = (ScoutQbTableBdPO) obj;
                    o.setBatchNo(batchNo);
                    return o;
                }).collect(Collectors.toList());
                result = scoutQbTableBdBiz.batchInsert(myList);
            }else if (DataSetCodeEnum.QB_SJ_YSMB.getValue().equals(datasetCode)) {
                List<QbSjYsmbPO> myList = list.stream().parallel().map(obj -> {
                    QbSjYsmbPO o = (QbSjYsmbPO) obj;
                    o.setBatchNo(batchNo);
                    return o;
                }).collect(Collectors.toList());
                result = qbSjYsmbBiz.batchInsert(myList);
            }else if (DataSetCodeEnum.QB_SJ_YSDZZTMMB.getValue().equals(datasetCode)) {
                List<QbSjYsdzztmmbPO> myList = list.stream().parallel().map(obj -> {
                    QbSjYsdzztmmbPO o = (QbSjYsdzztmmbPO) obj;
                    o.setBatchNo(batchNo);
                    return o;
                }).collect(Collectors.toList());
                result = qbSjYsdzztmmbBiz.batchInsert(myList);
            } else if (DataSetCodeEnum.QB_SJ_YSDZZJGMB.getValue().equals(datasetCode)) {
                List<QbSjYsdzzjgmbPO> myList = list.stream().parallel().map(obj -> {
                    QbSjYsdzzjgmbPO o = (QbSjYsdzzjgmbPO) obj;
                    o.setBatchNo(batchNo);
                    return o;
                }).collect(Collectors.toList());
                result = qbSjYsdzzjgmbBiz.batchInsert(myList);
            } else if (DataSetCodeEnum.QB_SJ_YSDZZDZZCMB.getValue().equals(datasetCode)) {
                List<QbSjYsdzzdzzcmbPOWithBLOBs> myList = list.stream().parallel().map(obj -> {
                    QbSjYsdzzdzzcmbPOWithBLOBs o = (QbSjYsdzzdzzcmbPOWithBLOBs) obj;
                    o.setBatchNo(batchNo);
                    return o;
                }).collect(Collectors.toList());
                result = qbSjYsdzzdzzcmbBiz.batchInsert(myList);
            } else if (DataSetCodeEnum.QB_SJ_RGMB.getValue().equals(datasetCode)) {
                List<QbSjRgmbPO> myList = list.stream().parallel().map(obj -> {
                    QbSjRgmbPO o = (QbSjRgmbPO) obj;
                    o.setBatchNo(batchNo);
                    return o;
                }).collect(Collectors.toList());
                result = qbSjRgmbBiz.batchInsert(myList);
            } else if (DataSetCodeEnum.QB_SJ_MYB.getValue().equals(datasetCode)) {
                List<QbSjMybPO> myList = list.stream().parallel().map(obj -> {
                    QbSjMybPO o = (QbSjMybPO) obj;
                    o.setBatchNo(batchNo);
                    return o;
                }).collect(Collectors.toList());
                result = qbSjMybBiz.batchInsert(myList);
            }else if (DataSetCodeEnum.QB_SJ_JZTSMB.getValue().equals(datasetCode)) {
                List<QbSjJztsmbPO> myList = list.stream().parallel().map(obj -> {
                    QbSjJztsmbPO o = (QbSjJztsmbPO) obj;
                    o.setBatchNo(batchNo);
                    return o;
                }).collect(Collectors.toList());
                result = qbSjJztsmbBiz.batchInsert(myList);
            }else if (DataSetCodeEnum.QB_SJ_DPTSSMB.getValue().equals(datasetCode)) {
                List<QbSjDptssmbPO> myList = list.stream().parallel().map(obj -> {
                    QbSjDptssmbPO o = (QbSjDptssmbPO) obj;
                    o.setBatchNo(batchNo);
                    return o;
                }).collect(Collectors.toList());
                result = qbSjDptssmbBiz.batchInsert(myList);
            } else if (DataSetCodeEnum.QB_SJ_DPTDZZMB.getValue().equals(datasetCode)) {
                List<QbSjDptdzzmbPOWithBLOBs> myList = list.stream().parallel().map(obj -> {
                    QbSjDptdzzmbPOWithBLOBs o = (QbSjDptdzzmbPOWithBLOBs) obj;
                    o.setBatchNo(batchNo);
                    return o;
                }).collect(Collectors.toList());
                result = qbSjDptdzzmbBiz.batchInsert(myList);
            }  else {
                result = false;
            }
        } catch (Exception e) {
            logger.error("写入数据失败", e);
            log.append(DateUtils.getCurrTimeStrWithSSS()).append(" 写入数据失败").append("<br/>");
            result = false;
        }
        if (result) {
            log.append(DateUtils.getCurrTimeStrWithSSS()).append(" 写入数据成功").append("<br/>");
        } else {
            log.append(DateUtils.getCurrTimeStrWithSSS()).append(" 写入数据失败").append("<br/>");
        }
        return result;
    }
}
