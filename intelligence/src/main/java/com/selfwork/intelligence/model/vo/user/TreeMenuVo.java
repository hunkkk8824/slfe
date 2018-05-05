package com.selfwork.intelligence.model.vo.user;


import com.selfwork.intelligence.model.po.PermissionInfoPO;

import java.util.List;

public class TreeMenuVo  {
    /**
     * permission id
     */
    private Integer id;

    /**
     * permission 菜单名称
     */
    private String name;

    /**
     * permission 菜单路径
     */
    private String url;

    /**
     * permission 产品编码
     */
    private String productCode;

    /**
     * 图标 （class）
     */
    private String icon;

    /**
     * 父id
     */
    private Integer parentId;

    /**
     * permission 子菜单
     */
    private List<TreeMenuVo> child;


    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public List<TreeMenuVo> getChild() {
        return child;
    }

    public void setChild(List<TreeMenuVo> child) {
        this.child = child;
    }

    public TreeMenuVo valueOf(PermissionInfoPO permissionInfoPO) {
        this.setId(permissionInfoPO.getPermissionid());
        this.setName(permissionInfoPO.getPermissionname());
        this.setProductCode(permissionInfoPO.getProductcode());
        this.setUrl(permissionInfoPO.getMenuurl());
        this.setIcon(permissionInfoPO.getMenuicon());
        return this;
    }
}
