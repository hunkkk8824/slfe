package com.selfwork.intelligence.config;

import com.selfwork.intelligence.interceptor.ErrorPageInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class WebAppConfigurer  extends WebMvcConfigurationSupport {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 多个拦截器组成一个拦截器链
        registry.addInterceptor(new ErrorPageInterceptor()).addPathPatterns("/**").excludePathPatterns("/errorpage/**");
        super.addInterceptors(registry);
    }

    /**
     * 配置静态访问资源
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/errorpage/**").addResourceLocations("classpath:/templates/errorpage/");
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        super.addResourceHandlers(registry);
    }
}
