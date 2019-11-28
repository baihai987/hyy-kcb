package com.hyy.kcb.controller.mine;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hyy.kcb.commons.ConstantEnum;
import com.hyy.kcb.config.controller.ApiBaseController;
import com.hyy.kcb.commons.exception.BusinessException;
import com.hyy.kcb.commons.page.Pager;
import com.hyy.kcb.domain.mine.MiningRecords;
import com.hyy.kcb.domain.mine.dto.MiningRecordsDTO;
import com.hyy.kcb.out.WebResout;
import com.hyy.kcb.service.mine.IMiningRecordsService;


@Controller
@RequestMapping(value = "/mine/miningRecords/1.0", method = RequestMethod.POST)
public class MiningRecordsController extends ApiBaseController{

	@Autowired
	private IMiningRecordsService miningRecordsService;

	@PostMapping(value = "save")
	@ResponseBody
	public WebResout saveObj(@ModelAttribute MiningRecords miningRecords,HttpServletRequest request) throws BusinessException{
		
		logger.debug("MiningRecordsController exe saveObj param={}",miningRecords);
		
		int i = miningRecordsService.insert(miningRecords);
		if(i > 0) {
			return success(request);
		}
		return fail(request);
	}
	
	@GetMapping(value = "listAll")
	@ResponseBody
	public WebResout listAll(HttpServletRequest request) throws BusinessException{
		logger.debug("MiningRecordsController exe listAll ");
		List<MiningRecords> list =  miningRecordsService.selectAll();
		logger.debug("MiningRecordsController exe listAll out={}",list);
		return success(request,list);
	}
	@GetMapping(value = "getById/{id}")
	@ResponseBody
	public WebResout getById(HttpServletRequest request,@PathVariable int id) throws BusinessException{
		
		logger.debug("MiningRecordsController exe getById?id={}",id);
		
		MiningRecords miningRecords = miningRecordsService.selectById(id);
		if(miningRecords == null) {
			return fail(request, ConstantEnum._WEB_DTAT_IS_NULL.getVal(), ConstantEnum._WEB_DTAT_IS_NULL.getDesc());
		}
		logger.debug("MiningRecordsController exe getById out={} ",miningRecords);
		return success(request,miningRecords);
	}
	
	@DeleteMapping(value = "delete/{id}")
	@ResponseBody
	public WebResout delete(HttpServletRequest request,@PathVariable int id) throws BusinessException{
		logger.debug("MiningRecordsController exe delete?id={}",id);
		
		MiningRecords miningRecords = miningRecordsService.selectById(id);
		if(miningRecords == null) {
			return fail(request, ConstantEnum._WEB_DTAT_IS_NULL.getVal(), ConstantEnum._WEB_DTAT_IS_NULL.getDesc());
		}
		miningRecordsService.deleteById(id);
		logger.debug("MiningRecordsController exe delete?id={}",id);
		
		return success(request);
	}
	
	@PutMapping(value = "update")
	@ResponseBody
	public WebResout update(HttpServletRequest request,@ModelAttribute MiningRecords miningRecords) throws BusinessException{
		
		logger.debug("MiningRecordsController exe update?baseAd={}",miningRecords);
		
		int i = miningRecordsService.updateObj(miningRecords);
		if(i > 0) {
			return success(request);
		}
		return fail(request);
	}
	
	/**
	 * currentPage: 当前页码
	   numPerPage：每页显示条数
     **/
	@RequestMapping(value = "list", method = RequestMethod.POST)
	@ResponseBody
	public WebResout list(HttpServletRequest request,Pager<MiningRecords> pager, 
						@ModelAttribute MiningRecordsDTO miningRecordsDto) throws BusinessException{
		
		logger.debug("MiningRecordsController exe list?pager={}",pager);
		logger.debug("MiningRecordsController exe list?MiningRecordsDto={}",miningRecordsDto);
		
		pager.setParams(miningRecordsDto);
		miningRecordsService.selectTList(pager);
		
		logger.debug("MiningRecordsController exe list out={}",pager);
		
		return success(request,pager);
	}
}
