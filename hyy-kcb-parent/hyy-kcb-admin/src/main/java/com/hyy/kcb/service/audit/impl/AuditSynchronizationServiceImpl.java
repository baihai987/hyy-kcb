package com.hyy.kcb.service.audit.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hyy.kcb.commons.base.BaseObject;
import com.hyy.kcb.commons.page.Pager;
import com.hyy.kcb.commons.page.SqlUtil;
import com.hyy.kcb.dao.audit.IAuditSynchronizationDao;
import com.hyy.kcb.domain.audit.AuditSynchronization;
import com.hyy.kcb.service.audit.IAuditSynchronizationService;

/**
 * @author WhiteLee
 * 功能描述:审核同步管理
 */
@Service
public class  AuditSynchronizationServiceImpl extends BaseObject implements IAuditSynchronizationService {
	

	@Autowired
    private IAuditSynchronizationDao auditSynchronizationDao;
    
    @Override
	public List<AuditSynchronization> selectAll() {
		logger.info("AuditSynchronizationServiceImpl exe method selectAll");
		List<AuditSynchronization> list = auditSynchronizationDao.selectAll();
		logger.info("AuditSynchronizationServiceImpl exe method selectAll out:{}",list);
		return list;
	}
	
	@Override
	public AuditSynchronization selectById(int id) {
		logger.info("AuditSynchronizationServiceImpl exe method selectById?id={}",id);
		AuditSynchronization t = auditSynchronizationDao.selectById(id);
		logger.info("AuditSynchronizationServiceImpl exe method selectById out:{}",t);
		return t;
	}
	
	@Override
	public AuditSynchronization selectByUUID(String uuid) {
		
		logger.info("AuditSynchronizationServiceImpl exe method selectByUUID?uuid={}",uuid);
		AuditSynchronization t = auditSynchronizationDao.selectByUUID(uuid);
		logger.info("AuditSynchronizationServiceImpl exe method selectByUUID out:{}",t);
		
		return t;
	}
	
	@Override
	public void selectTList(Pager<AuditSynchronization> pager) {
		logger.info("AuditSynchronizationServiceImpl exe method selectTList?pager={}",pager);
		
		if(pager.getLimitStart()>=0){
			int totalCount = auditSynchronizationDao.selectTListCount(pager);
			int numPerPage = SqlUtil.checkPageSize(pager.getNumPerPage());
			int currentPage = SqlUtil.checkPageCurrent(totalCount, numPerPage, pager.getPageNum());
			pager.setLimitStart(SqlUtil.countOffset(currentPage, numPerPage));
			pager.setPageSize(numPerPage);
			pager.setCurrentPage(currentPage);
			pager.setTotalCount(totalCount);
			pager.setTotalPage(totalCount%numPerPage==0?totalCount/numPerPage:totalCount/numPerPage+1);
		}
		List<AuditSynchronization> list = auditSynchronizationDao.selectTList(pager);
		pager.setList(list);
		
		logger.info("BaseAdServiceImpl exe method selectTList?out={}",pager);
	}
	
	@Override
	public void deleteById(int id) {
		logger.info("AuditSynchronizationServiceImpl exe method deleteById?id={}",id);
		
		auditSynchronizationDao.deleteById(id);
		
		logger.info("AuditSynchronizationServiceImpl exe method deleteById");
	}
	
	@Override
	public int insert(AuditSynchronization t) {
		
		logger.info("AuditSynchronizationServiceImpl exe method insert?t={}",t);
		
		int i = auditSynchronizationDao.insert(t);
		
		logger.info("AuditSynchronizationServiceImpl exe method insert out={}",i);
		
		return i;
	}
	
	@Override
	public int updateObj(AuditSynchronization t) {
		
		logger.info("AuditSynchronizationServiceImpl exe method updateObj?t={}",t);
		
		int i = auditSynchronizationDao.updateObj(t);
		
		logger.info("AuditSynchronizationServiceImpl exe method updateObj out={}",i);
		
		return i;
	}

}
