package com.selfwork.intelligence.model.bo;

import java.util.List;

/**
 * Created by zzc on 2018/5/3.
 */
public class ColumnRules {
    private String name;
    private List<Rule> ruleList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Rule> getRuleList() {
        return ruleList;
    }

    public void setRuleList(List<Rule> ruleList) {
        this.ruleList = ruleList;
    }
}
