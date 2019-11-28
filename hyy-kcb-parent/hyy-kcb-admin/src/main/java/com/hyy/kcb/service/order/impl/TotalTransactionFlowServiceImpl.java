package com.hyy.kcb.service.order.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hyy.kcb.commons.base.BaseObject;
import com.hyy.kcb.commons.page.Pager;
import com.hyy.kcb.commons.page.SqlUtil;
import com.hyy.kcb.dao.order.ITotalTransactionFlowDao;
import com.hyy.kcb.domain.order.TotalTransactionFlow;
import com.hyy.kcb.service.order.ITotalTransactionFlowService;

/**
 * @author WhiteLee
 * 功能描述:总交易流水(contain order_form)管理
 */
@Service
public class  TotalTransactionFlowServiceImpl extends BaseObject implements ITotalTransactionFlowService {
	

	@Autowired
    private ITotalTransactionFlowDao totalTransactionFlowDao;
    
    @Override
	public List<TotalTransactionFlow> selectAll() {
		logger.info("TotalTransactionFlowServiceImpl exe method selectAll");
		List<TotalTransactionFlow> list = totalTransactionFlowDao.selectAll();
		logger.info("TotalTransactionFlowServiceImpl exe method selectAll out:{}",list);
		return list;
	}
	
	@Override
	public TotalTransactionFlow selectById(int id) {
		logger.info("TotalTransactionFlowServiceImpl exe method selectById?id={}",id);
		TotalTransactionFlow t = totalTransactionFlowDao.selectById(id);
		logger.info("TotalTransactionFlowServiceImpl exe method selectById out:{}",t);
		return t;
	}
	
	@Override
	public TotalTransactionFlow selectByUUID(String uuid) {
		
		logger.info("TotalTransactionFlowServiceImpl exe method selectByUUID?uuid={}",uuid);
		TotalTransactionFlow t = totalTransactionFlowDao.selectByUUID(uuid);
		logger.info("TotalTransactionFlowServiceImpl exe method selectByUUID out:{}",t);
		
		return t;
	}
	
	@Override
	public void selectTList(Pager<TotalTransactionFlow> pager) {
		logger.info("TotalTransactionFlowServiceImpl exe method selectTList?pager={}",pager);
		
		if(pager.getLimitStart()>=0){
			int totalCount = totalTransactionFlowDao.selectTListCount(pager);
			int numPerPage = SqlUtil.checkPageSize(pager.getNumPerPage());
			int currentPage = SqlUtil.checkPageCurrent(totalCount, numPerPage, pager.getPageNum());
			pager.setLimitStart(SqlUtil.countOffset(currentPage, numPerPage));
			pager.setPageSize(numPerPage);
			pager.setCurrentPage(currentPage);
			pager.setTotalCount(totalCount);
			pager.setTotalPage(totalCount%numPerPage==0?totalCount/numPerPage:totalCount/numPerPage+1);
		}
		List<TotalTransactionFlow> list = totalTransactionFlowDao.selectTList(pager);
		pager.setList(list);
		
		logger.info("BaseAdServiceImpl exe method selectTList?out={}",pager);
	}
	
	@Override
	public void deleteById(int id) {
		logger.info("TotalTransactionFlowServiceImpl exe method deleteById?id={}",id);
		
		totalTransactionFlowDao.deleteById(id);
		
		logger.info("TotalTransactionFlowServiceImpl exe method deleteById");
	}
	
	@Override
	public int insert(TotalTransactionFlow t) {
		
		logger.info("TotalTransactionFlowServiceImpl exe method insert?t={}",t);
		
		int i = totalTransactionFlowDao.insert(t);
		
		logger.info("TotalTransactionFlowServiceImpl exe method insert out={}",i);
		
		return i;
	}
	
	@Override
	public int updateObj(TotalTransactionFlow t) {
		
		logger.info("TotalTransactionFlowServiceImpl exe method updateObj?t={}",t);
		
		int i = totalTransactionFlowDao.updateObj(t);
		
		logger.info("TotalTransactionFlowServiceImpl exe method updateObj out={}",i);
		
		return i;
	}

}
