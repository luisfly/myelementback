package com.netback.myelementback.Entity;

import java.io.Serializable;
import java.util.Date;

public class Video implements Serializable {
    private int nId;
    private String sVideoName;
    private String sUserNO;
    private String sCreateUser;
    private Date dCreateDate;
    private int nTag;
    private String sVideoPath;

    public int getnId() {
        return nId;
    }

    public void setnId(int nId) {
        this.nId = nId;
    }

    public String getsVideoName() {
        return sVideoName;
    }

    public void setsVideoName(String sVideoName) {
        this.sVideoName = sVideoName;
    }

    public String getsUserNO() {
        return sUserNO;
    }

    public void setsUserNO(String sUserNO) {
        this.sUserNO = sUserNO;
    }

    public String getsCreateUser() {
        return sCreateUser;
    }

    public void setsCreateUser(String sCreateUser) {
        this.sCreateUser = sCreateUser;
    }

    public Date getdCreateDate() {
        return dCreateDate;
    }

    public void setdCreateDate(Date dCreateDate) {
        this.dCreateDate = dCreateDate;
    }

    public int getnTag() {
        return nTag;
    }

    public void setnTag(int nTag) {
        this.nTag = nTag;
    }

    public String getsVideoPath() {
        return sVideoPath;
    }

    public void setsVideoPath(String sVideoPath) {
        this.sVideoPath = sVideoPath;
    }
}
