package com.baizhi.cmfv.dao;

import com.baizhi.cmfv.bean.SysPermission;
import com.baizhi.cmfv.bean.SysRole;

import java.util.List;

public interface SysRolePermissionMapper {

    public List<SysRole> selectRoleByName(String name);

    public List<SysPermission> selectPermissionByName(String name);

}
