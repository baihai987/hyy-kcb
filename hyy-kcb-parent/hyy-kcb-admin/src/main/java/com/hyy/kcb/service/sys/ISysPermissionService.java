package com.hyy.kcb.service.sys;

import com.hyy.kcb.commons.service.BaseService;
import com.hyy.kcb.domain.sys.SysPermission;
import com.hyy.kcb.domain.sys.dto.SysPermissionDTO;

import java.util.List;

/**
 * @author WhiteLee
 * 功能描述:权限管理-资源管理
 */
public interface ISysPermissionService extends BaseService<SysPermission>{

    List<SysPermissionDTO> selectSysPermissionAllByRoleId(Long id);
}
