package com.selfwork.intelligence.controller;

import com.github.pagehelper.PageInfo;
import com.selfwork.intelligence.biz.DataQualityBiz;
import com.selfwork.intelligence.biz.ExChangeConfigBiz;
import com.selfwork.intelligence.common.enums.AuditStatusEnum;
import com.selfwork.intelligence.common.enums.DataSetCodeEnum;
import com.selfwork.intelligence.common.enums.QualityEvaluateEnum;
import com.selfwork.intelligence.model.vo.ResourceEtlLogVo;
import com.selfwork.intelligence.model.vo.dataquality.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/resourcecatalog")
public class ResourceCatalogController {

    public final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private DataQualityBiz dataQualityBiz;

    @Autowired
    ExChangeConfigBiz exChangeConfigBiz;

    @RequestMapping(value = "/index")
    public ModelAndView index() {

        ModelAndView view = new ModelAndView("sub/resourcecatalog/index");
        view.addObject("auditStatusEnums", AuditStatusEnum.values());
        view.addObject("qualityEvaluateEnums", QualityEvaluateEnum.values());
        view.addObject("dataSetCodeEnums", DataSetCodeEnum.values());


        view.addObject("sourceExchangerCodeList", exChangeConfigBiz.findAllEnable());

        return view;

    }

    @ResponseBody
    @RequestMapping(value = "/getList", method = RequestMethod.POST)
    public Map<String, Object> getList(@RequestBody DataQualityQueryVo queryVo) {

        Map<String, Object> result = new HashMap<>();
        result.put("total", 0);
        result.put("rows", new ArrayList());

        try {
            PageInfo<DataQualitVo> pageData = dataQualityBiz.findPage(queryVo);
            if (pageData != null) {
                result.put("total", pageData.getTotal());
                result.put("rows", pageData.getList());
            }
        } catch (Exception e) {
            logger.error("获取资源信息异常：" + e.getMessage(), e);
        }
        return result;
    }

    //查看明细
    @RequestMapping(value = "/toDetail")
    public ModelAndView toDetail(@RequestParam String dataSetCode,@RequestParam String resourceCode) {

        ModelAndView view = new ModelAndView("sub/resourcecatalog/detail");
        view.addObject("dataSetCode", dataSetCode);//资源明细对应的表名称
        view.addObject("resourceCode", resourceCode);//批次号
        return view;
    }

    //导入日志
    @RequestMapping(value = "/toExportLog")
    public ModelAndView exportLog(@RequestParam Integer resourceId) {

        ModelAndView view = new ModelAndView("sub/resourcecatalog/exportLog");
        view.addObject("resourceId", resourceId);
        return view;

    }

    //etl日志
    @ResponseBody
    @RequestMapping(value = "/getExportLog", method = RequestMethod.POST)
    public Map<String, Object> getExportLog(@RequestBody ResourceEtlLogQueryVo vo) {

        Map<String, Object> result = new HashMap<>();
        result.put("total", 0);
        result.put("rows", new ArrayList());

        try {
            PageInfo<ResourceEtlLogVo> pageData = dataQualityBiz.selectByResourceId(vo);
            if (pageData != null) {
                result.put("total", pageData.getTotal());
                result.put("rows", pageData.getList());
            }
        } catch (Exception e) {
            logger.error("获取导入日志异常：" + e.getMessage(), e);
        }
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/getColumnsByDataSetCode", method = RequestMethod.GET)
    public List<ColumnsVo> getColumnsByDataSetCode(@RequestParam String dataSetCode) {

        try {
            return dataQualityBiz.getColumnsByDataSetCode(dataSetCode);
        } catch (Exception e) {
            logger.error("根据dataSetCode获取列异常："+ e.getMessage());
        }
        return new ArrayList<>();
    }

    @ResponseBody
    @RequestMapping(value = "/getDetail", method = RequestMethod.POST)
    public Map<String, Object> getDetail(@RequestBody DetailQueryVo queryVo) {

        Map<String, Object> result = new HashMap<>();
        result.put("total", 0);
        result.put("rows", new ArrayList());
        try {
            return dataQualityBiz.getDetail(queryVo);
        } catch (Exception e) {
            logger.error("查看明细异常：" + e.getMessage(), e);
        }
        return result;
    }

//    @RequestMapping(value = "/index")
//    public ModelAndView index() {
//
//        ModelAndView view = new ModelAndView("sub/resourcecatalog/index");
//        return view;
//
//    }
//
//    @RequestMapping(value = "/detail")
//    public ModelAndView detail(Integer id) {
//
//        ModelAndView view = new ModelAndView("sub/resourcecatalog/detail");
//        return view;
//
//    }
//
//    @RequestMapping(value = "/QB_SJ_YSDZZJGMB")
//    public ModelAndView QB_SJ_YSDZZJGMB() {
//
//        ModelAndView view = new ModelAndView("sub/resourcecatalog/QB_SJ_YSDZZJGMB");
//        return view;
//
//    }

}
