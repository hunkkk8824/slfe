package com.selfwork.intelligence.common.enums;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public enum ShipTypeEnum implements BaseEnum<ShipTypeEnum, Integer>{

    ZYC(3, "作业船"),
    GSL(4, "高速轮"),
    TL(5, "拖轮"),
    KL(6, "客轮"),
    HL(7, "货轮"),
    YL(8, "油轮"),
    ;

    static Map<Integer, ShipTypeEnum> dataMap = new HashMap<>();

    static {
        Arrays.stream(ShipTypeEnum.values()).forEach(en -> dataMap.put(en.getValue(), en));
    }

    private Integer value;
    private String displayName;

    ShipTypeEnum(Integer value, String displayName) {
        this.value = value;
        this.displayName = displayName;
    }

    public static ShipTypeEnum getEnum(Integer value) {
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
