package com.selfwork.intelligence.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

//@Order(1) //执行顺序(数字越小先越先执行)
//@Component
//@WebFilter(urlPatterns = "/login/*",filterName = "loginFilter")
//public class LoginFilter implements Filter {
//
//    private static final Logger logger = LoggerFactory.getLogger(LoginFilter.class);
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//
//    }
//
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//
//    }
//
//    @Override
//    public void destroy() {
//
//    }
//}