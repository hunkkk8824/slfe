package com.selfwork.intelligence.model.bo;

import java.util.List;
import java.util.Map;

/**
 * Created by zzc on 2018/5/3.
 */
public class TableRules {
    private String name;
    private Map<String,ColumnRules> columnRulesMap;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, ColumnRules> getColumnRulesMap() {
        return columnRulesMap;
    }

    public void setColumnRulesMap(Map<String, ColumnRules> columnRulesMap) {
        this.columnRulesMap = columnRulesMap;
    }
}
