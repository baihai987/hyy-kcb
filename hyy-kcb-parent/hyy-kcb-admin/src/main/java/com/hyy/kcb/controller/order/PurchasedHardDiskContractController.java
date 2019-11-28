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
import com.hyy.kcb.domain.order.PurchasedHardDiskContract;
import com.hyy.kcb.domain.order.dto.PurchasedHardDiskContractDTO;
import com.hyy.kcb.out.WebResout;
import com.hyy.kcb.service.order.IPurchasedHardDiskContractService;


@Controller
@RequestMapping(value = "/order/purchasedHardDiskContract/1.0", method = RequestMethod.POST)
public class PurchasedHardDiskContractController extends ApiBaseController{

	@Autowired
	private IPurchasedHardDiskContractService purchasedHardDiskContractService;

	@PostMapping(value = "save")
	@ResponseBody
	public WebResout saveObj(@ModelAttribute PurchasedHardDiskContract purchasedHardDiskContract,HttpServletRequest request) throws BusinessException{
		
		logger.debug("PurchasedHardDiskContractController exe saveObj param={}",purchasedHardDiskContract);
		
		int i = purchasedHardDiskContractService.insert(purchasedHardDiskContract);
		if(i > 0) {
			return success(request);
		}
		return fail(request);
	}
	
	@GetMapping(value = "listAll")
	@ResponseBody
	public WebResout listAll(HttpServletRequest request) throws BusinessException{
		logger.debug("PurchasedHardDiskContractController exe listAll ");
		List<PurchasedHardDiskContract> list =  purchasedHardDiskContractService.selectAll();
		logger.debug("PurchasedHardDiskContractController exe listAll out={}",list);
		return success(request,list);
	}
	@GetMapping(value = "getById/{id}")
	@ResponseBody
	public WebResout getById(HttpServletRequest request,@PathVariable int id) throws BusinessException{
		
		logger.debug("PurchasedHardDiskContractController exe getById?id={}",id);
		
		PurchasedHardDiskContract purchasedHardDiskContract = purchasedHardDiskContractService.selectById(id);
		if(purchasedHardDiskContract == null) {
			return fail(request, ConstantEnum._WEB_DTAT_IS_NULL.getVal(), ConstantEnum._WEB_DTAT_IS_NULL.getDesc());
		}
		logger.debug("PurchasedHardDiskContractController exe getById out={} ",purchasedHardDiskContract);
		return success(request,purchasedHardDiskContract);
	}
	
	@DeleteMapping(value = "delete/{id}")
	@ResponseBody
	public WebResout delete(HttpServletRequest request,@PathVariable int id) throws BusinessException{
		logger.debug("PurchasedHardDiskContractController exe delete?id={}",id);
		
		PurchasedHardDiskContract purchasedHardDiskContract = purchasedHardDiskContractService.selectById(id);
		if(purchasedHardDiskContract == null) {
			return fail(request, ConstantEnum._WEB_DTAT_IS_NULL.getVal(), ConstantEnum._WEB_DTAT_IS_NULL.getDesc());
		}
		purchasedHardDiskContractService.deleteById(id);
		logger.debug("PurchasedHardDiskContractController exe delete?id={}",id);
		
		return success(request);
	}
	
	@PutMapping(value = "update")
	@ResponseBody
	public WebResout update(HttpServletRequest request,@ModelAttribute PurchasedHardDiskContract purchasedHardDiskContract) throws BusinessException{
		
		logger.debug("PurchasedHardDiskContractController exe update?baseAd={}",purchasedHardDiskContract);
		
		int i = purchasedHardDiskContractService.updateObj(purchasedHardDiskContract);
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
	public WebResout list(HttpServletRequest request,Pager<PurchasedHardDiskContract> pager, 
						@ModelAttribute PurchasedHardDiskContractDTO purchasedHardDiskContractDto) throws BusinessException{
		
		logger.debug("PurchasedHardDiskContractController exe list?pager={}",pager);
		logger.debug("PurchasedHardDiskContractController exe list?PurchasedHardDiskContractDto={}",purchasedHardDiskContractDto);
		
		pager.setParams(purchasedHardDiskContractDto);
		purchasedHardDiskContractService.selectTList(pager);
		
		logger.debug("PurchasedHardDiskContractController exe list out={}",pager);
		
		return success(request,pager);
	}
}
