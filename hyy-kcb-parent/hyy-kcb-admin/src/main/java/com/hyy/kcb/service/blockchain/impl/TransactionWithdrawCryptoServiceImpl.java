package com.hyy.kcb.service.blockchain.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hyy.kcb.commons.base.BaseObject;
import com.hyy.kcb.commons.page.Pager;
import com.hyy.kcb.commons.page.SqlUtil;
import com.hyy.kcb.dao.blockchain.ITransactionWithdrawCryptoDao;
import com.hyy.kcb.domain.blockchain.TransactionWithdrawCrypto;
import com.hyy.kcb.service.blockchain.ITransactionWithdrawCryptoService;

/**
 * @author WhiteLee
 * 功能描述:区块链资产提现流水记录(un)管理
 */
@Service
public class  TransactionWithdrawCryptoServiceImpl extends BaseObject implements ITransactionWithdrawCryptoService {
	

	@Autowired
    private ITransactionWithdrawCryptoDao transactionWithdrawCryptoDao;
    
    @Override
	public List<TransactionWithdrawCrypto> selectAll() {
		logger.info("TransactionWithdrawCryptoServiceImpl exe method selectAll");
		List<TransactionWithdrawCrypto> list = transactionWithdrawCryptoDao.selectAll();
		logger.info("TransactionWithdrawCryptoServiceImpl exe method selectAll out:{}",list);
		return list;
	}
	
	@Override
	public TransactionWithdrawCrypto selectById(int id) {
		logger.info("TransactionWithdrawCryptoServiceImpl exe method selectById?id={}",id);
		TransactionWithdrawCrypto t = transactionWithdrawCryptoDao.selectById(id);
		logger.info("TransactionWithdrawCryptoServiceImpl exe method selectById out:{}",t);
		return t;
	}
	
	@Override
	public TransactionWithdrawCrypto selectByUUID(String uuid) {
		
		logger.info("TransactionWithdrawCryptoServiceImpl exe method selectByUUID?uuid={}",uuid);
		TransactionWithdrawCrypto t = transactionWithdrawCryptoDao.selectByUUID(uuid);
		logger.info("TransactionWithdrawCryptoServiceImpl exe method selectByUUID out:{}",t);
		
		return t;
	}
	
	@Override
	public void selectTList(Pager<TransactionWithdrawCrypto> pager) {
		logger.info("TransactionWithdrawCryptoServiceImpl exe method selectTList?pager={}",pager);
		
		if(pager.getLimitStart()>=0){
			int totalCount = transactionWithdrawCryptoDao.selectTListCount(pager);
			int numPerPage = SqlUtil.checkPageSize(pager.getNumPerPage());
			int currentPage = SqlUtil.checkPageCurrent(totalCount, numPerPage, pager.getPageNum());
			pager.setLimitStart(SqlUtil.countOffset(currentPage, numPerPage));
			pager.setPageSize(numPerPage);
			pager.setCurrentPage(currentPage);
			pager.setTotalCount(totalCount);
			pager.setTotalPage(totalCount%numPerPage==0?totalCount/numPerPage:totalCount/numPerPage+1);
		}
		List<TransactionWithdrawCrypto> list = transactionWithdrawCryptoDao.selectTList(pager);
		pager.setList(list);
		
		logger.info("BaseAdServiceImpl exe method selectTList?out={}",pager);
	}
	
	@Override
	public void deleteById(int id) {
		logger.info("TransactionWithdrawCryptoServiceImpl exe method deleteById?id={}",id);
		
		transactionWithdrawCryptoDao.deleteById(id);
		
		logger.info("TransactionWithdrawCryptoServiceImpl exe method deleteById");
	}
	
	@Override
	public int insert(TransactionWithdrawCrypto t) {
		
		logger.info("TransactionWithdrawCryptoServiceImpl exe method insert?t={}",t);
		
		int i = transactionWithdrawCryptoDao.insert(t);
		
		logger.info("TransactionWithdrawCryptoServiceImpl exe method insert out={}",i);
		
		return i;
	}
	
	@Override
	public int updateObj(TransactionWithdrawCrypto t) {
		
		logger.info("TransactionWithdrawCryptoServiceImpl exe method updateObj?t={}",t);
		
		int i = transactionWithdrawCryptoDao.updateObj(t);
		
		logger.info("TransactionWithdrawCryptoServiceImpl exe method updateObj out={}",i);
		
		return i;
	}

}
