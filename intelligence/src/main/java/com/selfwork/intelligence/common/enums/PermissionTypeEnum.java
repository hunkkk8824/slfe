package com.selfwork.intelligence.common.enums;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public enum PermissionTypeEnum implements BaseEnum<PermissionTypeEnum,Integer>{
    MENU_PERMISSION(1, "菜单权限"),
    BUTTON_PERMISSION(2, "普通权限"),
    APP_PERMISSION(3, "APP权限"),
    ;

    static Map<Integer, PermissionTypeEnum> dataMap = new HashMap<>();

    static {
        Arrays.stream(PermissionTypeEnum.values()).forEach(en -> dataMap.put(en.getValue(), en));
    }

    private Integer value;
    private String displayName;

    PermissionTypeEnum(Integer value, String displayName) {
        this.value = value;
        this.displayName = displayName;
    }

    public static PermissionTypeEnum getEnum(Integer value) {
        return dataMap.get(value);
    }

    @Override
    public Integer getValue() {
        return this.value;
    }

    @Override
    public String getDisplayName() {
        return this.displayName;
    }
}