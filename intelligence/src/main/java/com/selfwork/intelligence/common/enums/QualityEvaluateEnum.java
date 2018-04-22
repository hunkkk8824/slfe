package com.selfwork.intelligence.common.enums;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public enum QualityEvaluateEnum implements BaseEnum<QualityEvaluateEnum, Integer> {

    //'质量评定：0 未评定1 差2 良3 优',
    UnAssessed(0, "未评定"),
    Difference(1, "差"),
    Good(2, "良"),
    Excellent(3, "优"),;

    static Map<Integer, QualityEvaluateEnum> dataMap = new HashMap<>();

    static {
        Arrays.stream(QualityEvaluateEnum.values()).forEach(en -> dataMap.put(en.getValue(), en));
    }

    private Integer value;
    private String displayName;

    QualityEvaluateEnum(Integer value, String displayName) {
        this.value = value;
        this.displayName = displayName;
    }

    public static QualityEvaluateEnum getEnum(Integer value) {
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
