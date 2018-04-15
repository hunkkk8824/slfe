package com.selfwork.intelligence.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/home")
public class HomeController {

    @RequestMapping(value = "/page")
    public ModelAndView page() {

        ModelAndView view = new ModelAndView("sub/home");
        return view;

    }

}
