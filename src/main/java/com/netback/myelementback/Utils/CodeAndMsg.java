package com.netback.myelementback.Utils;

public enum CodeAndMsg {
    SUCCESS(20000, "SUCCESS"),
    METHODFAIL(21000, "ENCOUNTER AN ERROR WHEN EXECUTE METHOD"),
    UNKNOWECEPTION(22000, "UNKNOWECEPTION"),
    ILLEAGETOKEN(50008, "ILLEAGETOKEN"),
    OTHERCLIENTLOGIN(50012, "OTHERCLIENTLOGIN"),
    TOKENEXPIRED(50014, "TOKENEXPIRED");

    private int code;
    private String msg;

    CodeAndMsg(int code, String msg) {
        this.code= code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
