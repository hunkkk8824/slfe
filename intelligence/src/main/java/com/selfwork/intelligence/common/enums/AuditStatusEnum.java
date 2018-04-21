package com.selfwork.intelligence.common.enums;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public enum AuditStatusEnum implements BaseEnum<AuditStatusEnum, Integer> {

    //审核状态：0 待审核 1 已审核 2 已驳回
    Unaudited(0, "待审核"),
    Audited(1, "已审核"),
    Dismissal(2, "已驳回"),;

    static Map<Integer, AuditStatusEnum> dataMap = new HashMap<>();

    static {
        Arrays.stream(AuditStatusEnum.values()).forEach(en -> dataMap.put(en.getValue(), en));
    }

    private Integer value;
    private String displayName;

    AuditStatusEnum(Integer value, String displayName) {
        this.value = value;
        this.displayName = displayName;
    }

    public static AuditStatusEnum getEnum(Integer value) {
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
