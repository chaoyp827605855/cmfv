package com.baizhi.cmfv.bean;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * Created by Chao on 2018/7/3.
 */
public class Audio implements Serializable {

    private String  audioId;
    private String  audioName;
    private String  audioSinger;
    private String  audioCompose;
    private String  audioProducer;
    private Double  audioSize;
    private String  audioAddr;
    private Integer audioCount;
    private String  albumId;

    public String getAudioId() {
        return audioId;
    }

    public void setAudioId(String audioId) {
        this.audioId = audioId;
    }

    public String getAudioName() {
        return audioName;
    }

    public void setAudioName(String audioName) {
        this.audioName = audioName;
    }

    public String getAudioSinger() {
        return audioSinger;
    }

    public void setAudioSinger(String audioSinger) {
        this.audioSinger = audioSinger;
    }

    public String getAudioCompose() {
        return audioCompose;
    }

    public void setAudioCompose(String audioCompose) {
        this.audioCompose = audioCompose;
    }

    public String getAudioProducer() {
        return audioProducer;
    }

    public void setAudioProducer(String audioProducer) {
        this.audioProducer = audioProducer;
    }

    public Double getAudioSize() {
        return audioSize;
    }

    public void setAudioSize(Double audioSize) {
        this.audioSize = audioSize;
    }

    public String getAudioAddr() {
        return audioAddr;
    }

    public void setAudioAddr(String audioAddr) {
        this.audioAddr = audioAddr;
    }

    public Integer getAudioCount() {
        return audioCount;
    }

    public void setAudioCount(Integer audioCount) {
        this.audioCount = audioCount;
    }

    public String getAlbumId() {
        return albumId;
    }

    public void setAlbumId(String albumId) {
        this.albumId = albumId;
    }

    @Override
    public String toString() {
        return "Audio{" +
                "audioId='" + audioId + '\'' +
                ", audioName='" + audioName + '\'' +
                ", audioSinger='" + audioSinger + '\'' +
                ", audioCompose='" + audioCompose + '\'' +
                ", audioProducer='" + audioProducer + '\'' +
                ", audioSize=" + audioSize +
                ", audioAddr='" + audioAddr + '\'' +
                ", audioCount=" + audioCount +
                ", albumId='" + albumId + '\'' +
                '}';
    }
}
