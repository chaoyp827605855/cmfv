package com.baizhi.cmfv.bean;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * Created by Chao on 2018/7/3.
 */
public class User implements Serializable{

    private String userId;
    private String userName;
    private String userReligionName;
    private String userSalt;
    private String userPassword;
    private String userSex;
    private String userPicture;     //

    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getUserReligionName() {
        return userReligionName;
    }
    public void setUserReligionName(String userReligionName) {
        this.userReligionName = userReligionName;
    }
    public String getUserSalt() {
        return userSalt;
    }
    public void setUserSalt(String userSalt) {
        this.userSalt = userSalt;
    }
    public String getUserPassword() {
        return userPassword;
    }
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
    public String getUserSex() {
        return userSex;
    }
    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }
    public String getUserPicture() {
        return userPicture;
    }
    public void setUserPicture(String userPicture) {
        this.userPicture = userPicture;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userReligionName='" + userReligionName + '\'' +
                ", userSalt='" + userSalt + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userSex='" + userSex + '\'' +
                ", userPicture='" + userPicture + '\'' +
                '}';
    }

}