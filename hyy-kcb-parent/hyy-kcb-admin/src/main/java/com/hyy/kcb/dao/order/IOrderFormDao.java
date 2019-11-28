package com.hyy.kcb.dao.order;

import org.apache.ibatis.annotations.Mapper;

import com.hyy.kcb.commons.dao.BaseDao;
import com.hyy.kcb.domain.order.OrderForm;

/**
 * @author WhiteLee
 * 功能描述:转入充值到POS记录管理
 */
@Mapper
public interface IOrderFormDao extends BaseDao<OrderForm>{
	
	
}
