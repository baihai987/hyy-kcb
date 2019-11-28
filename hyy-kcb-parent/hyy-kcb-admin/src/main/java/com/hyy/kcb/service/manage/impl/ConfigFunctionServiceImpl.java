package com.hyy.kcb.service.manage.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hyy.kcb.commons.base.BaseObject;
import com.hyy.kcb.commons.page.Pager;
import com.hyy.kcb.commons.page.SqlUtil;
import com.hyy.kcb.dao.manage.IConfigFunctionDao;
import com.hyy.kcb.domain.manage.ConfigFunction;
import com.hyy.kcb.service.manage.IConfigFunctionService;

/**
 * @author WhiteLee
 * 功能描述:方法管理(un)管理
 */
@Service
public class  ConfigFunctionServiceImpl extends BaseObject implements IConfigFunctionService {
	

	@Autowired
    private IConfigFunctionDao configFunctionDao;
    
    @Override
	public List<ConfigFunction> selectAll() {
		logger.info("ConfigFunctionServiceImpl exe method selectAll");
		List<ConfigFunction> list = configFunctionDao.selectAll();
		logger.info("ConfigFunctionServiceImpl exe method selectAll out:{}",list);
		return list;
	}
	
	@Override
	public ConfigFunction selectById(int id) {
		logger.info("ConfigFunctionServiceImpl exe method selectById?id={}",id);
		ConfigFunction t = configFunctionDao.selectById(id);
		logger.info("ConfigFunctionServiceImpl exe method selectById out:{}",t);
		return t;
	}
	
	@Override
	public ConfigFunction selectByUUID(String uuid) {
		
		logger.info("ConfigFunctionServiceImpl exe method selectByUUID?uuid={}",uuid);
		ConfigFunction t = configFunctionDao.selectByUUID(uuid);
		logger.info("ConfigFunctionServiceImpl exe method selectByUUID out:{}",t);
		
		return t;
	}
	
	@Override
	public void selectTList(Pager<ConfigFunction> pager) {
		logger.info("ConfigFunctionServiceImpl exe method selectTList?pager={}",pager);
		
		if(pager.getLimitStart()>=0){
			int totalCount = configFunctionDao.selectTListCount(pager);
			int numPerPage = SqlUtil.checkPageSize(pager.getNumPerPage());
			int currentPage = SqlUtil.checkPageCurrent(totalCount, numPerPage, pager.getPageNum());
			pager.setLimitStart(SqlUtil.countOffset(currentPage, numPerPage));
			pager.setPageSize(numPerPage);
			pager.setCurrentPage(currentPage);
			pager.setTotalCount(totalCount);
			pager.setTotalPage(totalCount%numPerPage==0?totalCount/numPerPage:totalCount/numPerPage+1);
		}
		List<ConfigFunction> list = configFunctionDao.selectTList(pager);
		pager.setList(list);
		
		logger.info("BaseAdServiceImpl exe method selectTList?out={}",pager);
	}
	
	@Override
	public void deleteById(int id) {
		logger.info("ConfigFunctionServiceImpl exe method deleteById?id={}",id);
		
		configFunctionDao.deleteById(id);
		
		logger.info("ConfigFunctionServiceImpl exe method deleteById");
	}
	
	@Override
	public int insert(ConfigFunction t) {
		
		logger.info("ConfigFunctionServiceImpl exe method insert?t={}",t);
		
		int i = configFunctionDao.insert(t);
		
		logger.info("ConfigFunctionServiceImpl exe method insert out={}",i);
		
		return i;
	}
	
	@Override
	public int updateObj(ConfigFunction t) {
		
		logger.info("ConfigFunctionServiceImpl exe method updateObj?t={}",t);
		
		int i = configFunctionDao.updateObj(t);
		
		logger.info("ConfigFunctionServiceImpl exe method updateObj out={}",i);
		
		return i;
	}

}
