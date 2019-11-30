package com.hyy.kcb.service.order.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import com.hyy.kcb.domain.order.dto.OrderFormDTO;
import com.hyy.kcb.domain.order.dto.TransactionPaymentDTO;
import com.hyy.kcb.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hyy.kcb.commons.base.BaseObject;
import com.hyy.kcb.commons.page.Pager;
import com.hyy.kcb.commons.page.SqlUtil;
import com.hyy.kcb.dao.order.ITransactionPaymentDao;
import com.hyy.kcb.domain.order.TransactionPayment;
import com.hyy.kcb.service.order.ITransactionPaymentService;

/**
 * @author WhiteLee
 * 功能描述:POS付款流水表管理
 */
@Service
public class  TransactionPaymentServiceImpl extends BaseObject implements ITransactionPaymentService {
	

	@Autowired
    private ITransactionPaymentDao transactionPaymentDao;
    
    @Override
	public List<TransactionPayment> selectAll() {
		logger.info("TransactionPaymentServiceImpl exe method selectAll");
		List<TransactionPayment> list = transactionPaymentDao.selectAll();
		logger.info("TransactionPaymentServiceImpl exe method selectAll out:{}",list);
		return list;
	}
	
	@Override
	public TransactionPayment selectById(int id) {
		logger.info("TransactionPaymentServiceImpl exe method selectById?id={}",id);
		TransactionPayment t = transactionPaymentDao.selectById(id);
		logger.info("TransactionPaymentServiceImpl exe method selectById out:{}",t);
		return t;
	}
	
	@Override
	public TransactionPayment selectByUUID(String uuid) {
		
		logger.info("TransactionPaymentServiceImpl exe method selectByUUID?uuid={}",uuid);
		TransactionPayment t = transactionPaymentDao.selectByUUID(uuid);
		logger.info("TransactionPaymentServiceImpl exe method selectByUUID out:{}",t);
		
		return t;
	}
	
	@Override
	public void selectTList(Pager<TransactionPayment> pager) {
		logger.info("TransactionPaymentServiceImpl exe method selectTList?pager={}",pager);
		
		if(pager.getLimitStart()>=0){
			int totalCount = transactionPaymentDao.selectTListCount(pager);
			int numPerPage = SqlUtil.checkPageSize(pager.getNumPerPage());
			int currentPage = SqlUtil.checkPageCurrent(totalCount, numPerPage, pager.getPageNum());
			pager.setLimitStart(SqlUtil.countOffset(currentPage, numPerPage));
			pager.setPageSize(numPerPage);
			pager.setCurrentPage(currentPage);
			pager.setTotalCount(totalCount);
			pager.setTotalPage(totalCount%numPerPage==0?totalCount/numPerPage:totalCount/numPerPage+1);
		}
		List<TransactionPayment> list = transactionPaymentDao.selectTList(pager);
		pager.setList(list);
		
		logger.info("BaseAdServiceImpl exe method selectTList?out={}",pager);
	}
	
	@Override
	public void deleteById(int id) {
		logger.info("TransactionPaymentServiceImpl exe method deleteById?id={}",id);
		
		transactionPaymentDao.deleteById(id);
		
		logger.info("TransactionPaymentServiceImpl exe method deleteById");
	}
	
	@Override
	public int insert(TransactionPayment t) {
		
		logger.info("TransactionPaymentServiceImpl exe method insert?t={}",t);
		
		int i = transactionPaymentDao.insert(t);
		
		logger.info("TransactionPaymentServiceImpl exe method insert out={}",i);
		
		return i;
	}
	
	@Override
	public int updateObj(TransactionPayment t) {
		
		logger.info("TransactionPaymentServiceImpl exe method updateObj?t={}",t);
		
		int i = transactionPaymentDao.updateObj(t);
		
		logger.info("TransactionPaymentServiceImpl exe method updateObj out={}",i);
		
		return i;
	}

	@Override
	public Map findOutAndIn(Map<String, Object> map) {
		HashMap<String, Object> hashMap = new HashMap<>();
		Map<String, Object> stringObjectMap = PageUtil.setPageAndPerPageNum(map);
		Integer totalCount = transactionPaymentDao.findOutAndInCount(stringObjectMap);
		List<TransactionPaymentDTO> list =
				transactionPaymentDao.findOutAndIn(stringObjectMap);
		LinkedList<Map> linkedList = new LinkedList<>();
		HashMap<String, Object> resultMap = new HashMap<>();
		if (totalCount == 0) {
			hashMap.put("totalCount", 0);
			hashMap.put("list", new ArrayList<>());
			return hashMap;
		}
		String str = "yyy-MM-dd HH:mm:ss";
		SimpleDateFormat sdf = new SimpleDateFormat(str);
		for(TransactionPaymentDTO transactionPaymentDTO:list){
			Date createTime = transactionPaymentDTO.getCreateTime();
			String formatTime = sdf.format(createTime);
			resultMap.put("amount",transactionPaymentDTO.getAmount());
			resultMap.put("createTime",formatTime);
			resultMap.put("fee",transactionPaymentDTO.getFee());
			resultMap.put("payMobile",transactionPaymentDTO.getPayMobile());
			resultMap.put("receiptAmount",transactionPaymentDTO.getReceiptAmount());
			resultMap.put("receiptMobile",transactionPaymentDTO.getReceiptMobile());
			resultMap.put("remark",transactionPaymentDTO.getRemark());
			linkedList.add(resultMap);
		}
		hashMap.put("totalCount", totalCount);
		hashMap.put("list", linkedList);
		return hashMap;
	}
}
