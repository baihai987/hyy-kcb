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
import com.hyy.kcb.domain.configuration.ConfigHardDiskContract;
import com.hyy.kcb.domain.configuration.dto.ConfigHardDiskContractDTO;
import com.hyy.kcb.out.WebResout;
import com.hyy.kcb.service.configuration.IConfigHardDiskContractService;


@Controller
@RequestMapping(value = "/configuration/configHardDiskContract/1.0", method = RequestMethod.POST)
public class ConfigHardDiskContractController extends ApiBaseController{

	@Autowired
	private IConfigHardDiskContractService configHardDiskContractService;

	@PostMapping(value = "save")
	@ResponseBody
	public WebResout saveObj(@ModelAttribute ConfigHardDiskContract configHardDiskContract,HttpServletRequest request) throws BusinessException{
		
		logger.debug("ConfigHardDiskContractController exe saveObj param={}",configHardDiskContract);
		
		int i = configHardDiskContractService.insert(configHardDiskContract);
		if(i > 0) {
			return success(request);
		}
		return fail(request);
	}
	
	@GetMapping(value = "listAll")
	@ResponseBody
	public WebResout listAll(HttpServletRequest request) throws BusinessException{
		logger.debug("ConfigHardDiskContractController exe listAll ");
		List<ConfigHardDiskContract> list =  configHardDiskContractService.selectAll();
		logger.debug("ConfigHardDiskContractController exe listAll out={}",list);
		return success(request,list);
	}
	@GetMapping(value = "getById/{id}")
	@ResponseBody
	public WebResout getById(HttpServletRequest request,@PathVariable int id) throws BusinessException{
		
		logger.debug("ConfigHardDiskContractController exe getById?id={}",id);
		
		ConfigHardDiskContract configHardDiskContract = configHardDiskContractService.selectById(id);
		if(configHardDiskContract == null) {
			return fail(request, ConstantEnum._WEB_DTAT_IS_NULL.getVal(), ConstantEnum._WEB_DTAT_IS_NULL.getDesc());
		}
		logger.debug("ConfigHardDiskContractController exe getById out={} ",configHardDiskContract);
		return success(request,configHardDiskContract);
	}
	
	@DeleteMapping(value = "delete/{id}")
	@ResponseBody
	public WebResout delete(HttpServletRequest request,@PathVariable int id) throws BusinessException{
		logger.debug("ConfigHardDiskContractController exe delete?id={}",id);
		
		ConfigHardDiskContract configHardDiskContract = configHardDiskContractService.selectById(id);
		if(configHardDiskContract == null) {
			return fail(request, ConstantEnum._WEB_DTAT_IS_NULL.getVal(), ConstantEnum._WEB_DTAT_IS_NULL.getDesc());
		}
		configHardDiskContractService.deleteById(id);
		logger.debug("ConfigHardDiskContractController exe delete?id={}",id);
		
		return success(request);
	}
	
	@PutMapping(value = "update")
	@ResponseBody
	public WebResout update(HttpServletRequest request,@ModelAttribute ConfigHardDiskContract configHardDiskContract) throws BusinessException{
		
		logger.debug("ConfigHardDiskContractController exe update?baseAd={}",configHardDiskContract);
		
		int i = configHardDiskContractService.updateObj(configHardDiskContract);
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
	public WebResout list(HttpServletRequest request,Pager<ConfigHardDiskContract> pager, 
						@ModelAttribute ConfigHardDiskContractDTO configHardDiskContractDto) throws BusinessException{
		
		logger.debug("ConfigHardDiskContractController exe list?pager={}",pager);
		logger.debug("ConfigHardDiskContractController exe list?ConfigHardDiskContractDto={}",configHardDiskContractDto);
		
		pager.setParams(configHardDiskContractDto);
		configHardDiskContractService.selectTList(pager);
		
		logger.debug("ConfigHardDiskContractController exe list out={}",pager);
		
		return success(request,pager);
	}
}
