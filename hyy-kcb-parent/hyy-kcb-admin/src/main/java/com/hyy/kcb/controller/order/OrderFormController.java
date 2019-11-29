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
import com.hyy.kcb.domain.order.OrderForm;
import com.hyy.kcb.domain.order.dto.OrderFormDTO;
import com.hyy.kcb.out.WebResout;
import com.hyy.kcb.service.order.IOrderFormService;


@Controller
@RequestMapping(value = "/order/orderForm/1.0", method = RequestMethod.POST)
public class OrderFormController extends ApiBaseController{

	@Autowired
	private IOrderFormService orderFormService;

	@PostMapping(value = "save")
	@ResponseBody
	public WebResout saveObj(@ModelAttribute OrderForm orderForm,HttpServletRequest request) throws BusinessException{
		
		logger.debug("OrderFormController exe saveObj param={}",orderForm);
		
		int i = orderFormService.insert(orderForm);
		if(i > 0) {
			return success(request);
		}
		return fail(request);
	}
	
	@GetMapping(value = "listAll")
	@ResponseBody
	public WebResout listAll(HttpServletRequest request) throws BusinessException{
		logger.debug("OrderFormController exe listAll ");
		List<OrderForm> list =  orderFormService.selectAll();
		logger.debug("OrderFormController exe listAll out={}",list);
		return success(request,list);
	}
	@GetMapping(value = "getById/{id}")
	@ResponseBody
	public WebResout getById(HttpServletRequest request,@PathVariable int id) throws BusinessException{
		
		logger.debug("OrderFormController exe getById?id={}",id);
		
		OrderForm orderForm = orderFormService.selectById(id);
		if(orderForm == null) {
			return fail(request, ConstantEnum._WEB_DTAT_IS_NULL.getVal(), ConstantEnum._WEB_DTAT_IS_NULL.getDesc());
		}
		logger.debug("OrderFormController exe getById out={} ",orderForm);
		return success(request,orderForm);
	}
	
	@DeleteMapping(value = "delete/{id}")
	@ResponseBody
	public WebResout delete(HttpServletRequest request,@PathVariable int id) throws BusinessException{
		logger.debug("OrderFormController exe delete?id={}",id);
		
		OrderForm orderForm = orderFormService.selectById(id);
		if(orderForm == null) {
			return fail(request, ConstantEnum._WEB_DTAT_IS_NULL.getVal(), ConstantEnum._WEB_DTAT_IS_NULL.getDesc());
		}
		orderFormService.deleteById(id);
		logger.debug("OrderFormController exe delete?id={}",id);
		
		return success(request);
	}
	
	@PutMapping(value = "update")
	@ResponseBody
	public WebResout update(HttpServletRequest request,@ModelAttribute OrderForm orderForm) throws BusinessException{
		
		logger.debug("OrderFormController exe update?baseAd={}",orderForm);
		
		int i = orderFormService.updateObj(orderForm);
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
	public WebResout list(HttpServletRequest request,Pager<OrderForm> pager, 
						@ModelAttribute OrderFormDTO orderFormDto) throws BusinessException{
		
		logger.debug("OrderFormController exe list?pager={}",pager);
		logger.debug("OrderFormController exe list?OrderFormDto={}",orderFormDto);
		
		pager.setParams(orderFormDto);
		orderFormService.selectTList(pager);
		
		logger.debug("OrderFormController exe list out={}",pager);
		
		return success(request,pager);
	}

	@PostMapping("/findOrderByCondition")
	@ResponseBody
	public WebResout findOrderByCondition(HttpServletRequest request,Pager<OrderForm> pager,
										  @ModelAttribute OrderFormDTO orderFormDto)throws BusinessException{
		pager.setParams(orderFormDto);
		orderFormService.selectTList(pager);
		return success(request,pager);
	}
}
