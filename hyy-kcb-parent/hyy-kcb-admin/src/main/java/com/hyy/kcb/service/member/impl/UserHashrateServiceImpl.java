package com.hyy.kcb.service.member.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hyy.kcb.commons.base.BaseObject;
import com.hyy.kcb.commons.page.Pager;
import com.hyy.kcb.commons.page.SqlUtil;
import com.hyy.kcb.dao.member.IUserHashrateDao;
import com.hyy.kcb.domain.member.UserHashrate;
import com.hyy.kcb.service.member.IUserHashrateService;

/**
 * @author WhiteLee
 * 功能描述:用户算力管理
 */
@Service
public class  UserHashrateServiceImpl extends BaseObject implements IUserHashrateService {
	

	@Autowired
    private IUserHashrateDao userHashrateDao;
    
    @Override
	public List<UserHashrate> selectAll() {
		logger.info("UserHashrateServiceImpl exe method selectAll");
		List<UserHashrate> list = userHashrateDao.selectAll();
		logger.info("UserHashrateServiceImpl exe method selectAll out:{}",list);
		return list;
	}
	
	@Override
	public UserHashrate selectById(int id) {
		logger.info("UserHashrateServiceImpl exe method selectById?id={}",id);
		UserHashrate t = userHashrateDao.selectById(id);
		logger.info("UserHashrateServiceImpl exe method selectById out:{}",t);
		return t;
	}
	
	@Override
	public UserHashrate selectByUUID(String uuid) {
		
		logger.info("UserHashrateServiceImpl exe method selectByUUID?uuid={}",uuid);
		UserHashrate t = userHashrateDao.selectByUUID(uuid);
		logger.info("UserHashrateServiceImpl exe method selectByUUID out:{}",t);
		
		return t;
	}
	
	@Override
	public void selectTList(Pager<UserHashrate> pager) {
		logger.info("UserHashrateServiceImpl exe method selectTList?pager={}",pager);
		
		if(pager.getLimitStart()>=0){
			int totalCount = userHashrateDao.selectTListCount(pager);
			int numPerPage = SqlUtil.checkPageSize(pager.getNumPerPage());
			int currentPage = SqlUtil.checkPageCurrent(totalCount, numPerPage, pager.getPageNum());
			pager.setLimitStart(SqlUtil.countOffset(currentPage, numPerPage));
			pager.setPageSize(numPerPage);
			pager.setCurrentPage(currentPage);
			pager.setTotalCount(totalCount);
			pager.setTotalPage(totalCount%numPerPage==0?totalCount/numPerPage:totalCount/numPerPage+1);
		}
		List<UserHashrate> list = userHashrateDao.selectTList(pager);
		pager.setList(list);
		
		logger.info("BaseAdServiceImpl exe method selectTList?out={}",pager);
	}
	
	@Override
	public void deleteById(int id) {
		logger.info("UserHashrateServiceImpl exe method deleteById?id={}",id);
		
		userHashrateDao.deleteById(id);
		
		logger.info("UserHashrateServiceImpl exe method deleteById");
	}
	
	@Override
	public int insert(UserHashrate t) {
		
		logger.info("UserHashrateServiceImpl exe method insert?t={}",t);
		
		int i = userHashrateDao.insert(t);
		
		logger.info("UserHashrateServiceImpl exe method insert out={}",i);
		
		return i;
	}
	
	@Override
	public int updateObj(UserHashrate t) {
		
		logger.info("UserHashrateServiceImpl exe method updateObj?t={}",t);
		
		int i = userHashrateDao.updateObj(t);
		
		logger.info("UserHashrateServiceImpl exe method updateObj out={}",i);
		
		return i;
	}

}
