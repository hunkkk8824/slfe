package com.selfwork.intelligence.controller.portal;

import com.github.pagehelper.PageInfo;
import com.selfwork.intelligence.biz.ResourcecatalogDescBiz;
import com.selfwork.intelligence.controller.BaseController;
import com.selfwork.intelligence.model.vo.catalogdesc.CatalogDescQueryVo;
import com.selfwork.intelligence.model.vo.catalogdesc.CatalogDescVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/***
 * 资源目录说明
 * */
@Controller
@RequestMapping(value = "/resourcecatalogDesc")
public class ResourcecatalogDescController extends BaseController {

    public final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ResourcecatalogDescBiz resourcecatalogDescBiz;

    @RequestMapping(value = "/index")
    public ModelAndView index() {

        ModelAndView view = new ModelAndView("sub/catalogdesc/index");
        return view;

    }

    @ResponseBody
    @RequestMapping(value = "/getList", method = RequestMethod.POST)
    public Map<String, Object> getList(@RequestBody CatalogDescQueryVo queryVo) {

        Map<String, Object> result = new HashMap<>();
        result.put("total", 0);
        result.put("rows", new ArrayList());
        try {
            PageInfo<CatalogDescVo> pageData = resourcecatalogDescBiz.findPage(queryVo);
            if (pageData != null) {
                result.put("total", pageData.getTotal());
                result.put("rows", pageData.getList());
            }
        } catch (Exception e) {
            logger.error("获取资源目录说明异常 e:{}" + e.getMessage(), e);
        }
        return result;
    }

    @RequestMapping(value = "/toEdit")
    public ModelAndView toEdit(@RequestParam Integer id) {
        ModelAndView mv = new ModelAndView("sub/catalogdesc/edit");
        CatalogDescVo vo = resourcecatalogDescBiz.selectByPrimaryKey(id);
        mv.addObject("catalogDescVo", vo);
        return mv;
    }

    @ResponseBody
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public Map<String, Object> edit(@RequestBody CatalogDescVo vo) {

        Map<String, Object> result = new HashMap<>();
        result.put("total", 0);
        result.put("rows", new ArrayList());
        try {
            resourcecatalogDescBiz.edit(vo);
            result.put("message", "操作成功");
            result.put("code", 0);
        } catch (Exception e) {
            logger.error("编辑资源目录说明异常 e:{}" + e.getMessage(), e);
            result.put("message", e.getMessage());
            result.put("code", 0);
        }

        return result;
    }

}
