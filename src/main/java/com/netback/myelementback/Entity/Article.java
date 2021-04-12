package com.netback.myelementback.Entity;

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

}
