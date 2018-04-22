package com.selfwork.intelligence.common.enums;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public enum OperatorTypeEnum implements BaseEnum<OperatorTypeEnum, Integer>{
    APPLY(1, "申请入库"),
    COMPLETE(2, "入库完成"),
    AUDIT(3, "审核通过"),
    CANCEL(4, "撤销入库"),;

    static Map<Integer, OperatorTypeEnum> dataMap = new HashMap<>();

    static {
        Arrays.stream(OperatorTypeEnum.values()).forEach(en -> dataMap.put(en.getValue(), en));
    }

    private Integer value;
    private String displayName;

    OperatorTypeEnum(Integer value, String displayName) {
        this.value = value;
        this.displayName = displayName;
    }

    public static OperatorTypeEnum getEnum(Integer value) {
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
