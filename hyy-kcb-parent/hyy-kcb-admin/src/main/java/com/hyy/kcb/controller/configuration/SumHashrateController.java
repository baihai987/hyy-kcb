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
import com.hyy.kcb.domain.configuration.SumHashrate;
import com.hyy.kcb.domain.configuration.dto.SumHashrateDTO;
import com.hyy.kcb.out.WebResout;
import com.hyy.kcb.service.configuration.ISumHashrateService;


@Controller
@RequestMapping(value = "/configuration/sumHashrate/1.0", method = RequestMethod.POST)
public class SumHashrateController extends ApiBaseController{

	@Autowired
	private ISumHashrateService sumHashrateService;

	@PostMapping(value = "save")
	@ResponseBody
	public WebResout saveObj(@ModelAttribute SumHashrate sumHashrate,HttpServletRequest request) throws BusinessException{
		
		logger.debug("SumHashrateController exe saveObj param={}",sumHashrate);
		
		int i = sumHashrateService.insert(sumHashrate);
		if(i > 0) {
			return success(request);
		}
		return fail(request);
	}
	
	@GetMapping(value = "listAll")
	@ResponseBody
	public WebResout listAll(HttpServletRequest request) throws BusinessException{
		logger.debug("SumHashrateController exe listAll ");
		List<SumHashrate> list =  sumHashrateService.selectAll();
		logger.debug("SumHashrateController exe listAll out={}",list);
		return success(request,list);
	}
	@GetMapping(value = "getById/{id}")
	@ResponseBody
	public WebResout getById(HttpServletRequest request,@PathVariable int id) throws BusinessException{
		
		logger.debug("SumHashrateController exe getById?id={}",id);
		
		SumHashrate sumHashrate = sumHashrateService.selectById(id);
		if(sumHashrate == null) {
			return fail(request, ConstantEnum._WEB_DTAT_IS_NULL.getVal(), ConstantEnum._WEB_DTAT_IS_NULL.getDesc());
		}
		logger.debug("SumHashrateController exe getById out={} ",sumHashrate);
		return success(request,sumHashrate);
	}
	
	@DeleteMapping(value = "delete/{id}")
	@ResponseBody
	public WebResout delete(HttpServletRequest request,@PathVariable int id) throws BusinessException{
		logger.debug("SumHashrateController exe delete?id={}",id);
		
		SumHashrate sumHashrate = sumHashrateService.selectById(id);
		if(sumHashrate == null) {
			return fail(request, ConstantEnum._WEB_DTAT_IS_NULL.getVal(), ConstantEnum._WEB_DTAT_IS_NULL.getDesc());
		}
		sumHashrateService.deleteById(id);
		logger.debug("SumHashrateController exe delete?id={}",id);
		
		return success(request);
	}
	
	@PutMapping(value = "update")
	@ResponseBody
	public WebResout update(HttpServletRequest request,@ModelAttribute SumHashrate sumHashrate) throws BusinessException{
		
		logger.debug("SumHashrateController exe update?baseAd={}",sumHashrate);
		
		int i = sumHashrateService.updateObj(sumHashrate);
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
	public WebResout list(HttpServletRequest request,Pager<SumHashrate> pager, 
						@ModelAttribute SumHashrateDTO sumHashrateDto) throws BusinessException{
		
		logger.debug("SumHashrateController exe list?pager={}",pager);
		logger.debug("SumHashrateController exe list?SumHashrateDto={}",sumHashrateDto);
		
		pager.setParams(sumHashrateDto);
		sumHashrateService.selectTList(pager);
		
		logger.debug("SumHashrateController exe list out={}",pager);
		
		return success(request,pager);
	}
}
