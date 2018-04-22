package com.selfwork.intelligence.controller;


import com.github.pagehelper.PageInfo;
import com.selfwork.intelligence.biz.DataQualityBiz;
import com.selfwork.intelligence.common.enums.AuditStatusEnum;
import com.selfwork.intelligence.common.enums.QualityEvaluateEnum;
import com.selfwork.intelligence.model.po.RoleInfoPO;
import com.selfwork.intelligence.model.vo.dataquality.AuditRequestVo;
import com.selfwork.intelligence.model.vo.dataquality.DataQualitVo;
import com.selfwork.intelligence.model.vo.dataquality.DataQualityQueryVo;
import com.selfwork.intelligence.model.vo.dataquality.QualityEvaluateRequestVo;
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
 * 数据质量管理
 **/
@Controller
@RequestMapping(value = "/dataQuality")
public class DataQualityController extends BaseController {

    public final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private DataQualityBiz dataQualityBiz;

    @RequestMapping(value = "/index")
    public ModelAndView index() {

        ModelAndView view = new ModelAndView("sub/dataQuality/index");
        view.addObject("auditStatusEnums", AuditStatusEnum.values());
        view.addObject("qualityEvaluateEnums", QualityEvaluateEnum.values());
        return view;

    }

    @ResponseBody
    @RequestMapping(value = "/getList", method = RequestMethod.POST)
    public Map<String, Object> getList(@RequestBody DataQualityQueryVo queryVo) {

        Map<String, Object> result = new HashMap<>();
        result.put("total", 0);
        result.put("rows", new ArrayList());
        try {
            PageInfo<DataQualitVo> pageData =  dataQualityBiz.findPage(queryVo);
            if (pageData != null) {
                result.put("total", pageData.getTotal());
                result.put("rows", pageData.getList());
            }
        } catch (Exception e) {
            logger.error("获取资源信息异常 e:{}" + e.getMessage(), e);
        }
        return result;
    }

    //审核
    @ResponseBody
    @RequestMapping(value = "/audit", method = RequestMethod.POST)
    public Map<String, Object> audit(@RequestBody AuditRequestVo vo) {

        Map<String, Object> result = new HashMap<>();
        result.put("code", 0);

        try {
            dataQualityBiz.audit(vo);
        } catch (Exception e) {
            logger.error("审核资源信息异常 e:{}" + e.getMessage(), e);
            result.put("code", -1);
        }
        return result;
    }

    //质量评定
    @ResponseBody
    @RequestMapping(value = "/evaluateQuality", method = RequestMethod.POST)
    public Map<String, Object> evaluateQuality(@RequestBody QualityEvaluateRequestVo vo) {

        Map<String, Object> result = new HashMap<>();
        result.put("code", 0);

        try {
            dataQualityBiz.evaluateQuality(vo);
        } catch (Exception e) {
            logger.error("质量评定异常 e:{}" + e.getMessage(), e);
            result.put("code", -1);
        }
        return result;
    }
}
