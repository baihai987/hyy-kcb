package com.hyy.kcb.service.manage.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hyy.kcb.commons.base.BaseObject;
import com.hyy.kcb.commons.page.Pager;
import com.hyy.kcb.commons.page.SqlUtil;
import com.hyy.kcb.dao.manage.IHardDiskOrderDao;
import com.hyy.kcb.domain.manage.HardDiskOrder;
import com.hyy.kcb.service.manage.IHardDiskOrderService;

/**
 * @author WhiteLee
 * 功能描述:硬盘订单(un)管理
 */
@Service
public class  HardDiskOrderServiceImpl extends BaseObject implements IHardDiskOrderService {
	

	@Autowired
    private IHardDiskOrderDao hardDiskOrderDao;
    
    @Override
	public List<HardDiskOrder> selectAll() {
		logger.info("HardDiskOrderServiceImpl exe method selectAll");
		List<HardDiskOrder> list = hardDiskOrderDao.selectAll();
		logger.info("HardDiskOrderServiceImpl exe method selectAll out:{}",list);
		return list;
	}
	
	@Override
	public HardDiskOrder selectById(int id) {
		logger.info("HardDiskOrderServiceImpl exe method selectById?id={}",id);
		HardDiskOrder t = hardDiskOrderDao.selectById(id);
		logger.info("HardDiskOrderServiceImpl exe method selectById out:{}",t);
		return t;
	}
	
	@Override
	public HardDiskOrder selectByUUID(String uuid) {
		
		logger.info("HardDiskOrderServiceImpl exe method selectByUUID?uuid={}",uuid);
		HardDiskOrder t = hardDiskOrderDao.selectByUUID(uuid);
		logger.info("HardDiskOrderServiceImpl exe method selectByUUID out:{}",t);
		
		return t;
	}
	
	@Override
	public void selectTList(Pager<HardDiskOrder> pager) {
		logger.info("HardDiskOrderServiceImpl exe method selectTList?pager={}",pager);
		
		if(pager.getLimitStart()>=0){
			int totalCount = hardDiskOrderDao.selectTListCount(pager);
			int numPerPage = SqlUtil.checkPageSize(pager.getNumPerPage());
			int currentPage = SqlUtil.checkPageCurrent(totalCount, numPerPage, pager.getPageNum());
			pager.setLimitStart(SqlUtil.countOffset(currentPage, numPerPage));
			pager.setPageSize(numPerPage);
			pager.setCurrentPage(currentPage);
			pager.setTotalCount(totalCount);
			pager.setTotalPage(totalCount%numPerPage==0?totalCount/numPerPage:totalCount/numPerPage+1);
		}
		List<HardDiskOrder> list = hardDiskOrderDao.selectTList(pager);
		pager.setList(list);
		
		logger.info("BaseAdServiceImpl exe method selectTList?out={}",pager);
	}
	
	@Override
	public void deleteById(int id) {
		logger.info("HardDiskOrderServiceImpl exe method deleteById?id={}",id);
		
		hardDiskOrderDao.deleteById(id);
		
		logger.info("HardDiskOrderServiceImpl exe method deleteById");
	}
	
	@Override
	public int insert(HardDiskOrder t) {
		
		logger.info("HardDiskOrderServiceImpl exe method insert?t={}",t);
		
		int i = hardDiskOrderDao.insert(t);
		
		logger.info("HardDiskOrderServiceImpl exe method insert out={}",i);
		
		return i;
	}
	
	@Override
	public int updateObj(HardDiskOrder t) {
		
		logger.info("HardDiskOrderServiceImpl exe method updateObj?t={}",t);
		
		int i = hardDiskOrderDao.updateObj(t);
		
		logger.info("HardDiskOrderServiceImpl exe method updateObj out={}",i);
		
		return i;
	}

}
