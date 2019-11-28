package com.hyy.kcb.controller.blockchain;

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
import com.hyy.kcb.domain.blockchain.TransactionWithdrawCrypto;
import com.hyy.kcb.domain.blockchain.dto.TransactionWithdrawCryptoDTO;
import com.hyy.kcb.out.WebResout;
import com.hyy.kcb.service.blockchain.ITransactionWithdrawCryptoService;


@Controller
@RequestMapping(value = "/blockchain/transactionWithdrawCrypto/1.0", method = RequestMethod.POST)
public class TransactionWithdrawCryptoController extends ApiBaseController{

	@Autowired
	private ITransactionWithdrawCryptoService transactionWithdrawCryptoService;

	@PostMapping(value = "save")
	@ResponseBody
	public WebResout saveObj(@ModelAttribute TransactionWithdrawCrypto transactionWithdrawCrypto,HttpServletRequest request) throws BusinessException{
		
		logger.debug("TransactionWithdrawCryptoController exe saveObj param={}",transactionWithdrawCrypto);
		
		int i = transactionWithdrawCryptoService.insert(transactionWithdrawCrypto);
		if(i > 0) {
			return success(request);
		}
		return fail(request);
	}
	
	@GetMapping(value = "listAll")
	@ResponseBody
	public WebResout listAll(HttpServletRequest request) throws BusinessException{
		logger.debug("TransactionWithdrawCryptoController exe listAll ");
		List<TransactionWithdrawCrypto> list =  transactionWithdrawCryptoService.selectAll();
		logger.debug("TransactionWithdrawCryptoController exe listAll out={}",list);
		return success(request,list);
	}
	@GetMapping(value = "getById/{id}")
	@ResponseBody
	public WebResout getById(HttpServletRequest request,@PathVariable int id) throws BusinessException{
		
		logger.debug("TransactionWithdrawCryptoController exe getById?id={}",id);
		
		TransactionWithdrawCrypto transactionWithdrawCrypto = transactionWithdrawCryptoService.selectById(id);
		if(transactionWithdrawCrypto == null) {
			return fail(request, ConstantEnum._WEB_DTAT_IS_NULL.getVal(), ConstantEnum._WEB_DTAT_IS_NULL.getDesc());
		}
		logger.debug("TransactionWithdrawCryptoController exe getById out={} ",transactionWithdrawCrypto);
		return success(request,transactionWithdrawCrypto);
	}
	
	@DeleteMapping(value = "delete/{id}")
	@ResponseBody
	public WebResout delete(HttpServletRequest request,@PathVariable int id) throws BusinessException{
		logger.debug("TransactionWithdrawCryptoController exe delete?id={}",id);
		
		TransactionWithdrawCrypto transactionWithdrawCrypto = transactionWithdrawCryptoService.selectById(id);
		if(transactionWithdrawCrypto == null) {
			return fail(request, ConstantEnum._WEB_DTAT_IS_NULL.getVal(), ConstantEnum._WEB_DTAT_IS_NULL.getDesc());
		}
		transactionWithdrawCryptoService.deleteById(id);
		logger.debug("TransactionWithdrawCryptoController exe delete?id={}",id);
		
		return success(request);
	}
	
	@PutMapping(value = "update")
	@ResponseBody
	public WebResout update(HttpServletRequest request,@ModelAttribute TransactionWithdrawCrypto transactionWithdrawCrypto) throws BusinessException{
		
		logger.debug("TransactionWithdrawCryptoController exe update?baseAd={}",transactionWithdrawCrypto);
		
		int i = transactionWithdrawCryptoService.updateObj(transactionWithdrawCrypto);
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
	public WebResout list(HttpServletRequest request,Pager<TransactionWithdrawCrypto> pager, 
						@ModelAttribute TransactionWithdrawCryptoDTO transactionWithdrawCryptoDto) throws BusinessException{
		
		logger.debug("TransactionWithdrawCryptoController exe list?pager={}",pager);
		logger.debug("TransactionWithdrawCryptoController exe list?TransactionWithdrawCryptoDto={}",transactionWithdrawCryptoDto);
		
		pager.setParams(transactionWithdrawCryptoDto);
		transactionWithdrawCryptoService.selectTList(pager);
		
		logger.debug("TransactionWithdrawCryptoController exe list out={}",pager);
		
		return success(request,pager);
	}
}
