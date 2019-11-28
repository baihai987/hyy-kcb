package com.hyy.kcb.service.mine.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hyy.kcb.commons.base.BaseObject;
import com.hyy.kcb.commons.page.Pager;
import com.hyy.kcb.commons.page.SqlUtil;
import com.hyy.kcb.dao.mine.IMiningRecordsDao;
import com.hyy.kcb.domain.mine.MiningRecords;
import com.hyy.kcb.service.mine.IMiningRecordsService;

/**
 * @author WhiteLee
 * 功能描述:挖矿记录管理
 */
@Service
public class  MiningRecordsServiceImpl extends BaseObject implements IMiningRecordsService {
	

	@Autowired
    private IMiningRecordsDao miningRecordsDao;
    
    @Override
	public List<MiningRecords> selectAll() {
		logger.info("MiningRecordsServiceImpl exe method selectAll");
		List<MiningRecords> list = miningRecordsDao.selectAll();
		logger.info("MiningRecordsServiceImpl exe method selectAll out:{}",list);
		return list;
	}
	
	@Override
	public MiningRecords selectById(int id) {
		logger.info("MiningRecordsServiceImpl exe method selectById?id={}",id);
		MiningRecords t = miningRecordsDao.selectById(id);
		logger.info("MiningRecordsServiceImpl exe method selectById out:{}",t);
		return t;
	}
	
	@Override
	public MiningRecords selectByUUID(String uuid) {
		
		logger.info("MiningRecordsServiceImpl exe method selectByUUID?uuid={}",uuid);
		MiningRecords t = miningRecordsDao.selectByUUID(uuid);
		logger.info("MiningRecordsServiceImpl exe method selectByUUID out:{}",t);
		
		return t;
	}
	
	@Override
	public void selectTList(Pager<MiningRecords> pager) {
		logger.info("MiningRecordsServiceImpl exe method selectTList?pager={}",pager);
		
		if(pager.getLimitStart()>=0){
			int totalCount = miningRecordsDao.selectTListCount(pager);
			int numPerPage = SqlUtil.checkPageSize(pager.getNumPerPage());
			int currentPage = SqlUtil.checkPageCurrent(totalCount, numPerPage, pager.getPageNum());
			pager.setLimitStart(SqlUtil.countOffset(currentPage, numPerPage));
			pager.setPageSize(numPerPage);
			pager.setCurrentPage(currentPage);
			pager.setTotalCount(totalCount);
			pager.setTotalPage(totalCount%numPerPage==0?totalCount/numPerPage:totalCount/numPerPage+1);
		}
		List<MiningRecords> list = miningRecordsDao.selectTList(pager);
		pager.setList(list);
		
		logger.info("BaseAdServiceImpl exe method selectTList?out={}",pager);
	}
	
	@Override
	public void deleteById(int id) {
		logger.info("MiningRecordsServiceImpl exe method deleteById?id={}",id);
		
		miningRecordsDao.deleteById(id);
		
		logger.info("MiningRecordsServiceImpl exe method deleteById");
	}
	
	@Override
	public int insert(MiningRecords t) {
		
		logger.info("MiningRecordsServiceImpl exe method insert?t={}",t);
		
		int i = miningRecordsDao.insert(t);
		
		logger.info("MiningRecordsServiceImpl exe method insert out={}",i);
		
		return i;
	}
	
	@Override
	public int updateObj(MiningRecords t) {
		
		logger.info("MiningRecordsServiceImpl exe method updateObj?t={}",t);
		
		int i = miningRecordsDao.updateObj(t);
		
		logger.info("MiningRecordsServiceImpl exe method updateObj out={}",i);
		
		return i;
	}

}
