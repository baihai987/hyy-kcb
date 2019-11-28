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
import com.hyy.kcb.domain.configuration.ConfigInviteIncomeRate;
import com.hyy.kcb.domain.configuration.dto.ConfigInviteIncomeRateDTO;
import com.hyy.kcb.out.WebResout;
import com.hyy.kcb.service.configuration.IConfigInviteIncomeRateService;


@Controller
@RequestMapping(value = "/configuration/configInviteIncomeRate/1.0", method = RequestMethod.POST)
public class ConfigInviteIncomeRateController extends ApiBaseController{

	@Autowired
	private IConfigInviteIncomeRateService configInviteIncomeRateService;

	@PostMapping(value = "save")
	@ResponseBody
	public WebResout saveObj(@ModelAttribute ConfigInviteIncomeRate configInviteIncomeRate,HttpServletRequest request) throws BusinessException{
		
		logger.debug("ConfigInviteIncomeRateController exe saveObj param={}",configInviteIncomeRate);
		
		int i = configInviteIncomeRateService.insert(configInviteIncomeRate);
		if(i > 0) {
			return success(request);
		}
		return fail(request);
	}
	
	@GetMapping(value = "listAll")
	@ResponseBody
	public WebResout listAll(HttpServletRequest request) throws BusinessException{
		logger.debug("ConfigInviteIncomeRateController exe listAll ");
		List<ConfigInviteIncomeRate> list =  configInviteIncomeRateService.selectAll();
		logger.debug("ConfigInviteIncomeRateController exe listAll out={}",list);
		return success(request,list);
	}
	@GetMapping(value = "getById/{id}")
	@ResponseBody
	public WebResout getById(HttpServletRequest request,@PathVariable int id) throws BusinessException{
		
		logger.debug("ConfigInviteIncomeRateController exe getById?id={}",id);
		
		ConfigInviteIncomeRate configInviteIncomeRate = configInviteIncomeRateService.selectById(id);
		if(configInviteIncomeRate == null) {
			return fail(request, ConstantEnum._WEB_DTAT_IS_NULL.getVal(), ConstantEnum._WEB_DTAT_IS_NULL.getDesc());
		}
		logger.debug("ConfigInviteIncomeRateController exe getById out={} ",configInviteIncomeRate);
		return success(request,configInviteIncomeRate);
	}
	
	@DeleteMapping(value = "delete/{id}")
	@ResponseBody
	public WebResout delete(HttpServletRequest request,@PathVariable int id) throws BusinessException{
		logger.debug("ConfigInviteIncomeRateController exe delete?id={}",id);
		
		ConfigInviteIncomeRate configInviteIncomeRate = configInviteIncomeRateService.selectById(id);
		if(configInviteIncomeRate == null) {
			return fail(request, ConstantEnum._WEB_DTAT_IS_NULL.getVal(), ConstantEnum._WEB_DTAT_IS_NULL.getDesc());
		}
		configInviteIncomeRateService.deleteById(id);
		logger.debug("ConfigInviteIncomeRateController exe delete?id={}",id);
		
		return success(request);
	}
	
	@PutMapping(value = "update")
	@ResponseBody
	public WebResout update(HttpServletRequest request,@ModelAttribute ConfigInviteIncomeRate configInviteIncomeRate) throws BusinessException{
		
		logger.debug("ConfigInviteIncomeRateController exe update?baseAd={}",configInviteIncomeRate);
		
		int i = configInviteIncomeRateService.updateObj(configInviteIncomeRate);
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
	public WebResout list(HttpServletRequest request,Pager<ConfigInviteIncomeRate> pager, 
						@ModelAttribute ConfigInviteIncomeRateDTO configInviteIncomeRateDto) throws BusinessException{
		
		logger.debug("ConfigInviteIncomeRateController exe list?pager={}",pager);
		logger.debug("ConfigInviteIncomeRateController exe list?ConfigInviteIncomeRateDto={}",configInviteIncomeRateDto);
		
		pager.setParams(configInviteIncomeRateDto);
		configInviteIncomeRateService.selectTList(pager);
		
		logger.debug("ConfigInviteIncomeRateController exe list out={}",pager);
		
		return success(request,pager);
	}
}
