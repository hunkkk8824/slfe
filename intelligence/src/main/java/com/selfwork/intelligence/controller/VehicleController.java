package com.selfwork.intelligence.controller;

import com.github.pagehelper.PageInfo;
import com.selfwork.intelligence.biz.VehicleBiz;
import com.selfwork.intelligence.model.po.VehiclePO;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "/vehicle")
public class VehicleController extends BaseController {

    //安全框架,jsp，拦截器，事务控制，错误页面配置,日志，多环境配置切换

    @Autowired
    private VehicleBiz vehicleBiz;

    @ResponseBody
    @RequestMapping(value = "/getByid/{id}", produces = {"application/json;charset=UTF-8"})
    public VehiclePO getByid(@PathVariable("id") Integer id) throws Exception {
        // throw new Exception("ff");
        return vehicleBiz.getByid(id);

    }


    @ResponseBody
    @RequestMapping(value = "/getAll/{pagenum}", produces = {"application/json;charset=UTF-8"})
    public List<VehiclePO> getAll(@PathVariable("pagenum") int pagenum) {

        PageInfo<VehiclePO> pageInfo = vehicleBiz.getAll(pagenum);
        return pageInfo.getList();

    }

    @RequestMapping(value = "/vehicleListView/{pagenum}")
    public ModelAndView vehicleListView(@PathVariable("pagenum") int pagenum) {

        ModelAndView view = new ModelAndView("testv");
        view.addObject("data", "855555888");

        return view;

    }

    @RequestMapping(value = "/add")
    public ModelAndView add() {

        ModelAndView view = new ModelAndView("testv");
        view.addObject("data", "855555888");

        return view;

    }

}
