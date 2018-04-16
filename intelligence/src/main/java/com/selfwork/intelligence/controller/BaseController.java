package com.selfwork.intelligence.controller;

import com.selfwork.intelligence.model.po.UserInfoPO;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

public class BaseController {

    public UserInfoPO getLoginUser() {
        return (UserInfoPO) SecurityUtils.getSubject().getPrincipal();
    }

}
