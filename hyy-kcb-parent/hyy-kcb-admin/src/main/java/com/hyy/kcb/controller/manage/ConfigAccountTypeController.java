package com.hyy.kcb.controller.manage;

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
import com.hyy.kcb.domain.manage.ConfigAccountType;
import com.hyy.kcb.domain.manage.dto.ConfigAccountTypeDTO;
import com.hyy.kcb.out.WebResout;
import com.hyy.kcb.service.manage.IConfigAccountTypeService;


@Controller
@RequestMapping(value = "/manage/configAccountType/1.0", method = RequestMethod.POST)
public class ConfigAccountTypeController extends ApiBaseController{

	@Autowired
	private IConfigAccountTypeService configAccountTypeService;

	@PostMapping(value = "save")
	@ResponseBody
	public WebResout saveObj(@ModelAttribute ConfigAccountType configAccountType,HttpServletRequest request) throws BusinessException{
		
		logger.debug("ConfigAccountTypeController exe saveObj param={}",configAccountType);
		
		int i = configAccountTypeService.insert(configAccountType);
		if(i > 0) {
			return success(request);
		}
		return fail(request);
	}
	
	@GetMapping(value = "listAll")
	@ResponseBody
	public WebResout listAll(HttpServletRequest request) throws BusinessException{
		logger.debug("ConfigAccountTypeController exe listAll ");
		List<ConfigAccountType> list =  configAccountTypeService.selectAll();
		logger.debug("ConfigAccountTypeController exe listAll out={}",list);
		return success(request,list);
	}
	@GetMapping(value = "getById/{id}")
	@ResponseBody
	public WebResout getById(HttpServletRequest request,@PathVariable int id) throws BusinessException{
		
		logger.debug("ConfigAccountTypeController exe getById?id={}",id);
		
		ConfigAccountType configAccountType = configAccountTypeService.selectById(id);
		if(configAccountType == null) {
			return fail(request, ConstantEnum._WEB_DTAT_IS_NULL.getVal(), ConstantEnum._WEB_DTAT_IS_NULL.getDesc());
		}
		logger.debug("ConfigAccountTypeController exe getById out={} ",configAccountType);
		return success(request,configAccountType);
	}
	
	@DeleteMapping(value = "delete/{id}")
	@ResponseBody
	public WebResout delete(HttpServletRequest request,@PathVariable int id) throws BusinessException{
		logger.debug("ConfigAccountTypeController exe delete?id={}",id);
		
		ConfigAccountType configAccountType = configAccountTypeService.selectById(id);
		if(configAccountType == null) {
			return fail(request, ConstantEnum._WEB_DTAT_IS_NULL.getVal(), ConstantEnum._WEB_DTAT_IS_NULL.getDesc());
		}
		configAccountTypeService.deleteById(id);
		logger.debug("ConfigAccountTypeController exe delete?id={}",id);
		
		return success(request);
	}
	
	@PutMapping(value = "update")
	@ResponseBody
	public WebResout update(HttpServletRequest request,@ModelAttribute ConfigAccountType configAccountType) throws BusinessException{
		
		logger.debug("ConfigAccountTypeController exe update?baseAd={}",configAccountType);
		
		int i = configAccountTypeService.updateObj(configAccountType);
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
	public WebResout list(HttpServletRequest request,Pager<ConfigAccountType> pager, 
						@ModelAttribute ConfigAccountTypeDTO configAccountTypeDto) throws BusinessException{
		
		logger.debug("ConfigAccountTypeController exe list?pager={}",pager);
		logger.debug("ConfigAccountTypeController exe list?ConfigAccountTypeDto={}",configAccountTypeDto);
		
		pager.setParams(configAccountTypeDto);
		configAccountTypeService.selectTList(pager);
		
		logger.debug("ConfigAccountTypeController exe list out={}",pager);
		
		return success(request,pager);
	}
}
