package com.selfwork.intelligence.task;

import com.selfwork.intelligence.biz.ResourceBiz;
import com.selfwork.intelligence.model.po.ResourcePO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by zzc on 2018/4/27.
 */
@Component
public class Task {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    private ExecutorService executorService = Executors.newCachedThreadPool();

    @Autowired
    private ResourceBiz resourceBiz;

    @Scheduled(cron = "0 */1 * * * ?")
    public void syncResourceTask(){
        logger.info("========同步定时任务开始=========");
        // 查询resouce
        List<ResourcePO> resourcePOList = resourceBiz.findPrepareResource();

        if(CollectionUtils.isEmpty(resourcePOList)){
            logger.info("========暂无同步资源=========");
            return;
        }

        logger.info("========同步定时任务,size:" + resourcePOList.size());

        resourcePOList.forEach(resource -> {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    resourceBiz.sycnResource(resource);
                }
            });
        });

    }
}
