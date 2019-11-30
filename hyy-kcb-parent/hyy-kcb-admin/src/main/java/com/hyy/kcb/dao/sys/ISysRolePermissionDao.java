package com.hyy.kcb.dao.sys;

import org.apache.ibatis.annotations.Mapper;

import com.hyy.kcb.commons.dao.BaseDao;
import com.hyy.kcb.domain.sys.SysRolePermission;

/**
 * @author WhiteLee
 * 功能描述:权限管理-角色-资源管理
 */
@Mapper
public interface ISysRolePermissionDao extends BaseDao<SysRolePermission>{


    SysRolePermission findRolePermissionById(Long roleId, Long permissionId);

}
