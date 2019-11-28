package com.hyy.kcb.controller.configuration;

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
import com.hyy.kcb.domain.configuration.TypeHashrate;
import com.hyy.kcb.domain.configuration.dto.TypeHashrateDTO;
import com.hyy.kcb.out.WebResout;
import com.hyy.kcb.service.configuration.ITypeHashrateService;


@Controller
@RequestMapping(value = "/configuration/typeHashrate/1.0", method = RequestMethod.POST)
public class TypeHashrateController extends ApiBaseController{

	@Autowired
	private ITypeHashrateService typeHashrateService;

	@PostMapping(value = "save")
	@ResponseBody
	public WebResout saveObj(@ModelAttribute TypeHashrate typeHashrate,HttpServletRequest request) throws BusinessException{
		
		logger.debug("TypeHashrateController exe saveObj param={}",typeHashrate);
		
		int i = typeHashrateService.insert(typeHashrate);
		if(i > 0) {
			return success(request);
		}
		return fail(request);
	}
	
	@GetMapping(value = "listAll")
	@ResponseBody
	public WebResout listAll(HttpServletRequest request) throws BusinessException{
		logger.debug("TypeHashrateController exe listAll ");
		List<TypeHashrate> list =  typeHashrateService.selectAll();
		logger.debug("TypeHashrateController exe listAll out={}",list);
		return success(request,list);
	}
	@GetMapping(value = "getById/{id}")
	@ResponseBody
	public WebResout getById(HttpServletRequest request,@PathVariable int id) throws BusinessException{
		
		logger.debug("TypeHashrateController exe getById?id={}",id);
		
		TypeHashrate typeHashrate = typeHashrateService.selectById(id);
		if(typeHashrate == null) {
			return fail(request, ConstantEnum._WEB_DTAT_IS_NULL.getVal(), ConstantEnum._WEB_DTAT_IS_NULL.getDesc());
		}
		logger.debug("TypeHashrateController exe getById out={} ",typeHashrate);
		return success(request,typeHashrate);
	}
	
	@DeleteMapping(value = "delete/{id}")
	@ResponseBody
	public WebResout delete(HttpServletRequest request,@PathVariable int id) throws BusinessException{
		logger.debug("TypeHashrateController exe delete?id={}",id);
		
		TypeHashrate typeHashrate = typeHashrateService.selectById(id);
		if(typeHashrate == null) {
			return fail(request, ConstantEnum._WEB_DTAT_IS_NULL.getVal(), ConstantEnum._WEB_DTAT_IS_NULL.getDesc());
		}
		typeHashrateService.deleteById(id);
		logger.debug("TypeHashrateController exe delete?id={}",id);
		
		return success(request);
	}
	
	@PutMapping(value = "update")
	@ResponseBody
	public WebResout update(HttpServletRequest request,@ModelAttribute TypeHashrate typeHashrate) throws BusinessException{
		
		logger.debug("TypeHashrateController exe update?baseAd={}",typeHashrate);
		
		int i = typeHashrateService.updateObj(typeHashrate);
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
	public WebResout list(HttpServletRequest request,Pager<TypeHashrate> pager, 
						@ModelAttribute TypeHashrateDTO typeHashrateDto) throws BusinessException{
		
		logger.debug("TypeHashrateController exe list?pager={}",pager);
		logger.debug("TypeHashrateController exe list?TypeHashrateDto={}",typeHashrateDto);
		
		pager.setParams(typeHashrateDto);
		typeHashrateService.selectTList(pager);
		
		logger.debug("TypeHashrateController exe list out={}",pager);
		
		return success(request,pager);
	}
}
