package com.netback.myelementback.Utils;

/**
 * 自定义异常
 */
public class UserDefinedException extends RuntimeException{
    private CodeAndMsg exception;

    public UserDefinedException(CodeAndMsg exception) {
        this.exception = exception;
    }

    public CodeAndMsg getException() {
        return exception;
    }

    public void setException(CodeAndMsg exception) {
        this.exception = exception;
    }
}
