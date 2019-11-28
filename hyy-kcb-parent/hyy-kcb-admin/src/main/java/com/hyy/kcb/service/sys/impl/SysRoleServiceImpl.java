package com.hyy.kcb.service.sys.impl;

import java.util.List;

import com.hyy.kcb.domain.sys.dto.SysRoleDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hyy.kcb.commons.base.BaseObject;
import com.hyy.kcb.commons.page.Pager;
import com.hyy.kcb.commons.page.SqlUtil;
import com.hyy.kcb.dao.sys.ISysRoleDao;
import com.hyy.kcb.domain.sys.SysRole;
import com.hyy.kcb.service.sys.ISysRoleService;

/**
 * @author WhiteLee
 * 功能描述:权限管理-角色管理
 */
@Service
public class  SysRoleServiceImpl extends BaseObject implements ISysRoleService {
	

	@Autowired
    private ISysRoleDao sysRoleDao;
    
    @Override
	public List<SysRole> selectAll() {
		logger.info("SysRoleServiceImpl exe method selectAll");
		List<SysRole> list = sysRoleDao.selectAll();
		logger.info("SysRoleServiceImpl exe method selectAll out:{}",list);
		return list;
	}
	
	@Override
	public SysRole selectById(int id) {
		logger.info("SysRoleServiceImpl exe method selectById?id={}",id);
		SysRole t = sysRoleDao.selectById(id);
		logger.info("SysRoleServiceImpl exe method selectById out:{}",t);
		return t;
	}
	
	@Override
	public SysRole selectByUUID(String uuid) {
		
		logger.info("SysRoleServiceImpl exe method selectByUUID?uuid={}",uuid);
		SysRole t = sysRoleDao.selectByUUID(uuid);
		logger.info("SysRoleServiceImpl exe method selectByUUID out:{}",t);
		
		return t;
	}
	
	@Override
	public void selectTList(Pager<SysRole> pager) {
		logger.info("SysRoleServiceImpl exe method selectTList?pager={}",pager);
		
		if(pager.getLimitStart()>=0){
			int totalCount = sysRoleDao.selectTListCount(pager);
			int numPerPage = SqlUtil.checkPageSize(pager.getNumPerPage());
			int currentPage = SqlUtil.checkPageCurrent(totalCount, numPerPage, pager.getPageNum());
			pager.setLimitStart(SqlUtil.countOffset(currentPage, numPerPage));
			pager.setPageSize(numPerPage);
			pager.setCurrentPage(currentPage);
			pager.setTotalCount(totalCount);
			pager.setTotalPage(totalCount%numPerPage==0?totalCount/numPerPage:totalCount/numPerPage+1);
		}
		List<SysRole> list = sysRoleDao.selectTList(pager);
		pager.setList(list);
		
		logger.info("BaseAdServiceImpl exe method selectTList?out={}",pager);
	}
	
	@Override
	public void deleteById(int id) {
		logger.info("SysRoleServiceImpl exe method deleteById?id={}",id);
		
		sysRoleDao.deleteById(id);
		
		logger.info("SysRoleServiceImpl exe method deleteById");
	}
	
	@Override
	public int insert(SysRole t) {
		
		logger.info("SysRoleServiceImpl exe method insert?t={}",t);
		
		int i = sysRoleDao.insert(t);
		
		logger.info("SysRoleServiceImpl exe method insert out={}",i);
		
		return i;
	}
	
	@Override
	public int updateObj(SysRole t) {
		
		logger.info("SysRoleServiceImpl exe method updateObj?t={}",t);
		
		int i = sysRoleDao.updateObj(t);
		
		logger.info("SysRoleServiceImpl exe method updateObj out={}",i);
		
		return i;
	}

	@Override
	public List<SysRoleDTO> selectRoleAllByUserId(Long id) {
		return sysRoleDao.selectRoleAllByUserId(id);
	}
}
