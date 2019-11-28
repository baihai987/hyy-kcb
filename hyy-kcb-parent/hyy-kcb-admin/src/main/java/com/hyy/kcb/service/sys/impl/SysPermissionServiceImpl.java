package com.hyy.kcb.service.sys.impl;

import java.util.List;

import com.hyy.kcb.domain.sys.dto.SysPermissionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hyy.kcb.commons.base.BaseObject;
import com.hyy.kcb.commons.page.Pager;
import com.hyy.kcb.commons.page.SqlUtil;
import com.hyy.kcb.dao.sys.ISysPermissionDao;
import com.hyy.kcb.domain.sys.SysPermission;
import com.hyy.kcb.service.sys.ISysPermissionService;

/**
 * @author WhiteLee
 * 功能描述:权限管理-资源管理
 */
@Service
public class  SysPermissionServiceImpl extends BaseObject implements ISysPermissionService {
	

	@Autowired
    private ISysPermissionDao sysPermissionDao;
    
    @Override
	public List<SysPermission> selectAll() {
		logger.info("SysPermissionServiceImpl exe method selectAll");
		List<SysPermission> list = sysPermissionDao.selectAll();
		logger.info("SysPermissionServiceImpl exe method selectAll out:{}",list);
		return list;
	}
	
	@Override
	public SysPermission selectById(int id) {
		logger.info("SysPermissionServiceImpl exe method selectById?id={}",id);
		SysPermission t = sysPermissionDao.selectById(id);
		logger.info("SysPermissionServiceImpl exe method selectById out:{}",t);
		return t;
	}
	
	@Override
	public SysPermission selectByUUID(String uuid) {
		
		logger.info("SysPermissionServiceImpl exe method selectByUUID?uuid={}",uuid);
		SysPermission t = sysPermissionDao.selectByUUID(uuid);
		logger.info("SysPermissionServiceImpl exe method selectByUUID out:{}",t);
		
		return t;
	}
	
	@Override
	public void selectTList(Pager<SysPermission> pager) {
		logger.info("SysPermissionServiceImpl exe method selectTList?pager={}",pager);
		
		if(pager.getLimitStart()>=0){
			int totalCount = sysPermissionDao.selectTListCount(pager);
			int numPerPage = SqlUtil.checkPageSize(pager.getNumPerPage());
			int currentPage = SqlUtil.checkPageCurrent(totalCount, numPerPage, pager.getPageNum());
			pager.setLimitStart(SqlUtil.countOffset(currentPage, numPerPage));
			pager.setPageSize(numPerPage);
			pager.setCurrentPage(currentPage);
			pager.setTotalCount(totalCount);
			pager.setTotalPage(totalCount%numPerPage==0?totalCount/numPerPage:totalCount/numPerPage+1);
		}
		List<SysPermission> list = sysPermissionDao.selectTList(pager);
		pager.setList(list);
		
		logger.info("BaseAdServiceImpl exe method selectTList?out={}",pager);
	}
	
	@Override
	public void deleteById(int id) {
		logger.info("SysPermissionServiceImpl exe method deleteById?id={}",id);
		
		sysPermissionDao.deleteById(id);
		
		logger.info("SysPermissionServiceImpl exe method deleteById");
	}
	
	@Override
	public int insert(SysPermission t) {
		
		logger.info("SysPermissionServiceImpl exe method insert?t={}",t);
		
		int i = sysPermissionDao.insert(t);
		
		logger.info("SysPermissionServiceImpl exe method insert out={}",i);
		
		return i;
	}
	
	@Override
	public int updateObj(SysPermission t) {
		
		logger.info("SysPermissionServiceImpl exe method updateObj?t={}",t);
		
		int i = sysPermissionDao.updateObj(t);
		
		logger.info("SysPermissionServiceImpl exe method updateObj out={}",i);
		
		return i;
	}

	@Override
	public List<SysPermissionDTO> selectSysPermissionAllByRoleId(Long id) {
		return sysPermissionDao.selectSysPermissionAllByRoleId(id);
	}
}
