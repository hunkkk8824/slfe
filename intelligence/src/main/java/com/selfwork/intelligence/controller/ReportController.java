package com.selfwork.intelligence.controller;

import com.github.pagehelper.PageInfo;
import com.selfwork.intelligence.biz.DataQualityBiz;
import com.selfwork.intelligence.biz.dataset.AisBiz;
import com.selfwork.intelligence.common.enums.DataSetCodeEnum;
import com.selfwork.intelligence.model.po.UserInfoPO;
import com.selfwork.intelligence.model.vo.BaseQueryVo;
import com.selfwork.intelligence.model.vo.dateset.AisQueryReq;
import com.selfwork.intelligence.model.vo.dateset.AisVo;
import com.selfwork.intelligence.model.vo.dateset.LocationDto;
import com.selfwork.intelligence.model.vo.dateset.QueryVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zzc on 2018/6/10.
 */
@Controller
@RequestMapping(value = "/report")
public class ReportController extends BaseController {
    public final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private DataQualityBiz dataQualityBiz;

    @Autowired
    private AisBiz aisBiz;

    //装备能力分析
    @RequestMapping(value = "/report1")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("system/report/report1");

        UserInfoPO user = this.getLoginUser();
        modelAndView.addObject("nickname", user.getNickname());
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping(value = "/getLocations", method = RequestMethod.POST)
    public List<LocationDto> getLocations(@RequestBody QueryVo queryVo) {
        List<LocationDto> dtos = null;
        try {
            dtos = dataQualityBiz.getLocations(queryVo);
        } catch (Exception e) {
            logger.error("查询失败：" + e.getMessage(), e);
        }
        return dtos != null ? dtos : new ArrayList<>();
    }

    @ResponseBody
    @RequestMapping(value = "/getList", method = RequestMethod.POST)
    public Map<String, Object> getList(@RequestBody QueryVo queryVo) {
        Map<String, Object> result = new HashMap<>();
        result.put("total", 0);
        result.put("rows", new ArrayList());

        if (queryVo == null || queryVo.getTableName() == null) {
            return result;
        }

        try {
            return dataQualityBiz.getList(queryVo);
        } catch (Exception e) {
            logger.error("查询失败：" + e.getMessage(), e);
        }
        return result;
    }

    //航道提取分析
    @RequestMapping(value = "/aisReport")
    public ModelAndView aisReport() {
        ModelAndView modelAndView = new ModelAndView("system/report/aisReport");
        UserInfoPO user = this.getLoginUser();
        modelAndView.addObject("nickname", user.getNickname());
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping(value = "/getAisList", method = RequestMethod.POST)
    public Map<String, Object> getAisList(@RequestBody AisQueryReq request) {

        Map<String, Object> result = new HashMap<>();
        result.put("total", 0);
        result.put("rows", new ArrayList());

        if (request == null) {
            return result;
        }

        try {
            PageInfo<AisVo> pageData = aisBiz.getAisInfoList(request);
            if (pageData != null) {
                result.put("total", pageData.getTotal());
                result.put("rows", pageData.getList());
            }
        } catch (Exception e) {
            logger.error("查询失败：" + e.getMessage(), e);
        }
        return result;
    }

    @RequestMapping(value = "/knowledgeReport")
    public ModelAndView knowledgeReport() {

        ModelAndView modelAndView = new ModelAndView("system/report/knowledgeReport");
        UserInfoPO user = this.getLoginUser();
        modelAndView.addObject("nickname", user.getNickname());
        return modelAndView;
    }


    //----------------------------------目标活动规律
    @RequestMapping(value = "/toTargetActivityRule")
    public ModelAndView toTtargetActivityRule() {
        ModelAndView modelAndView = new ModelAndView("system/report/targetActivityRule");
        UserInfoPO user = this.getLoginUser();
        modelAndView.addObject("dataSetCodeEnums", DataSetCodeEnum.values());
        modelAndView.addObject("nickname", user.getNickname());
        return modelAndView;
    }

}
