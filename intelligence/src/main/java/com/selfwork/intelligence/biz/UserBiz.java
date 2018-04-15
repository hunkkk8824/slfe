package com.selfwork.intelligence.biz;

import com.selfwork.intelligence.mapper.PermissionInfoPOMapper;
import com.selfwork.intelligence.mapper.RoleInfoPOMapper;
import com.selfwork.intelligence.mapper.UserInfoPOMapper;
import com.selfwork.intelligence.model.po.PermissionInfoPO;
import com.selfwork.intelligence.model.po.RoleInfoPO;
import com.selfwork.intelligence.model.po.UserInfoPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class UserBiz extends BaseBiz {

    @Autowired
    private UserInfoPOMapper userMapper;

    @Autowired
    private RoleInfoPOMapper roleMapper;

    @Autowired
    private PermissionInfoPOMapper permissionMapper;

    //从数据库获取对应用户名密码的用户
    public UserInfoPO findUser(String username) {
        List<UserInfoPO> userList = userMapper.findUserByAccountOrCallPhone(username);
        if (CollectionUtils.isEmpty(userList)) {
            return null;
        }
        return userList.get(0);
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

}

