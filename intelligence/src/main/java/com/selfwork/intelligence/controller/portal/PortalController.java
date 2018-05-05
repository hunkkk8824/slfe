package com.selfwork.intelligence.controller.portal;

import com.selfwork.intelligence.controller.BaseController;
import com.selfwork.intelligence.model.po.UserInfoPO;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by zzc on 2018/5/6.
 */
@Controller
@RequestMapping(value = "/portal")
public class PortalController extends BaseController {


    /**
     * 首页
     * @return
     */
    @RequestMapping(value = "index")
    public ModelAndView index() {
        ModelAndView modelAndView=new ModelAndView("portal/index");
        UserInfoPO user = (UserInfoPO) SecurityUtils.getSubject().getPrincipal();
        modelAndView.addObject("userName",user.getRealname());
        modelAndView.addObject("nickname",user.getNickname());
        return modelAndView;
    }

    /**
     * 跳转到新增数据转换页面
     * @return
     */
    @RequestMapping(value = "add")
    public ModelAndView add() {
        ModelAndView modelAndView=new ModelAndView("portal/add");
        UserInfoPO user = (UserInfoPO) SecurityUtils.getSubject().getPrincipal();
        modelAndView.addObject("userName",user.getRealname());
        modelAndView.addObject("nickname",user.getNickname());
        return modelAndView;
    }


    /**
     * 跳转到资源详情页
     * @return
     */
    @RequestMapping(value = "detail")
    public ModelAndView detail() {
        ModelAndView modelAndView=new ModelAndView("portal/detail");
        UserInfoPO user = (UserInfoPO) SecurityUtils.getSubject().getPrincipal();
        modelAndView.addObject("userName",user.getRealname());
        modelAndView.addObject("nickname",user.getNickname());
        return modelAndView;
    }

}
