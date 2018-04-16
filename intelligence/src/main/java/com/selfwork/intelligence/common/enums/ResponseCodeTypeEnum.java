package com.selfwork.intelligence.common.enums;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public enum ResponseCodeTypeEnum implements BaseEnum<ResponseCodeTypeEnum, String> {

    SUCCESS("0", "成功", ""),
    FAIL("-1", "系统繁忙", ""),
    EXCEPTION_SYSTEM_INNER_ERROR("0005", "系统繁忙", "系统内部异常"),
    CODE_ERROR("0005", "系统繁忙", ""),
    DATABASE_EXCEPTION("0005", "系统繁忙", "数据库操作异常"),
    ES_ERROR("0005", "系统繁忙", "ES查询异常"),
    /**
     * 基础模块
     */
    SIGN_CHECK_FAIL("0001", "验签失败", ""),
    NULL_RESULT("0002", "结果为空", ""),
    PARAMETER_ERROR("0003", "参数有误", ""),
    ILLEGAL_ACCESS("0004", "非法访问", ""),
    EXCEPTION("0005", "系统繁忙", ""),
    /**
     * 用户模块
     */
    USERNAME_PASSWORD_ERROR("0100", "用户名或密码错误", ""),
    FORBIDDEN("0101", "没有权限", ""),
    USER_TIME_OUT("0102", "用户超时", ""),
    USER_TICK_OUT("0103", "该用户已在其他地方登录", ""),
    USERNAME_PASSWORD_EMPTY("0104", "用户名或密码不能为空", ""),
    CHANGE_OTHER_PASSWORD("0105", "不能修改他人的密码", ""),
    OLD_PASSWORD_ERROR("0106", "原密码错误", ""),

    /**
     * 报表模块
     */
    NOT_COMPANY_USER("0200", "不是企业用户无法访问", "")

    ;


    static Map<String, ResponseCodeTypeEnum> dataMap = new HashMap<>();

    static {
        Arrays.stream(ResponseCodeTypeEnum.values()).forEach(en -> dataMap.put(en.getValue(), en));
    }

    private String value;
    private String displayName;
    private String desc;

    ResponseCodeTypeEnum(String value, String displayName, String desc) {
        this.value = value;
        this.displayName = displayName;
        this.desc = desc;
    }

    public static ResponseCodeTypeEnum getEnum(String value) {
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

    public String getDesc() {
        return desc;
    }
}
