package com.baizhi.cmfv.bean;

import java.io.Serializable;

/**
 * @ClassName SysPermission
 * @Description 类的作用
 * @Author Chao
 * @Date 2018/7/12 14:35
 */
public class SysPermission implements Serializable {

    private Integer id;
    private String resourceName;
    private String resourceTag;
    private String resourceUrl;
    private String permissionTag;

    @Override
    public String toString() {
        return "SysPermission{" +
                "id=" + id +
                ", resourceName='" + resourceName + '\'' +
                ", resourceTag='" + resourceTag + '\'' +
                ", resourceUrl='" + resourceUrl + '\'' +
                ", permissionTag='" + permissionTag + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getResourceTag() {
        return resourceTag;
    }

    public void setResourceTag(String resourceTag) {
        this.resourceTag = resourceTag;
    }

    public String getResourceUrl() {
        return resourceUrl;
    }

    public void setResourceUrl(String resourceUrl) {
        this.resourceUrl = resourceUrl;
    }

    public String getPermissionTag() {
        return permissionTag;
    }

    public void setPermissionTag(String permissionTag) {
        this.permissionTag = permissionTag;
    }
}
