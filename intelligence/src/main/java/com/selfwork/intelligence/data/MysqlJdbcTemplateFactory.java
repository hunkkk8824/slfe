package com.selfwork.intelligence.data;

import com.alibaba.druid.pool.DruidDataSource;
import com.selfwork.intelligence.model.bo.DateSourceConfig;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

/**
 * Created by zzc on 2018/4/25.
 */
@Component
public class MysqlJdbcTemplateFactory extends JdbcTemplateFactory {

    @Override
    public JdbcTemplate createJdbcTemplate(DateSourceConfig config) {
        DruidDataSource dataSource = initDataSource(config);
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        return jdbcTemplate;
    }

    private DruidDataSource initDataSource(DateSourceConfig config){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://"+ config.getHost()+":"+ config.getPort()+"/"+ config.getDataName()+"?characterEncoding=utf-8");
        dataSource.setUsername(config.getUserName());
        dataSource.setPassword(config.getPassword());
        return dataSource;
    }

}
