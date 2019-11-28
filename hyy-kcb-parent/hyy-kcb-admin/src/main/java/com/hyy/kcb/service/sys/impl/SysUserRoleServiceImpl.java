package com.hyy.kcb.service.sys.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hyy.kcb.commons.base.BaseObject;
import com.hyy.kcb.commons.page.Pager;
import com.hyy.kcb.commons.page.SqlUtil;
import com.hyy.kcb.dao.sys.ISysUserRoleDao;
import com.hyy.kcb.domain.sys.SysUserRole;
import com.hyy.kcb.service.sys.ISysUserRoleService;

/**
 * @author WhiteLee
 * 功能描述:权限管理-用户-角色管理
 */
@Service
public class  SysUserRoleServiceImpl extends BaseObject implements ISysUserRoleService {
	

	@Autowired
    private ISysUserRoleDao sysUserRoleDao;
    
    @Override
	public List<SysUserRole> selectAll() {
		logger.info("SysUserRoleServiceImpl exe method selectAll");
		List<SysUserRole> list = sysUserRoleDao.selectAll();
		logger.info("SysUserRoleServiceImpl exe method selectAll out:{}",list);
		return list;
	}
	
	@Override
	public SysUserRole selectById(int id) {
		logger.info("SysUserRoleServiceImpl exe method selectById?id={}",id);
		SysUserRole t = sysUserRoleDao.selectById(id);
		logger.info("SysUserRoleServiceImpl exe method selectById out:{}",t);
		return t;
	}
	
	@Override
	public SysUserRole selectByUUID(String uuid) {
		
		logger.info("SysUserRoleServiceImpl exe method selectByUUID?uuid={}",uuid);
		SysUserRole t = sysUserRoleDao.selectByUUID(uuid);
		logger.info("SysUserRoleServiceImpl exe method selectByUUID out:{}",t);
		
		return t;
	}
	
	@Override
	public void selectTList(Pager<SysUserRole> pager) {
		logger.info("SysUserRoleServiceImpl exe method selectTList?pager={}",pager);
		
		if(pager.getLimitStart()>=0){
			int totalCount = sysUserRoleDao.selectTListCount(pager);
			int numPerPage = SqlUtil.checkPageSize(pager.getNumPerPage());
			int currentPage = SqlUtil.checkPageCurrent(totalCount, numPerPage, pager.getPageNum());
			pager.setLimitStart(SqlUtil.countOffset(currentPage, numPerPage));
			pager.setPageSize(numPerPage);
			pager.setCurrentPage(currentPage);
			pager.setTotalCount(totalCount);
			pager.setTotalPage(totalCount%numPerPage==0?totalCount/numPerPage:totalCount/numPerPage+1);
		}
		List<SysUserRole> list = sysUserRoleDao.selectTList(pager);
		pager.setList(list);
		
		logger.info("BaseAdServiceImpl exe method selectTList?out={}",pager);
	}
	
	@Override
	public void deleteById(int id) {
		logger.info("SysUserRoleServiceImpl exe method deleteById?id={}",id);
		
		sysUserRoleDao.deleteById(id);
		
		logger.info("SysUserRoleServiceImpl exe method deleteById");
	}
	
	@Override
	public int insert(SysUserRole t) {
		
		logger.info("SysUserRoleServiceImpl exe method insert?t={}",t);
		
		int i = sysUserRoleDao.insert(t);
		
		logger.info("SysUserRoleServiceImpl exe method insert out={}",i);
		
		return i;
	}
	
	@Override
	public int updateObj(SysUserRole t) {
		
		logger.info("SysUserRoleServiceImpl exe method updateObj?t={}",t);
		
		int i = sysUserRoleDao.updateObj(t);
		
		logger.info("SysUserRoleServiceImpl exe method updateObj out={}",i);
		
		return i;
	}

}
