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
import com.hyy.kcb.domain.sys.SysRole;
import com.hyy.kcb.domain.sys.dto.SysRoleDTO;
import com.hyy.kcb.out.WebResout;
import com.hyy.kcb.service.sys.ISysRoleService;


@Controller
@RequestMapping(value = "/sys/sysRole/1.0", method = RequestMethod.POST)
public class SysRoleController extends ApiBaseController{

	@Autowired
	private ISysRoleService sysRoleService;

	@PostMapping(value = "save")
	@ResponseBody
	public WebResout saveObj(@ModelAttribute SysRole sysRole,HttpServletRequest request) throws BusinessException{
		
		logger.debug("SysRoleController exe saveObj param={}",sysRole);
		
		int i = sysRoleService.insert(sysRole);
		if(i > 0) {
			return success(request);
		}
		return fail(request);
	}
	
	@GetMapping(value = "listAll")
	@ResponseBody
	public WebResout listAll(HttpServletRequest request) throws BusinessException{
		logger.debug("SysRoleController exe listAll ");
		List<SysRole> list =  sysRoleService.selectAll();
		logger.debug("SysRoleController exe listAll out={}",list);
		return success(request,list);
	}
	@GetMapping(value = "getById/{id}")
	@ResponseBody
	public WebResout getById(HttpServletRequest request,@PathVariable int id) throws BusinessException{
		
		logger.debug("SysRoleController exe getById?id={}",id);
		
		SysRole sysRole = sysRoleService.selectById(id);
		if(sysRole == null) {
			return fail(request, ConstantEnum._WEB_DTAT_IS_NULL.getVal(), ConstantEnum._WEB_DTAT_IS_NULL.getDesc());
		}
		logger.debug("SysRoleController exe getById out={} ",sysRole);
		return success(request,sysRole);
	}
	
	@DeleteMapping(value = "delete/{id}")
	@ResponseBody
	public WebResout delete(HttpServletRequest request,@PathVariable int id) throws BusinessException{
		logger.debug("SysRoleController exe delete?id={}",id);
		
		SysRole sysRole = sysRoleService.selectById(id);
		if(sysRole == null) {
			return fail(request, ConstantEnum._WEB_DTAT_IS_NULL.getVal(), ConstantEnum._WEB_DTAT_IS_NULL.getDesc());
		}
		sysRoleService.deleteById(id);
		logger.debug("SysRoleController exe delete?id={}",id);
		
		return success(request);
	}
	
	@PutMapping(value = "update")
	@ResponseBody
	public WebResout update(HttpServletRequest request,@ModelAttribute SysRole sysRole) throws BusinessException{
		
		logger.debug("SysRoleController exe update?baseAd={}",sysRole);
		
		int i = sysRoleService.updateObj(sysRole);
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
	public WebResout list(HttpServletRequest request,Pager<SysRole> pager, 
						@ModelAttribute SysRoleDTO sysRoleDto) throws BusinessException{
		
		logger.debug("SysRoleController exe list?pager={}",pager);
		logger.debug("SysRoleController exe list?SysRoleDto={}",sysRoleDto);
		
		pager.setParams(sysRoleDto);
		sysRoleService.selectTList(pager);
		
		logger.debug("SysRoleController exe list out={}",pager);
		
		return success(request,pager);
	}
}
