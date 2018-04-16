package com.selfwork.intelligence.controller;


import com.github.pagehelper.PageInfo;
import com.selfwork.intelligence.biz.UserBiz;
import com.selfwork.intelligence.common.BaseException;
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

    /**
     * 新增用户
     *
     * @return
     */
    @RequestMapping("/toAdd")
    public ModelAndView toAdd() {
        ModelAndView view = new ModelAndView("sub/user/add");
        return view;
    }

    /**
     * 保存用户信息
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> save(@RequestBody UserInfoPO user) {
        Map<String, Object> result = new HashMap<>();

        // 参数验证
        if (null == user) {
            return result;
        }

        // 获取数据
        try {

            int res = userBiz.save(user, this.getLoginUser());
            if (res == 0) {
                logger.error("保存用户失败");
                result.put("code", -1);
                result.put("msg", "保存用户失败");
            }
            else{
                result.put("code", 0);
                result.put("msg", "保存用户成功");
            }

        } catch (Exception e) {
            logger.error("保存用户信息系统异常 e:{}", e);
            result.put("code", -1);
            result.put("msg", "保存用户失败");
        }

        return result;
    }

}
