package com.selfwork.intelligence.controller;

import com.selfwork.intelligence.biz.ResourceBiz;
import com.selfwork.intelligence.model.po.ResourcePO;
import com.selfwork.intelligence.model.po.UserInfoPO;
import com.selfwork.intelligence.model.vo.BaseResultVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zzc on 2018/5/6.
 */
@Controller
@RequestMapping(value = "/resource")
public class ResourceController extends BaseController{
    public final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ResourceBiz resourceBiz;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> saveExchangeEtl(@RequestBody ResourcePO resourcePO) {
        Map<String, Object> result = new HashMap<>();

        // 参数验证
        if (null == resourcePO) {
            return result;
        }
        try {
            UserInfoPO user = this.getLoginUser();
            resourcePO.setCommitUser(user.getUseraccount());
            resourcePO.setCommitUserName(user.getRealname());
            BaseResultVo baseResultVo = resourceBiz.applyDataExchange(resourcePO);
            if(baseResultVo.isSuccessful()){
                result.put("code", 0);
                result.put("msg", "保存成功");
            }else{
                result.put("code", -1);
                result.put("msg", "保存失败");
            }

        } catch (Exception e) {
            logger.error("保存异常 e:{}", e);
            result.put("code", -1);
            result.put("msg", "保存失败");
        }
        return result;
    }
}
