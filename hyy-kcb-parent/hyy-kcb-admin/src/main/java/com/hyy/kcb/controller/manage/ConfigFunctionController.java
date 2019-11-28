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
import com.hyy.kcb.domain.manage.ConfigFunction;
import com.hyy.kcb.domain.manage.dto.ConfigFunctionDTO;
import com.hyy.kcb.out.WebResout;
import com.hyy.kcb.service.manage.IConfigFunctionService;


@Controller
@RequestMapping(value = "/manage/configFunction/1.0", method = RequestMethod.POST)
public class ConfigFunctionController extends ApiBaseController{

	@Autowired
	private IConfigFunctionService configFunctionService;

	@PostMapping(value = "save")
	@ResponseBody
	public WebResout saveObj(@ModelAttribute ConfigFunction configFunction,HttpServletRequest request) throws BusinessException{
		
		logger.debug("ConfigFunctionController exe saveObj param={}",configFunction);
		
		int i = configFunctionService.insert(configFunction);
		if(i > 0) {
			return success(request);
		}
		return fail(request);
	}
	
	@GetMapping(value = "listAll")
	@ResponseBody
	public WebResout listAll(HttpServletRequest request) throws BusinessException{
		logger.debug("ConfigFunctionController exe listAll ");
		List<ConfigFunction> list =  configFunctionService.selectAll();
		logger.debug("ConfigFunctionController exe listAll out={}",list);
		return success(request,list);
	}
	@GetMapping(value = "getById/{id}")
	@ResponseBody
	public WebResout getById(HttpServletRequest request,@PathVariable int id) throws BusinessException{
		
		logger.debug("ConfigFunctionController exe getById?id={}",id);
		
		ConfigFunction configFunction = configFunctionService.selectById(id);
		if(configFunction == null) {
			return fail(request, ConstantEnum._WEB_DTAT_IS_NULL.getVal(), ConstantEnum._WEB_DTAT_IS_NULL.getDesc());
		}
		logger.debug("ConfigFunctionController exe getById out={} ",configFunction);
		return success(request,configFunction);
	}
	
	@DeleteMapping(value = "delete/{id}")
	@ResponseBody
	public WebResout delete(HttpServletRequest request,@PathVariable int id) throws BusinessException{
		logger.debug("ConfigFunctionController exe delete?id={}",id);
		
		ConfigFunction configFunction = configFunctionService.selectById(id);
		if(configFunction == null) {
			return fail(request, ConstantEnum._WEB_DTAT_IS_NULL.getVal(), ConstantEnum._WEB_DTAT_IS_NULL.getDesc());
		}
		configFunctionService.deleteById(id);
		logger.debug("ConfigFunctionController exe delete?id={}",id);
		
		return success(request);
	}
	
	@PutMapping(value = "update")
	@ResponseBody
	public WebResout update(HttpServletRequest request,@ModelAttribute ConfigFunction configFunction) throws BusinessException{
		
		logger.debug("ConfigFunctionController exe update?baseAd={}",configFunction);
		
		int i = configFunctionService.updateObj(configFunction);
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
	public WebResout list(HttpServletRequest request,Pager<ConfigFunction> pager, 
						@ModelAttribute ConfigFunctionDTO configFunctionDto) throws BusinessException{
		
		logger.debug("ConfigFunctionController exe list?pager={}",pager);
		logger.debug("ConfigFunctionController exe list?ConfigFunctionDto={}",configFunctionDto);
		
		pager.setParams(configFunctionDto);
		configFunctionService.selectTList(pager);
		
		logger.debug("ConfigFunctionController exe list out={}",pager);
		
		return success(request,pager);
	}
}
