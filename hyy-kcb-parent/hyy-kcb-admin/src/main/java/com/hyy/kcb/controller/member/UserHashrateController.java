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
import com.hyy.kcb.domain.member.UserHashrate;
import com.hyy.kcb.domain.member.dto.UserHashrateDTO;
import com.hyy.kcb.out.WebResout;
import com.hyy.kcb.service.member.IUserHashrateService;


@Controller
@RequestMapping(value = "/member/userHashrate/1.0", method = RequestMethod.POST)
public class UserHashrateController extends ApiBaseController{

	@Autowired
	private IUserHashrateService userHashrateService;

	@PostMapping(value = "save")
	@ResponseBody
	public WebResout saveObj(@ModelAttribute UserHashrate userHashrate,HttpServletRequest request) throws BusinessException{
		
		logger.debug("UserHashrateController exe saveObj param={}",userHashrate);
		
		int i = userHashrateService.insert(userHashrate);
		if(i > 0) {
			return success(request);
		}
		return fail(request);
	}
	
	@GetMapping(value = "listAll")
	@ResponseBody
	public WebResout listAll(HttpServletRequest request) throws BusinessException{
		logger.debug("UserHashrateController exe listAll ");
		List<UserHashrate> list =  userHashrateService.selectAll();
		logger.debug("UserHashrateController exe listAll out={}",list);
		return success(request,list);
	}
	@GetMapping(value = "getById/{id}")
	@ResponseBody
	public WebResout getById(HttpServletRequest request,@PathVariable int id) throws BusinessException{
		
		logger.debug("UserHashrateController exe getById?id={}",id);
		
		UserHashrate userHashrate = userHashrateService.selectById(id);
		if(userHashrate == null) {
			return fail(request, ConstantEnum._WEB_DTAT_IS_NULL.getVal(), ConstantEnum._WEB_DTAT_IS_NULL.getDesc());
		}
		logger.debug("UserHashrateController exe getById out={} ",userHashrate);
		return success(request,userHashrate);
	}
	
	@DeleteMapping(value = "delete/{id}")
	@ResponseBody
	public WebResout delete(HttpServletRequest request,@PathVariable int id) throws BusinessException{
		logger.debug("UserHashrateController exe delete?id={}",id);
		
		UserHashrate userHashrate = userHashrateService.selectById(id);
		if(userHashrate == null) {
			return fail(request, ConstantEnum._WEB_DTAT_IS_NULL.getVal(), ConstantEnum._WEB_DTAT_IS_NULL.getDesc());
		}
		userHashrateService.deleteById(id);
		logger.debug("UserHashrateController exe delete?id={}",id);
		
		return success(request);
	}
	
	@PutMapping(value = "update")
	@ResponseBody
	public WebResout update(HttpServletRequest request,@ModelAttribute UserHashrate userHashrate) throws BusinessException{
		
		logger.debug("UserHashrateController exe update?baseAd={}",userHashrate);
		
		int i = userHashrateService.updateObj(userHashrate);
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
	public WebResout list(HttpServletRequest request,Pager<UserHashrate> pager, 
						@ModelAttribute UserHashrateDTO userHashrateDto) throws BusinessException{
		
		logger.debug("UserHashrateController exe list?pager={}",pager);
		logger.debug("UserHashrateController exe list?UserHashrateDto={}",userHashrateDto);
		
		pager.setParams(userHashrateDto);
		userHashrateService.selectTList(pager);
		
		logger.debug("UserHashrateController exe list out={}",pager);
		
		return success(request,pager);
	}
}
