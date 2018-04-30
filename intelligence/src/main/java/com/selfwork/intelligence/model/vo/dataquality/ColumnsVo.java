package com.selfwork.intelligence.model.vo.dataquality;

public class ColumnsVo {

    public ColumnsVo(String field, String title) {
        this.field = field;
        this.title = title;
    }

    private String field;
    private String title;

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
