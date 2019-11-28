package com.hyy.kcb.dao.sys;

import org.apache.ibatis.annotations.Mapper;

import com.hyy.kcb.commons.dao.BaseDao;
import com.hyy.kcb.domain.sys.SysUser;

/**
 * @author WhiteLee
 * 功能描述:权限管理-用户管理
 */
@Mapper
public interface ISysUserDao extends BaseDao<SysUser>{


    SysUser findUserByName(String username);
}
