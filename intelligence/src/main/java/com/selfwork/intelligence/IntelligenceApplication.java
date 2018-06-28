package com.selfwork.intelligence;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

@SpringBootApplication
@EnableScheduling
@ServletComponentScan //用于filter扫描
@MapperScan("com.selfwork.intelligence.mapper")//将项目中对应的mapper类的路径加进来就可以了
public class IntelligenceApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {

        SpringApplication.run(IntelligenceApplication.class, args);
    }

    @Bean
    public TaskScheduler taskScheduler(){
        ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
        taskScheduler.setPoolSize(11);
        taskScheduler.setThreadNamePrefix("data-sync-task");
        return taskScheduler;
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(IntelligenceApplication.class);
    }

}
