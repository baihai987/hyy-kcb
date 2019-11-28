package com.hyy.kcb.service.blockchain.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hyy.kcb.commons.base.BaseObject;
import com.hyy.kcb.commons.page.Pager;
import com.hyy.kcb.commons.page.SqlUtil;
import com.hyy.kcb.dao.blockchain.ITransactionDepositCryptoDao;
import com.hyy.kcb.domain.blockchain.TransactionDepositCrypto;
import com.hyy.kcb.service.blockchain.ITransactionDepositCryptoService;

/**
 * @author WhiteLee
 * 功能描述:区块链资产充值流水记录(un)管理
 */
@Service
public class  TransactionDepositCryptoServiceImpl extends BaseObject implements ITransactionDepositCryptoService {
	

	@Autowired
    private ITransactionDepositCryptoDao transactionDepositCryptoDao;
    
    @Override
	public List<TransactionDepositCrypto> selectAll() {
		logger.info("TransactionDepositCryptoServiceImpl exe method selectAll");
		List<TransactionDepositCrypto> list = transactionDepositCryptoDao.selectAll();
		logger.info("TransactionDepositCryptoServiceImpl exe method selectAll out:{}",list);
		return list;
	}
	
	@Override
	public TransactionDepositCrypto selectById(int id) {
		logger.info("TransactionDepositCryptoServiceImpl exe method selectById?id={}",id);
		TransactionDepositCrypto t = transactionDepositCryptoDao.selectById(id);
		logger.info("TransactionDepositCryptoServiceImpl exe method selectById out:{}",t);
		return t;
	}
	
	@Override
	public TransactionDepositCrypto selectByUUID(String uuid) {
		
		logger.info("TransactionDepositCryptoServiceImpl exe method selectByUUID?uuid={}",uuid);
		TransactionDepositCrypto t = transactionDepositCryptoDao.selectByUUID(uuid);
		logger.info("TransactionDepositCryptoServiceImpl exe method selectByUUID out:{}",t);
		
		return t;
	}
	
	@Override
	public void selectTList(Pager<TransactionDepositCrypto> pager) {
		logger.info("TransactionDepositCryptoServiceImpl exe method selectTList?pager={}",pager);
		
		if(pager.getLimitStart()>=0){
			int totalCount = transactionDepositCryptoDao.selectTListCount(pager);
			int numPerPage = SqlUtil.checkPageSize(pager.getNumPerPage());
			int currentPage = SqlUtil.checkPageCurrent(totalCount, numPerPage, pager.getPageNum());
			pager.setLimitStart(SqlUtil.countOffset(currentPage, numPerPage));
			pager.setPageSize(numPerPage);
			pager.setCurrentPage(currentPage);
			pager.setTotalCount(totalCount);
			pager.setTotalPage(totalCount%numPerPage==0?totalCount/numPerPage:totalCount/numPerPage+1);
		}
		List<TransactionDepositCrypto> list = transactionDepositCryptoDao.selectTList(pager);
		pager.setList(list);
		
		logger.info("BaseAdServiceImpl exe method selectTList?out={}",pager);
	}
	
	@Override
	public void deleteById(int id) {
		logger.info("TransactionDepositCryptoServiceImpl exe method deleteById?id={}",id);
		
		transactionDepositCryptoDao.deleteById(id);
		
		logger.info("TransactionDepositCryptoServiceImpl exe method deleteById");
	}
	
	@Override
	public int insert(TransactionDepositCrypto t) {
		
		logger.info("TransactionDepositCryptoServiceImpl exe method insert?t={}",t);
		
		int i = transactionDepositCryptoDao.insert(t);
		
		logger.info("TransactionDepositCryptoServiceImpl exe method insert out={}",i);
		
		return i;
	}
	
	@Override
	public int updateObj(TransactionDepositCrypto t) {
		
		logger.info("TransactionDepositCryptoServiceImpl exe method updateObj?t={}",t);
		
		int i = transactionDepositCryptoDao.updateObj(t);
		
		logger.info("TransactionDepositCryptoServiceImpl exe method updateObj out={}",i);
		
		return i;
	}

}
