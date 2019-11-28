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
import com.hyy.kcb.domain.manage.ConfigCoinSymbol;
import com.hyy.kcb.domain.manage.dto.ConfigCoinSymbolDTO;
import com.hyy.kcb.out.WebResout;
import com.hyy.kcb.service.manage.IConfigCoinSymbolService;


@Controller
@RequestMapping(value = "/manage/configCoinSymbol/1.0", method = RequestMethod.POST)
public class ConfigCoinSymbolController extends ApiBaseController{

	@Autowired
	private IConfigCoinSymbolService configCoinSymbolService;

	@PostMapping(value = "save")
	@ResponseBody
	public WebResout saveObj(@ModelAttribute ConfigCoinSymbol configCoinSymbol,HttpServletRequest request) throws BusinessException{
		
		logger.debug("ConfigCoinSymbolController exe saveObj param={}",configCoinSymbol);
		
		int i = configCoinSymbolService.insert(configCoinSymbol);
		if(i > 0) {
			return success(request);
		}
		return fail(request);
	}
	
	@GetMapping(value = "listAll")
	@ResponseBody
	public WebResout listAll(HttpServletRequest request) throws BusinessException{
		logger.debug("ConfigCoinSymbolController exe listAll ");
		List<ConfigCoinSymbol> list =  configCoinSymbolService.selectAll();
		logger.debug("ConfigCoinSymbolController exe listAll out={}",list);
		return success(request,list);
	}
	@GetMapping(value = "getById/{id}")
	@ResponseBody
	public WebResout getById(HttpServletRequest request,@PathVariable int id) throws BusinessException{
		
		logger.debug("ConfigCoinSymbolController exe getById?id={}",id);
		
		ConfigCoinSymbol configCoinSymbol = configCoinSymbolService.selectById(id);
		if(configCoinSymbol == null) {
			return fail(request, ConstantEnum._WEB_DTAT_IS_NULL.getVal(), ConstantEnum._WEB_DTAT_IS_NULL.getDesc());
		}
		logger.debug("ConfigCoinSymbolController exe getById out={} ",configCoinSymbol);
		return success(request,configCoinSymbol);
	}
	
	@DeleteMapping(value = "delete/{id}")
	@ResponseBody
	public WebResout delete(HttpServletRequest request,@PathVariable int id) throws BusinessException{
		logger.debug("ConfigCoinSymbolController exe delete?id={}",id);
		
		ConfigCoinSymbol configCoinSymbol = configCoinSymbolService.selectById(id);
		if(configCoinSymbol == null) {
			return fail(request, ConstantEnum._WEB_DTAT_IS_NULL.getVal(), ConstantEnum._WEB_DTAT_IS_NULL.getDesc());
		}
		configCoinSymbolService.deleteById(id);
		logger.debug("ConfigCoinSymbolController exe delete?id={}",id);
		
		return success(request);
	}
	
	@PutMapping(value = "update")
	@ResponseBody
	public WebResout update(HttpServletRequest request,@ModelAttribute ConfigCoinSymbol configCoinSymbol) throws BusinessException{
		
		logger.debug("ConfigCoinSymbolController exe update?baseAd={}",configCoinSymbol);
		
		int i = configCoinSymbolService.updateObj(configCoinSymbol);
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
	public WebResout list(HttpServletRequest request,Pager<ConfigCoinSymbol> pager, 
						@ModelAttribute ConfigCoinSymbolDTO configCoinSymbolDto) throws BusinessException{
		
		logger.debug("ConfigCoinSymbolController exe list?pager={}",pager);
		logger.debug("ConfigCoinSymbolController exe list?ConfigCoinSymbolDto={}",configCoinSymbolDto);
		
		pager.setParams(configCoinSymbolDto);
		configCoinSymbolService.selectTList(pager);
		
		logger.debug("ConfigCoinSymbolController exe list out={}",pager);
		
		return success(request,pager);
	}
}
