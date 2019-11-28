package com.hyy.kcb.service.harddisk.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hyy.kcb.commons.base.BaseObject;
import com.hyy.kcb.commons.page.Pager;
import com.hyy.kcb.commons.page.SqlUtil;
import com.hyy.kcb.dao.harddisk.IHardDiskUnleasingRecordsDao;
import com.hyy.kcb.domain.harddisk.HardDiskUnleasingRecords;
import com.hyy.kcb.service.harddisk.IHardDiskUnleasingRecordsService;

/**
 * @author WhiteLee
 * 功能描述:硬盘解压管理
 */
@Service
public class  HardDiskUnleasingRecordsServiceImpl extends BaseObject implements IHardDiskUnleasingRecordsService {
	

	@Autowired
    private IHardDiskUnleasingRecordsDao hardDiskUnleasingRecordsDao;
    
    @Override
	public List<HardDiskUnleasingRecords> selectAll() {
		logger.info("HardDiskUnleasingRecordsServiceImpl exe method selectAll");
		List<HardDiskUnleasingRecords> list = hardDiskUnleasingRecordsDao.selectAll();
		logger.info("HardDiskUnleasingRecordsServiceImpl exe method selectAll out:{}",list);
		return list;
	}
	
	@Override
	public HardDiskUnleasingRecords selectById(int id) {
		logger.info("HardDiskUnleasingRecordsServiceImpl exe method selectById?id={}",id);
		HardDiskUnleasingRecords t = hardDiskUnleasingRecordsDao.selectById(id);
		logger.info("HardDiskUnleasingRecordsServiceImpl exe method selectById out:{}",t);
		return t;
	}
	
	@Override
	public HardDiskUnleasingRecords selectByUUID(String uuid) {
		
		logger.info("HardDiskUnleasingRecordsServiceImpl exe method selectByUUID?uuid={}",uuid);
		HardDiskUnleasingRecords t = hardDiskUnleasingRecordsDao.selectByUUID(uuid);
		logger.info("HardDiskUnleasingRecordsServiceImpl exe method selectByUUID out:{}",t);
		
		return t;
	}
	
	@Override
	public void selectTList(Pager<HardDiskUnleasingRecords> pager) {
		logger.info("HardDiskUnleasingRecordsServiceImpl exe method selectTList?pager={}",pager);
		
		if(pager.getLimitStart()>=0){
			int totalCount = hardDiskUnleasingRecordsDao.selectTListCount(pager);
			int numPerPage = SqlUtil.checkPageSize(pager.getNumPerPage());
			int currentPage = SqlUtil.checkPageCurrent(totalCount, numPerPage, pager.getPageNum());
			pager.setLimitStart(SqlUtil.countOffset(currentPage, numPerPage));
			pager.setPageSize(numPerPage);
			pager.setCurrentPage(currentPage);
			pager.setTotalCount(totalCount);
			pager.setTotalPage(totalCount%numPerPage==0?totalCount/numPerPage:totalCount/numPerPage+1);
		}
		List<HardDiskUnleasingRecords> list = hardDiskUnleasingRecordsDao.selectTList(pager);
		pager.setList(list);
		
		logger.info("BaseAdServiceImpl exe method selectTList?out={}",pager);
	}
	
	@Override
	public void deleteById(int id) {
		logger.info("HardDiskUnleasingRecordsServiceImpl exe method deleteById?id={}",id);
		
		hardDiskUnleasingRecordsDao.deleteById(id);
		
		logger.info("HardDiskUnleasingRecordsServiceImpl exe method deleteById");
	}
	
	@Override
	public int insert(HardDiskUnleasingRecords t) {
		
		logger.info("HardDiskUnleasingRecordsServiceImpl exe method insert?t={}",t);
		
		int i = hardDiskUnleasingRecordsDao.insert(t);
		
		logger.info("HardDiskUnleasingRecordsServiceImpl exe method insert out={}",i);
		
		return i;
	}
	
	@Override
	public int updateObj(HardDiskUnleasingRecords t) {
		
		logger.info("HardDiskUnleasingRecordsServiceImpl exe method updateObj?t={}",t);
		
		int i = hardDiskUnleasingRecordsDao.updateObj(t);
		
		logger.info("HardDiskUnleasingRecordsServiceImpl exe method updateObj out={}",i);
		
		return i;
	}

}
