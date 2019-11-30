package com.hyy.kcb.service.order;

import com.hyy.kcb.commons.page.Pager;
import com.hyy.kcb.commons.service.BaseService;
import com.hyy.kcb.dao.order.IOrderFormDao;
import com.hyy.kcb.domain.order.OrderForm;
import com.hyy.kcb.domain.order.dto.OrderFormDTO;

import java.util.List;
import java.util.Map;

/**
 * @author WhiteLee
 * 功能描述:转入充值到POS记录管理
 */
public interface IOrderFormService extends BaseService<OrderForm>{

    Map findOrderByCondition(Map<String,Object> map);
}
