package com.selfwork.intelligence.controller;

import com.selfwork.intelligence.model.po.UserInfoPO;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.LinkedHashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/")
public class IndexController extends BaseController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    //跳转到主页
    @RequestMapping(value = "index")
    public ModelAndView index() {
        ModelAndView modelAndView=new ModelAndView("index");
        UserInfoPO user = (UserInfoPO) SecurityUtils.getSubject().getPrincipal();
        modelAndView.addObject("userName",user.getRealname());
        modelAndView.addObject("nickname",user.getNickname());
        return modelAndView;
    }

    /**
     * 退出
     *
     * @return
     */
    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public ModelAndView logout() {
        ModelAndView view = new ModelAndView("/login");
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        try {
            //退出
            SecurityUtils.getSubject().logout();

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return view;
    }

}
