package com.hyy.kcb.dao.configuration;

import org.apache.ibatis.annotations.Mapper;

import com.hyy.kcb.commons.dao.BaseDao;
import com.hyy.kcb.domain.configuration.ConfigHardDiskContract;

/**
 * @author WhiteLee
 * 功能描述:合约时长配置管理
 */
@Mapper
public interface IConfigHardDiskContractDao extends BaseDao<ConfigHardDiskContract>{
	
	
}
