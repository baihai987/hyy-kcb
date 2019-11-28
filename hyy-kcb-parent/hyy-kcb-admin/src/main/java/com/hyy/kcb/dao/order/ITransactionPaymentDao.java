package com.hyy.kcb.dao.order;

import org.apache.ibatis.annotations.Mapper;

import com.hyy.kcb.commons.dao.BaseDao;
import com.hyy.kcb.domain.order.TransactionPayment;

/**
 * @author WhiteLee
 * 功能描述:POS付款流水表管理
 */
@Mapper
public interface ITransactionPaymentDao extends BaseDao<TransactionPayment>{
	
	
}
