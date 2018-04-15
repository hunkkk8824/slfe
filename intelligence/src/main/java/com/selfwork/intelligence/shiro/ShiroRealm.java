package com.selfwork.intelligence.shiro;

import com.selfwork.intelligence.biz.UserBiz;
import com.selfwork.intelligence.model.po.PermissionInfoPO;
import com.selfwork.intelligence.model.po.RoleInfoPO;
import com.selfwork.intelligence.model.po.UserInfoPO;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.List;

public class ShiroRealm extends AuthorizingRealm {

    @Autowired
    private UserBiz userBiz;

    /**
     * 认证信息.(身份验证) : Authentication 是用来验证用户身份
     *
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(
            AuthenticationToken authcToken) throws AuthenticationException {

        System.out.println("身份认证方法：MyShiroRealm.doGetAuthenticationInfo()");

        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
        // 从数据库获取对应用户名密码的用户
        UserInfoPO user = userBiz.findUser(token.getUsername());

        if (null == user) {
            throw new AccountException("帐号或密码不正确！");
        }

        if (!user.getValid()) {
            throw new AccountException(); // 账户已被禁用
        }

        //交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                user, //用户名
                user.getPassword(), //密码
                ByteSource.Util.bytes(user.getPasswordsalt()),
                getName());  //realm name

        return authenticationInfo;

    }


    /**
     * 授权
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(
            PrincipalCollection principals) {
        System.out.println("权限认证方法：MyShiroRealm.doGetAuthenticationInfo()");
        UserInfoPO user = (UserInfoPO) SecurityUtils.getSubject().getPrincipal();

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        //根据用户ID查询角色（role），放入到Authorization里。
        List<RoleInfoPO> roleList = userBiz.getRolesByUserId(user.getUserid());
        Set<String> roleSet = new HashSet<String>();
        for (RoleInfoPO role : roleList) {
            roleSet.add(role.getRolecode());
        }
        info.setRoles(roleSet);

        //根据用户ID查询权限（permission），放入到Authorization里。
        List<PermissionInfoPO> permissionList = userBiz.getPermissionsByUserId(user.getUserid());
        Set<String> permissionSet = new HashSet<String>();
        for (PermissionInfoPO Permission : permissionList) {
            permissionSet.add(Permission.getPermissioncode());
        }

        info.setStringPermissions(permissionSet);
        return info;
    }

}
