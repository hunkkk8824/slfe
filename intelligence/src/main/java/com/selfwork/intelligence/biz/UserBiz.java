package com.selfwork.intelligence.biz;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.selfwork.intelligence.common.BaseException;
import com.selfwork.intelligence.common.PasswordHelper;
import com.selfwork.intelligence.mapper.PermissionInfoPOMapper;
import com.selfwork.intelligence.mapper.RoleInfoPOMapper;
import com.selfwork.intelligence.mapper.UserInfoPOMapper;
import com.selfwork.intelligence.model.po.PermissionInfoPO;
import com.selfwork.intelligence.model.po.RoleInfoPO;
import com.selfwork.intelligence.model.po.UserInfoPO;

import com.selfwork.intelligence.model.vo.BaseQueryVo;
import com.selfwork.intelligence.model.vo.UserQueryVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

@Service
public class UserBiz extends BaseBiz {

    public final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserInfoPOMapper userMapper;

    @Autowired
    private RoleInfoPOMapper roleMapper;

    @Autowired
    private PermissionInfoPOMapper permissionMapper;

    @Autowired
    private PasswordHelper passwordHelper;

    /**
     * 保存用户
     *
     * @param user
     * @param currentUser
     */
    public int save(UserInfoPO user, UserInfoPO currentUser) {
        // 密码加密
        passwordHelper.encryptPassword(user);
        user.setCreateuserid(String.valueOf(currentUser.getUserid()));
        user.setCreatetime(new Date());
        return userMapper.insertSelective(user);
    }

    //从数据库获取对应用户名密码的用户
    public UserInfoPO findUser(String username) {
        try {
            List<UserInfoPO> userList = userMapper.findUserByAccountOrCallPhone(username);
            if (CollectionUtils.isEmpty(userList)) {
                return null;
            }
            return userList.get(0);
        }catch (Exception e){
            logger.error("从数据库获取对应用户名密码的用户失败",e);
        }

        return null;
    }


    //根据用户ID查询角色（role）
    public List<RoleInfoPO> getRolesByUserId(Integer userId) {

        try {
            return roleMapper.getRolesByUserId(userId);
        } catch (Exception e) {
            //TODO log
            return null;
        }

    }

    //根据用户ID查询权限（permission）
    public List<PermissionInfoPO> getPermissionsByUserId(Integer userId) {

        try {
            return permissionMapper.getPermissionsByUserId(userId);
        } catch (Exception e) {
            //TODO log
            return null;
        }

    }

    /**
     * 分页查询
     *
     * @return
     */
    public PageInfo<UserInfoPO> findPage(UserQueryVo queryVo) {

        // 查询
        int pageNumber = queryVo.getPageNumber();
        int pageSize = queryVo.getLimit();
        PageHelper.startPage(pageNumber, pageSize);
        List<UserInfoPO> list = userMapper.findList(queryVo);
        if (null == list || list.size() == 0) {
            logger.error("获取用户分页信息失败");
            return null;
        }

        return new PageInfo<>(list);
    }

}

