package com.selfwork.intelligence.biz;

import com.selfwork.intelligence.common.BeanUtils;
import com.selfwork.intelligence.data.MysqlJdbcTemplateFactory;
import com.selfwork.intelligence.model.bo.DateSourceConfig;
import com.selfwork.intelligence.model.po.ExchangerPO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

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
}
