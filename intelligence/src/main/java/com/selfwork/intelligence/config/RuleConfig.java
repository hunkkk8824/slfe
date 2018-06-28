package com.selfwork.intelligence.config;

import com.alibaba.fastjson.JSONReader;
import com.selfwork.intelligence.model.bo.ColumnRules;
import com.selfwork.intelligence.model.bo.Rule;
import com.selfwork.intelligence.model.bo.TableRules;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zzc on 2018/5/3.
 */
@Component
public class RuleConfig {

    private final Logger logger = LoggerFactory.getLogger(RuleConfig.class);

    private ArrayList<File> fileList = new ArrayList<>();

    private Map<String, TableRules> tableRulesMap = new HashMap<>();


    public RuleConfig() {
        URL resource = ClassLoader.getSystemResource("rule");
        if (resource != null) {
            // 加载文件
            String path = resource.getPath();
            loadFile(path);
            // 解析规则
            parseFile(fileList);
        }
    }


    private void parseFile(ArrayList<File> fileList) {
        if (CollectionUtils.isEmpty(fileList)) {
            return;
        }

        for (File file : fileList) {

            String tableName = file.getName().split("\\.")[0];
            TableRules tableRules = new TableRules();
            tableRules.setName(tableName);
            Map<String, ColumnRules> columnRulesMap = new HashMap<>();
            tableRules.setColumnRulesMap(columnRulesMap);
            tableRulesMap.put(tableName, tableRules);
            try {
                JSONReader reader = new JSONReader(new FileReader(file));
                reader.startObject();
                while (reader.hasNext()) {
                    String column = reader.readString();
                    ColumnRules colunmRules = new ColumnRules();
                    colunmRules.setName(column);
                    List<Rule> ruleList = new ArrayList<>();
                    colunmRules.setRuleList(ruleList);
                    columnRulesMap.put(column, colunmRules);
                    reader.startArray();
                    while (reader.hasNext()) {
                        Rule rule = new Rule();
                        reader.startObject();
                        while (reader.hasNext()) {
                            String key = reader.readString();
                            String value = reader.readObject().toString();
                            if ("rule".equals(key)) {
                                rule.setRule(value);
                            } else if ("value".equals(key)) {
                                rule.setValue(value);
                            } else if ("message".equals(key)) {
                                rule.setMessage(value);
                            }
                        }
                        reader.endObject();
                        ruleList.add(rule);
                    }
                    reader.endArray();
                }
                reader.endObject();
            } catch (FileNotFoundException e) {
                logger.error("规则文件读取异常，file:" + file.getName(), e);
            }
        }
    }


    public void loadFile(String filepath) {
        File file = new File(filepath);
        if (!file.isDirectory()) {
            fileList.add(file);
        } else if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File fileIndex : files) {
                //如果这个文件是目录，则进行递归搜索
                if (fileIndex.isDirectory()) {
                    loadFile(fileIndex.getPath());
                } else {
                    //如果文件是普通文件，则将文件句柄放入集合
                    fileList.add(fileIndex);
                }
            }
        }
    }

    public Map<String, TableRules> getTableRulesMap() {
        return tableRulesMap;
    }

    public void setTableRulesMap(Map<String, TableRules> tableRulesMap) {
        this.tableRulesMap = tableRulesMap;
    }
}
