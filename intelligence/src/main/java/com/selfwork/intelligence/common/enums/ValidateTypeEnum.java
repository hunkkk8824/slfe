package com.selfwork.intelligence.common.enums;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zzc on 2018/5/5.
 */
public enum ValidateTypeEnum implements BaseEnum<ValidateTypeEnum, String>{
    REQUIRE("require","是否必须"),
    MIN_LENGTH("MIN_LENGTH", "最小长度"),
    MAX_LENGTH("MAX_LENGTH", "最大长度"),
            ;

    static Map<String, ValidateTypeEnum> dataMap = new HashMap<>();

    static {
        Arrays.stream(ValidateTypeEnum.values()).forEach(en -> dataMap.put(en.getValue(), en));
    }

    private String value;
    private String displayName;

    ValidateTypeEnum(String value, String displayName) {
        this.value = value;
        this.displayName = displayName;
    }

    public static ValidateTypeEnum getEnum(Integer value) {
        return dataMap.get(value);
    }

    @Override
    public String getValue() {
        return this.value;
    }

    @Override
    public String getDisplayName() {
        return this.displayName;
    }
}
