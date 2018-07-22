package com.selfwork.intelligence.controller;

import com.github.pagehelper.PageInfo;
import com.selfwork.intelligence.biz.DataQualityBiz;
import com.selfwork.intelligence.biz.dataset.AirwayDataBiz;
import com.selfwork.intelligence.biz.dataset.AisBiz;
import com.selfwork.intelligence.biz.dataset.QbSjDptdzzmbBiz;
import com.selfwork.intelligence.common.enums.DataSetCodeEnum;
import com.selfwork.intelligence.model.po.AirwayDataPO;
import com.selfwork.intelligence.model.po.UserInfoPO;
import com.selfwork.intelligence.model.vo.BaseQueryVo;
import com.selfwork.intelligence.model.vo.dateset.*;
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

    @Autowired
    private QbSjDptdzzmbBiz qbSjDptdzzmbBiz;

    @Autowired
    AirwayDataBiz airwayDataBiz;


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
        List<LocationDto> list = null;
        try {
            list = dataQualityBiz.getLocations(queryVo);

            //距离分布饼图数据
            Map<String, Long> map = new HashMap<>();
            if (list != null && !list.isEmpty()) {

                //80km-90km区间
                long count8090 = list.stream().filter(n ->
                        n != null && n.getJl().intValue() >= 80 && n.getJl().intValue() <= 90
                ).count();
                map.put("80km-90km区间", count8090);

                //90km-100km区间
                long count90100 = list.stream().filter(n ->
                        n != null && n.getJl().intValue() > 90 && n.getJl().intValue() <= 100
                ).count();
                map.put("90km-100km区间", count90100);

                //100km以上区间
                long countGt100 = list.stream().filter(n ->
                        n != null && n.getJl().intValue() > 100
                ).count();
                map.put("100km以上区间", countGt100);
            }

            List<String> titleList = new ArrayList();//jl 距离区间
            List<Map<String, String>> dataList = new ArrayList();
            for (Map.Entry<String, Long> entry : map.entrySet()) {
                titleList.add(entry.getKey());

                Map<String, String> mapitem = new HashMap<>();
                mapitem.put("name", entry.getKey());
                mapitem.put("value", String.valueOf(entry.getValue()));
                dataList.add(mapitem);
            }

            Map<String, Object> result = new HashMap<>();
            result.put("x", new ArrayList());
            result.put("y", new ArrayList());
            result.put("titleList", titleList);
            result.put("dataList", dataList);

            if(CollectionUtils.isEmpty(list)){
                list.get(0).setChartDataMap(result);
            }

        } catch (Exception e) {
            logger.error("查询失败：" + e.getMessage(), e);
        }
        return list != null ? list : new ArrayList<>();
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
           return aisBiz.getAisInfoList(request);
        } catch (Exception e) {
            logger.error("查询失败：" + e.getMessage(), e);
        }
        return result;
    }


    //航线数据
    @ResponseBody
    @RequestMapping(value = "/getAirwayData", method = RequestMethod.POST)
    public List<AirwayDataPO> getAirwayData() {

        List<AirwayDataPO> result = new ArrayList<>();

        try {
            List<AirwayDataPO> list = airwayDataBiz.getList();
            result = list;
        } catch (Exception e) {
            logger.error("查询失败：" + e.getMessage(), e);
        }
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/getSingleAisList", method = RequestMethod.POST)
    public List<AisVo> getSingleAisList(@RequestBody AisQueryReq request) {

        List<AisVo> result = new ArrayList<AisVo>();
        if (request == null) {
            return result;
        }

        try {
            Map<String,Object> pageData = aisBiz.getAisInfoList(request);
            if (pageData != null) {
                result = (List<AisVo>)pageData.get("rows");
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

    //----------------------------------装备威力规律
    @ResponseBody
    @RequestMapping(value = "/powerlaw", method = RequestMethod.POST)
    public Map<String, Object> powerlaw(@RequestBody QbSjDptdzzmbQueryReq request) {

        Map<String, Object> result = new HashMap<>();
        result.put("x", new ArrayList());
        result.put("y", new ArrayList());

        if (request == null) {
            return result;
        }

        try {
            Map<String, Long> res = qbSjDptdzzmbBiz.getStatisicInfoList(request);

            List<String> titleList = new ArrayList();//jl 距离区间
            List<Map<String, String>> dataList = new ArrayList();
            for (Map.Entry<String, Long> entry : res.entrySet()) {
                titleList.add(entry.getKey());

                Map<String, String> mapitem = new HashMap<>();
                mapitem.put("name", entry.getKey());
                mapitem.put("value", String.valueOf(entry.getValue()));
                dataList.add(mapitem);
            }
            result.put("titleList", titleList);
            result.put("dataList", dataList);

        } catch (Exception e) {
            logger.error("查询失败：" + e.getMessage(), e);
        }

        return result;
    }

    //----------------------------------目标融合识别
    @RequestMapping(value = "/toTargetFusionRecognition")
    public ModelAndView toTargetFusionRecognition() {
        ModelAndView modelAndView = new ModelAndView("system/report/tabpage");
        UserInfoPO user = this.getLoginUser();
        modelAndView.addObject("nickname", user.getNickname());
        return modelAndView;
    }

    //文本导入

    //

}
