package com.hyy.kcb.dao.order;

import org.apache.ibatis.annotations.Mapper;

import com.hyy.kcb.commons.dao.BaseDao;
import com.hyy.kcb.domain.order.TotalTransactionFlow;

/**
 * @author WhiteLee
 * 功能描述:总交易流水(contain order_form)管理
 */
@Mapper
public interface ITotalTransactionFlowDao extends BaseDao<TotalTransactionFlow>{
	
	
}
