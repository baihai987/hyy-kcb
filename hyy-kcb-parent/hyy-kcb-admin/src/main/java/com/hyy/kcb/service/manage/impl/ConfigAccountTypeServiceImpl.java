package com.hyy.kcb.service.manage.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hyy.kcb.commons.base.BaseObject;
import com.hyy.kcb.commons.page.Pager;
import com.hyy.kcb.commons.page.SqlUtil;
import com.hyy.kcb.dao.manage.IConfigAccountTypeDao;
import com.hyy.kcb.domain.manage.ConfigAccountType;
import com.hyy.kcb.service.manage.IConfigAccountTypeService;

/**
 * @author WhiteLee
 * 功能描述:资产类型(un)管理
 */
@Service
public class  ConfigAccountTypeServiceImpl extends BaseObject implements IConfigAccountTypeService {
	

	@Autowired
    private IConfigAccountTypeDao configAccountTypeDao;
    
    @Override
	public List<ConfigAccountType> selectAll() {
		logger.info("ConfigAccountTypeServiceImpl exe method selectAll");
		List<ConfigAccountType> list = configAccountTypeDao.selectAll();
		logger.info("ConfigAccountTypeServiceImpl exe method selectAll out:{}",list);
		return list;
	}
	
	@Override
	public ConfigAccountType selectById(int id) {
		logger.info("ConfigAccountTypeServiceImpl exe method selectById?id={}",id);
		ConfigAccountType t = configAccountTypeDao.selectById(id);
		logger.info("ConfigAccountTypeServiceImpl exe method selectById out:{}",t);
		return t;
	}
	
	@Override
	public ConfigAccountType selectByUUID(String uuid) {
		
		logger.info("ConfigAccountTypeServiceImpl exe method selectByUUID?uuid={}",uuid);
		ConfigAccountType t = configAccountTypeDao.selectByUUID(uuid);
		logger.info("ConfigAccountTypeServiceImpl exe method selectByUUID out:{}",t);
		
		return t;
	}
	
	@Override
	public void selectTList(Pager<ConfigAccountType> pager) {
		logger.info("ConfigAccountTypeServiceImpl exe method selectTList?pager={}",pager);
		
		if(pager.getLimitStart()>=0){
			int totalCount = configAccountTypeDao.selectTListCount(pager);
			int numPerPage = SqlUtil.checkPageSize(pager.getNumPerPage());
			int currentPage = SqlUtil.checkPageCurrent(totalCount, numPerPage, pager.getPageNum());
			pager.setLimitStart(SqlUtil.countOffset(currentPage, numPerPage));
			pager.setPageSize(numPerPage);
			pager.setCurrentPage(currentPage);
			pager.setTotalCount(totalCount);
			pager.setTotalPage(totalCount%numPerPage==0?totalCount/numPerPage:totalCount/numPerPage+1);
		}
		List<ConfigAccountType> list = configAccountTypeDao.selectTList(pager);
		pager.setList(list);
		
		logger.info("BaseAdServiceImpl exe method selectTList?out={}",pager);
	}
	
	@Override
	public void deleteById(int id) {
		logger.info("ConfigAccountTypeServiceImpl exe method deleteById?id={}",id);
		
		configAccountTypeDao.deleteById(id);
		
		logger.info("ConfigAccountTypeServiceImpl exe method deleteById");
	}
	
	@Override
	public int insert(ConfigAccountType t) {
		
		logger.info("ConfigAccountTypeServiceImpl exe method insert?t={}",t);
		
		int i = configAccountTypeDao.insert(t);
		
		logger.info("ConfigAccountTypeServiceImpl exe method insert out={}",i);
		
		return i;
	}
	
	@Override
	public int updateObj(ConfigAccountType t) {
		
		logger.info("ConfigAccountTypeServiceImpl exe method updateObj?t={}",t);
		
		int i = configAccountTypeDao.updateObj(t);
		
		logger.info("ConfigAccountTypeServiceImpl exe method updateObj out={}",i);
		
		return i;
	}

}
