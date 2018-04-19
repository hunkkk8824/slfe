package com.selfwork.intelligence.biz;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.selfwork.intelligence.mapper.RoleInfoPOMapper;
import com.selfwork.intelligence.model.po.RoleInfoPO;
import com.selfwork.intelligence.model.po.UserInfoPO;
import com.selfwork.intelligence.model.vo.role.RoleInfoQueryVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Date;

@Service
public class RoleBiz extends BaseBiz {
    public final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private RoleInfoPOMapper roleMapper;


    /**
     * 分页查询
     *
     * @return
     */
    public PageInfo<RoleInfoPO> findPage(RoleInfoQueryVo queryVo) {

        // 查询
        int pageNumber = queryVo.getPageNumber();
        int pageSize = queryVo.getLimit();
        PageHelper.startPage(pageNumber, pageSize);
        List<RoleInfoPO> list = roleMapper.findList(queryVo);
        if (null == list || list.size() == 0) {
            logger.error("获取角色分页信息失败");
            return null;
        }

        return new PageInfo<>(list);
    }

    /**
     * 保存用户
     *
     * @param currentUser
     */
    public int save(RoleInfoPO role, UserInfoPO currentUser) {

        role.setCreateuserid(String.valueOf(currentUser.getUserid()));
        role.setCreatetime(new Date());
        return roleMapper.insertSelective(role);
    }
}
