package com.selfwork.intelligence.model.vo;

public class BaseQueryVo<T> {

    /**
     * 记录条数
     */
    private Integer limit = 50;
    /**
     * 翻阅
     */
    private Integer offset = 0;

    /**
     * 排序方式
     */
    private String order ;

    /**
     * 排序字段
     */
    private String sort;

    private T queryDto;

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public T getQueryDto() {
        return queryDto;
    }

    public void setQueryDto(T queryDto) {
        this.queryDto = queryDto;
    }
}
