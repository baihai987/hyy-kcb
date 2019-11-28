package com.hyy.kcb.dao.sys;

import com.hyy.kcb.domain.sys.dto.SysRoleDTO;
import org.apache.ibatis.annotations.Mapper;

import com.hyy.kcb.commons.dao.BaseDao;
import com.hyy.kcb.domain.sys.SysRole;

import java.util.List;

/**
 * @author WhiteLee
 * 功能描述:权限管理-角色管理
 */
@Mapper
public interface ISysRoleDao extends BaseDao<SysRole>{


    List<SysRoleDTO> selectRoleAllByUserId(Long userId);

}
