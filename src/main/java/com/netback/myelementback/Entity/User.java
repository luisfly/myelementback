package com.netback.myelementback.Entity;

import org.apache.ibatis.annotations.Mapper;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {

    private int nUserId;
    private String sUserNO;
    private String sUserName;
    private String sPassword;
    private Date dLastLoginDate;
    private Date dCreateDate;

    public int getnUserId() {
        return nUserId;
    }

    public void setnUserId(int nUserId) {
        this.nUserId = nUserId;
    }

    public String getsUserNO() {
        return sUserNO;
    }

    public void setsUserNO(String sUserNO) {
        this.sUserNO = sUserNO;
    }

    public String getsUserName() {
        return sUserName;
    }

    public void setsUserName(String sUserName) {
        this.sUserName = sUserName;
    }

    public String getsPassword() {
        return sPassword;
    }

    public void setsPassword(String sPassword) {
        this.sPassword = sPassword;
    }

    public Date getdLastLoginDate() {
        return dLastLoginDate;
    }

    public void setdLastLoginDate(Date dLastLoginDate) {
        this.dLastLoginDate = dLastLoginDate;
    }

    public Date getdCreateDate() {
        return dCreateDate;
    }

    public void setdCreateDate(Date dCreateDate) {
        this.dCreateDate = dCreateDate;
    }
}
