package com.demo.common.exception;

/**
 * 自定义异常
 */
public class GlobleException extends RuntimeException {

    /** */
    private static final long serialVersionUID = 1L;

    /** 成功 */
    public static final int   SUCCESS          = 200;

    /** 请求错误 */
    public static final int   ERROR            = 400;

    /** 未授权 */
    public static final int   UNAUTHORIZED     = 401;

    private String            errorCode;

    private int               responseCode;

    private Object[]          args;

    public GlobleException(String errorCode) {
        this(errorCode, ERROR);
    }

    public GlobleException(String errorCode, Object[] args) {
        this(errorCode, ERROR, args);
    }

    public GlobleException(String errorCode, String arg) {
        this(errorCode, ERROR, new Object[] { arg });
    }

    public GlobleException(String errorCode, int responseCode) {
        this(errorCode, responseCode, null);
    }

    public GlobleException(String errorCode, int responseCode, Object[] args) {
        super();
        this.errorCode = errorCode;
        this.responseCode = responseCode;
        this.args = args;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public Object[] getArgs() {
        return args;
    }

    public void setArgs(Object[] args) {
        this.args = args;
    }

}
