package com.baizhi.cmfv.util;

import com.baizhi.cmfv.bean.Manager;
import com.baizhi.cmfv.bean.SysPermission;
import com.baizhi.cmfv.bean.SysRole;
import com.baizhi.cmfv.service.ManagerService;
import com.baizhi.cmfv.service.SysRolePermissionService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;

/**
 * @ClassName MyRealm
 * @Description 类的作用
 * @Author Chao
 * @Date 2018/7/11 20:55
 */
public class MyRealm extends AuthorizingRealm {

    @Autowired
    private ManagerService managerService;

    @Autowired
    private SysRolePermissionService sysRolePermissionService;

    /**
    * @Description  获取授权信息方法    角色信息 + 权限信息
    * @Author       chao
    * @Date         2018/7/11 20:55 
    */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("-------------------doGetAuthorizationInfo--------------------------");
        String username = (String) principalCollection.getPrimaryPrincipal();
        List<SysRole> sysRoles = sysRolePermissionService.queryRoleByName(username);
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        for (SysRole sysRole : sysRoles) {
            info.addRole(sysRole.getRoleTag());
        }

        List<SysPermission> sysPermissions = sysRolePermissionService.queryPermissionByName(username);
        for (SysPermission sysPermission : sysPermissions) {
            System.out.println("------------------------"+sysPermission.getPermissionTag());
            info.addStringPermission(sysPermission.getPermissionTag());
        }
        return info;
    }
    /**
    * @Description  获取验证信息
    * @Author       chao
    * @Date         2018/7/11 20:56
    */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("----------------doGetAuthenticationInfo------------------------");

        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
        String username = usernamePasswordToken.getUsername();

        Manager man = managerService.queryByName(username);
        System.out.println("++++++++++++"+man);
        System.out.println(usernamePasswordToken+"------------"+usernamePasswordToken.getUsername());
        if(man != null) {
            return new SimpleAuthenticationInfo(username,man.getPassword(), ByteSource.Util.bytes(man.getSalt()), UUID.randomUUID().toString());
        }
        return null;
    }
}
