package com.hyy.kcb.service.configuration.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hyy.kcb.commons.base.BaseObject;
import com.hyy.kcb.commons.page.Pager;
import com.hyy.kcb.commons.page.SqlUtil;
import com.hyy.kcb.dao.configuration.ISumHashrateDao;
import com.hyy.kcb.domain.configuration.SumHashrate;
import com.hyy.kcb.service.configuration.ISumHashrateService;

/**
 * @author WhiteLee
 * 功能描述:总算力配置管理
 */
@Service
public class  SumHashrateServiceImpl extends BaseObject implements ISumHashrateService {
	

	@Autowired
    private ISumHashrateDao sumHashrateDao;
    
    @Override
	public List<SumHashrate> selectAll() {
		logger.info("SumHashrateServiceImpl exe method selectAll");
		List<SumHashrate> list = sumHashrateDao.selectAll();
		logger.info("SumHashrateServiceImpl exe method selectAll out:{}",list);
		return list;
	}
	
	@Override
	public SumHashrate selectById(int id) {
		logger.info("SumHashrateServiceImpl exe method selectById?id={}",id);
		SumHashrate t = sumHashrateDao.selectById(id);
		logger.info("SumHashrateServiceImpl exe method selectById out:{}",t);
		return t;
	}
	
	@Override
	public SumHashrate selectByUUID(String uuid) {
		
		logger.info("SumHashrateServiceImpl exe method selectByUUID?uuid={}",uuid);
		SumHashrate t = sumHashrateDao.selectByUUID(uuid);
		logger.info("SumHashrateServiceImpl exe method selectByUUID out:{}",t);
		
		return t;
	}
	
	@Override
	public void selectTList(Pager<SumHashrate> pager) {
		logger.info("SumHashrateServiceImpl exe method selectTList?pager={}",pager);
		
		if(pager.getLimitStart()>=0){
			int totalCount = sumHashrateDao.selectTListCount(pager);
			int numPerPage = SqlUtil.checkPageSize(pager.getNumPerPage());
			int currentPage = SqlUtil.checkPageCurrent(totalCount, numPerPage, pager.getPageNum());
			pager.setLimitStart(SqlUtil.countOffset(currentPage, numPerPage));
			pager.setPageSize(numPerPage);
			pager.setCurrentPage(currentPage);
			pager.setTotalCount(totalCount);
			pager.setTotalPage(totalCount%numPerPage==0?totalCount/numPerPage:totalCount/numPerPage+1);
		}
		List<SumHashrate> list = sumHashrateDao.selectTList(pager);
		pager.setList(list);
		
		logger.info("BaseAdServiceImpl exe method selectTList?out={}",pager);
	}
	
	@Override
	public void deleteById(int id) {
		logger.info("SumHashrateServiceImpl exe method deleteById?id={}",id);
		
		sumHashrateDao.deleteById(id);
		
		logger.info("SumHashrateServiceImpl exe method deleteById");
	}
	
	@Override
	public int insert(SumHashrate t) {
		
		logger.info("SumHashrateServiceImpl exe method insert?t={}",t);
		
		int i = sumHashrateDao.insert(t);
		
		logger.info("SumHashrateServiceImpl exe method insert out={}",i);
		
		return i;
	}
	
	@Override
	public int updateObj(SumHashrate t) {
		
		logger.info("SumHashrateServiceImpl exe method updateObj?t={}",t);
		
		int i = sumHashrateDao.updateObj(t);
		
		logger.info("SumHashrateServiceImpl exe method updateObj out={}",i);
		
		return i;
	}

}
