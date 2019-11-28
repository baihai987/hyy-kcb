package com.hyy.kcb.controller.audit;

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
import com.hyy.kcb.domain.audit.AuditSynchronization;
import com.hyy.kcb.domain.audit.dto.AuditSynchronizationDTO;
import com.hyy.kcb.out.WebResout;
import com.hyy.kcb.service.audit.IAuditSynchronizationService;


@Controller
@RequestMapping(value = "/audit/auditSynchronization/1.0", method = RequestMethod.POST)
public class AuditSynchronizationController extends ApiBaseController{

	@Autowired
	private IAuditSynchronizationService auditSynchronizationService;

	@PostMapping(value = "save")
	@ResponseBody
	public WebResout saveObj(@ModelAttribute AuditSynchronization auditSynchronization,HttpServletRequest request) throws BusinessException{
		
		logger.debug("AuditSynchronizationController exe saveObj param={}",auditSynchronization);
		
		int i = auditSynchronizationService.insert(auditSynchronization);
		if(i > 0) {
			return success(request);
		}
		return fail(request);
	}
	
	@GetMapping(value = "listAll")
	@ResponseBody
	public WebResout listAll(HttpServletRequest request) throws BusinessException{
		logger.debug("AuditSynchronizationController exe listAll ");
		List<AuditSynchronization> list =  auditSynchronizationService.selectAll();
		logger.debug("AuditSynchronizationController exe listAll out={}",list);
		return success(request,list);
	}
	@GetMapping(value = "getById/{id}")
	@ResponseBody
	public WebResout getById(HttpServletRequest request,@PathVariable int id) throws BusinessException{
		
		logger.debug("AuditSynchronizationController exe getById?id={}",id);
		
		AuditSynchronization auditSynchronization = auditSynchronizationService.selectById(id);
		if(auditSynchronization == null) {
			return fail(request, ConstantEnum._WEB_DTAT_IS_NULL.getVal(), ConstantEnum._WEB_DTAT_IS_NULL.getDesc());
		}
		logger.debug("AuditSynchronizationController exe getById out={} ",auditSynchronization);
		return success(request,auditSynchronization);
	}
	
	@DeleteMapping(value = "delete/{id}")
	@ResponseBody
	public WebResout delete(HttpServletRequest request,@PathVariable int id) throws BusinessException{
		logger.debug("AuditSynchronizationController exe delete?id={}",id);
		
		AuditSynchronization auditSynchronization = auditSynchronizationService.selectById(id);
		if(auditSynchronization == null) {
			return fail(request, ConstantEnum._WEB_DTAT_IS_NULL.getVal(), ConstantEnum._WEB_DTAT_IS_NULL.getDesc());
		}
		auditSynchronizationService.deleteById(id);
		logger.debug("AuditSynchronizationController exe delete?id={}",id);
		
		return success(request);
	}
	
	@PutMapping(value = "update")
	@ResponseBody
	public WebResout update(HttpServletRequest request,@ModelAttribute AuditSynchronization auditSynchronization) throws BusinessException{
		
		logger.debug("AuditSynchronizationController exe update?baseAd={}",auditSynchronization);
		
		int i = auditSynchronizationService.updateObj(auditSynchronization);
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
	public WebResout list(HttpServletRequest request,Pager<AuditSynchronization> pager, 
						@ModelAttribute AuditSynchronizationDTO auditSynchronizationDto) throws BusinessException{
		
		logger.debug("AuditSynchronizationController exe list?pager={}",pager);
		logger.debug("AuditSynchronizationController exe list?AuditSynchronizationDto={}",auditSynchronizationDto);
		
		pager.setParams(auditSynchronizationDto);
		auditSynchronizationService.selectTList(pager);
		
		logger.debug("AuditSynchronizationController exe list out={}",pager);
		
		return success(request,pager);
	}
}
