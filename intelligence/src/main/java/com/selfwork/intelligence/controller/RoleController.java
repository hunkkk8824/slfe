package com.selfwork.intelligence.controller;

import com.github.pagehelper.PageInfo;
import com.selfwork.intelligence.biz.RoleBiz;
import com.selfwork.intelligence.model.po.RoleInfoPO;
import com.selfwork.intelligence.model.vo.RoleInfoQueryVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.management.relation.Role;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/role")
public class RoleController extends BaseController {

    public final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private RoleBiz roleBiz;

    @RequestMapping(value = "/index")
    public ModelAndView index() {

        ModelAndView view = new ModelAndView("sub/role/index");
        return view;

    }

    @ResponseBody
    @RequestMapping(value = "/getRoleList", method = RequestMethod.POST)
    public Map<String, Object> getRoleList(@RequestBody RoleInfoQueryVo queryVo) {

        Map<String, Object> result = new HashMap<>();
        result.put("total", 0);
        result.put("rows", new ArrayList());

        // 参数验证
        if (null == queryVo) {
            return result;
        }

        // 获取数据
        try {
            PageInfo<RoleInfoPO> pageData = roleBiz.findPage(queryVo);
            if (pageData != null) {
                result.put("total", pageData.getTotal());
                result.put("rows", pageData.getList());
            }

        } catch (Exception e) {
            logger.error("获取角色信息异常 e:{}" + e.getMessage(), e);
        }

        return result;

    }

    /**
     * 新增角色
     *
     * @return
     */
    @RequestMapping("/toAdd")
    public ModelAndView toAdd() {
        ModelAndView view = new ModelAndView("sub/role/add");
        return view;
    }

    /**
     * 保存角色信息
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> save(@RequestBody RoleInfoPO role) {
        Map<String, Object> result = new HashMap<>();

        // 参数验证
        if (null == role) {
            return result;
        }

        // 获取数据
        try {

            int res = roleBiz.save(role, this.getLoginUser());
            if (res == 0) {
                logger.error("保存角色失败");
                result.put("code", -1);
                result.put("msg", "保存角色失败");
            }
            else{
                result.put("code", 0);
                result.put("msg", "保存角色成功");
            }

        } catch (Exception e) {
            logger.error("保存角色信息系统异常 e:{}", e);
            result.put("code", -1);
            result.put("msg", "保存角色失败");
        }

        return result;
    }
}
