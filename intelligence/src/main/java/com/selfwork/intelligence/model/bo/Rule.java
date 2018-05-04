package com.selfwork.intelligence.model.bo;

/**
 * Created by zzc on 2018/5/3.
 */
public class Rule {
    /**
     * 规则名称
     */
    private String rule;
    /**
     * 规则取值
     */
    private String value;
    /**
     * 违反规则秒速
     */
    private String message;

    public String getRule() {
        return rule;
    }

    public void setRule(String rule) {
        this.rule = rule;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Rule{" +
                "rule='" + rule + '\'' +
                ", value='" + value + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
