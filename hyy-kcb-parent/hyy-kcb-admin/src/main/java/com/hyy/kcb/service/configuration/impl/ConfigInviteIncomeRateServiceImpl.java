package com.hyy.kcb.service.configuration.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hyy.kcb.commons.base.BaseObject;
import com.hyy.kcb.commons.page.Pager;
import com.hyy.kcb.commons.page.SqlUtil;
import com.hyy.kcb.dao.configuration.IConfigInviteIncomeRateDao;
import com.hyy.kcb.domain.configuration.ConfigInviteIncomeRate;
import com.hyy.kcb.service.configuration.IConfigInviteIncomeRateService;

/**
 * @author WhiteLee
 * 功能描述:布道代数算力配置管理
 */
@Service
public class  ConfigInviteIncomeRateServiceImpl extends BaseObject implements IConfigInviteIncomeRateService {
	

	@Autowired
    private IConfigInviteIncomeRateDao configInviteIncomeRateDao;
    
    @Override
	public List<ConfigInviteIncomeRate> selectAll() {
		logger.info("ConfigInviteIncomeRateServiceImpl exe method selectAll");
		List<ConfigInviteIncomeRate> list = configInviteIncomeRateDao.selectAll();
		logger.info("ConfigInviteIncomeRateServiceImpl exe method selectAll out:{}",list);
		return list;
	}
	
	@Override
	public ConfigInviteIncomeRate selectById(int id) {
		logger.info("ConfigInviteIncomeRateServiceImpl exe method selectById?id={}",id);
		ConfigInviteIncomeRate t = configInviteIncomeRateDao.selectById(id);
		logger.info("ConfigInviteIncomeRateServiceImpl exe method selectById out:{}",t);
		return t;
	}
	
	@Override
	public ConfigInviteIncomeRate selectByUUID(String uuid) {
		
		logger.info("ConfigInviteIncomeRateServiceImpl exe method selectByUUID?uuid={}",uuid);
		ConfigInviteIncomeRate t = configInviteIncomeRateDao.selectByUUID(uuid);
		logger.info("ConfigInviteIncomeRateServiceImpl exe method selectByUUID out:{}",t);
		
		return t;
	}
	
	@Override
	public void selectTList(Pager<ConfigInviteIncomeRate> pager) {
		logger.info("ConfigInviteIncomeRateServiceImpl exe method selectTList?pager={}",pager);
		
		if(pager.getLimitStart()>=0){
			int totalCount = configInviteIncomeRateDao.selectTListCount(pager);
			int numPerPage = SqlUtil.checkPageSize(pager.getNumPerPage());
			int currentPage = SqlUtil.checkPageCurrent(totalCount, numPerPage, pager.getPageNum());
			pager.setLimitStart(SqlUtil.countOffset(currentPage, numPerPage));
			pager.setPageSize(numPerPage);
			pager.setCurrentPage(currentPage);
			pager.setTotalCount(totalCount);
			pager.setTotalPage(totalCount%numPerPage==0?totalCount/numPerPage:totalCount/numPerPage+1);
		}
		List<ConfigInviteIncomeRate> list = configInviteIncomeRateDao.selectTList(pager);
		pager.setList(list);
		
		logger.info("BaseAdServiceImpl exe method selectTList?out={}",pager);
	}
	
	@Override
	public void deleteById(int id) {
		logger.info("ConfigInviteIncomeRateServiceImpl exe method deleteById?id={}",id);
		
		configInviteIncomeRateDao.deleteById(id);
		
		logger.info("ConfigInviteIncomeRateServiceImpl exe method deleteById");
	}
	
	@Override
	public int insert(ConfigInviteIncomeRate t) {
		
		logger.info("ConfigInviteIncomeRateServiceImpl exe method insert?t={}",t);
		
		int i = configInviteIncomeRateDao.insert(t);
		
		logger.info("ConfigInviteIncomeRateServiceImpl exe method insert out={}",i);
		
		return i;
	}
	
	@Override
	public int updateObj(ConfigInviteIncomeRate t) {
		
		logger.info("ConfigInviteIncomeRateServiceImpl exe method updateObj?t={}",t);
		
		int i = configInviteIncomeRateDao.updateObj(t);
		
		logger.info("ConfigInviteIncomeRateServiceImpl exe method updateObj out={}",i);
		
		return i;
	}

}
