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
import com.hyy.kcb.domain.sys.SysRolePermission;
import com.hyy.kcb.domain.sys.dto.SysRolePermissionDTO;
import com.hyy.kcb.out.WebResout;
import com.hyy.kcb.service.sys.ISysRolePermissionService;


@Controller
@RequestMapping(value = "/sys/sysRolePermission/1.0", method = RequestMethod.POST)
public class SysRolePermissionController extends ApiBaseController{

	@Autowired
	private ISysRolePermissionService sysRolePermissionService;

	@PostMapping(value = "save")
	@ResponseBody
	public WebResout saveObj(@ModelAttribute SysRolePermission sysRolePermission,HttpServletRequest request) throws BusinessException{
		
		logger.debug("SysRolePermissionController exe saveObj param={}",sysRolePermission);
		
		int i = sysRolePermissionService.insert(sysRolePermission);
		if(i > 0) {
			return success(request);
		}
		return fail(request);
	}
	
	@GetMapping(value = "listAll")
	@ResponseBody
	public WebResout listAll(HttpServletRequest request) throws BusinessException{
		logger.debug("SysRolePermissionController exe listAll ");
		List<SysRolePermission> list =  sysRolePermissionService.selectAll();
		logger.debug("SysRolePermissionController exe listAll out={}",list);
		return success(request,list);
	}
	@GetMapping(value = "getById/{id}")
	@ResponseBody
	public WebResout getById(HttpServletRequest request,@PathVariable int id) throws BusinessException{
		
		logger.debug("SysRolePermissionController exe getById?id={}",id);
		
		SysRolePermission sysRolePermission = sysRolePermissionService.selectById(id);
		if(sysRolePermission == null) {
			return fail(request, ConstantEnum._WEB_DTAT_IS_NULL.getVal(), ConstantEnum._WEB_DTAT_IS_NULL.getDesc());
		}
		logger.debug("SysRolePermissionController exe getById out={} ",sysRolePermission);
		return success(request,sysRolePermission);
	}
	
	@DeleteMapping(value = "delete/{id}")
	@ResponseBody
	public WebResout delete(HttpServletRequest request,@PathVariable int id) throws BusinessException{
		logger.debug("SysRolePermissionController exe delete?id={}",id);
		
		SysRolePermission sysRolePermission = sysRolePermissionService.selectById(id);
		if(sysRolePermission == null) {
			return fail(request, ConstantEnum._WEB_DTAT_IS_NULL.getVal(), ConstantEnum._WEB_DTAT_IS_NULL.getDesc());
		}
		sysRolePermissionService.deleteById(id);
		logger.debug("SysRolePermissionController exe delete?id={}",id);
		
		return success(request);
	}
	
	@PutMapping(value = "update")
	@ResponseBody
	public WebResout update(HttpServletRequest request,@ModelAttribute SysRolePermission sysRolePermission) throws BusinessException{
		
		logger.debug("SysRolePermissionController exe update?baseAd={}",sysRolePermission);
		
		int i = sysRolePermissionService.updateObj(sysRolePermission);
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
	public WebResout list(HttpServletRequest request,Pager<SysRolePermission> pager, 
						@ModelAttribute SysRolePermissionDTO sysRolePermissionDto) throws BusinessException{
		
		logger.debug("SysRolePermissionController exe list?pager={}",pager);
		logger.debug("SysRolePermissionController exe list?SysRolePermissionDto={}",sysRolePermissionDto);
		
		pager.setParams(sysRolePermissionDto);
		sysRolePermissionService.selectTList(pager);
		
		logger.debug("SysRolePermissionController exe list out={}",pager);
		
		return success(request,pager);
	}
}
