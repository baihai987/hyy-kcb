package com.hyy.kcb.service.order.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hyy.kcb.domain.order.dto.OrderFormDTO;
import com.hyy.kcb.domain.order.dto.PurchasedHardDiskDTO;
import com.hyy.kcb.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hyy.kcb.commons.base.BaseObject;
import com.hyy.kcb.commons.page.Pager;
import com.hyy.kcb.commons.page.SqlUtil;
import com.hyy.kcb.dao.order.IPurchasedHardDiskDao;
import com.hyy.kcb.domain.order.PurchasedHardDisk;
import com.hyy.kcb.service.order.IPurchasedHardDiskService;

/**
 * @author WhiteLee
 * 功能描述:硬盘购买记录管理
 */
@Service
public class PurchasedHardDiskServiceImpl extends BaseObject implements IPurchasedHardDiskService {


    @Autowired
    private IPurchasedHardDiskDao purchasedHardDiskDao;

    @Override
    public List<PurchasedHardDisk> selectAll() {
        logger.info("PurchasedHardDiskServiceImpl exe method selectAll");
        List<PurchasedHardDisk> list = purchasedHardDiskDao.selectAll();
        logger.info("PurchasedHardDiskServiceImpl exe method selectAll out:{}", list);
        return list;
    }

    @Override
    public PurchasedHardDisk selectById(int id) {
        logger.info("PurchasedHardDiskServiceImpl exe method selectById?id={}", id);
        PurchasedHardDisk t = purchasedHardDiskDao.selectById(id);
        logger.info("PurchasedHardDiskServiceImpl exe method selectById out:{}", t);
        return t;
    }

    @Override
    public PurchasedHardDisk selectByUUID(String uuid) {

        logger.info("PurchasedHardDiskServiceImpl exe method selectByUUID?uuid={}", uuid);
        PurchasedHardDisk t = purchasedHardDiskDao.selectByUUID(uuid);
        logger.info("PurchasedHardDiskServiceImpl exe method selectByUUID out:{}", t);

        return t;
    }

    @Override
    public void selectTList(Pager<PurchasedHardDisk> pager) {
        logger.info("PurchasedHardDiskServiceImpl exe method selectTList?pager={}", pager);

        if (pager.getLimitStart() >= 0) {
            int totalCount = purchasedHardDiskDao.selectTListCount(pager);
            int numPerPage = SqlUtil.checkPageSize(pager.getNumPerPage());
            int currentPage = SqlUtil.checkPageCurrent(totalCount, numPerPage, pager.getPageNum());
            pager.setLimitStart(SqlUtil.countOffset(currentPage, numPerPage));
            pager.setPageSize(numPerPage);
            pager.setCurrentPage(currentPage);
            pager.setTotalCount(totalCount);
            pager.setTotalPage(totalCount % numPerPage == 0 ? totalCount / numPerPage : totalCount / numPerPage + 1);
        }
        List<PurchasedHardDisk> list = purchasedHardDiskDao.selectTList(pager);
        pager.setList(list);

        logger.info("BaseAdServiceImpl exe method selectTList?out={}", pager);
    }

    @Override
    public void deleteById(int id) {
        logger.info("PurchasedHardDiskServiceImpl exe method deleteById?id={}", id);

        purchasedHardDiskDao.deleteById(id);

        logger.info("PurchasedHardDiskServiceImpl exe method deleteById");
    }

    @Override
    public int insert(PurchasedHardDisk t) {

        logger.info("PurchasedHardDiskServiceImpl exe method insert?t={}", t);

        int i = purchasedHardDiskDao.insert(t);

        logger.info("PurchasedHardDiskServiceImpl exe method insert out={}", i);

        return i;
    }

    @Override
    public int updateObj(PurchasedHardDisk t) {

        logger.info("PurchasedHardDiskServiceImpl exe method updateObj?t={}", t);

        int i = purchasedHardDiskDao.updateObj(t);

        logger.info("PurchasedHardDiskServiceImpl exe method updateObj out={}", i);

        return i;
    }

    @Override
    public Map findHardDiskCondition(Map<String, Object> map) {
        HashMap<String, Object> hashMap = new HashMap<>();
        Map<String, Object> stringObjectMap = PageUtil.setPageAndPerPageNum(map);
        Integer totalCount = purchasedHardDiskDao.findOrderByConditionCount(stringObjectMap);
        List<PurchasedHardDiskDTO> list =
				purchasedHardDiskDao.findOrderByCondition(stringObjectMap);
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
