package com.hyy.kcb.service.configuration.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hyy.kcb.commons.base.BaseObject;
import com.hyy.kcb.commons.page.Pager;
import com.hyy.kcb.commons.page.SqlUtil;
import com.hyy.kcb.dao.configuration.IHardDiskDao;
import com.hyy.kcb.domain.configuration.HardDisk;
import com.hyy.kcb.service.configuration.IHardDiskService;

/**
 * @author WhiteLee
 * 功能描述:硬盘配置管理
 */
@Service
public class  HardDiskServiceImpl extends BaseObject implements IHardDiskService {
	

	@Autowired
    private IHardDiskDao hardDiskDao;
    
    @Override
	public List<HardDisk> selectAll() {
		logger.info("HardDiskServiceImpl exe method selectAll");
		List<HardDisk> list = hardDiskDao.selectAll();
		logger.info("HardDiskServiceImpl exe method selectAll out:{}",list);
		return list;
	}
	
	@Override
	public HardDisk selectById(int id) {
		logger.info("HardDiskServiceImpl exe method selectById?id={}",id);
		HardDisk t = hardDiskDao.selectById(id);
		logger.info("HardDiskServiceImpl exe method selectById out:{}",t);
		return t;
	}
	
	@Override
	public HardDisk selectByUUID(String uuid) {
		
		logger.info("HardDiskServiceImpl exe method selectByUUID?uuid={}",uuid);
		HardDisk t = hardDiskDao.selectByUUID(uuid);
		logger.info("HardDiskServiceImpl exe method selectByUUID out:{}",t);
		
		return t;
	}
	
	@Override
	public void selectTList(Pager<HardDisk> pager) {
		logger.info("HardDiskServiceImpl exe method selectTList?pager={}",pager);
		
		if(pager.getLimitStart()>=0){
			int totalCount = hardDiskDao.selectTListCount(pager);
			int numPerPage = SqlUtil.checkPageSize(pager.getNumPerPage());
			int currentPage = SqlUtil.checkPageCurrent(totalCount, numPerPage, pager.getPageNum());
			pager.setLimitStart(SqlUtil.countOffset(currentPage, numPerPage));
			pager.setPageSize(numPerPage);
			pager.setCurrentPage(currentPage);
			pager.setTotalCount(totalCount);
			pager.setTotalPage(totalCount%numPerPage==0?totalCount/numPerPage:totalCount/numPerPage+1);
		}
		List<HardDisk> list = hardDiskDao.selectTList(pager);
		pager.setList(list);
		
		logger.info("BaseAdServiceImpl exe method selectTList?out={}",pager);
	}
	
	@Override
	public void deleteById(int id) {
		logger.info("HardDiskServiceImpl exe method deleteById?id={}",id);
		
		hardDiskDao.deleteById(id);
		
		logger.info("HardDiskServiceImpl exe method deleteById");
	}
	
	@Override
	public int insert(HardDisk t) {
		
		logger.info("HardDiskServiceImpl exe method insert?t={}",t);
		
		int i = hardDiskDao.insert(t);
		
		logger.info("HardDiskServiceImpl exe method insert out={}",i);
		
		return i;
	}
	
	@Override
	public int updateObj(HardDisk t) {
		
		logger.info("HardDiskServiceImpl exe method updateObj?t={}",t);
		
		int i = hardDiskDao.updateObj(t);
		
		logger.info("HardDiskServiceImpl exe method updateObj out={}",i);
		
		return i;
	}

}
