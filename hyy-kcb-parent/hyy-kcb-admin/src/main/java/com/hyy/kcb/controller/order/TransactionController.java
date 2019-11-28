package com.hyy.kcb.controller.order;

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
import com.hyy.kcb.domain.order.Transaction;
import com.hyy.kcb.domain.order.dto.TransactionDTO;
import com.hyy.kcb.out.WebResout;
import com.hyy.kcb.service.order.ITransactionService;


@Controller
@RequestMapping(value = "/order/transaction/1.0", method = RequestMethod.POST)
public class TransactionController extends ApiBaseController{

	@Autowired
	private ITransactionService transactionService;

	@PostMapping(value = "save")
	@ResponseBody
	public WebResout saveObj(@ModelAttribute Transaction transaction,HttpServletRequest request) throws BusinessException{
		
		logger.debug("TransactionController exe saveObj param={}",transaction);
		
		int i = transactionService.insert(transaction);
		if(i > 0) {
			return success(request);
		}
		return fail(request);
	}
	
	@GetMapping(value = "listAll")
	@ResponseBody
	public WebResout listAll(HttpServletRequest request) throws BusinessException{
		logger.debug("TransactionController exe listAll ");
		List<Transaction> list =  transactionService.selectAll();
		logger.debug("TransactionController exe listAll out={}",list);
		return success(request,list);
	}
	@GetMapping(value = "getById/{id}")
	@ResponseBody
	public WebResout getById(HttpServletRequest request,@PathVariable int id) throws BusinessException{
		
		logger.debug("TransactionController exe getById?id={}",id);
		
		Transaction transaction = transactionService.selectById(id);
		if(transaction == null) {
			return fail(request, ConstantEnum._WEB_DTAT_IS_NULL.getVal(), ConstantEnum._WEB_DTAT_IS_NULL.getDesc());
		}
		logger.debug("TransactionController exe getById out={} ",transaction);
		return success(request,transaction);
	}
	
	@DeleteMapping(value = "delete/{id}")
	@ResponseBody
	public WebResout delete(HttpServletRequest request,@PathVariable int id) throws BusinessException{
		logger.debug("TransactionController exe delete?id={}",id);
		
		Transaction transaction = transactionService.selectById(id);
		if(transaction == null) {
			return fail(request, ConstantEnum._WEB_DTAT_IS_NULL.getVal(), ConstantEnum._WEB_DTAT_IS_NULL.getDesc());
		}
		transactionService.deleteById(id);
		logger.debug("TransactionController exe delete?id={}",id);
		
		return success(request);
	}
	
	@PutMapping(value = "update")
	@ResponseBody
	public WebResout update(HttpServletRequest request,@ModelAttribute Transaction transaction) throws BusinessException{
		
		logger.debug("TransactionController exe update?baseAd={}",transaction);
		
		int i = transactionService.updateObj(transaction);
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
	public WebResout list(HttpServletRequest request,Pager<Transaction> pager, 
						@ModelAttribute TransactionDTO transactionDto) throws BusinessException{
		
		logger.debug("TransactionController exe list?pager={}",pager);
		logger.debug("TransactionController exe list?TransactionDto={}",transactionDto);
		
		pager.setParams(transactionDto);
		transactionService.selectTList(pager);
		
		logger.debug("TransactionController exe list out={}",pager);
		
		return success(request,pager);
	}
}
