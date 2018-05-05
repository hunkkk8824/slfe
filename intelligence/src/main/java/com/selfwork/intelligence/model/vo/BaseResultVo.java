package com.selfwork.intelligence.model.vo;

/**
 * 基本结果Vo
 */
public class BaseResultVo {
    /**
     * 是否成功
     */
    private boolean isSuccessful;
    /**
     * 失败原因
     */
    private String errorMsg;

    public boolean isSuccessful() {
        return isSuccessful;
    }

    public void setSuccessful(boolean successful) {
        isSuccessful = successful;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
