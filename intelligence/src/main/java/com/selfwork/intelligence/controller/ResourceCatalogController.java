package com.selfwork.intelligence.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/resourcecatalog")
public class ResourceCatalogController {

    @RequestMapping(value = "/index")
    public ModelAndView index() {

        ModelAndView view = new ModelAndView("sub/resourcecatalog/index");
        return view;

    }

    @RequestMapping(value = "/detail")
    public ModelAndView detail(Integer id) {

        ModelAndView view = new ModelAndView("sub/resourcecatalog/detail");
        return view;

    }

    @RequestMapping(value = "/QB_SJ_YSDZZJGMB")
    public ModelAndView QB_SJ_YSDZZJGMB() {

        ModelAndView view = new ModelAndView("sub/resourcecatalog/QB_SJ_YSDZZJGMB");
        return view;

    }

}
