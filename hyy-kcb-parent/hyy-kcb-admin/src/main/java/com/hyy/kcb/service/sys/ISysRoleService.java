package com.hyy.kcb.service.sys;

import com.hyy.kcb.commons.service.BaseService;
import com.hyy.kcb.domain.sys.SysRole;
import com.hyy.kcb.domain.sys.dto.SysRoleDTO;

import java.util.List;

/**
 * @author WhiteLee
 * 功能描述:权限管理-角色管理
 */
public interface ISysRoleService extends BaseService<SysRole>{

    List<SysRoleDTO> selectRoleAllByUserId(Long id);
}
