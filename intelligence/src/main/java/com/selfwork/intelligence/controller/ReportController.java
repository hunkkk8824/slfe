package com.selfwork.intelligence.controller;

import com.selfwork.intelligence.biz.DataQualityBiz;
import com.selfwork.intelligence.model.vo.BaseQueryVo;
import com.selfwork.intelligence.model.vo.dateset.QueryVo;
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
 * Created by zzc on 2018/6/10.
 */
@Controller
@RequestMapping(value = "/report")
public class ReportController extends BaseController{
    public final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private DataQualityBiz dataQualityBiz;

    @RequestMapping(value = "report1")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("system/report/report1");
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping(value = "/getList", method = RequestMethod.POST)
    public Map<String, Object> getList(@RequestBody QueryVo queryVo) {

        Map<String, Object> result = new HashMap<>();
        result.put("list", new ArrayList());

        if(queryVo == null || queryVo.getTableName() == null || queryVo.getQueryType() == null){
            return result;
        }

        try {

        } catch (Exception e) {
            logger.error("查询失败：" + e.getMessage(), e);
        }
        return result;
    }
}
