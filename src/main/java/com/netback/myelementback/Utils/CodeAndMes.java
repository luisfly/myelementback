package com.netback.myelementback.Utils;

public enum CodeAndMes {
    SUCCESS(20000, "SUCCESS"),
    ILLEAGETOKEN(50008, "ILLEAGETOKEN"),
    OTHERCLIENTLOGIN(50012, "OTHERCLIENTLOGIN"),
    TOKENEXPIRED(50014, "TOKENEXPIRED");

    private int code;
    private String msg;

    CodeAndMes(int code, String msg) {
        this.code= code;
        this.msg = msg;
    }
}
