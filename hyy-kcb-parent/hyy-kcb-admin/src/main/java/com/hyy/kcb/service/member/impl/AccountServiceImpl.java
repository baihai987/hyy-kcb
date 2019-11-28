package com.hyy.kcb.service.member.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hyy.kcb.commons.base.BaseObject;
import com.hyy.kcb.commons.page.Pager;
import com.hyy.kcb.commons.page.SqlUtil;
import com.hyy.kcb.dao.member.IAccountDao;
import com.hyy.kcb.domain.member.Account;
import com.hyy.kcb.service.member.IAccountService;

import javax.annotation.Resource;

/**
 * @author WhiteLee
 * 功能描述:用户基础数据管理
 */
@Service
public class  AccountServiceImpl extends BaseObject implements IAccountService {
	

	@Resource
    private IAccountDao accountDao;
    
    @Override
	public List<Account> selectAll() {
		logger.info("AccountServiceImpl exe method selectAll");
		List<Account> list = accountDao.selectAll();
		logger.info("AccountServiceImpl exe method selectAll out:{}",list);
		return list;
	}
	
	@Override
	public Account selectById(int id) {
		logger.info("AccountServiceImpl exe method selectById?id={}",id);
		Account t = accountDao.selectById(id);
		logger.info("AccountServiceImpl exe method selectById out:{}",t);
		return t;
	}
	
	@Override
	public Account selectByUUID(String uuid) {
		
		logger.info("AccountServiceImpl exe method selectByUUID?uuid={}",uuid);
		Account t = accountDao.selectByUUID(uuid);
		logger.info("AccountServiceImpl exe method selectByUUID out:{}",t);
		
		return t;
	}
	
	@Override
	public void selectTList(Pager<Account> pager) {
		logger.info("AccountServiceImpl exe method selectTList?pager={}",pager);
		
		if(pager.getLimitStart()>=0){
			int totalCount = accountDao.selectTListCount(pager);
			int numPerPage = SqlUtil.checkPageSize(pager.getNumPerPage());
			int currentPage = SqlUtil.checkPageCurrent(totalCount, numPerPage, pager.getPageNum());
			pager.setLimitStart(SqlUtil.countOffset(currentPage, numPerPage));
			pager.setPageSize(numPerPage);
			pager.setCurrentPage(currentPage);
			pager.setTotalCount(totalCount);
			pager.setTotalPage(totalCount%numPerPage==0?totalCount/numPerPage:totalCount/numPerPage+1);
		}
		List<Account> list = accountDao.selectTList(pager);
		pager.setList(list);
		
		logger.info("BaseAdServiceImpl exe method selectTList?out={}",pager);
	}
	
	@Override
	public void deleteById(int id) {
		logger.info("AccountServiceImpl exe method deleteById?id={}",id);
		
		accountDao.deleteById(id);
		
		logger.info("AccountServiceImpl exe method deleteById");
	}
	
	@Override
	public int insert(Account t) {
		
		logger.info("AccountServiceImpl exe method insert?t={}",t);
		
		int i = accountDao.insert(t);
		
		logger.info("AccountServiceImpl exe method insert out={}",i);
		
		return i;
	}
	
	@Override
	public int updateObj(Account t) {
		
		logger.info("AccountServiceImpl exe method updateObj?t={}",t);
		
		int i = accountDao.updateObj(t);
		
		logger.info("AccountServiceImpl exe method updateObj out={}",i);
		
		return i;
	}

}
