package com.demo.common.param;

/**
 * Created by Duhuafei on 11/13/2017.
 */
public final class ResultBuilder<T> {
    private Result<T> result;

    private ResultBuilder() {
        result = new Result<>();
    }

    public static <T> ResultBuilder aResult() {
        return new ResultBuilder<T>();
    }

    public ResultBuilder withCode(int code) {
        result.setCode(code);
        return this;
    }

    public ResultBuilder withMessage(String message) {
        result.setMessage(message);
        return this;
    }

    public ResultBuilder withData(T data) {
        result.setData(data);
        return this;
    }

    public Result build() {
        return result;
    }

}
