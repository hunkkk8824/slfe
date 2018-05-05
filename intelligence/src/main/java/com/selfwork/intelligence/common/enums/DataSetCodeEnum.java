package com.selfwork.intelligence.common.enums;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public enum DataSetCodeEnum implements BaseEnum<DataSetCodeEnum, String> {

    SCOUT_QB_TABLE_BD("scout_qb_table_bd", "动向情报表"),
    QB_SJ_YSMB("qb_sj_ysmb", "情报数据原始目标报表"),
    QB_SJ_YSDZZTMMB("qb_sj_ysdzztmmb", "情报_数据_原始电子战通信目标"),
    QB_SJ_YSDZZJGMB("qb_sj_ysdzzjgmb", "情报_数据_原始电子战激光目标"),
    QB_SJ_YSDZZDZZCMB("qb_sj_ysdzzdzzcmb", "情报_数据_电子战电子侦察目标表"),
    QB_SJ_RHMB("qb_sj_rhmb", "情报_数据_融合目标表"),
    QB_SJ_RGMB("qb_sj_rgmb", "情报_数据_人工目标"),
    QB_SJ_MYB("qb_sj_myb", "情报_数据_密语表"),
    QB_SJ_JZTSMB("qb_sj_jztsmb", "情报_数据_技侦态势目标"),
    QB_SJ_DPTSSMB("qb_sj_dptssmb", "情报_数据_多平台水声目标"),
    QB_SJ_DPTDZZMB("qb_sj_dptdzzmb", "情报_数据_多平台电子战目标"),

    ;

    static Map<String, DataSetCodeEnum> dataMap = new HashMap<>();

    static {
        Arrays.stream(DataSetCodeEnum.values()).forEach(en -> dataMap.put(en.getValue(), en));
    }

    private String value;
    private String displayName;

    DataSetCodeEnum(String value, String displayName) {
        this.value = value;
        this.displayName = displayName;
    }

    public static DataSetCodeEnum getEnum(String value) {
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
