package com.selfwork.intelligence.model.vo.dateset;

import com.selfwork.intelligence.model.vo.BaseQueryVo;

/**
 * Created by zzc on 2018/6/10.
 */
public class QueryVo extends BaseQueryVo{

    private String tableName;
    /**
     * 传感器编号
     */
    private String cgqbh;
    /**
     * 平台编号、平台名称
     */
    private String ptbh;
    /**
     * 平台类型 （有些表没有此字段）
     */
    private Integer ptlx;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getCgqbh() {
        return cgqbh;
    }

    public void setCgqbh(String cgqbh) {
        this.cgqbh = cgqbh;
    }

    public String getPtbh() {
        return ptbh;
    }

    public void setPtbh(String ptbh) {
        this.ptbh = ptbh;
    }

    public Integer getPtlx() {
        return ptlx;
    }

    public void setPtlx(Integer ptlx) {
        this.ptlx = ptlx;
    }
}
