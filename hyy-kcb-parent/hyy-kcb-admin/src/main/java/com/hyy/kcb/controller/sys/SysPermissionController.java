package com.hyy.kcb.controller.sys;

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
import com.hyy.kcb.domain.sys.SysPermission;
import com.hyy.kcb.domain.sys.dto.SysPermissionDTO;
import com.hyy.kcb.out.WebResout;
import com.hyy.kcb.service.sys.ISysPermissionService;


@Controller
@RequestMapping(value = "/sys/sysPermission/1.0", method = RequestMethod.POST)
public class SysPermissionController extends ApiBaseController{

	@Autowired
	private ISysPermissionService sysPermissionService;

	//['系统管理','权限管理','审批管理','财务管理','APP内容管理','统计分析','消息管理']
	@PostMapping(value = "save")
	@ResponseBody
	public WebResout saveObj(@ModelAttribute SysPermission sysPermission,HttpServletRequest request) throws BusinessException{
		
		logger.debug("SysPermissionController exe saveObj param={}",sysPermission);
		
		int i = sysPermissionService.insert(sysPermission);
		if(i > 0) {
			return success(request);
		}
		return fail(request);
	}
	
	@GetMapping(value = "listAll")
	@ResponseBody
	public WebResout listAll(HttpServletRequest request) throws BusinessException{
		logger.debug("SysPermissionController exe listAll ");
		List<SysPermission> list =  sysPermissionService.selectAll();
		logger.debug("SysPermissionController exe listAll out={}",list);
		return success(request,list);
	}
	@GetMapping(value = "getById/{id}")
	@ResponseBody
	public WebResout getById(HttpServletRequest request,@PathVariable int id) throws BusinessException{
		
		logger.debug("SysPermissionController exe getById?id={}",id);
		
		SysPermission sysPermission = sysPermissionService.selectById(id);
		if(sysPermission == null) {
			return fail(request, ConstantEnum._WEB_DTAT_IS_NULL.getVal(), ConstantEnum._WEB_DTAT_IS_NULL.getDesc());
		}
		logger.debug("SysPermissionController exe getById out={} ",sysPermission);
		return success(request,sysPermission);
	}
	
	@DeleteMapping(value = "delete/{id}")
	@ResponseBody
	public WebResout delete(HttpServletRequest request,@PathVariable int id) throws BusinessException{
		logger.debug("SysPermissionController exe delete?id={}",id);
		
		SysPermission sysPermission = sysPermissionService.selectById(id);
		if(sysPermission == null) {
			return fail(request, ConstantEnum._WEB_DTAT_IS_NULL.getVal(), ConstantEnum._WEB_DTAT_IS_NULL.getDesc());
		}
		sysPermissionService.deleteById(id);
		logger.debug("SysPermissionController exe delete?id={}",id);
		
		return success(request);
	}
	
	@PutMapping(value = "update")
	@ResponseBody
	public WebResout update(HttpServletRequest request,@ModelAttribute SysPermission sysPermission) throws BusinessException{
		
		logger.debug("SysPermissionController exe update?baseAd={}",sysPermission);
		
		int i = sysPermissionService.updateObj(sysPermission);
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
	public WebResout list(HttpServletRequest request,Pager<SysPermission> pager, 
						@ModelAttribute SysPermissionDTO sysPermissionDto) throws BusinessException{
		
		logger.debug("SysPermissionController exe list?pager={}",pager);
		logger.debug("SysPermissionController exe list?SysPermissionDto={}",sysPermissionDto);
		
		pager.setParams(sysPermissionDto);
		sysPermissionService.selectTList(pager);
		
		logger.debug("SysPermissionController exe list out={}",pager);
		
		return success(request,pager);
	}
}
