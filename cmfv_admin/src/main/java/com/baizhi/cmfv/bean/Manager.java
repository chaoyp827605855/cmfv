package com.baizhi.cmfv.bean;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * Created by Chao on 2018/7/3.
 */
public class Manager implements Serializable {

    private String mId;
    private String mName;
    private String mSalt;
    private String mStatus;
    private String mPassword;

    public String getmId() {
        return mId;
    }
    public void setmId(String mId) {
        this.mId = mId;
    }
    public String getmName() {
        return mName;
    }
    public void setmName(String mName) {
        this.mName = mName;
    }
    public String getmSalt() {
        return mSalt;
    }
    public void setmSalt(String mSalt) {
        this.mSalt = mSalt;
    }
    public String getmStatus() {
        return mStatus;
    }
    public void setmStatus(String mStatus) {
        this.mStatus = mStatus;
    }
    public String getmPassword() {
        return mPassword;
    }
    public void setmPassword(String mPassword) {
        this.mPassword = mPassword;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "mId='" + mId + '\'' +
                ", mName='" + mName + '\'' +
                ", mSalt='" + mSalt + '\'' +
                ", mStatus='" + mStatus + '\'' +
                ", mPassword='" + mPassword + '\'' +
                '}';
    }
}
