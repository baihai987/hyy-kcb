package com.hyy.kcb.service.drop.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hyy.kcb.commons.base.BaseObject;
import com.hyy.kcb.commons.page.Pager;
import com.hyy.kcb.commons.page.SqlUtil;
import com.hyy.kcb.dao.drop.IRecordDropDao;
import com.hyy.kcb.domain.drop.RecordDrop;
import com.hyy.kcb.service.drop.IRecordDropService;

/**
 * @author WhiteLee
 * 功能描述:空投记录（un）管理
 */
@Service
public class  RecordDropServiceImpl extends BaseObject implements IRecordDropService {
	

	@Autowired
    private IRecordDropDao recordDropDao;
    
    @Override
	public List<RecordDrop> selectAll() {
		logger.info("RecordDropServiceImpl exe method selectAll");
		List<RecordDrop> list = recordDropDao.selectAll();
		logger.info("RecordDropServiceImpl exe method selectAll out:{}",list);
		return list;
	}
	
	@Override
	public RecordDrop selectById(int id) {
		logger.info("RecordDropServiceImpl exe method selectById?id={}",id);
		RecordDrop t = recordDropDao.selectById(id);
		logger.info("RecordDropServiceImpl exe method selectById out:{}",t);
		return t;
	}
	
	@Override
	public RecordDrop selectByUUID(String uuid) {
		
		logger.info("RecordDropServiceImpl exe method selectByUUID?uuid={}",uuid);
		RecordDrop t = recordDropDao.selectByUUID(uuid);
		logger.info("RecordDropServiceImpl exe method selectByUUID out:{}",t);
		
		return t;
	}
	
	@Override
	public void selectTList(Pager<RecordDrop> pager) {
		logger.info("RecordDropServiceImpl exe method selectTList?pager={}",pager);
		
		if(pager.getLimitStart()>=0){
			int totalCount = recordDropDao.selectTListCount(pager);
			int numPerPage = SqlUtil.checkPageSize(pager.getNumPerPage());
			int currentPage = SqlUtil.checkPageCurrent(totalCount, numPerPage, pager.getPageNum());
			pager.setLimitStart(SqlUtil.countOffset(currentPage, numPerPage));
			pager.setPageSize(numPerPage);
			pager.setCurrentPage(currentPage);
			pager.setTotalCount(totalCount);
			pager.setTotalPage(totalCount%numPerPage==0?totalCount/numPerPage:totalCount/numPerPage+1);
		}
		List<RecordDrop> list = recordDropDao.selectTList(pager);
		pager.setList(list);
		
		logger.info("BaseAdServiceImpl exe method selectTList?out={}",pager);
	}
	
	@Override
	public void deleteById(int id) {
		logger.info("RecordDropServiceImpl exe method deleteById?id={}",id);
		
		recordDropDao.deleteById(id);
		
		logger.info("RecordDropServiceImpl exe method deleteById");
	}
	
	@Override
	public int insert(RecordDrop t) {
		
		logger.info("RecordDropServiceImpl exe method insert?t={}",t);
		
		int i = recordDropDao.insert(t);
		
		logger.info("RecordDropServiceImpl exe method insert out={}",i);
		
		return i;
	}
	
	@Override
	public int updateObj(RecordDrop t) {
		
		logger.info("RecordDropServiceImpl exe method updateObj?t={}",t);
		
		int i = recordDropDao.updateObj(t);
		
		logger.info("RecordDropServiceImpl exe method updateObj out={}",i);
		
		return i;
	}

}
