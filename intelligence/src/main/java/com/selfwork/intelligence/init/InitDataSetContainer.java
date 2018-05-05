package com.selfwork.intelligence.init;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

public class InitDataSetContainer implements InitializingBean {

    private static Logger logger = LoggerFactory.getLogger(InitDataSetContainer.class);

    @Override
    public void afterPropertiesSet() throws Exception {

    }
}
