package com.selfwork.intelligence.controller.portal;

import com.github.pagehelper.PageInfo;
import com.selfwork.intelligence.biz.DataQualityBiz;
import com.selfwork.intelligence.biz.ExChangeConfigBiz;
import com.selfwork.intelligence.biz.ResourcecatalogDescBiz;
import com.selfwork.intelligence.biz.UserBiz;
import com.selfwork.intelligence.common.enums.AuditStatusEnum;
import com.selfwork.intelligence.common.enums.DataSetCodeEnum;
import com.selfwork.intelligence.common.enums.QualityEvaluateEnum;
import com.selfwork.intelligence.controller.BaseController;
import com.selfwork.intelligence.model.vo.ResourceEtlLogVo;
import com.selfwork.intelligence.model.vo.dataquality.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/resourcecatalog")
public class ResourceCatalogController extends BaseController {

    public final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private DataQualityBiz dataQualityBiz;

    @Autowired
    ExChangeConfigBiz exChangeConfigBiz;

    @Autowired
    UserBiz userBiz;

    @Autowired
    ResourcecatalogDescBiz resourcecatalogDescBiz;

    @RequestMapping(value = "/index")
    public ModelAndView index(@RequestParam(required = false) String defaultdataSetCode) {

        ModelAndView view = new ModelAndView("sub/resourcecatalog/index");

        view.addObject("dataSetCodeEnums", DataSetCodeEnum.values());
        view.addObject("defaultdataSetCode", StringUtils.isEmpty(defaultdataSetCode) ? DataSetCodeEnum.QB_SJ_RHMB.getValue() : defaultdataSetCode);
        view.addObject("touristRoleCount", userBiz.touristRolsCount(this.getLoginUser().getUserid()));
        return view;

    }


    @ResponseBody
    @RequestMapping(value = "/getColumnsByDataSetCode", method = RequestMethod.GET)
    public List<ColumnsVo> getColumnsByDataSetCode(@RequestParam String dataSetCode) {

        try {
            return dataQualityBiz.getColumnsByDataSetCode(dataSetCode);
        } catch (Exception e) {
            logger.error("根据dataSetCode获取列异常：" + e.getMessage());
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

    //获取游客模式内容
    @ResponseBody
    @RequestMapping(value = "/getTouristContent", method = RequestMethod.GET)
    public Map<String, Object> getTouristContent(@RequestParam String dataSetCode) {
        Map<String, Object> result = new HashMap<>();
        result.put("data", "");
        try {
            String data = resourcecatalogDescBiz.getTouristContent(dataSetCode);
            result.put("data", data);
        } catch (Exception e) {
            logger.error("获取游客模式内容异常：" + e.getMessage(), e);
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
