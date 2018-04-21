package com.selfwork.intelligence.common.enums;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public enum ImportStatusEnum implements BaseEnum<ImportStatusEnum, Integer> {

    //0 未入库1 预入库2 入库成功3 入库失败'
    UnAssessed(0, "未入库"),
    Difference(1, "预入库"),
    Good(2, "入库成功"),
    Excellent(3, "入库失败"),;

    static Map<Integer, ImportStatusEnum> dataMap = new HashMap<>();

    static {
        Arrays.stream(ImportStatusEnum.values()).forEach(en -> dataMap.put(en.getValue(), en));
    }

    private Integer value;
    private String displayName;

    ImportStatusEnum(Integer value, String displayName) {
        this.value = value;
        this.displayName = displayName;
    }

    public static ImportStatusEnum getEnum(Integer value) {
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
