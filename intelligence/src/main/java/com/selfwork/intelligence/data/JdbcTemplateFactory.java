package com.selfwork.intelligence.data;

import com.selfwork.intelligence.model.bo.DateSourceConfig;
import com.selfwork.intelligence.model.po.ExchangerPO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/**
 * Created by zzc on 2018/4/25.
 */
public abstract class JdbcTemplateFactory {

    public abstract JdbcTemplate createJdbcTemplate(DateSourceConfig config);

}
