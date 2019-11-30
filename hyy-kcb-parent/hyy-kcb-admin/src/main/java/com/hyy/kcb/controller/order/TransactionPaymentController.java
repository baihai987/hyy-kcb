package com.hyy.kcb.controller.order;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.hyy.kcb.commons.ConstantEnum;
import com.hyy.kcb.config.controller.ApiBaseController;
import com.hyy.kcb.commons.exception.BusinessException;
import com.hyy.kcb.commons.page.Pager;
import com.hyy.kcb.domain.order.TransactionPayment;
import com.hyy.kcb.domain.order.dto.TransactionPaymentDTO;
import com.hyy.kcb.out.WebResout;
import com.hyy.kcb.service.order.ITransactionPaymentService;


@Controller
@RequestMapping(value = "/order/transactionPayment/1.0", method = RequestMethod.POST)
public class TransactionPaymentController extends ApiBaseController{

	@Autowired
	private ITransactionPaymentService transactionPaymentService;

	@PostMapping(value = "save")
	@ResponseBody
	public WebResout saveObj(@ModelAttribute TransactionPayment transactionPayment,HttpServletRequest request) throws BusinessException{
		
		logger.debug("TransactionPaymentController exe saveObj param={}",transactionPayment);
		
		int i = transactionPaymentService.insert(transactionPayment);
		if(i > 0) {
			return success(request);
		}
		return fail(request);
	}
	
	@GetMapping(value = "listAll")
	@ResponseBody
	public WebResout listAll(HttpServletRequest request) throws BusinessException{
		logger.debug("TransactionPaymentController exe listAll ");
		List<TransactionPayment> list =  transactionPaymentService.selectAll();
		logger.debug("TransactionPaymentController exe listAll out={}",list);
		return success(request,list);
	}
	@GetMapping(value = "getById/{id}")
	@ResponseBody
	public WebResout getById(HttpServletRequest request,@PathVariable int id) throws BusinessException{
		
		logger.debug("TransactionPaymentController exe getById?id={}",id);
		
		TransactionPayment transactionPayment = transactionPaymentService.selectById(id);
		if(transactionPayment == null) {
			return fail(request, ConstantEnum._WEB_DTAT_IS_NULL.getVal(), ConstantEnum._WEB_DTAT_IS_NULL.getDesc());
		}
		logger.debug("TransactionPaymentController exe getById out={} ",transactionPayment);
		return success(request,transactionPayment);
	}
	
	@DeleteMapping(value = "delete/{id}")
	@ResponseBody
	public WebResout delete(HttpServletRequest request,@PathVariable int id) throws BusinessException{
		logger.debug("TransactionPaymentController exe delete?id={}",id);
		
		TransactionPayment transactionPayment = transactionPaymentService.selectById(id);
		if(transactionPayment == null) {
			return fail(request, ConstantEnum._WEB_DTAT_IS_NULL.getVal(), ConstantEnum._WEB_DTAT_IS_NULL.getDesc());
		}
		transactionPaymentService.deleteById(id);
		logger.debug("TransactionPaymentController exe delete?id={}",id);
		
		return success(request);
	}
	
	@PutMapping(value = "update")
	@ResponseBody
	public WebResout update(HttpServletRequest request,@ModelAttribute TransactionPayment transactionPayment) throws BusinessException{
		
		logger.debug("TransactionPaymentController exe update?baseAd={}",transactionPayment);
		
		int i = transactionPaymentService.updateObj(transactionPayment);
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
	public WebResout list(HttpServletRequest request,Pager<TransactionPayment> pager, 
						@ModelAttribute TransactionPaymentDTO transactionPaymentDto) throws BusinessException{
		
		logger.debug("TransactionPaymentController exe list?pager={}",pager);
		logger.debug("TransactionPaymentController exe list?TransactionPaymentDto={}",transactionPaymentDto);
		
		pager.setParams(transactionPaymentDto);
		transactionPaymentService.selectTList(pager);
		
		logger.debug("TransactionPaymentController exe list out={}",pager);
		
		return success(request,pager);
	}

	//转入转出
	@PostMapping("/findOutAndIn")
	@ResponseBody
//	@RequiresPermissions("static:findOutAndIn")
	public WebResout findOutAndIn(HttpServletRequest request,
										  @RequestParam Map<String,Object> map) throws BusinessException {
		Map hashMap= transactionPaymentService.findOutAndIn(map);
		if(hashMap.get("totalCount").equals(0)){
			return fail(request,"无查询结果");
		}
		return success(request,hashMap);
	}
}
