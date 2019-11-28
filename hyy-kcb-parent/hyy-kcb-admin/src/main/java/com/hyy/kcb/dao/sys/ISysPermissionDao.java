package com.hyy.kcb.dao.sys;

import com.hyy.kcb.domain.sys.dto.SysPermissionDTO;
import org.apache.ibatis.annotations.Mapper;

import com.hyy.kcb.commons.dao.BaseDao;
import com.hyy.kcb.domain.sys.SysPermission;

import java.util.List;

/**
 * @author WhiteLee
 * 功能描述:权限管理-资源管理
 */
@Mapper
public interface ISysPermissionDao extends BaseDao<SysPermission>{

    List<SysPermissionDTO> selectSysPermissionAllByRoleId(Long roleId);
}
