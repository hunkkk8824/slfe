package com.selfwork.intelligence.controller;


import com.github.pagehelper.PageInfo;

import com.selfwork.intelligence.biz.MonitorLogBiz;
import com.selfwork.intelligence.model.vo.monitorlog.MonitorLogQueryVo;
import com.selfwork.intelligence.model.vo.monitorlog.MonitorLogVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 监控日志管理
 **/
@Controller
@RequestMapping(value = "/monitorLog")
public class MonitorLogController extends BaseController {

    public final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private MonitorLogBiz monitorLogBiz;

    @RequestMapping(value = "/index")
    public ModelAndView index() {

        ModelAndView view = new ModelAndView("sub/monitorLog/index");
        return view;

    }

    @ResponseBody
    @RequestMapping(value = "/getList", method = RequestMethod.POST)
    public Map<String, Object> getList(@RequestBody MonitorLogQueryVo queryVo) {

        Map<String, Object> result = new HashMap<>();
        result.put("total", 0);
        result.put("rows", new ArrayList());
        try {
            PageInfo<MonitorLogVo> pageData =  monitorLogBiz.findPage(queryVo);
            if (pageData != null) {
                result.put("total", pageData.getTotal());
                result.put("rows", pageData.getList());
            }
        } catch (Exception e) {
            logger.error("获取监控日志信息异常 e:{}" + e.getMessage(), e);
        }
        return result;
    }
}
