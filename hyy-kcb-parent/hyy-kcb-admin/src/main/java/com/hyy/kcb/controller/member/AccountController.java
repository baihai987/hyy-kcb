package com.hyy.kcb.controller.member;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.User;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.authz.annotation.RequiresUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.hyy.kcb.commons.ConstantEnum;
import com.hyy.kcb.config.controller.ApiBaseController;
import com.hyy.kcb.commons.exception.BusinessException;
import com.hyy.kcb.commons.page.Pager;
import com.hyy.kcb.domain.member.Account;
import com.hyy.kcb.domain.member.dto.AccountDTO;
import com.hyy.kcb.out.WebResout;
import com.hyy.kcb.service.member.IAccountService;


@Controller
@RequestMapping(value = "/member/account/1.0", method = RequestMethod.POST)
public class AccountController extends ApiBaseController{

	@Autowired
	private IAccountService accountService;

	@PostMapping(value = "save")
	@ResponseBody
	public WebResout saveObj(@ModelAttribute Account account,HttpServletRequest request) throws BusinessException{
		
		logger.debug("AccountController exe saveObj param={}",account);
		
		int i = accountService.insert(account);
		if(i > 0) {
			return success(request);
		}
		return fail(request);
	}
	@GetMapping(value = "listAll")
	@RequiresUser
	@ResponseBody
	public WebResout listAll(HttpServletRequest request) throws BusinessException{
		logger.debug("AccountController exe listAll ");
		List<Account> list =  accountService.selectAll();
		logger.debug("AccountController exe listAll out={}",list);
		return success(request,list);
	}
	@GetMapping(value = "getById/{id}")
	@ResponseBody
	public WebResout getById(HttpServletRequest request,@PathVariable int id) throws BusinessException{
		
		logger.debug("AccountController exe getById?id={}",id);
		
		Account account = accountService.selectById(id);
		if(account == null) {
			return fail(request, ConstantEnum._WEB_DTAT_IS_NULL.getVal(), ConstantEnum._WEB_DTAT_IS_NULL.getDesc());
		}
		logger.debug("AccountController exe getById out={} ",account);
		return success(request,account);
	}
	
	@DeleteMapping(value = "delete/{id}")
	@ResponseBody
	public WebResout delete(HttpServletRequest request,@PathVariable int id) throws BusinessException{
		logger.debug("AccountController exe delete?id={}",id);
		
		Account account = accountService.selectById(id);
		if(account == null) {
			return fail(request, ConstantEnum._WEB_DTAT_IS_NULL.getVal(), ConstantEnum._WEB_DTAT_IS_NULL.getDesc());
		}
		accountService.deleteById(id);
		logger.debug("AccountController exe delete?id={}",id);
		
		return success(request);
	}
	
	@PutMapping(value = "update")
	@ResponseBody
	public WebResout update(HttpServletRequest request,@ModelAttribute Account account) throws BusinessException{
		
		logger.debug("AccountController exe update?baseAd={}",account);
		
		int i = accountService.updateObj(account);
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
	public WebResout list(HttpServletRequest request,Pager<Account> pager, 
						@ModelAttribute AccountDTO accountDto) throws BusinessException{
		
		logger.debug("AccountController exe list?pager={}",pager);
		logger.debug("AccountController exe list?AccountDto={}",accountDto);
		
		pager.setParams(accountDto);
		accountService.selectTList(pager);
		
		logger.debug("AccountController exe list out={}",pager);
		
		return success(request,pager);
	}

	//转入转出
	@PostMapping("/findAllAccounts")
	@ResponseBody
//	@RequiresPermissions("static:findAllAccounts")
	public WebResout findAllAccounts(HttpServletRequest request,
								  @RequestParam Map<String,Object> map) throws BusinessException {
		Map hashMap= accountService.findOutAndIn(map);
		if(hashMap.get("totalCount").equals(0)){
			return fail(request,"无查询结果");
		}
		return success(request,hashMap);
	}
}
