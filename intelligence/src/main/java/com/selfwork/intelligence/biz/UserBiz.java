package com.selfwork.intelligence.biz;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.selfwork.intelligence.common.BaseException;
import com.selfwork.intelligence.common.BeanUtils;
import com.selfwork.intelligence.common.PasswordHelper;
import com.selfwork.intelligence.mapper.PermissionInfoPOMapper;
import com.selfwork.intelligence.mapper.RoleInfoPOMapper;
import com.selfwork.intelligence.mapper.UserInfoPOMapper;
import com.selfwork.intelligence.mapper.UserRoleRelationPOMapper;
import com.selfwork.intelligence.model.po.PermissionInfoPO;
import com.selfwork.intelligence.model.po.RoleInfoPO;
import com.selfwork.intelligence.model.po.UserInfoPO;
import com.selfwork.intelligence.model.po.UserRoleRelationPO;
import com.selfwork.intelligence.model.vo.role.RoleInfoQueryVo;
import com.selfwork.intelligence.model.vo.role.RoleInfoVo;
import com.selfwork.intelligence.model.vo.user.TreeMenuVo;
import com.selfwork.intelligence.model.vo.user.UpdateUserRolesRequest;
import com.selfwork.intelligence.model.vo.user.UserQueryVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserBiz extends BaseBiz {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserInfoPOMapper userMapper;

    @Autowired
    private RoleInfoPOMapper roleMapper;

    @Autowired
    private PermissionInfoPOMapper permissionMapper;

    @Autowired
    private PasswordHelper passwordHelper;

    @Autowired
    private UserRoleRelationPOMapper userRoleRelationPOMapper;

    //是否为游客账户
    public long touristRolsCount(Integer userid) {
        List<RoleInfoPO> roleInfoPOS = getRolesByUserId(userid);
        if (!CollectionUtils.isEmpty(roleInfoPOS)) {
            return roleInfoPOS.stream().filter(role -> "gust".equals(role.getRolecode())).count();
        } else {
            return 0;
        }
    }

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
        } catch (Exception e) {
            logger.error("从数据库获取对应用户名密码的用户失败", e);
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
        this.startPage(queryVo);
        List<UserInfoPO> list = userMapper.findList(queryVo);
        if (null == list || list.size() == 0) {
            logger.error("获取用户分页信息失败");
            return null;
        }

        return new PageInfo<>(list);
    }

    //获取用户已有角色Id
    public List<Integer> getRolesIDListByUserId(Integer userid) {

        List<Integer> result = new ArrayList<>();

        try {

            List<RoleInfoPO> res = this.getRolesByUserId(userid);

            if (!CollectionUtils.isEmpty(res)) {

                res.forEach(m -> {
                    result.add(m.getRoleid());
                });

            } else {
                logger.error("获取用户已有角色失败");
            }
        } catch (Exception e) {
            logger.error("获取用户已有角色失败", e);
        }

        return result;
    }

    //获取所有可用角色
    public List<RoleInfoVo> getAllValidRoles(Integer userid) {

        try {

            List<Integer> userRolesIds = this.getRolesIDListByUserId(userid);

            RoleInfoQueryVo vo = new RoleInfoQueryVo();
            vo.setValid(true);
            List<RoleInfoPO> list = roleMapper.findList(vo);
            if (CollectionUtils.isEmpty(list)) {
                return null;
            } else {
                return list.parallelStream().map(m -> {
                    RoleInfoVo item = new RoleInfoVo();
                    BeanUtils.copy(m, item);
                    item.setChecked(this.isRoleOfUser(userRolesIds, m.getRoleid()) ? "checked" : "");
                    return item;
                }).collect(Collectors.toList());
            }
        } catch (Exception e) {
            logger.error("获取所有可用角色失败", e);
            return null;
        }
    }

    private boolean isRoleOfUser(List<Integer> userRolesIds, Integer roleId) {
        return CollectionUtils.isEmpty(userRolesIds) ? false : userRolesIds.stream().filter(m -> m.equals(roleId)).count() > 0;
    }


    /**
     * 更新用户角色
     **/
    @Transactional
    public void updateUserRoles(UpdateUserRolesRequest request) throws Exception {


        if (request == null || CollectionUtils.isEmpty(request.getRoles())) {
            return;
        }

        userRoleRelationPOMapper.deleteByUserId(request.getUserId());

        request.getRoles().forEach(m -> {

            UserRoleRelationPO record = new UserRoleRelationPO();
            record.setCreatetime(new Date());
            record.setCreateuserid(request.getCreateUserId());
            record.setRoleid(m.getRoleid());
            record.setUserid(request.getUserId());
            userRoleRelationPOMapper.insertSelective(record);
        });


    }

    /**
     * create treeMenu by permission
     *
     * @param permissionInfoPO
     * @return
     */
    private TreeMenuVo createTreeMenu(PermissionInfoPO permissionInfoPO) {
        TreeMenuVo dto = new TreeMenuVo();
        dto.setId(permissionInfoPO.getPermissionid());
        dto.setName(permissionInfoPO.getPermissionname());
        dto.setProductCode(permissionInfoPO.getProductcode());
        dto.setUrl(permissionInfoPO.getMenuurl());
        dto.setParentId(permissionInfoPO.getParentid());
        dto.setIcon(permissionInfoPO.getMenuicon());
        return dto;
    }

    /**
     * 获取用户权限菜单
     *
     * @param userId
     * @return
     */

    public List<TreeMenuVo> findTreeMenuByUserId(Integer userId, Integer permissionType) {
        List<TreeMenuVo> menuList = new ArrayList<>();
        LinkedHashMap<String, TreeMenuVo> menuMap = new LinkedHashMap<>();
        // 获取用户所有权限
        List<PermissionInfoPO> permissionList = permissionMapper.listByUserId(userId, permissionType);
        if (CollectionUtils.isEmpty(permissionList)) {
            return menuList;
        }

        // 组建菜单树
        permissionList.stream().forEach(permissionInfoPO -> {
            if (null == permissionInfoPO.getParentid()) {
                TreeMenuVo dto = createTreeMenu(permissionInfoPO);
                menuMap.put(String.valueOf(dto.getId()), dto);
            } else {
                Integer parentId = permissionInfoPO.getParentid();
                TreeMenuVo parentDto = menuMap.get(String.valueOf(parentId));

                TreeMenuVo dto = createTreeMenu(permissionInfoPO);
                if (null != parentDto) {
                    if (CollectionUtils.isEmpty(parentDto.getChild())) {
                        List<TreeMenuVo> childList = new ArrayList<>();
                        childList.add(dto);
                        parentDto.setChild(childList);
                    } else {
                        parentDto.getChild().add(dto);
                    }

                } else {
                    menuMap.put(String.valueOf(dto.getId()), dto);
                }
            }
        });


        if (menuMap.size() == 0) {
            return menuList;
        } else {
            menuMap.forEach((treeId, treeMenuDto) -> {
                menuList.add(treeMenuDto);
            });
        }

        return menuList;
    }

}

