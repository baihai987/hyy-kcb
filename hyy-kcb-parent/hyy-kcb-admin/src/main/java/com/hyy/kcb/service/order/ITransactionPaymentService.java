package com.hyy.kcb.service.order;

import com.hyy.kcb.commons.service.BaseService;
import com.hyy.kcb.domain.order.TransactionPayment;

import java.util.Map;

/**
 * @author WhiteLee
 * 功能描述:POS付款流水表管理
 */
public interface ITransactionPaymentService extends BaseService<TransactionPayment>{

    Map findOutAndIn(Map<String, Object> map);
}
