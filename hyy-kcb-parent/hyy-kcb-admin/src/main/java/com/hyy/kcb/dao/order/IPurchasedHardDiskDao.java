package com.hyy.kcb.dao.order;

import com.hyy.kcb.domain.order.dto.PurchasedHardDiskDTO;
import org.apache.ibatis.annotations.Mapper;

import com.hyy.kcb.commons.dao.BaseDao;
import com.hyy.kcb.domain.order.PurchasedHardDisk;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author WhiteLee
 * 功能描述:硬盘购买记录管理
 */
@Mapper
public interface IPurchasedHardDiskDao extends BaseDao<PurchasedHardDisk>{


    Integer findOrderByConditionCount(@Param("map") Map<String, Object> stringObjectMap);

    List<PurchasedHardDiskDTO> findOrderByCondition(@Param("map")Map<String, Object> stringObjectMap);
}
