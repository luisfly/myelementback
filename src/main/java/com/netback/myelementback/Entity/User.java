package com.netback.myelementback.Entity;

import org.apache.ibatis.annotations.Mapper;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {

    private int userId;
    private String userNO;
    private String userName;
    private String password;
    private Date lastLoginDate;
    private Date createDate;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserNO() {
        return userNO;
    }

    public void setUserNO(String userNO) {
        this.userNO = userNO;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(Date lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
