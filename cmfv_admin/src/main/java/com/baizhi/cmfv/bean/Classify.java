package com.baizhi.cmfv.bean;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * Created by Chao on 2018/7/3.
 */
public class Classify implements Serializable {

    private String  cId;
    private String  cName;
    private String  cDifferent;
    private String  userId;

    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getcDifferent() {
        return cDifferent;
    }

    public void setcDifferent(String cDifferent) {
        this.cDifferent = cDifferent;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Classify{" +
                "cId='" + cId + '\'' +
                ", cName='" + cName + '\'' +
                ", cDifferent='" + cDifferent + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }
}
