package com.baizhi.cmfv.service.impl;

import com.baizhi.cmfv.bean.SysPermission;
import com.baizhi.cmfv.bean.SysRole;
import com.baizhi.cmfv.dao.SysRolePermissionMapper;
import com.baizhi.cmfv.service.SysRolePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName SysRolePermissionServiceImpl
 * @Description 类的作用
 * @Author Chao
 * @Date 2018/7/12 15:54
 */
@Service
@Transactional
public class SysRolePermissionServiceImpl implements SysRolePermissionService {

    @Autowired
    private SysRolePermissionMapper sysRolePermissionMapper;

    /**
    * @Description  方法的作用
    * @Author       chao
    * @Date         2018/7/12 15:54 
    * @Param        参数的作用
    * @Exception    抛出的异常
    */
    @Override
    @Transactional(readOnly = true , propagation = Propagation.SUPPORTS)
    public List<SysRole> queryRoleByName(String name) {
        return sysRolePermissionMapper.selectRoleByName(name);
    }

    /**
    * @Description  方法的作用
    * @Author       chao
    * @Date         2018/7/12 15:55
    * @Param        参数的作用
    * @Exception    抛出的异常
    */
    @Override
    @Transactional(readOnly = true , propagation = Propagation.SUPPORTS)
    public List<SysPermission> queryPermissionByName(String name) {
        return sysRolePermissionMapper.selectPermissionByName(name);
    }
}
