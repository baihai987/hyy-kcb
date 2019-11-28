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
import com.hyy.kcb.domain.order.TotalTransactionFlow;
import com.hyy.kcb.domain.order.dto.TotalTransactionFlowDTO;
import com.hyy.kcb.out.WebResout;
import com.hyy.kcb.service.order.ITotalTransactionFlowService;


@Controller
@RequestMapping(value = "/order/totalTransactionFlow/1.0", method = RequestMethod.POST)
public class TotalTransactionFlowController extends ApiBaseController{

	@Autowired
	private ITotalTransactionFlowService totalTransactionFlowService;

	@PostMapping(value = "save")
	@ResponseBody
	public WebResout saveObj(@ModelAttribute TotalTransactionFlow totalTransactionFlow,HttpServletRequest request) throws BusinessException{
		
		logger.debug("TotalTransactionFlowController exe saveObj param={}",totalTransactionFlow);
		
		int i = totalTransactionFlowService.insert(totalTransactionFlow);
		if(i > 0) {
			return success(request);
		}
		return fail(request);
	}
	
	@GetMapping(value = "listAll")
	@ResponseBody
	public WebResout listAll(HttpServletRequest request) throws BusinessException{
		logger.debug("TotalTransactionFlowController exe listAll ");
		List<TotalTransactionFlow> list =  totalTransactionFlowService.selectAll();
		logger.debug("TotalTransactionFlowController exe listAll out={}",list);
		return success(request,list);
	}
	@GetMapping(value = "getById/{id}")
	@ResponseBody
	public WebResout getById(HttpServletRequest request,@PathVariable int id) throws BusinessException{
		
		logger.debug("TotalTransactionFlowController exe getById?id={}",id);
		
		TotalTransactionFlow totalTransactionFlow = totalTransactionFlowService.selectById(id);
		if(totalTransactionFlow == null) {
			return fail(request, ConstantEnum._WEB_DTAT_IS_NULL.getVal(), ConstantEnum._WEB_DTAT_IS_NULL.getDesc());
		}
		logger.debug("TotalTransactionFlowController exe getById out={} ",totalTransactionFlow);
		return success(request,totalTransactionFlow);
	}
	
	@DeleteMapping(value = "delete/{id}")
	@ResponseBody
	public WebResout delete(HttpServletRequest request,@PathVariable int id) throws BusinessException{
		logger.debug("TotalTransactionFlowController exe delete?id={}",id);
		
		TotalTransactionFlow totalTransactionFlow = totalTransactionFlowService.selectById(id);
		if(totalTransactionFlow == null) {
			return fail(request, ConstantEnum._WEB_DTAT_IS_NULL.getVal(), ConstantEnum._WEB_DTAT_IS_NULL.getDesc());
		}
		totalTransactionFlowService.deleteById(id);
		logger.debug("TotalTransactionFlowController exe delete?id={}",id);
		
		return success(request);
	}
	
	@PutMapping(value = "update")
	@ResponseBody
	public WebResout update(HttpServletRequest request,@ModelAttribute TotalTransactionFlow totalTransactionFlow) throws BusinessException{
		
		logger.debug("TotalTransactionFlowController exe update?baseAd={}",totalTransactionFlow);
		
		int i = totalTransactionFlowService.updateObj(totalTransactionFlow);
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
	public WebResout list(HttpServletRequest request,Pager<TotalTransactionFlow> pager, 
						@ModelAttribute TotalTransactionFlowDTO totalTransactionFlowDto) throws BusinessException{
		
		logger.debug("TotalTransactionFlowController exe list?pager={}",pager);
		logger.debug("TotalTransactionFlowController exe list?TotalTransactionFlowDto={}",totalTransactionFlowDto);
		
		pager.setParams(totalTransactionFlowDto);
		totalTransactionFlowService.selectTList(pager);
		
		logger.debug("TotalTransactionFlowController exe list out={}",pager);
		
		return success(request,pager);
	}
}
