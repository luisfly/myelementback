package com.netback.myelementback.Entity;

import org.apache.ibatis.annotations.Mapper;

import java.io.Serializable;
import java.util.Date;

public class Article implements Serializable {

    private int nUserId;
    private String sArticle;
    private String sCreateUser;
    private String sChangeUser;
    private Date dCreateDate;
    private Date dChangeDate;
    private Date dLastUpdateTime;
    private int nRankID;

    public int getnUserId() {
        return nUserId;
    }

    public void setnUserId(int nUserId) {
        this.nUserId = nUserId;
    }

    public String getsArticle() {
        return sArticle;
    }

    public void setsArticle(String sArticle) {
        this.sArticle = sArticle;
    }

    public String getsCreateUser() {
        return sCreateUser;
    }

    public void setsCreateUser(String sCreateUser) {
        this.sCreateUser = sCreateUser;
    }

    public String getsChangeUser() {
        return sChangeUser;
    }

    public void setsChangeUser(String sChangeUser) {
        this.sChangeUser = sChangeUser;
    }

    public Date getdCreateDate() {
        return dCreateDate;
    }

    public void setdCreateDate(Date dCreateDate) {
        this.dCreateDate = dCreateDate;
    }

    public Date getdChangeDate() {
        return dChangeDate;
    }

    public void setdChangeDate(Date dChangeDate) {
        this.dChangeDate = dChangeDate;
    }

    public Date getdLastUpdateTime() {
        return dLastUpdateTime;
    }

    public void setdLastUpdateTime(Date dLastUpdateTime) {
        this.dLastUpdateTime = dLastUpdateTime;
    }

    public int getnRankID() {
        return nRankID;
    }

    public void setnRankID(int nRankID) {
        this.nRankID = nRankID;
    }
}
