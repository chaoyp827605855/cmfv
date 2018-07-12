package com.baizhi.cmfv.bean;

import java.io.Serializable;

/**
 * @ClassName SysRole
 * @Description 类的作用
 * @Author Chao
 * @Date 2018/7/12 14:33
 */
public class SysRole implements Serializable {

    private Integer id;
    private String roleName;
    private String roleTag;

    @Override
    public String toString() {
        return "SysRole{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                ", roleTag='" + roleTag + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleTag() {
        return roleTag;
    }

    public void setRoleTag(String roleTag) {
        this.roleTag = roleTag;
    }
}
