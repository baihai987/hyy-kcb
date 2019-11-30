package com.hyy.kcb.dao.order;

import com.hyy.kcb.domain.order.dto.TransactionPaymentDTO;
import org.apache.ibatis.annotations.Mapper;

import com.hyy.kcb.commons.dao.BaseDao;
import com.hyy.kcb.domain.order.TransactionPayment;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author WhiteLee
 * 功能描述:POS付款流水表管理
 */
@Mapper
public interface ITransactionPaymentDao extends BaseDao<TransactionPayment>{


    Integer findOutAndInCount(@Param("map")Map<String, Object> stringObjectMap);

    List<TransactionPaymentDTO> findOutAndIn(@Param("map")Map<String, Object> stringObjectMap);

}
