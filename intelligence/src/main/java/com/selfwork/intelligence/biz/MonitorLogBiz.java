package com.selfwork.intelligence.biz;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.selfwork.intelligence.common.BeanUtils;
import com.selfwork.intelligence.common.DateUtils;
import com.selfwork.intelligence.common.enums.OperatorTypeEnum;
import com.selfwork.intelligence.mapper.ResourceMonitorLogPOMapper;
import com.selfwork.intelligence.model.po.ResourceMonitorLogPO;
import com.selfwork.intelligence.model.vo.monitorlog.AppendMonitorLogVo;
import com.selfwork.intelligence.model.vo.monitorlog.MonitorLogQueryVo;
import com.selfwork.intelligence.model.vo.monitorlog.MonitorLogVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MonitorLogBiz extends BaseBiz {

    public final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ResourceMonitorLogPOMapper resourceMonitorLogPOMapper;

    public Map<String, Object> findPage(MonitorLogQueryVo queryVo) {

        Map<String, Object> result = new HashMap<>();
        result.put("total", 0);
        result.put("rows", new ArrayList());

        // 查询
        Page page = this.startPage(queryVo);
        List<ResourceMonitorLogPO> list = resourceMonitorLogPOMapper.findList(queryVo);
        if (null == list || list.size() == 0) {
            logger.error("获取监控日志分页信息失败");
            return result;
        }

        try {

            List<MonitorLogVo> res = BeanUtils.copyList(list, MonitorLogVo.class);

            if (CollectionUtils.isEmpty(res)) {
                logger.error("BeanUtils.copyList 返回为空");
                return result;
            }

            res.forEach(m -> {
                m.setOperatorTimeStr(DateUtils.getFormatDateTime(m.getOperatorTime()));
                m.setOperatorTypeStr(m.getOperatorType() == null ? "" : OperatorTypeEnum.getEnum(m.getOperatorType().intValue()).getDisplayName());
            });

            result.put("rows", res);
            result.put("total", page.getTotal());
        } catch (Exception e) {
            logger.error("数据转换错误", e);
        }

        return result;
    }

    /**
     * 添加监控日志
     *
     * @param logVo
     */
    public void AppendMonitorLog(AppendMonitorLogVo logVo) {
        try {
            if (logVo != null) {
                ResourceMonitorLogPO po = new ResourceMonitorLogPO();
                po.setResourceId(logVo.getResourceId());
                po.setResourceCode(logVo.getResourceCode());
                po.setResourceName(logVo.getResourceName());
                po.setSourceExchangerCode(logVo.getSourceExchangerCode());
                po.setSourceExchangerName(logVo.getSourceExchangerName());
                po.setOperator(logVo.getOperator());
                po.setOperatorType(logVo.getOperatorType().getValue().shortValue());
                po.setOperatorName(logVo.getOperatorName());
                po.setOperatorTime(logVo.getOperatorTime());
                po.setRemark(logVo.getRemark());

                resourceMonitorLogPOMapper.insert(po);
            }

        } catch (Exception ex) {
            logger.error("添加监控日志失败", ex);
        }
    }
}
