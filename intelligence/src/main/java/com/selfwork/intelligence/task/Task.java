package com.selfwork.intelligence.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by zzc on 2018/4/27.
 */
@Component
public class Task {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Scheduled(cron = "0/1 * * * * ?")
    public void task01(){
        System.out.println(Thread.currentThread().getName() + "----task01");
    }

    @Scheduled(cron = "0/1 * * * * ?")
    public void task02(){
        System.out.println(Thread.currentThread().getName() + "----task02");
    }

    @Scheduled(cron = "0/1 * * * * ?")
    public void task03(){
        System.out.println(Thread.currentThread().getName() + "----task03");
    }
}
