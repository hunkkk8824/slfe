package com.selfwork.intelligence.biz;

import com.selfwork.intelligence.common.BaseException;
import com.selfwork.intelligence.common.BeanUtils;
import com.selfwork.intelligence.common.Constant;
import com.selfwork.intelligence.common.enums.DataSetCodeEnum;
import com.selfwork.intelligence.common.enums.ResponseCodeTypeEnum;
import com.selfwork.intelligence.data.MysqlJdbcTemplateFactory;
import com.selfwork.intelligence.model.QbSjDptdzzmbPO;
import com.selfwork.intelligence.model.bo.DateSourceConfig;
import com.selfwork.intelligence.model.po.ExchangerPO;
import com.selfwork.intelligence.model.po.QbSjRhmbPO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zzc on 2018/4/25.
 */
@Service
public class DataBiz {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private MysqlJdbcTemplateFactory jdbcTemplateFactory;

    public boolean testConnect(DateSourceConfig config){
        String sql = "select 1 from dual";
        JdbcTemplate jdbcTemplate = jdbcTemplateFactory.createJdbcTemplate(config);
        String result = jdbcTemplate.queryForObject(sql,String.class);
        if("1".equals(result)){
            return true;
        }
        return false;
    }


    /**
     * 连接测试
     * @param exchanger
     */
    public boolean test(ExchangerPO exchanger) {
        DateSourceConfig config = new DateSourceConfig();
        BeanUtils.copy(exchanger,config);
        return testConnect(config);
    }

    public JdbcTemplate getJdbcTemplate(ExchangerPO exchangePo) {
        DateSourceConfig config = new DateSourceConfig();
        BeanUtils.copy(exchangePo,config);
        return jdbcTemplateFactory.createJdbcTemplate(config);
    }

    /**
     * 获取数据
     * @param jdbcTemplate
     * @param datasetCode
     * @return
     */
    public List<Object> getDataList(JdbcTemplate jdbcTemplate, String datasetCode) {
        String sql = "select * from " + datasetCode + " where batch_no is null";
        BeanPropertyRowMapper beanpropertyRowMapper = this.getRowMapper(datasetCode);
        return jdbcTemplate.query(sql,beanpropertyRowMapper);
    }

    private BeanPropertyRowMapper getRowMapper(String datasetCode) {
        if(DataSetCodeEnum.QB_SJ_RHMB.getValue().equals(datasetCode)){
            return new BeanPropertyRowMapper<QbSjRhmbPO>(QbSjRhmbPO.class);
        }else {
            return new BeanPropertyRowMapper<QbSjDptdzzmbPO>(QbSjDptdzzmbPO.class);
        }
    }


    public void writeBatchNoBack(JdbcTemplate jdbcTemplate, String datasetCode, String batchNo) {
        String sql = "update " + datasetCode + " set BATCH_NO = ? where BATCH_NO is null";
        Object args[] = new Object[]{batchNo};
        int temp = jdbcTemplate.update(sql,args);
        if (temp > 0) {
            logger.info("更新成功");
        }else {
            logger.error("更新失败");
            throw new BaseException(ResponseCodeTypeEnum.DATABASE_EXCEPTION.getValue(),"更新失败");
        }
    }
}
