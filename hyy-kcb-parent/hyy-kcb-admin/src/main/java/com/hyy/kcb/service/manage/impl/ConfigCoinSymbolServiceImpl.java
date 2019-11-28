package com.hyy.kcb.service.manage.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hyy.kcb.commons.base.BaseObject;
import com.hyy.kcb.commons.page.Pager;
import com.hyy.kcb.commons.page.SqlUtil;
import com.hyy.kcb.dao.manage.IConfigCoinSymbolDao;
import com.hyy.kcb.domain.manage.ConfigCoinSymbol;
import com.hyy.kcb.service.manage.IConfigCoinSymbolService;

/**
 * @author WhiteLee
 * 功能描述:币种配置(un)管理
 */
@Service
public class  ConfigCoinSymbolServiceImpl extends BaseObject implements IConfigCoinSymbolService {
	

	@Autowired
    private IConfigCoinSymbolDao configCoinSymbolDao;
    
    @Override
	public List<ConfigCoinSymbol> selectAll() {
		logger.info("ConfigCoinSymbolServiceImpl exe method selectAll");
		List<ConfigCoinSymbol> list = configCoinSymbolDao.selectAll();
		logger.info("ConfigCoinSymbolServiceImpl exe method selectAll out:{}",list);
		return list;
	}
	
	@Override
	public ConfigCoinSymbol selectById(int id) {
		logger.info("ConfigCoinSymbolServiceImpl exe method selectById?id={}",id);
		ConfigCoinSymbol t = configCoinSymbolDao.selectById(id);
		logger.info("ConfigCoinSymbolServiceImpl exe method selectById out:{}",t);
		return t;
	}
	
	@Override
	public ConfigCoinSymbol selectByUUID(String uuid) {
		
		logger.info("ConfigCoinSymbolServiceImpl exe method selectByUUID?uuid={}",uuid);
		ConfigCoinSymbol t = configCoinSymbolDao.selectByUUID(uuid);
		logger.info("ConfigCoinSymbolServiceImpl exe method selectByUUID out:{}",t);
		
		return t;
	}
	
	@Override
	public void selectTList(Pager<ConfigCoinSymbol> pager) {
		logger.info("ConfigCoinSymbolServiceImpl exe method selectTList?pager={}",pager);
		
		if(pager.getLimitStart()>=0){
			int totalCount = configCoinSymbolDao.selectTListCount(pager);
			int numPerPage = SqlUtil.checkPageSize(pager.getNumPerPage());
			int currentPage = SqlUtil.checkPageCurrent(totalCount, numPerPage, pager.getPageNum());
			pager.setLimitStart(SqlUtil.countOffset(currentPage, numPerPage));
			pager.setPageSize(numPerPage);
			pager.setCurrentPage(currentPage);
			pager.setTotalCount(totalCount);
			pager.setTotalPage(totalCount%numPerPage==0?totalCount/numPerPage:totalCount/numPerPage+1);
		}
		List<ConfigCoinSymbol> list = configCoinSymbolDao.selectTList(pager);
		pager.setList(list);
		
		logger.info("BaseAdServiceImpl exe method selectTList?out={}",pager);
	}
	
	@Override
	public void deleteById(int id) {
		logger.info("ConfigCoinSymbolServiceImpl exe method deleteById?id={}",id);
		
		configCoinSymbolDao.deleteById(id);
		
		logger.info("ConfigCoinSymbolServiceImpl exe method deleteById");
	}
	
	@Override
	public int insert(ConfigCoinSymbol t) {
		
		logger.info("ConfigCoinSymbolServiceImpl exe method insert?t={}",t);
		
		int i = configCoinSymbolDao.insert(t);
		
		logger.info("ConfigCoinSymbolServiceImpl exe method insert out={}",i);
		
		return i;
	}
	
	@Override
	public int updateObj(ConfigCoinSymbol t) {
		
		logger.info("ConfigCoinSymbolServiceImpl exe method updateObj?t={}",t);
		
		int i = configCoinSymbolDao.updateObj(t);
		
		logger.info("ConfigCoinSymbolServiceImpl exe method updateObj out={}",i);
		
		return i;
	}

}
