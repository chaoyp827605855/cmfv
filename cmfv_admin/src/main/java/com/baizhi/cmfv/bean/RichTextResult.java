package com.baizhi.cmfv.bean;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName RichTextResult
 * @Description 多文件上传的封装
 * @Author Chao
 * @Date 2018/7/8 20:29
 */
public class RichTextResult implements Serializable{

    private Integer errno;
    private List<String> data;

    @Override
    public String toString() {
        return "RichTextResult{" +
                "errno=" + errno +
                ", data=" + data +
                '}';
    }

    public Integer getErrno() {
        return errno;
    }

    public void setErrno(Integer errno) {
        this.errno = errno;
    }

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }
}
