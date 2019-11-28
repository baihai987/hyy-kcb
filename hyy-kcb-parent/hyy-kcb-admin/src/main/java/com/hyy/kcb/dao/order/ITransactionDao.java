package com.hyy.kcb.dao.order;

import org.apache.ibatis.annotations.Mapper;

import com.hyy.kcb.commons.dao.BaseDao;
import com.hyy.kcb.domain.order.Transaction;

/**
 * @author WhiteLee
 * 功能描述:交易记录(contain mining_records)管理
 */
@Mapper
public interface ITransactionDao extends BaseDao<Transaction>{
	
	
}
