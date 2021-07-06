package com.netback.myelementback.Entity;

import java.io.Serializable;

public class Radio implements Serializable {
    private int nId;
    private String sResourceName;
    private String sDescribe;
    private String sResTag;
    private int nCategory;
    private int nRelease;
    private String sPath;

    public String getsPath() {
        return sPath;
    }

    public void setsPath(String sPath) {
        this.sPath = sPath;
    }

    public int getnId() {
        return nId;
    }

    public void setnId(int nId) {
        this.nId = nId;
    }

    public String getsResourceName() {
        return sResourceName;
    }

    public void setsResourceName(String sResourceName) {
        this.sResourceName = sResourceName;
    }

    public String getsDescribe() {
        return sDescribe;
    }

    public void setsDescribe(String sDescribe) {
        this.sDescribe = sDescribe;
    }

    public String getsResTag() {
        return sResTag;
    }

    public void setsResTag(String sResTag) {
        this.sResTag = sResTag;
    }

    public int getnCategory() {
        return nCategory;
    }

    public void setnCategory(int nCategory) {
        this.nCategory = nCategory;
    }

    public int getnRelease() {
        return nRelease;
    }

    public void setnRelease(int nRelease) {
        this.nRelease = nRelease;
    }

}
