package com.selfwork.intelligence.model.vo.dataquality;


/**
 * 数量查询Vo
 */
public class QuantityQueryVo {
    /**
     * 数据集编码
     */
    private String dataSetCode;
    /**
     * 源前置机编码
     */
    private String sourceExchangerCode;
    /**
     * 开始时间
     */
    private String startTime;
    /**
     * 结束时间
     */
    private String endTime;

    public String getDataSetCode() {
        return dataSetCode;
    }

    public void setDataSetCode(String dataSetCode) {
        this.dataSetCode = dataSetCode;
    }

    public String getSourceExchangerCode() {
        return sourceExchangerCode;
    }

    public void setSourceExchangerCode(String sourceExchangerCode) {
        this.sourceExchangerCode = sourceExchangerCode;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
