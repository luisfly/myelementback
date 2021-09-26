package com.netback.myelementback.Utils;

import lombok.Data;

/**
 * 响应体实体类
 */

// @Data
public class ResponseEntity<T> {
    private boolean result;
    private int code;
    private String message;
    private T data;

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
