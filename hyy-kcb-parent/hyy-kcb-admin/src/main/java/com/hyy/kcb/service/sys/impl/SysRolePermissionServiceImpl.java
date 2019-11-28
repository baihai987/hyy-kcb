package com.hyy.kcb.service.sys.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hyy.kcb.commons.base.BaseObject;
import com.hyy.kcb.commons.page.Pager;
import com.hyy.kcb.commons.page.SqlUtil;
import com.hyy.kcb.dao.sys.ISysRolePermissionDao;
import com.hyy.kcb.domain.sys.SysRolePermission;
import com.hyy.kcb.service.sys.ISysRolePermissionService;

/**
 * @author WhiteLee
 * 功能描述:权限管理-角色-资源管理
 */
@Service
public class  SysRolePermissionServiceImpl extends BaseObject implements ISysRolePermissionService {
	

	@Autowired
    private ISysRolePermissionDao sysRolePermissionDao;
    
    @Override
	public List<SysRolePermission> selectAll() {
		logger.info("SysRolePermissionServiceImpl exe method selectAll");
		List<SysRolePermission> list = sysRolePermissionDao.selectAll();
		logger.info("SysRolePermissionServiceImpl exe method selectAll out:{}",list);
		return list;
	}
	
	@Override
	public SysRolePermission selectById(int id) {
		logger.info("SysRolePermissionServiceImpl exe method selectById?id={}",id);
		SysRolePermission t = sysRolePermissionDao.selectById(id);
		logger.info("SysRolePermissionServiceImpl exe method selectById out:{}",t);
		return t;
	}
	
	@Override
	public SysRolePermission selectByUUID(String uuid) {
		
		logger.info("SysRolePermissionServiceImpl exe method selectByUUID?uuid={}",uuid);
		SysRolePermission t = sysRolePermissionDao.selectByUUID(uuid);
		logger.info("SysRolePermissionServiceImpl exe method selectByUUID out:{}",t);
		
		return t;
	}
	
	@Override
	public void selectTList(Pager<SysRolePermission> pager) {
		logger.info("SysRolePermissionServiceImpl exe method selectTList?pager={}",pager);
		
		if(pager.getLimitStart()>=0){
			int totalCount = sysRolePermissionDao.selectTListCount(pager);
			int numPerPage = SqlUtil.checkPageSize(pager.getNumPerPage());
			int currentPage = SqlUtil.checkPageCurrent(totalCount, numPerPage, pager.getPageNum());
			pager.setLimitStart(SqlUtil.countOffset(currentPage, numPerPage));
			pager.setPageSize(numPerPage);
			pager.setCurrentPage(currentPage);
			pager.setTotalCount(totalCount);
			pager.setTotalPage(totalCount%numPerPage==0?totalCount/numPerPage:totalCount/numPerPage+1);
		}
		List<SysRolePermission> list = sysRolePermissionDao.selectTList(pager);
		pager.setList(list);
		
		logger.info("BaseAdServiceImpl exe method selectTList?out={}",pager);
	}
	
	@Override
	public void deleteById(int id) {
		logger.info("SysRolePermissionServiceImpl exe method deleteById?id={}",id);
		
		sysRolePermissionDao.deleteById(id);
		
		logger.info("SysRolePermissionServiceImpl exe method deleteById");
	}
	
	@Override
	public int insert(SysRolePermission t) {
		
		logger.info("SysRolePermissionServiceImpl exe method insert?t={}",t);
		
		int i = sysRolePermissionDao.insert(t);
		
		logger.info("SysRolePermissionServiceImpl exe method insert out={}",i);
		
		return i;
	}
	
	@Override
	public int updateObj(SysRolePermission t) {
		
		logger.info("SysRolePermissionServiceImpl exe method updateObj?t={}",t);
		
		int i = sysRolePermissionDao.updateObj(t);
		
		logger.info("SysRolePermissionServiceImpl exe method updateObj out={}",i);
		
		return i;
	}

}
