package com.baizhi.cmfv.bean;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Chao on 2018/7/3.
 */

public class Album implements Serializable {

    private String  albumId;
    private String  albumName;
    private String  albumAuthor;
    private String  albumCv;
    private Integer albumCount;
    private Integer albumScore;
    private String  albumSrc;
    private Date albumPublishTime;
    private String  albumContent;

    public String getAlbumId() {
        return albumId;
    }

    public void setAlbumId(String albumId) {
        this.albumId = albumId;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getAlbumAuthor() {
        return albumAuthor;
    }

    public void setAlbumAuthor(String albumAuthor) {
        this.albumAuthor = albumAuthor;
    }

    public String getAlbumCv() {
        return albumCv;
    }

    public void setAlbumCv(String albumCv) {
        this.albumCv = albumCv;
    }

    public Integer getAlbumCount() {
        return albumCount;
    }

    public void setAlbumCount(Integer albumCount) {
        this.albumCount = albumCount;
    }

    public Integer getAlbumScore() {
        return albumScore;
    }

    public void setAlbumScore(Integer albumScore) {
        this.albumScore = albumScore;
    }

    public String getAlbumSrc() {
        return albumSrc;
    }

    public void setAlbumSrc(String albumSrc) {
        this.albumSrc = albumSrc;
    }

    public Date getAlbumPublishTime() {
        return albumPublishTime;
    }

    public void setAlbumPublishTime(Date albumPublishTime) {
        this.albumPublishTime = albumPublishTime;
    }

    public String getAlbumContent() {
        return albumContent;
    }

    public void setAlbumContent(String albumContent) {
        this.albumContent = albumContent;
    }

    @Override
    public String toString() {
        return "Album{" +
                "albumId='" + albumId + '\'' +
                ", albumName='" + albumName + '\'' +
                ", albumAuthor='" + albumAuthor + '\'' +
                ", albumCv='" + albumCv + '\'' +
                ", albumCount=" + albumCount +
                ", albumScore=" + albumScore +
                ", albumSrc='" + albumSrc + '\'' +
                ", albumPublishTime='" + albumPublishTime + '\'' +
                ", albumContent='" + albumContent + '\'' +
                '}';
    }
}
