package com.selfwork.intelligence.common.enums;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 航行状态
 */
public enum ShipStatusEnum implements BaseEnum<ShipStatusEnum, Integer> {
    DLHXZ(0, "动力航行中"),
    MB(1, "锚泊"),
    WSL(2, "未受令"),
    JDXSX(3, "机动性受限"),
    SCSXZ(4, "受吃水限制"),
    MLXB(5, "锚链系泊"),
    GQ(6, "搁浅"),
    BLZ(7, "捕捞中"),
    FFDLHX(8, "风帆动力航行"),
    ;

    static Map<Integer, ShipStatusEnum> dataMap = new HashMap<>();

    static {
        Arrays.stream(ShipStatusEnum.values()).forEach(en -> dataMap.put(en.getValue(), en));
    }

    private Integer value;
    private String displayName;

    ShipStatusEnum(Integer value, String displayName) {
        this.value = value;
        this.displayName = displayName;
    }

    public static ShipStatusEnum getEnum(Integer value) {
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
