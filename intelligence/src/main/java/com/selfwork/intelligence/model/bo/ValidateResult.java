package com.selfwork.intelligence.model.bo;

/**
 * Created by zzc on 2018/5/5.
 */
public class ValidateResult {
    private boolean pass;
    private String message;

    public ValidateResult() {
    }

    public ValidateResult(boolean pass, String message) {
        this.pass = pass;
        this.message = message;
    }

    public boolean isPass() {
        return pass;
    }

    public void setPass(boolean pass) {
        this.pass = pass;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
