package com.hyy.kcb.controller.harddisk;

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
import com.hyy.kcb.domain.harddisk.HardDiskUnleasingRecords;
import com.hyy.kcb.domain.harddisk.dto.HardDiskUnleasingRecordsDTO;
import com.hyy.kcb.out.WebResout;
import com.hyy.kcb.service.harddisk.IHardDiskUnleasingRecordsService;


@Controller
@RequestMapping(value = "/harddisk/hardDiskUnleasingRecords/1.0", method = RequestMethod.POST)
public class HardDiskUnleasingRecordsController extends ApiBaseController{

	@Autowired
	private IHardDiskUnleasingRecordsService hardDiskUnleasingRecordsService;

	@PostMapping(value = "save")
	@ResponseBody
	public WebResout saveObj(@ModelAttribute HardDiskUnleasingRecords hardDiskUnleasingRecords,HttpServletRequest request) throws BusinessException{
		
		logger.debug("HardDiskUnleasingRecordsController exe saveObj param={}",hardDiskUnleasingRecords);
		
		int i = hardDiskUnleasingRecordsService.insert(hardDiskUnleasingRecords);
		if(i > 0) {
			return success(request);
		}
		return fail(request);
	}
	@GetMapping(value = "listAll")
	@ResponseBody
	public WebResout listAll(HttpServletRequest request) throws BusinessException{
		logger.debug("HardDiskUnleasingRecordsController exe listAll ");
		List<HardDiskUnleasingRecords> list =  hardDiskUnleasingRecordsService.selectAll();
		logger.debug("HardDiskUnleasingRecordsController exe listAll out={}",list);
		return success(request,list);
	}
	@GetMapping(value = "getById/{id}")
	@ResponseBody
	public WebResout getById(HttpServletRequest request,@PathVariable int id) throws BusinessException{
		
		logger.debug("HardDiskUnleasingRecordsController exe getById?id={}",id);
		
		HardDiskUnleasingRecords hardDiskUnleasingRecords = hardDiskUnleasingRecordsService.selectById(id);
		if(hardDiskUnleasingRecords == null) {
			return fail(request, ConstantEnum._WEB_DTAT_IS_NULL.getVal(), ConstantEnum._WEB_DTAT_IS_NULL.getDesc());
		}
		logger.debug("HardDiskUnleasingRecordsController exe getById out={} ",hardDiskUnleasingRecords);
		return success(request,hardDiskUnleasingRecords);
	}
	
	@DeleteMapping(value = "delete/{id}")
	@ResponseBody
	public WebResout delete(HttpServletRequest request,@PathVariable int id) throws BusinessException{
		logger.debug("HardDiskUnleasingRecordsController exe delete?id={}",id);
		
		HardDiskUnleasingRecords hardDiskUnleasingRecords = hardDiskUnleasingRecordsService.selectById(id);
		if(hardDiskUnleasingRecords == null) {
			return fail(request, ConstantEnum._WEB_DTAT_IS_NULL.getVal(), ConstantEnum._WEB_DTAT_IS_NULL.getDesc());
		}
		hardDiskUnleasingRecordsService.deleteById(id);
		logger.debug("HardDiskUnleasingRecordsController exe delete?id={}",id);
		
		return success(request);
	}
	
	@PutMapping(value = "update")
	@ResponseBody
	public WebResout update(HttpServletRequest request,@ModelAttribute HardDiskUnleasingRecords hardDiskUnleasingRecords) throws BusinessException{
		
		logger.debug("HardDiskUnleasingRecordsController exe update?baseAd={}",hardDiskUnleasingRecords);
		
		int i = hardDiskUnleasingRecordsService.updateObj(hardDiskUnleasingRecords);
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
	public WebResout list(HttpServletRequest request,Pager<HardDiskUnleasingRecords> pager, 
						@ModelAttribute HardDiskUnleasingRecordsDTO hardDiskUnleasingRecordsDto) throws BusinessException{
		
		logger.debug("HardDiskUnleasingRecordsController exe list?pager={}",pager);
		logger.debug("HardDiskUnleasingRecordsController exe list?HardDiskUnleasingRecordsDto={}",hardDiskUnleasingRecordsDto);
		
		pager.setParams(hardDiskUnleasingRecordsDto);
		hardDiskUnleasingRecordsService.selectTList(pager);
		
		logger.debug("HardDiskUnleasingRecordsController exe list out={}",pager);
		
		return success(request,pager);
	}
}
