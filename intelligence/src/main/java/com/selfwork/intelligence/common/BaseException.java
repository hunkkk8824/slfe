package com.selfwork.intelligence.common;

import com.selfwork.intelligence.common.enums.ResponseCodeTypeEnum;

public class BaseException extends RuntimeException {

    private static final long serialVersionUID = 4157900797943364227L;
	/*-----------------------------------------  parameters  -----------------------------------------*/

    /**
     *
     */
    private String code = ResponseCodeTypeEnum.CODE_ERROR.getValue();


    private String message = ResponseCodeTypeEnum.CODE_ERROR.getValue();


    private Throwable throwable;

    /*----------------------------------------  constructors  ----------------------------------------*/
    public BaseException() {
    }

    public BaseException(String message) {
        this.message = message;
    }

    public BaseException(String code, String message) {
        this.code = code;
        this.message = message;
    }



    public BaseException(String code, String message, Throwable throwable) {
        this.code = code;
        this.message = message;
        this.throwable = throwable;
    }


    public static BaseException valueOf(String code, String message, Throwable throwable) {
        return new BaseException(code, message, throwable);
    }

    public String throwMessage() {
        return "[batchStock error] code=" + this.getCode() + ";message=" + this.getMessage() + ";";
    }

	/*-----------------------------------------  get && set  -----------------------------------------*/
    /**
     * @return 异常码
     */
    public String getCode() {
        return code;
    }

    /**
     * @param 异常码
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return 异常提示信息
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param 异常提示信息
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * @return 异常，可选
     */
    public Throwable getThrowable() {
        return throwable;
    }

    /**
     * @param 异常，可选
     */
    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }
}