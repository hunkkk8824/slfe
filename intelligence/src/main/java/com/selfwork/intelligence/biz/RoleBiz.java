package com.selfwork.intelligence.biz;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.selfwork.intelligence.common.BeanUtils;
import com.selfwork.intelligence.mapper.PermissionInfoPOMapper;
import com.selfwork.intelligence.mapper.RoleInfoPOMapper;
import com.selfwork.intelligence.mapper.RolePermissionRelationPOMapper;
import com.selfwork.intelligence.model.po.PermissionInfoPO;
import com.selfwork.intelligence.model.po.RoleInfoPO;
import com.selfwork.intelligence.model.po.RolePermissionRelationPO;
import com.selfwork.intelligence.model.po.UserInfoPO;
import com.selfwork.intelligence.model.vo.permission.PermissionVo;
import com.selfwork.intelligence.model.vo.role.RoleInfoQueryVo;
import com.selfwork.intelligence.model.vo.role.UpdateRolePermissionsRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.util.stream.Collectors;

@Service
public class RoleBiz extends BaseBiz {
    public final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private RoleInfoPOMapper roleMapper;

    @Autowired
    private PermissionInfoPOMapper permissionInfoPOMapper;

    @Autowired
    private RolePermissionRelationPOMapper rolePermissionRelationPOMapper;
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
     * 保存
     *
     * @param currentUser
     */
    public int save(RoleInfoPO role, UserInfoPO currentUser) {

        role.setCreateuserid(String.valueOf(currentUser.getUserid()));
        role.setCreatetime(new Date());
        return roleMapper.insertSelective(role);
    }

    //获取角色已有权限Id
    public List<Integer> getPermissionsIDListByRoleId(Integer roleId) {

        List<Integer> result = new ArrayList<>();

        try {

            List<PermissionInfoPO> res = permissionInfoPOMapper.getPermissionsByRoleId(roleId);

            if (!CollectionUtils.isEmpty(res)) {

                res.forEach(m -> {
                    result.add(m.getPermissionid());
                });

            } else {
                logger.error("获取用户已有角色失败");
            }
        } catch (Exception e) {
            logger.error("获取用户已有角色失败", e);
        }

        return result;
    }

    //获取所有可用权限
    public List<PermissionVo> getAllValidPermissions(Integer userid) {

        try {

            List<Integer> rolePermissionsIds = this.getPermissionsIDListByRoleId(userid);

            RoleInfoQueryVo vo = new RoleInfoQueryVo();
            vo.setValid(true);
            List<PermissionInfoPO> list = permissionInfoPOMapper.findValidList(vo);
            if (CollectionUtils.isEmpty(list)) {
                return null;
            } else {
                return list.parallelStream().map(m -> {
                    PermissionVo item = new PermissionVo();
                    BeanUtils.copy(m, item);
                    item.setChecked(this.isPermissionOfRole(rolePermissionsIds, m.getPermissionid()) ? "checked" : "");
                    return item;
                }).collect(Collectors.toList());
            }
        } catch (Exception e) {
            logger.error("获取所有可用角色失败", e);
            return null;
        }
    }

    private boolean isPermissionOfRole(List<Integer> userRolesIds, Integer roleId) {
        return CollectionUtils.isEmpty(userRolesIds) ? false : userRolesIds.stream().filter(m -> m.equals(roleId)).count() > 0;
    }


    /**
     * 更新角色权限
     **/
    @Transactional
    public void updateRolePermissions(UpdateRolePermissionsRequest request) throws Exception {


        if (request == null || CollectionUtils.isEmpty(request.getPermissions())) {
            return;
        }

        rolePermissionRelationPOMapper.deleteByRoleId(request.getRoleId());

        request.getPermissions().forEach(m -> {

            RolePermissionRelationPO record = new RolePermissionRelationPO();
            record.setCreatetime(new Date());
            record.setCreateuserid(request.getCreateUserId());
            record.setPermissionid(m.getPermissionid());
            record.setRoleid(request.getRoleId());
            rolePermissionRelationPOMapper.insertSelective(record);
        });


    }


}
