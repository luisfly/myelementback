package com.netback.myelementback.Entity;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {

    private int nUserId;
    private String sUserNO;
    private String sUserName;
    private String sPassword;
    private Date dLastLoginDate;
    private Date dCreateDate;

}
