package com.hyy.kcb.service.order.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hyy.kcb.commons.base.BaseObject;
import com.hyy.kcb.commons.page.Pager;
import com.hyy.kcb.commons.page.SqlUtil;
import com.hyy.kcb.dao.order.ITransactionDao;
import com.hyy.kcb.domain.order.Transaction;
import com.hyy.kcb.service.order.ITransactionService;

/**
 * @author WhiteLee
 * 功能描述:交易记录(contain mining_records)管理
 */
@Service
public class  TransactionServiceImpl extends BaseObject implements ITransactionService {
	

	@Autowired
    private ITransactionDao transactionDao;
    
    @Override
	public List<Transaction> selectAll() {
		logger.info("TransactionServiceImpl exe method selectAll");
		List<Transaction> list = transactionDao.selectAll();
		logger.info("TransactionServiceImpl exe method selectAll out:{}",list);
		return list;
	}
	
	@Override
	public Transaction selectById(int id) {
		logger.info("TransactionServiceImpl exe method selectById?id={}",id);
		Transaction t = transactionDao.selectById(id);
		logger.info("TransactionServiceImpl exe method selectById out:{}",t);
		return t;
	}
	
	@Override
	public Transaction selectByUUID(String uuid) {
		
		logger.info("TransactionServiceImpl exe method selectByUUID?uuid={}",uuid);
		Transaction t = transactionDao.selectByUUID(uuid);
		logger.info("TransactionServiceImpl exe method selectByUUID out:{}",t);
		
		return t;
	}
	
	@Override
	public void selectTList(Pager<Transaction> pager) {
		logger.info("TransactionServiceImpl exe method selectTList?pager={}",pager);
		
		if(pager.getLimitStart()>=0){
			int totalCount = transactionDao.selectTListCount(pager);
			int numPerPage = SqlUtil.checkPageSize(pager.getNumPerPage());
			int currentPage = SqlUtil.checkPageCurrent(totalCount, numPerPage, pager.getPageNum());
			pager.setLimitStart(SqlUtil.countOffset(currentPage, numPerPage));
			pager.setPageSize(numPerPage);
			pager.setCurrentPage(currentPage);
			pager.setTotalCount(totalCount);
			pager.setTotalPage(totalCount%numPerPage==0?totalCount/numPerPage:totalCount/numPerPage+1);
		}
		List<Transaction> list = transactionDao.selectTList(pager);
		pager.setList(list);
		
		logger.info("BaseAdServiceImpl exe method selectTList?out={}",pager);
	}
	
	@Override
	public void deleteById(int id) {
		logger.info("TransactionServiceImpl exe method deleteById?id={}",id);
		
		transactionDao.deleteById(id);
		
		logger.info("TransactionServiceImpl exe method deleteById");
	}
	
	@Override
	public int insert(Transaction t) {
		
		logger.info("TransactionServiceImpl exe method insert?t={}",t);
		
		int i = transactionDao.insert(t);
		
		logger.info("TransactionServiceImpl exe method insert out={}",i);
		
		return i;
	}
	
	@Override
	public int updateObj(Transaction t) {
		
		logger.info("TransactionServiceImpl exe method updateObj?t={}",t);
		
		int i = transactionDao.updateObj(t);
		
		logger.info("TransactionServiceImpl exe method updateObj out={}",i);
		
		return i;
	}

}
