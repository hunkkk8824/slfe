package com.selfwork.intelligence.biz;

import com.selfwork.intelligence.biz.dataset.QbSjRhmbBiz;
import com.selfwork.intelligence.common.Constant;
import com.selfwork.intelligence.common.DateUtils;
import com.selfwork.intelligence.common.enums.ImportStatusEnum;
import com.selfwork.intelligence.common.enums.QualityEvaluateEnum;
import com.selfwork.intelligence.mapper.ResourcePOMapper;
import com.selfwork.intelligence.model.po.ExchangerPO;
import com.selfwork.intelligence.model.po.QbSjRhmbPO;
import com.selfwork.intelligence.model.po.ResourcePO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
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



    /**
     * 获取所有预入库状态resource
     * @return
     */
    public List<ResourcePO> findPrepareResource() {
        return resourcePOMapper.findPrepareResource();
    }

    /**
     * 资源同步
     * @param resource
     */
//    @Transactional
    public void sycnResource(ResourcePO resource) {
        logger.info("开始同步资源,resourceId：" + resource.getId());
        StringBuilder log = new StringBuilder();
        log.append(DateUtils.getCurrTimeStr()).append(" 开始同步资源").append("/r/n");
        try{
            // 修改resource状态为执行中
            resource.setImportStatus(ImportStatusEnum.IMPORTING.getValue().shortValue());
            resourcePOMapper.updateByPrimaryKey(resource);
            // 获取交换机信息
            ExchangerPO exchangePo = exChangeConfigBiz.findByCode(resource.getSourceExchangerCode());

            if(exchangePo == null){
                log.append(DateUtils.getCurrTimeStr()).append(" 配置交换机信息未找到").append("/r/n");
                logger.error("resource 配置交换机信息未找到");
                return ;
            }
            // 创建模板
            JdbcTemplate jdbcTemplate = dataBiz.getJdbcTemplate(exchangePo);

            String datasetCode = resource.getDatasetCode();
            String batchNo = resource.getCode();
            // 获取所有同步数据
            List<Object> list = dataBiz.getDataList(jdbcTemplate,datasetCode);
            Integer total = 0;

            // 无同步数据，resource 状态刷为同步成功，预导入总数：0 成功总数：0
            if(CollectionUtils.isEmpty(list)){
                logger.info("暂无同步数据",resource);
                log.append(DateUtils.getCurrTimeStr()).append(" 暂无同步数据").append("/r/n");
                this.updateResourceSuccess(resource,datasetCode,batchNo,total,log);
                return;
            }
            total = list.size();

            // 数据验证
            // TODO: 2018/5/1

            // 数据写入
            boolean insert = this.insertData(datasetCode,list,batchNo,log);

            if(insert){
                // 批次号写入同步数据
                dataBiz.writeBatchNoBack(jdbcTemplate,datasetCode,batchNo);

                // 更新resource
                this.updateResourceSuccess(resource,datasetCode,batchNo,total,log);
            }
        }catch (Exception e){
            logger.error("数据同步失败",e);
            log.append(DateUtils.getCurrTimeStr()).append(" 数据同步失败").append("/r/n");
            resource.setImportStatus(ImportStatusEnum.Excellent.getValue().shortValue());
            resourcePOMapper.updateByPrimaryKey(resource);
        }
        log.append(DateUtils.getCurrTimeStr()).append(" 同步结束");
        logger.info(log.toString());
        resourceEtlLogBiz.asynSave(resource.getId(),log.toString());
    }

    /**
     * 同步完成，更新resource状态
     * @param datasetCode
     * @param batchNo
     */
    private void updateResourceSuccess(ResourcePO resource,String datasetCode, String batchNo,Integer total,StringBuilder log) {
        // 查询该批次插入数据
        Integer count = resourcePOMapper.countByBatchNo(datasetCode,batchNo);
        Integer qualityLevel = this.getQualityLevel(count,total);
        resource.setPreimportTotalCount(total);
        resource.setImportSuccessCount(count);
        resource.setImportStatus(ImportStatusEnum.Good.getValue().shortValue());
        resource.setQuality(qualityLevel.shortValue());
        resourcePOMapper.updateByPrimaryKey(resource);

        String result = " 预导入数据" + total + "条,导入成功" + count + "条！";
        log.append(DateUtils.getCurrTimeStr()).append(result).append("/r/n");
    }

    /**
     * 评定级别0 未评定，1 差（0-60） ，2 良 （60-90），3 优 （90+）,
     * @param count
     * @param total
     * @return
     */
    private Integer getQualityLevel(Integer count, Integer total) {
        if(total == 0){
            return QualityEvaluateEnum.UnAssessed.getValue();
        }

        Double d = Double.valueOf(count)/Double.valueOf(total);

        if(d >= 0 && d < 0.6){
            return QualityEvaluateEnum.Difference.getValue();
        }else if(d >= 0.6 && d < 0.8){
            return QualityEvaluateEnum.Good.getValue();
        }else {
            return QualityEvaluateEnum.Excellent.getValue();
        }
    }


    /**
     * 数据写入
     * @param datasetCode
     * @param list
     */
    private boolean insertData(String datasetCode, List<Object> list,String batchNo,StringBuilder log) {
        boolean result = false;
        try{
            log.append(DateUtils.getCurrTimeStr()).append(" 开始写入数据").append("/r/n");
            if(Constant.QbSjRhmb.equals(datasetCode)){
                List<QbSjRhmbPO> myList = list.stream().parallel().map(obj -> {
                    QbSjRhmbPO o = (QbSjRhmbPO)obj;
                    o.setBatchNo(batchNo);
                    return o;
                }).collect(Collectors.toList());
                result = qbSjRhmbBiz.batchInsert(myList);
            }else {
                result = false;
            }
        }catch (Exception e){
            logger.error("写入数据失败",e);
            result = false;
        }
        if(result){
            log.append(DateUtils.getCurrTimeStr()).append(" 写入数据成功").append("/r/n");
        }else{
            log.append(DateUtils.getCurrTimeStr()).append(" 写入数据失败").append("/r/n");
        }
        return result;
    }
}
