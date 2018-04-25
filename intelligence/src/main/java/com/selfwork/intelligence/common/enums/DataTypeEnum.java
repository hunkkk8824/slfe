package com.selfwork.intelligence.common.enums;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zzc on 2018/4/25.
 */
public enum DataTypeEnum implements BaseEnum<DataTypeEnum, Integer> {

    MYSQL(0, "MYSQL"),
    ORACLE(1, "ORACLE"),
    SQLSERVER(2, "SQLSERVER"),
    ;

    static Map<Integer, DataTypeEnum> dataMap = new HashMap<>();

    static {
        Arrays.stream(DataTypeEnum.values()).forEach(en -> dataMap.put(en.getValue(), en));
    }

    private Integer value;
    private String displayName;

    DataTypeEnum(Integer value, String displayName) {
        this.value = value;
        this.displayName = displayName;
    }

    public static DataTypeEnum getEnum(Integer value) {
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
