package com.hyy.kcb.dao.member;

import org.apache.ibatis.annotations.Mapper;

import com.hyy.kcb.commons.dao.BaseDao;
import com.hyy.kcb.domain.member.UserHashrate;

/**
 * @author WhiteLee
 * 功能描述:用户算力管理
 */
@Mapper
public interface IUserHashrateDao extends BaseDao<UserHashrate>{
	
	
}
