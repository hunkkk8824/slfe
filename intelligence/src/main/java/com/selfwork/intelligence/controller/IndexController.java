package com.selfwork.intelligence.controller;

import com.selfwork.intelligence.biz.UserBiz;
import com.selfwork.intelligence.common.enums.DataSetCodeEnum;
import com.selfwork.intelligence.common.enums.PermissionTypeEnum;
import com.selfwork.intelligence.model.po.UserInfoPO;
import com.selfwork.intelligence.model.vo.user.TreeMenuVo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.sql.DataSource;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/")
public class IndexController extends BaseController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    UserBiz userBiz;

    //跳转到主页
    @RequestMapping(value = "index")
    public ModelAndView index() {

        ModelAndView modelAndView = new ModelAndView("system/index");

        boolean isAuthenticated = SecurityUtils.getSubject().isAuthenticated();
        if (!isAuthenticated) {
            UsernamePasswordToken token = new UsernamePasswordToken("tourist", "123456");
            SecurityUtils.getSubject().login(token);
        }

        UserInfoPO user = this.getLoginUser();
        modelAndView.addObject("userName", user.getRealname());
        modelAndView.addObject("nickname", user.getNickname());


        modelAndView.addObject("dataSetCodeEnums", DataSetCodeEnum.values());
        return modelAndView;
    }


    //跳转到主页
    @RequestMapping(value = "manageindex")
    public ModelAndView manageindex() {

        ModelAndView modelAndView = new ModelAndView("index");
        UserInfoPO user = (UserInfoPO) SecurityUtils.getSubject().getPrincipal();
        modelAndView.addObject("userName", user.getRealname());
        modelAndView.addObject("nickname", user.getNickname());

        // 获取用户权限菜单
        List<TreeMenuVo> menuList = userBiz.findTreeMenuByUserId(getLoginUser().getUserid(), PermissionTypeEnum.MENU_PERMISSION.getValue());
        modelAndView.addObject("menuList", menuList);
        return modelAndView;

    }

    /**
     * 退出
     *
     * @return
     */
    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public ModelAndView logout(@RequestParam(required = false) Integer sys) {
        ModelAndView view = new ModelAndView("/logout");
        view.addObject("sys", sys);
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
