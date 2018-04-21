package com.selfwork.intelligence.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 数据质量管理
 * **/
@Controller
@RequestMapping(value = "/dataQuality")
public class DataQualityController extends BaseController {

    public final Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping(value = "/index")
    public ModelAndView index() {

        ModelAndView view = new ModelAndView("sub/dataQuality/index");
        return view;

    }
}
