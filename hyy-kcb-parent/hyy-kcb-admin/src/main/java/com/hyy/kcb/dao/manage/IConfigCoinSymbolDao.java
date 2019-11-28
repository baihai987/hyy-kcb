package com.hyy.kcb.dao.manage;

import org.apache.ibatis.annotations.Mapper;

import com.hyy.kcb.commons.dao.BaseDao;
import com.hyy.kcb.domain.manage.ConfigCoinSymbol;

/**
 * @author WhiteLee
 * 功能描述:币种配置(un)管理
 */
@Mapper
public interface IConfigCoinSymbolDao extends BaseDao<ConfigCoinSymbol>{
	
	
}
