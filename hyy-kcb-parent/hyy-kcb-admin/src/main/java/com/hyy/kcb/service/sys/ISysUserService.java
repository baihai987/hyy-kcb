package com.hyy.kcb.service.sys;

import com.hyy.kcb.commons.service.BaseService;
import com.hyy.kcb.domain.sys.SysUser;

/**
 * @author WhiteLee
 * 功能描述:权限管理-用户管理
 */
public interface ISysUserService extends BaseService<SysUser>{

    SysUser findUserByName(String loginName);
}
