package com.selfwork.intelligence.model;

public class DataSetDescPO {
    private Integer id;

    private String datasetCode;

    private String content;

    private String datasetName;

    public String getDatasetName() {
        return datasetName;
    }

    public void setDatasetName(String datasetName) {
        this.datasetName = datasetName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDatasetCode() {
        return datasetCode;
    }

    public void setDatasetCode(String datasetCode) {
        this.datasetCode = datasetCode == null ? null : datasetCode.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}