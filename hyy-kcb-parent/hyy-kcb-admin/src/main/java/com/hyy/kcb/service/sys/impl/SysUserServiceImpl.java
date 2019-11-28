package com.hyy.kcb.service.sys.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hyy.kcb.commons.base.BaseObject;
import com.hyy.kcb.commons.page.Pager;
import com.hyy.kcb.commons.page.SqlUtil;
import com.hyy.kcb.dao.sys.ISysUserDao;
import com.hyy.kcb.domain.sys.SysUser;
import com.hyy.kcb.service.sys.ISysUserService;

/**
 * @author WhiteLee
 * 功能描述:权限管理-用户管理
 */
@Service
public class  SysUserServiceImpl extends BaseObject implements ISysUserService {
	

	@Autowired
    private ISysUserDao sysUserDao;
    
    @Override
	public List<SysUser> selectAll() {
		logger.info("SysUserServiceImpl exe method selectAll");
		List<SysUser> list = sysUserDao.selectAll();
		logger.info("SysUserServiceImpl exe method selectAll out:{}",list);
		return list;
	}
	
	@Override
	public SysUser selectById(int id) {
		logger.info("SysUserServiceImpl exe method selectById?id={}",id);
		SysUser t = sysUserDao.selectById(id);
		logger.info("SysUserServiceImpl exe method selectById out:{}",t);
		return t;
	}
	
	@Override
	public SysUser selectByUUID(String uuid) {
		
		logger.info("SysUserServiceImpl exe method selectByUUID?uuid={}",uuid);
		SysUser t = sysUserDao.selectByUUID(uuid);
		logger.info("SysUserServiceImpl exe method selectByUUID out:{}",t);
		
		return t;
	}
	
	@Override
	public void selectTList(Pager<SysUser> pager) {
		logger.info("SysUserServiceImpl exe method selectTList?pager={}",pager);
		
		if(pager.getLimitStart()>=0){
			int totalCount = sysUserDao.selectTListCount(pager);
			int numPerPage = SqlUtil.checkPageSize(pager.getNumPerPage());
			int currentPage = SqlUtil.checkPageCurrent(totalCount, numPerPage, pager.getPageNum());
			pager.setLimitStart(SqlUtil.countOffset(currentPage, numPerPage));
			pager.setPageSize(numPerPage);
			pager.setCurrentPage(currentPage);
			pager.setTotalCount(totalCount);
			pager.setTotalPage(totalCount%numPerPage==0?totalCount/numPerPage:totalCount/numPerPage+1);
		}
		List<SysUser> list = sysUserDao.selectTList(pager);
		pager.setList(list);
		
		logger.info("BaseAdServiceImpl exe method selectTList?out={}",pager);
	}
	
	@Override
	public void deleteById(int id) {
		logger.info("SysUserServiceImpl exe method deleteById?id={}",id);
		
		sysUserDao.deleteById(id);
		
		logger.info("SysUserServiceImpl exe method deleteById");
	}
	
	@Override
	public int insert(SysUser t) {
		
		logger.info("SysUserServiceImpl exe method insert?t={}",t);
		
		int i = sysUserDao.insert(t);
		
		logger.info("SysUserServiceImpl exe method insert out={}",i);
		
		return i;
	}
	
	@Override
	public int updateObj(SysUser t) {
		
		logger.info("SysUserServiceImpl exe method updateObj?t={}",t);
		
		int i = sysUserDao.updateObj(t);
		
		logger.info("SysUserServiceImpl exe method updateObj out={}",i);
		
		return i;
	}

	@Override
	public SysUser findUserByName(String loginName) {
		return sysUserDao.findUserByName(loginName);
	}
}
