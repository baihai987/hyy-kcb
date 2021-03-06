package com.hyy.kcb.service.order;

import com.hyy.kcb.commons.service.BaseService;
import com.hyy.kcb.domain.order.PurchasedHardDisk;

import java.util.Map;

/**
 * @author WhiteLee
 * 功能描述:硬盘购买记录管理
 */
public interface IPurchasedHardDiskService extends BaseService<PurchasedHardDisk>{

    Map findHardDiskCondition(Map<String, Object> map);
}
