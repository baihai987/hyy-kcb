package com.hyy.kcb.service.order.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hyy.kcb.commons.base.BaseObject;
import com.hyy.kcb.commons.page.Pager;
import com.hyy.kcb.commons.page.SqlUtil;
import com.hyy.kcb.dao.order.IPurchasedHardDiskContractDao;
import com.hyy.kcb.domain.order.PurchasedHardDiskContract;
import com.hyy.kcb.service.order.IPurchasedHardDiskContractService;

/**
 * @author WhiteLee
 * 功能描述:合约到期记录管理
 */
@Service
public class  PurchasedHardDiskContractServiceImpl extends BaseObject implements IPurchasedHardDiskContractService {
	

	@Autowired
    private IPurchasedHardDiskContractDao purchasedHardDiskContractDao;
    
    @Override
	public List<PurchasedHardDiskContract> selectAll() {
		logger.info("PurchasedHardDiskContractServiceImpl exe method selectAll");
		List<PurchasedHardDiskContract> list = purchasedHardDiskContractDao.selectAll();
		logger.info("PurchasedHardDiskContractServiceImpl exe method selectAll out:{}",list);
		return list;
	}
	
	@Override
	public PurchasedHardDiskContract selectById(int id) {
		logger.info("PurchasedHardDiskContractServiceImpl exe method selectById?id={}",id);
		PurchasedHardDiskContract t = purchasedHardDiskContractDao.selectById(id);
		logger.info("PurchasedHardDiskContractServiceImpl exe method selectById out:{}",t);
		return t;
	}
	
	@Override
	public PurchasedHardDiskContract selectByUUID(String uuid) {
		
		logger.info("PurchasedHardDiskContractServiceImpl exe method selectByUUID?uuid={}",uuid);
		PurchasedHardDiskContract t = purchasedHardDiskContractDao.selectByUUID(uuid);
		logger.info("PurchasedHardDiskContractServiceImpl exe method selectByUUID out:{}",t);
		
		return t;
	}
	
	@Override
	public void selectTList(Pager<PurchasedHardDiskContract> pager) {
		logger.info("PurchasedHardDiskContractServiceImpl exe method selectTList?pager={}",pager);
		
		if(pager.getLimitStart()>=0){
			int totalCount = purchasedHardDiskContractDao.selectTListCount(pager);
			int numPerPage = SqlUtil.checkPageSize(pager.getNumPerPage());
			int currentPage = SqlUtil.checkPageCurrent(totalCount, numPerPage, pager.getPageNum());
			pager.setLimitStart(SqlUtil.countOffset(currentPage, numPerPage));
			pager.setPageSize(numPerPage);
			pager.setCurrentPage(currentPage);
			pager.setTotalCount(totalCount);
			pager.setTotalPage(totalCount%numPerPage==0?totalCount/numPerPage:totalCount/numPerPage+1);
		}
		List<PurchasedHardDiskContract> list = purchasedHardDiskContractDao.selectTList(pager);
		pager.setList(list);
		
		logger.info("BaseAdServiceImpl exe method selectTList?out={}",pager);
	}
	
	@Override
	public void deleteById(int id) {
		logger.info("PurchasedHardDiskContractServiceImpl exe method deleteById?id={}",id);
		
		purchasedHardDiskContractDao.deleteById(id);
		
		logger.info("PurchasedHardDiskContractServiceImpl exe method deleteById");
	}
	
	@Override
	public int insert(PurchasedHardDiskContract t) {
		
		logger.info("PurchasedHardDiskContractServiceImpl exe method insert?t={}",t);
		
		int i = purchasedHardDiskContractDao.insert(t);
		
		logger.info("PurchasedHardDiskContractServiceImpl exe method insert out={}",i);
		
		return i;
	}
	
	@Override
	public int updateObj(PurchasedHardDiskContract t) {
		
		logger.info("PurchasedHardDiskContractServiceImpl exe method updateObj?t={}",t);
		
		int i = purchasedHardDiskContractDao.updateObj(t);
		
		logger.info("PurchasedHardDiskContractServiceImpl exe method updateObj out={}",i);
		
		return i;
	}

}
