package com.hyy.kcb.dao.configuration;

import org.apache.ibatis.annotations.Mapper;

import com.hyy.kcb.commons.dao.BaseDao;
import com.hyy.kcb.domain.configuration.HardDisk;

/**
 * @author WhiteLee
 * 功能描述:硬盘配置管理
 */
@Mapper
public interface IHardDiskDao extends BaseDao<HardDisk>{
	
	
}
