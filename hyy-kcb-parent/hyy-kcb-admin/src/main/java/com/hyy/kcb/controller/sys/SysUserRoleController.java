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
import com.hyy.kcb.domain.sys.SysUserRole;
import com.hyy.kcb.domain.sys.dto.SysUserRoleDTO;
import com.hyy.kcb.out.WebResout;
import com.hyy.kcb.service.sys.ISysUserRoleService;


@Controller
@RequestMapping(value = "/sys/sysUserRole/1.0", method = RequestMethod.POST)
public class SysUserRoleController extends ApiBaseController{

	@Autowired
	private ISysUserRoleService sysUserRoleService;

	@PostMapping(value = "save")
	@ResponseBody
	public WebResout saveObj(@ModelAttribute SysUserRole sysUserRole,HttpServletRequest request) throws BusinessException{
		
		logger.debug("SysUserRoleController exe saveObj param={}",sysUserRole);
		
		int i = sysUserRoleService.insert(sysUserRole);
		if(i > 0) {
			return success(request);
		}
		return fail(request);
	}
	
	@GetMapping(value = "listAll")
	@ResponseBody
	public WebResout listAll(HttpServletRequest request) throws BusinessException{
		logger.debug("SysUserRoleController exe listAll ");
		List<SysUserRole> list =  sysUserRoleService.selectAll();
		logger.debug("SysUserRoleController exe listAll out={}",list);
		return success(request,list);
	}
	@GetMapping(value = "getById/{id}")
	@ResponseBody
	public WebResout getById(HttpServletRequest request,@PathVariable int id) throws BusinessException{
		
		logger.debug("SysUserRoleController exe getById?id={}",id);
		
		SysUserRole sysUserRole = sysUserRoleService.selectById(id);
		if(sysUserRole == null) {
			return fail(request, ConstantEnum._WEB_DTAT_IS_NULL.getVal(), ConstantEnum._WEB_DTAT_IS_NULL.getDesc());
		}
		logger.debug("SysUserRoleController exe getById out={} ",sysUserRole);
		return success(request,sysUserRole);
	}
	
	@DeleteMapping(value = "delete/{id}")
	@ResponseBody
	public WebResout delete(HttpServletRequest request,@PathVariable int id) throws BusinessException{
		logger.debug("SysUserRoleController exe delete?id={}",id);
		
		SysUserRole sysUserRole = sysUserRoleService.selectById(id);
		if(sysUserRole == null) {
			return fail(request, ConstantEnum._WEB_DTAT_IS_NULL.getVal(), ConstantEnum._WEB_DTAT_IS_NULL.getDesc());
		}
		sysUserRoleService.deleteById(id);
		logger.debug("SysUserRoleController exe delete?id={}",id);
		
		return success(request);
	}
	
	@PutMapping(value = "update")
	@ResponseBody
	public WebResout update(HttpServletRequest request,@ModelAttribute SysUserRole sysUserRole) throws BusinessException{
		
		logger.debug("SysUserRoleController exe update?baseAd={}",sysUserRole);
		
		int i = sysUserRoleService.updateObj(sysUserRole);
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
	public WebResout list(HttpServletRequest request,Pager<SysUserRole> pager, 
						@ModelAttribute SysUserRoleDTO sysUserRoleDto) throws BusinessException{
		
		logger.debug("SysUserRoleController exe list?pager={}",pager);
		logger.debug("SysUserRoleController exe list?SysUserRoleDto={}",sysUserRoleDto);
		
		pager.setParams(sysUserRoleDto);
		sysUserRoleService.selectTList(pager);
		
		logger.debug("SysUserRoleController exe list out={}",pager);
		
		return success(request,pager);
	}
}
