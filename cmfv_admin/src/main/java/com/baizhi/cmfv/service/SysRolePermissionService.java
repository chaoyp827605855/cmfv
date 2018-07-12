package com.baizhi.cmfv.service;

import com.baizhi.cmfv.bean.SysPermission;
import com.baizhi.cmfv.bean.SysRole;

import java.util.List;

public interface SysRolePermissionService {

    public List<SysRole> queryRoleByName(String name);

    public List<SysPermission> queryPermissionByName(String name);

}
