package com.hyy.kcb.service.configuration.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hyy.kcb.commons.base.BaseObject;
import com.hyy.kcb.commons.page.Pager;
import com.hyy.kcb.commons.page.SqlUtil;
import com.hyy.kcb.dao.configuration.ITypeHashrateDao;
import com.hyy.kcb.domain.configuration.TypeHashrate;
import com.hyy.kcb.service.configuration.ITypeHashrateService;

/**
 * @author WhiteLee
 * 功能描述:算力类型（un）管理
 */
@Service
public class  TypeHashrateServiceImpl extends BaseObject implements ITypeHashrateService {
	

	@Autowired
    private ITypeHashrateDao typeHashrateDao;
    
    @Override
	public List<TypeHashrate> selectAll() {
		logger.info("TypeHashrateServiceImpl exe method selectAll");
		List<TypeHashrate> list = typeHashrateDao.selectAll();
		logger.info("TypeHashrateServiceImpl exe method selectAll out:{}",list);
		return list;
	}
	
	@Override
	public TypeHashrate selectById(int id) {
		logger.info("TypeHashrateServiceImpl exe method selectById?id={}",id);
		TypeHashrate t = typeHashrateDao.selectById(id);
		logger.info("TypeHashrateServiceImpl exe method selectById out:{}",t);
		return t;
	}
	
	@Override
	public TypeHashrate selectByUUID(String uuid) {
		
		logger.info("TypeHashrateServiceImpl exe method selectByUUID?uuid={}",uuid);
		TypeHashrate t = typeHashrateDao.selectByUUID(uuid);
		logger.info("TypeHashrateServiceImpl exe method selectByUUID out:{}",t);
		
		return t;
	}
	
	@Override
	public void selectTList(Pager<TypeHashrate> pager) {
		logger.info("TypeHashrateServiceImpl exe method selectTList?pager={}",pager);
		
		if(pager.getLimitStart()>=0){
			int totalCount = typeHashrateDao.selectTListCount(pager);
			int numPerPage = SqlUtil.checkPageSize(pager.getNumPerPage());
			int currentPage = SqlUtil.checkPageCurrent(totalCount, numPerPage, pager.getPageNum());
			pager.setLimitStart(SqlUtil.countOffset(currentPage, numPerPage));
			pager.setPageSize(numPerPage);
			pager.setCurrentPage(currentPage);
			pager.setTotalCount(totalCount);
			pager.setTotalPage(totalCount%numPerPage==0?totalCount/numPerPage:totalCount/numPerPage+1);
		}
		List<TypeHashrate> list = typeHashrateDao.selectTList(pager);
		pager.setList(list);
		
		logger.info("BaseAdServiceImpl exe method selectTList?out={}",pager);
	}
	
	@Override
	public void deleteById(int id) {
		logger.info("TypeHashrateServiceImpl exe method deleteById?id={}",id);
		
		typeHashrateDao.deleteById(id);
		
		logger.info("TypeHashrateServiceImpl exe method deleteById");
	}
	
	@Override
	public int insert(TypeHashrate t) {
		
		logger.info("TypeHashrateServiceImpl exe method insert?t={}",t);
		
		int i = typeHashrateDao.insert(t);
		
		logger.info("TypeHashrateServiceImpl exe method insert out={}",i);
		
		return i;
	}
	
	@Override
	public int updateObj(TypeHashrate t) {
		
		logger.info("TypeHashrateServiceImpl exe method updateObj?t={}",t);
		
		int i = typeHashrateDao.updateObj(t);
		
		logger.info("TypeHashrateServiceImpl exe method updateObj out={}",i);
		
		return i;
	}

}
