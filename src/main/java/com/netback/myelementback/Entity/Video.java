package com.netback.myelementback.Entity;

import java.io.Serializable;
import java.util.Date;

public class Video implements Serializable {
    private int id;
    private String videoName;
    private String userNO;
    private String createUser;
    private Date createDate;
    private int tag;
    private String videoPath;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVideoName() {
        return videoName;
    }

    public void setVideoName(String videoName) {
        this.videoName = videoName;
    }

    public String getUserNO() {
        return userNO;
    }

    public void setUserNO(String userNO) {
        this.userNO = userNO;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public int getTag() {
        return tag;
    }

    public void setTag(int tag) {
        this.tag = tag;
    }

    public String getVideoPath() {
        return videoPath;
    }

    public void setVideoPath(String videoPath) {
        this.videoPath = videoPath;
    }
}
