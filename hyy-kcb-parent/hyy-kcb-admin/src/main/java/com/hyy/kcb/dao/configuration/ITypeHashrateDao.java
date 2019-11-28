package com.hyy.kcb.dao.configuration;

import org.apache.ibatis.annotations.Mapper;

import com.hyy.kcb.commons.dao.BaseDao;
import com.hyy.kcb.domain.configuration.TypeHashrate;

/**
 * @author WhiteLee
 * 功能描述:算力类型（un）管理
 */
@Mapper
public interface ITypeHashrateDao extends BaseDao<TypeHashrate>{
	
	
}
