package com.selfwork.intelligence.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.selfwork.intelligence.common.enums.DataSetCodeEnum;
import com.selfwork.intelligence.common.enums.ValidateTypeEnum;
import com.selfwork.intelligence.model.bo.ColumnRules;
import com.selfwork.intelligence.model.bo.Rule;
import com.selfwork.intelligence.model.bo.TableRules;
import com.selfwork.intelligence.model.bo.ValidateResult;
import com.selfwork.intelligence.model.po.QbSjRhmbPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.NumberUtils;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by zzc on 2018/5/3.
 */
@Component
public class ValidateHandler {

    @Autowired
    private RuleConfig ruleConfig;

    public ValidateResult validate(String datasetCode,JSONObject jsonObject){
        ValidateResult result = new ValidateResult(true,null);

        Map<String,TableRules> tableRulesMap = ruleConfig.getTableRulesMap();
        if(tableRulesMap==null || tableRulesMap.size() == 0){
            return result;
        }

        if(Constant.QbSjRhmb.equals(datasetCode)){
            ValidateResult rt = validateByTable(Constant.QbSjRhmb,jsonObject, result, tableRulesMap);
            if (rt != null) return rt;
        }else{
            // TODO: 2018/5/5  other table validate
        }
        return null;
    }

    private ValidateResult validateByTable(String tableName,JSONObject jsonObject, ValidateResult result, Map<String, TableRules> tableRulesMap) {
        TableRules tableRules = tableRulesMap.get(tableName);
        if(tableRules == null){
            return result;
        }
        Map<String,ColumnRules> columnRulesMap = tableRules.getColumnRulesMap();
        if(columnRulesMap == null || columnRulesMap.size() == 0){
            return result;
        }

        Set<String> keySet = columnRulesMap.keySet();
        for (String key : keySet) {
            String columnValue = jsonObject.getString(key);
            ColumnRules value = columnRulesMap.get(key);
            // 默认不为空
            List<Rule> ruleList = value.getRuleList();
            for (Rule rule : ruleList) {
                ValidateResult rt = validateByRule(columnValue,rule);
                if(!rt.isPass()){
                    return rt;
                }
            }
        }else{
            // TODO: 2018/5/5  other table validate
        }
        return null;
    }

    private ValidateResult validateByRule(String columnValue, Rule rule) {
        if(ValidateTypeEnum.REQUIRE.getValue().equals(rule.getRule())){
            return validateRequire(columnValue,rule);
        }if(ValidateTypeEnum.MIN_LENGTH.getValue().equals(rule.getRule())){
            return validateMinLength(columnValue,rule);
        }if(ValidateTypeEnum.MAX_LENGTH.getValue().equals(rule.getRule())){
            return validateMaxLength(columnValue,rule);
        }else{
           // TODO: 2018/5/5  other rule
            return new ValidateResult(true,null);
        }
    }

    /**
     * 最大长度验证
     * @param columnValue
     * @param rule
     * @return
     */
    private ValidateResult validateMaxLength(String columnValue, Rule rule) {
        int maxLength = NumberUtils.parseNumber(rule.getValue(),Integer.class);
        int columnLength = columnValue.length();
        if(columnLength > maxLength){
            return new ValidateResult(false,rule.getMessage());
        }else {
            return new ValidateResult(true,null);
        }
    }

    /**
     * 最小长度验证
     * @param columnValue
     * @param rule
     * @return
     */
    private ValidateResult validateMinLength(String columnValue, Rule rule) {
        int minLength = NumberUtils.parseNumber(rule.getValue(),Integer.class);
        int columnLength = columnValue.length();
        if(columnLength < minLength){
            return new ValidateResult(false,rule.getMessage());
        }else {
            return new ValidateResult(true,null);
        }
    }

    /**
     * 非空验证
     * @param columnValue
     * @param rule
     * @return
     */
    private ValidateResult validateRequire(String columnValue, Rule rule) {
        if("true".equals(rule.getValue())){
            if(StringUtils.isEmpty(columnValue)){
                return new ValidateResult(false,rule.getMessage());
            }else{
                return new ValidateResult(true,null);
            }
        }else{
            return new ValidateResult(true,null);
        }
    }

}
