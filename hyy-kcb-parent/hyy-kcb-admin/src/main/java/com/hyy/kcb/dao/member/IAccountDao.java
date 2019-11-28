package com.hyy.kcb.dao.member;

import org.apache.ibatis.annotations.Mapper;

import com.hyy.kcb.commons.dao.BaseDao;
import com.hyy.kcb.domain.member.Account;

/**
 * @author WhiteLee
 * 功能描述:用户基础数据管理
 */
@Mapper
public interface IAccountDao extends BaseDao<Account>{
	
	
}
