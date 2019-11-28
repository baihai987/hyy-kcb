package com.hyy.kcb.controller.blockchain;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.hyy.kcb.config.controller.ApiBaseController;
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
import com.hyy.kcb.commons.exception.BusinessException;
import com.hyy.kcb.commons.page.Pager;
import com.hyy.kcb.domain.blockchain.TransactionDepositCrypto;
import com.hyy.kcb.domain.blockchain.dto.TransactionDepositCryptoDTO;
import com.hyy.kcb.out.WebResout;
import com.hyy.kcb.service.blockchain.ITransactionDepositCryptoService;


@Controller
@RequestMapping(value = "/blockchain/transactionDepositCrypto/1.0", method = RequestMethod.POST)
public class TransactionDepositCryptoController extends ApiBaseController {

	@Autowired
	private ITransactionDepositCryptoService transactionDepositCryptoService;

	@PostMapping(value = "save")
	@ResponseBody
	public WebResout saveObj(@ModelAttribute TransactionDepositCrypto transactionDepositCrypto,HttpServletRequest request) throws BusinessException{
		
		logger.debug("TransactionDepositCryptoController exe saveObj param={}",transactionDepositCrypto);
		
		int i = transactionDepositCryptoService.insert(transactionDepositCrypto);
		if(i > 0) {
			return success(request);
		}
		return fail(request);
	}
	
	@GetMapping(value = "listAll")
	@ResponseBody
	public WebResout listAll(HttpServletRequest request) throws BusinessException{
		logger.debug("TransactionDepositCryptoController exe listAll ");
		List<TransactionDepositCrypto> list =  transactionDepositCryptoService.selectAll();
		logger.debug("TransactionDepositCryptoController exe listAll out={}",list);
		return success(request,list);
	}
	@GetMapping(value = "getById/{id}")
	@ResponseBody
	public WebResout getById(HttpServletRequest request,@PathVariable int id) throws BusinessException{
		
		logger.debug("TransactionDepositCryptoController exe getById?id={}",id);
		
		TransactionDepositCrypto transactionDepositCrypto = transactionDepositCryptoService.selectById(id);
		if(transactionDepositCrypto == null) {
			return fail(request, ConstantEnum._WEB_DTAT_IS_NULL.getVal(), ConstantEnum._WEB_DTAT_IS_NULL.getDesc());
		}
		logger.debug("TransactionDepositCryptoController exe getById out={} ",transactionDepositCrypto);
		return success(request,transactionDepositCrypto);
	}
	
	@DeleteMapping(value = "delete/{id}")
	@ResponseBody
	public WebResout delete(HttpServletRequest request,@PathVariable int id) throws BusinessException{
		logger.debug("TransactionDepositCryptoController exe delete?id={}",id);
		
		TransactionDepositCrypto transactionDepositCrypto = transactionDepositCryptoService.selectById(id);
		if(transactionDepositCrypto == null) {
			return fail(request, ConstantEnum._WEB_DTAT_IS_NULL.getVal(), ConstantEnum._WEB_DTAT_IS_NULL.getDesc());
		}
		transactionDepositCryptoService.deleteById(id);
		logger.debug("TransactionDepositCryptoController exe delete?id={}",id);
		
		return success(request);
	}
	
	@PutMapping(value = "update")
	@ResponseBody
	public WebResout update(HttpServletRequest request,@ModelAttribute TransactionDepositCrypto transactionDepositCrypto) throws BusinessException{
		
		logger.debug("TransactionDepositCryptoController exe update?baseAd={}",transactionDepositCrypto);
		
		int i = transactionDepositCryptoService.updateObj(transactionDepositCrypto);
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
	public WebResout list(HttpServletRequest request,Pager<TransactionDepositCrypto> pager, 
						@ModelAttribute TransactionDepositCryptoDTO transactionDepositCryptoDto) throws BusinessException{
		
		logger.debug("TransactionDepositCryptoController exe list?pager={}",pager);
		logger.debug("TransactionDepositCryptoController exe list?TransactionDepositCryptoDto={}",transactionDepositCryptoDto);
		
		pager.setParams(transactionDepositCryptoDto);
		transactionDepositCryptoService.selectTList(pager);
		
		logger.debug("TransactionDepositCryptoController exe list out={}",pager);
		
		return success(request,pager);
	}
}
