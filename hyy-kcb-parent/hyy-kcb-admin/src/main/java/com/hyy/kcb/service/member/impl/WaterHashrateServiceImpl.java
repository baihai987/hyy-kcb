package com.hyy.kcb.service.member.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hyy.kcb.commons.base.BaseObject;
import com.hyy.kcb.commons.page.Pager;
import com.hyy.kcb.commons.page.SqlUtil;
import com.hyy.kcb.dao.member.IWaterHashrateDao;
import com.hyy.kcb.domain.member.WaterHashrate;
import com.hyy.kcb.service.member.IWaterHashrateService;

/**
 * @author WhiteLee
 * 功能描述:用户算力流水管理
 */
@Service
public class  WaterHashrateServiceImpl extends BaseObject implements IWaterHashrateService {
	

	@Autowired
    private IWaterHashrateDao waterHashrateDao;
    
    @Override
	public List<WaterHashrate> selectAll() {
		logger.info("WaterHashrateServiceImpl exe method selectAll");
		List<WaterHashrate> list = waterHashrateDao.selectAll();
		logger.info("WaterHashrateServiceImpl exe method selectAll out:{}",list);
		return list;
	}
	
	@Override
	public WaterHashrate selectById(int id) {
		logger.info("WaterHashrateServiceImpl exe method selectById?id={}",id);
		WaterHashrate t = waterHashrateDao.selectById(id);
		logger.info("WaterHashrateServiceImpl exe method selectById out:{}",t);
		return t;
	}
	
	@Override
	public WaterHashrate selectByUUID(String uuid) {
		
		logger.info("WaterHashrateServiceImpl exe method selectByUUID?uuid={}",uuid);
		WaterHashrate t = waterHashrateDao.selectByUUID(uuid);
		logger.info("WaterHashrateServiceImpl exe method selectByUUID out:{}",t);
		
		return t;
	}
	
	@Override
	public void selectTList(Pager<WaterHashrate> pager) {
		logger.info("WaterHashrateServiceImpl exe method selectTList?pager={}",pager);
		
		if(pager.getLimitStart()>=0){
			int totalCount = waterHashrateDao.selectTListCount(pager);
			int numPerPage = SqlUtil.checkPageSize(pager.getNumPerPage());
			int currentPage = SqlUtil.checkPageCurrent(totalCount, numPerPage, pager.getPageNum());
			pager.setLimitStart(SqlUtil.countOffset(currentPage, numPerPage));
			pager.setPageSize(numPerPage);
			pager.setCurrentPage(currentPage);
			pager.setTotalCount(totalCount);
			pager.setTotalPage(totalCount%numPerPage==0?totalCount/numPerPage:totalCount/numPerPage+1);
		}
		List<WaterHashrate> list = waterHashrateDao.selectTList(pager);
		pager.setList(list);
		
		logger.info("BaseAdServiceImpl exe method selectTList?out={}",pager);
	}
	
	@Override
	public void deleteById(int id) {
		logger.info("WaterHashrateServiceImpl exe method deleteById?id={}",id);
		
		waterHashrateDao.deleteById(id);
		
		logger.info("WaterHashrateServiceImpl exe method deleteById");
	}
	
	@Override
	public int insert(WaterHashrate t) {
		
		logger.info("WaterHashrateServiceImpl exe method insert?t={}",t);
		
		int i = waterHashrateDao.insert(t);
		
		logger.info("WaterHashrateServiceImpl exe method insert out={}",i);
		
		return i;
	}
	
	@Override
	public int updateObj(WaterHashrate t) {
		
		logger.info("WaterHashrateServiceImpl exe method updateObj?t={}",t);
		
		int i = waterHashrateDao.updateObj(t);
		
		logger.info("WaterHashrateServiceImpl exe method updateObj out={}",i);
		
		return i;
	}

}
