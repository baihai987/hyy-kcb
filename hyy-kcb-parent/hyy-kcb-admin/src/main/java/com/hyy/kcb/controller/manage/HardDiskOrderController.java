package com.hyy.kcb.controller.manage;

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
import com.hyy.kcb.domain.manage.HardDiskOrder;
import com.hyy.kcb.domain.manage.dto.HardDiskOrderDTO;
import com.hyy.kcb.out.WebResout;
import com.hyy.kcb.service.manage.IHardDiskOrderService;


@Controller
@RequestMapping(value = "/manage/hardDiskOrder/1.0", method = RequestMethod.POST)
public class HardDiskOrderController extends ApiBaseController{

	@Autowired
	private IHardDiskOrderService hardDiskOrderService;

	@PostMapping(value = "save")
	@ResponseBody
	public WebResout saveObj(@ModelAttribute HardDiskOrder hardDiskOrder,HttpServletRequest request) throws BusinessException{
		
		logger.debug("HardDiskOrderController exe saveObj param={}",hardDiskOrder);
		
		int i = hardDiskOrderService.insert(hardDiskOrder);
		if(i > 0) {
			return success(request);
		}
		return fail(request);
	}
	
	@GetMapping(value = "listAll")
	@ResponseBody
	public WebResout listAll(HttpServletRequest request) throws BusinessException{
		logger.debug("HardDiskOrderController exe listAll ");
		List<HardDiskOrder> list =  hardDiskOrderService.selectAll();
		logger.debug("HardDiskOrderController exe listAll out={}",list);
		return success(request,list);
	}
	@GetMapping(value = "getById/{id}")
	@ResponseBody
	public WebResout getById(HttpServletRequest request,@PathVariable int id) throws BusinessException{
		
		logger.debug("HardDiskOrderController exe getById?id={}",id);
		
		HardDiskOrder hardDiskOrder = hardDiskOrderService.selectById(id);
		if(hardDiskOrder == null) {
			return fail(request, ConstantEnum._WEB_DTAT_IS_NULL.getVal(), ConstantEnum._WEB_DTAT_IS_NULL.getDesc());
		}
		logger.debug("HardDiskOrderController exe getById out={} ",hardDiskOrder);
		return success(request,hardDiskOrder);
	}
	
	@DeleteMapping(value = "delete/{id}")
	@ResponseBody
	public WebResout delete(HttpServletRequest request,@PathVariable int id) throws BusinessException{
		logger.debug("HardDiskOrderController exe delete?id={}",id);
		
		HardDiskOrder hardDiskOrder = hardDiskOrderService.selectById(id);
		if(hardDiskOrder == null) {
			return fail(request, ConstantEnum._WEB_DTAT_IS_NULL.getVal(), ConstantEnum._WEB_DTAT_IS_NULL.getDesc());
		}
		hardDiskOrderService.deleteById(id);
		logger.debug("HardDiskOrderController exe delete?id={}",id);
		
		return success(request);
	}
	
	@PutMapping(value = "update")
	@ResponseBody
	public WebResout update(HttpServletRequest request,@ModelAttribute HardDiskOrder hardDiskOrder) throws BusinessException{
		
		logger.debug("HardDiskOrderController exe update?baseAd={}",hardDiskOrder);
		
		int i = hardDiskOrderService.updateObj(hardDiskOrder);
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
	public WebResout list(HttpServletRequest request,Pager<HardDiskOrder> pager, 
						@ModelAttribute HardDiskOrderDTO hardDiskOrderDto) throws BusinessException{
		
		logger.debug("HardDiskOrderController exe list?pager={}",pager);
		logger.debug("HardDiskOrderController exe list?HardDiskOrderDto={}",hardDiskOrderDto);
		
		pager.setParams(hardDiskOrderDto);
		hardDiskOrderService.selectTList(pager);
		
		logger.debug("HardDiskOrderController exe list out={}",pager);
		
		return success(request,pager);
	}
}
