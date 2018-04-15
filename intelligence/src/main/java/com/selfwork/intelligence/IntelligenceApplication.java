package com.selfwork.intelligence;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan //用于filter扫描
@MapperScan("com.selfwork.intelligence.mapper")//将项目中对应的mapper类的路径加进来就可以了
public class IntelligenceApplication {

    public static void main(String[] args) {

        SpringApplication.run(IntelligenceApplication.class, args);
    }
}
