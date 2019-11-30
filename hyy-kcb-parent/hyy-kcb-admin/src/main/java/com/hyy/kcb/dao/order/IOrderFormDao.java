package com.hyy.kcb.dao.order;

import com.hyy.kcb.domain.order.dto.OrderFormDTO;
import org.apache.ibatis.annotations.Mapper;

import com.hyy.kcb.commons.dao.BaseDao;
import com.hyy.kcb.domain.order.OrderForm;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author WhiteLee
 * 功能描述:转入充值到POS记录管理
 */
@Mapper
public interface IOrderFormDao extends BaseDao<OrderForm>{


    Integer findOrderByConditionCount(@Param("map")Map<String, Object> stringObjectMap);

    List<OrderFormDTO> findOrderByCondition(@Param("map")Map<String, Object> stringObjectMap);
}
