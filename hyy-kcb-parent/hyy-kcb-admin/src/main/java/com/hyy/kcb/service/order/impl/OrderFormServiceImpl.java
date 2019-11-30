package com.hyy.kcb.service.order.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hyy.kcb.domain.order.dto.OrderFormDTO;
import com.hyy.kcb.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hyy.kcb.commons.base.BaseObject;
import com.hyy.kcb.commons.page.Pager;
import com.hyy.kcb.commons.page.SqlUtil;
import com.hyy.kcb.dao.order.IOrderFormDao;
import com.hyy.kcb.domain.order.OrderForm;
import com.hyy.kcb.service.order.IOrderFormService;

/**
 * @author WhiteLee
 * 功能描述:转入充值到POS记录管理
 */
@Service
public class OrderFormServiceImpl extends BaseObject implements IOrderFormService {


    @Autowired
    private IOrderFormDao orderFormDao;

    @Override
    public List<OrderForm> selectAll() {
        logger.info("OrderFormServiceImpl exe method selectAll");
        List<OrderForm> list = orderFormDao.selectAll();
        logger.info("OrderFormServiceImpl exe method selectAll out:{}", list);
        return list;
    }

    @Override
    public OrderForm selectById(int id) {
        logger.info("OrderFormServiceImpl exe method selectById?id={}", id);
        OrderForm t = orderFormDao.selectById(id);
        logger.info("OrderFormServiceImpl exe method selectById out:{}", t);
        return t;
    }

    @Override
    public OrderForm selectByUUID(String uuid) {

        logger.info("OrderFormServiceImpl exe method selectByUUID?uuid={}", uuid);
        OrderForm t = orderFormDao.selectByUUID(uuid);
        logger.info("OrderFormServiceImpl exe method selectByUUID out:{}", t);

        return t;
    }

    @Override
    public void selectTList(Pager<OrderForm> pager) {
        logger.info("OrderFormServiceImpl exe method selectTList?pager={}", pager);

        if (pager.getLimitStart() >= 0) {
            int totalCount = orderFormDao.selectTListCount(pager);
            int numPerPage = SqlUtil.checkPageSize(pager.getNumPerPage());
            int currentPage = SqlUtil.checkPageCurrent(totalCount, numPerPage, pager.getPageNum());
            pager.setLimitStart(SqlUtil.countOffset(currentPage, numPerPage));
            pager.setPageSize(numPerPage);
            pager.setCurrentPage(currentPage);
            pager.setTotalCount(totalCount);
            pager.setTotalPage(totalCount % numPerPage == 0 ? totalCount / numPerPage : totalCount / numPerPage + 1);
        }
        List<OrderForm> list = orderFormDao.selectTList(pager);
        pager.setList(list);

        logger.info("BaseAdServiceImpl exe method selectTList?out={}", pager);
    }

    @Override
    public void deleteById(int id) {
        logger.info("OrderFormServiceImpl exe method deleteById?id={}", id);

        orderFormDao.deleteById(id);

        logger.info("OrderFormServiceImpl exe method deleteById");
    }

    @Override
    public int insert(OrderForm t) {

        logger.info("OrderFormServiceImpl exe method insert?t={}", t);

        int i = orderFormDao.insert(t);

        logger.info("OrderFormServiceImpl exe method insert out={}", i);

        return i;
    }

    @Override
    public int updateObj(OrderForm t) {

        logger.info("OrderFormServiceImpl exe method updateObj?t={}", t);

        int i = orderFormDao.updateObj(t);

        logger.info("OrderFormServiceImpl exe method updateObj out={}", i);

        return i;
    }

    @Override
    public Map findOrderByCondition(Map<String, Object> map) {
        HashMap<String, Object> hashMap = new HashMap<>();
        Map<String, Object> stringObjectMap = PageUtil.setPageAndPerPageNum(map);
        Integer totalCount = orderFormDao.findOrderByConditionCount(stringObjectMap);
        List<OrderFormDTO> list =
                orderFormDao.findOrderByCondition(stringObjectMap);
        if (totalCount == 0) {
            hashMap.put("totalCount", 0);
            hashMap.put("list", new ArrayList<>());
            return hashMap;
        }
        hashMap.put("totalCount", totalCount);
        hashMap.put("list", list);
        return hashMap;
    }
}
