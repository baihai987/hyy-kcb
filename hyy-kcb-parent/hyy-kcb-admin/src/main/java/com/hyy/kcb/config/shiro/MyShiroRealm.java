
package com.hyy.kcb.config.shiro;

import com.hyy.kcb.commons.exception.BusinessException;
import com.hyy.kcb.domain.sys.SysUser;
import com.hyy.kcb.domain.sys.dto.SysPermissionDTO;
import com.hyy.kcb.domain.sys.dto.SysRoleDTO;
import com.hyy.kcb.service.sys.ISysPermissionService;
import com.hyy.kcb.service.sys.ISysRoleService;
import com.hyy.kcb.service.sys.ISysUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import javax.annotation.Resource;
import java.util.List;

/**
 * 身份校验核心类;
 */
public class MyShiroRealm extends AuthorizingRealm {

    @Resource
    private ISysUserService sysUserService;
    @Resource
    private ISysRoleService sysRoleService;
    @Resource
    private ISysPermissionService sysPermissionService;

    /**
     * 认证信息.(身份验证)
     * :
     * Authentication 是用来验证用户身份
     *
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //获取用户的输入的账号.
        String username = (String) token.getPrincipal();
        //实际项目中，这里可以根据实际情况做缓存，如果不做，Shiro自己也是有时间间隔机制，2分钟内不会重复执行该方法
        SysUser userInfo;
        try {
            userInfo = sysUserService.findUserByName(username);
        } catch (BusinessException e) {
            e.printStackTrace();
            throw e;
        }


        if (userInfo == null) {
            return null;
        }

		if (userInfo.getState().equals("0")) { //账户冻结
            throw new LockedAccountException();
        }
        //加密方式;
        //交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配，如果觉得人家的不好可以自定义实现
        return new SimpleAuthenticationInfo(
                userInfo, //用户名
                userInfo.getPassword(), //密码
                ByteSource.Util.bytes(userInfo.getCredentialsSalt()),//salt=username+salt
                getName()  //realm name
        );
    }


    /**
     * 此方法调用  hasRole,hasPermission的时候才会进行回调.
     * <p>
     * 权限信息.(授权):
     * 1、如果用户正常退出，缓存自动清空；
     * 2、如果用户非正常退出，缓存自动清空；
     * 3、如果我们修改了用户的权限，而用户不退出系统，修改的权限无法立即生效。
     * （需要手动编程进行实现；放在service进行调用）
     * 在权限修改后调用realm中的方法，realm已经由spring管理，所以从spring中获取realm实例，
     * 调用clearCached方法；
     * :Authorization 是授权访问控制，用于对用户进行的操作授权，证明该用户是否允许进行当前操作，如访问某个链接，某个资源文件等。
     *
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        /*
         * 当没有使用缓存的时候，不断刷新页面的话，这个代码会不断执行，
         * 当其实没有必要每次都重新设置权限信息，所以我们需要放到缓存中进行管理；
         * 当放到缓存中时，这样的话，doGetAuthorizationInfo就只会执行一次了，
         * 缓存过期之后会再次执行。
         */

        System.out.println("---------------doGetAuthorizationInfo 授权------------------------");
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
//		List<SysRole> listRole = sysRoleService.selectAll();
//		for(SysRole role:listRole) {
//			authorizationInfo.addRole(role.getRole());
//		}
//		List<SysPermission> listPermission = sysPermissionService.selectAll();
//		for(SysPermission p : listPermission) {
//			if(p.getPermission() != null && !p.getPermission().equals("")) {
//				authorizationInfo.addStringPermission(p.getPermission());
//			}
//		}

        SysUser userInfo = (SysUser) principals.getPrimaryPrincipal();
        List<SysRoleDTO> sysRoleList = sysRoleService.selectRoleAllByUserId(userInfo.getId());
        for (SysRoleDTO role : sysRoleList) {
            authorizationInfo.addRole(role.getRole());
            List<SysPermissionDTO> permissionList = sysPermissionService.selectSysPermissionAllByRoleId(role.getId());
            for (SysPermissionDTO p : permissionList) {
                if (p.getPermission() != null && !p.getPermission().equals("")) {
                    authorizationInfo.addStringPermission(p.getPermission());
                }
            }
        }
        return authorizationInfo;
    }
}
