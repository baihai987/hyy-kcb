package com.hyy.kcb.service.configuration.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hyy.kcb.commons.base.BaseObject;
import com.hyy.kcb.commons.page.Pager;
import com.hyy.kcb.commons.page.SqlUtil;
import com.hyy.kcb.dao.configuration.IConfigHardDiskContractDao;
import com.hyy.kcb.domain.configuration.ConfigHardDiskContract;
import com.hyy.kcb.service.configuration.IConfigHardDiskContractService;

/**
 * @author WhiteLee
 * 功能描述:合约时长配置管理
 */
@Service
public class  ConfigHardDiskContractServiceImpl extends BaseObject implements IConfigHardDiskContractService {
	

	@Autowired
    private IConfigHardDiskContractDao configHardDiskContractDao;
    
    @Override
	public List<ConfigHardDiskContract> selectAll() {
		logger.info("ConfigHardDiskContractServiceImpl exe method selectAll");
		List<ConfigHardDiskContract> list = configHardDiskContractDao.selectAll();
		logger.info("ConfigHardDiskContractServiceImpl exe method selectAll out:{}",list);
		return list;
	}
	
	@Override
	public ConfigHardDiskContract selectById(int id) {
		logger.info("ConfigHardDiskContractServiceImpl exe method selectById?id={}",id);
		ConfigHardDiskContract t = configHardDiskContractDao.selectById(id);
		logger.info("ConfigHardDiskContractServiceImpl exe method selectById out:{}",t);
		return t;
	}
	
	@Override
	public ConfigHardDiskContract selectByUUID(String uuid) {
		
		logger.info("ConfigHardDiskContractServiceImpl exe method selectByUUID?uuid={}",uuid);
		ConfigHardDiskContract t = configHardDiskContractDao.selectByUUID(uuid);
		logger.info("ConfigHardDiskContractServiceImpl exe method selectByUUID out:{}",t);
		
		return t;
	}
	
	@Override
	public void selectTList(Pager<ConfigHardDiskContract> pager) {
		logger.info("ConfigHardDiskContractServiceImpl exe method selectTList?pager={}",pager);
		
		if(pager.getLimitStart()>=0){
			int totalCount = configHardDiskContractDao.selectTListCount(pager);
			int numPerPage = SqlUtil.checkPageSize(pager.getNumPerPage());
			int currentPage = SqlUtil.checkPageCurrent(totalCount, numPerPage, pager.getPageNum());
			pager.setLimitStart(SqlUtil.countOffset(currentPage, numPerPage));
			pager.setPageSize(numPerPage);
			pager.setCurrentPage(currentPage);
			pager.setTotalCount(totalCount);
			pager.setTotalPage(totalCount%numPerPage==0?totalCount/numPerPage:totalCount/numPerPage+1);
		}
		List<ConfigHardDiskContract> list = configHardDiskContractDao.selectTList(pager);
		pager.setList(list);
		
		logger.info("BaseAdServiceImpl exe method selectTList?out={}",pager);
	}
	
	@Override
	public void deleteById(int id) {
		logger.info("ConfigHardDiskContractServiceImpl exe method deleteById?id={}",id);
		
		configHardDiskContractDao.deleteById(id);
		
		logger.info("ConfigHardDiskContractServiceImpl exe method deleteById");
	}
	
	@Override
	public int insert(ConfigHardDiskContract t) {
		
		logger.info("ConfigHardDiskContractServiceImpl exe method insert?t={}",t);
		
		int i = configHardDiskContractDao.insert(t);
		
		logger.info("ConfigHardDiskContractServiceImpl exe method insert out={}",i);
		
		return i;
	}
	
	@Override
	public int updateObj(ConfigHardDiskContract t) {
		
		logger.info("ConfigHardDiskContractServiceImpl exe method updateObj?t={}",t);
		
		int i = configHardDiskContractDao.updateObj(t);
		
		logger.info("ConfigHardDiskContractServiceImpl exe method updateObj out={}",i);
		
		return i;
	}

}
