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
import com.hyy.kcb.domain.configuration.HardDisk;
import com.hyy.kcb.domain.configuration.dto.HardDiskDTO;
import com.hyy.kcb.out.WebResout;
import com.hyy.kcb.service.configuration.IHardDiskService;


@Controller
@RequestMapping(value = "/configuration/hardDisk/1.0", method = RequestMethod.POST)
public class HardDiskController extends ApiBaseController{

	@Autowired
	private IHardDiskService hardDiskService;

	@PostMapping(value = "save")
	@ResponseBody
	public WebResout saveObj(@ModelAttribute HardDisk hardDisk,HttpServletRequest request) throws BusinessException{
		
		logger.debug("HardDiskController exe saveObj param={}",hardDisk);
		
		int i = hardDiskService.insert(hardDisk);
		if(i > 0) {
			return success(request);
		}
		return fail(request);
	}
	
	@GetMapping(value = "listAll")
	@ResponseBody
	public WebResout listAll(HttpServletRequest request) throws BusinessException{
		logger.debug("HardDiskController exe listAll ");
		List<HardDisk> list =  hardDiskService.selectAll();
		logger.debug("HardDiskController exe listAll out={}",list);
		return success(request,list);
	}
	@GetMapping(value = "getById/{id}")
	@ResponseBody
	public WebResout getById(HttpServletRequest request,@PathVariable int id) throws BusinessException{
		
		logger.debug("HardDiskController exe getById?id={}",id);
		
		HardDisk hardDisk = hardDiskService.selectById(id);
		if(hardDisk == null) {
			return fail(request, ConstantEnum._WEB_DTAT_IS_NULL.getVal(), ConstantEnum._WEB_DTAT_IS_NULL.getDesc());
		}
		logger.debug("HardDiskController exe getById out={} ",hardDisk);
		return success(request,hardDisk);
	}
	
	@DeleteMapping(value = "delete/{id}")
	@ResponseBody
	public WebResout delete(HttpServletRequest request,@PathVariable int id) throws BusinessException{
		logger.debug("HardDiskController exe delete?id={}",id);
		
		HardDisk hardDisk = hardDiskService.selectById(id);
		if(hardDisk == null) {
			return fail(request, ConstantEnum._WEB_DTAT_IS_NULL.getVal(), ConstantEnum._WEB_DTAT_IS_NULL.getDesc());
		}
		hardDiskService.deleteById(id);
		logger.debug("HardDiskController exe delete?id={}",id);
		
		return success(request);
	}
	
	@PutMapping(value = "update")
	@ResponseBody
	public WebResout update(HttpServletRequest request,@ModelAttribute HardDisk hardDisk) throws BusinessException{
		
		logger.debug("HardDiskController exe update?baseAd={}",hardDisk);
		
		int i = hardDiskService.updateObj(hardDisk);
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
	public WebResout list(HttpServletRequest request,Pager<HardDisk> pager, 
						@ModelAttribute HardDiskDTO hardDiskDto) throws BusinessException{
		
		logger.debug("HardDiskController exe list?pager={}",pager);
		logger.debug("HardDiskController exe list?HardDiskDto={}",hardDiskDto);
		
		pager.setParams(hardDiskDto);
		hardDiskService.selectTList(pager);
		
		logger.debug("HardDiskController exe list out={}",pager);
		
		return success(request,pager);
	}
}
