package com.hyy.kcb.controller.member;

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
import com.hyy.kcb.domain.member.WaterHashrate;
import com.hyy.kcb.domain.member.dto.WaterHashrateDTO;
import com.hyy.kcb.out.WebResout;
import com.hyy.kcb.service.member.IWaterHashrateService;


@Controller
@RequestMapping(value = "/member/waterHashrate/1.0", method = RequestMethod.POST)
public class WaterHashrateController extends ApiBaseController{

	@Autowired
	private IWaterHashrateService waterHashrateService;

	@PostMapping(value = "save")
	@ResponseBody
	public WebResout saveObj(@ModelAttribute WaterHashrate waterHashrate,HttpServletRequest request) throws BusinessException{
		
		logger.debug("WaterHashrateController exe saveObj param={}",waterHashrate);
		
		int i = waterHashrateService.insert(waterHashrate);
		if(i > 0) {
			return success(request);
		}
		return fail(request);
	}
	
	@GetMapping(value = "listAll")
	@ResponseBody
	public WebResout listAll(HttpServletRequest request) throws BusinessException{
		logger.debug("WaterHashrateController exe listAll ");
		List<WaterHashrate> list =  waterHashrateService.selectAll();
		logger.debug("WaterHashrateController exe listAll out={}",list);
		return success(request,list);
	}
	@GetMapping(value = "getById/{id}")
	@ResponseBody
	public WebResout getById(HttpServletRequest request,@PathVariable int id) throws BusinessException{
		
		logger.debug("WaterHashrateController exe getById?id={}",id);
		
		WaterHashrate waterHashrate = waterHashrateService.selectById(id);
		if(waterHashrate == null) {
			return fail(request, ConstantEnum._WEB_DTAT_IS_NULL.getVal(), ConstantEnum._WEB_DTAT_IS_NULL.getDesc());
		}
		logger.debug("WaterHashrateController exe getById out={} ",waterHashrate);
		return success(request,waterHashrate);
	}
	
	@DeleteMapping(value = "delete/{id}")
	@ResponseBody
	public WebResout delete(HttpServletRequest request,@PathVariable int id) throws BusinessException{
		logger.debug("WaterHashrateController exe delete?id={}",id);
		
		WaterHashrate waterHashrate = waterHashrateService.selectById(id);
		if(waterHashrate == null) {
			return fail(request, ConstantEnum._WEB_DTAT_IS_NULL.getVal(), ConstantEnum._WEB_DTAT_IS_NULL.getDesc());
		}
		waterHashrateService.deleteById(id);
		logger.debug("WaterHashrateController exe delete?id={}",id);
		
		return success(request);
	}
	
	@PutMapping(value = "update")
	@ResponseBody
	public WebResout update(HttpServletRequest request,@ModelAttribute WaterHashrate waterHashrate) throws BusinessException{
		
		logger.debug("WaterHashrateController exe update?baseAd={}",waterHashrate);
		
		int i = waterHashrateService.updateObj(waterHashrate);
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
	public WebResout list(HttpServletRequest request,Pager<WaterHashrate> pager, 
						@ModelAttribute WaterHashrateDTO waterHashrateDto) throws BusinessException{
		
		logger.debug("WaterHashrateController exe list?pager={}",pager);
		logger.debug("WaterHashrateController exe list?WaterHashrateDto={}",waterHashrateDto);
		
		pager.setParams(waterHashrateDto);
		waterHashrateService.selectTList(pager);
		
		logger.debug("WaterHashrateController exe list out={}",pager);
		
		return success(request,pager);
	}
}
