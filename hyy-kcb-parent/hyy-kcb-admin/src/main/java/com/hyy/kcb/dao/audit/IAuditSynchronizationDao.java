package com.hyy.kcb.dao.audit;

import org.apache.ibatis.annotations.Mapper;

import com.hyy.kcb.commons.dao.BaseDao;
import com.hyy.kcb.domain.audit.AuditSynchronization;

/**
 * @author WhiteLee
 * 功能描述:审核同步管理
 */
@Mapper
public interface IAuditSynchronizationDao extends BaseDao<AuditSynchronization>{
	
	
}
