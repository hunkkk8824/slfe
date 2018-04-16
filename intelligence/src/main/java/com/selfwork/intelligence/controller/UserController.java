package com.selfwork.intelligence.controller;


import com.github.pagehelper.PageInfo;
import com.selfwork.intelligence.biz.UserBiz;
import com.selfwork.intelligence.model.po.UserInfoPO;
import com.selfwork.intelligence.model.po.VehiclePO;
import com.selfwork.intelligence.model.vo.UserQueryVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/user")
public class UserController extends BaseController {

    public final Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    UserBiz userBiz;

    @RequestMapping(value = "/index")
    public ModelAndView index() {

        ModelAndView view = new ModelAndView("sub/user/index");
        return view;

    }

    @ResponseBody
    @RequestMapping(value = "/getUserList", method = RequestMethod.POST)
    public Map<String, Object> getUserList(@RequestBody UserQueryVo queryVo) {

        Map<String, Object> result = new HashMap<>();
        result.put("total", 0);
        result.put("rows", new ArrayList());

        // 参数验证
        if (null == queryVo) {
            return result;
        }

        // 获取数据
        try {
            PageInfo<UserInfoPO> pageData = userBiz.findPage(queryVo);
            if (pageData != null) {
                result.put("total", pageData.getTotal());
                result.put("rows", pageData.getList());
            }

        } catch (Exception e) {
            logger.error("获取用户信息异常 e:{}" + e.getMessage(), e);
        }

        return result;

    }


}
