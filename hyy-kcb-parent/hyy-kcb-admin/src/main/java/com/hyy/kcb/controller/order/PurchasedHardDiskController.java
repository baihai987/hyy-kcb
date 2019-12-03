package com.hyy.kcb.controller.order;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.hyy.kcb.commons.ConstantEnum;
import com.hyy.kcb.config.controller.ApiBaseController;
import com.hyy.kcb.commons.exception.BusinessException;
import com.hyy.kcb.commons.page.Pager;
import com.hyy.kcb.domain.order.PurchasedHardDisk;
import com.hyy.kcb.domain.order.dto.PurchasedHardDiskDTO;
import com.hyy.kcb.out.WebResout;
import com.hyy.kcb.service.order.IPurchasedHardDiskService;


@Controller
@RequestMapping(value = "/order/purchasedHardDisk/1.0", method = RequestMethod.POST)
public class PurchasedHardDiskController extends ApiBaseController{

	@Autowired
	private IPurchasedHardDiskService purchasedHardDiskService;

	@PostMapping(value = "save")
	@ResponseBody
	public WebResout saveObj(@ModelAttribute PurchasedHardDisk purchasedHardDisk,HttpServletRequest request) throws BusinessException{
		
		logger.debug("PurchasedHardDiskController exe saveObj param={}",purchasedHardDisk);
		
		int i = purchasedHardDiskService.insert(purchasedHardDisk);
		if(i > 0) {
			return success(request);
		}
		return fail(request);
	}
	
	@GetMapping(value = "listAll")
	@ResponseBody
	public WebResout listAll(HttpServletRequest request) throws BusinessException{
		logger.debug("PurchasedHardDiskController exe listAll ");
		List<PurchasedHardDisk> list =  purchasedHardDiskService.selectAll();
		logger.debug("PurchasedHardDiskController exe listAll out={}",list);
		return success(request,list);
	}
	@GetMapping(value = "getById/{id}")
	@ResponseBody
	public WebResout getById(HttpServletRequest request,@PathVariable int id) throws BusinessException{
		
		logger.debug("PurchasedHardDiskController exe getById?id={}",id);
		
		PurchasedHardDisk purchasedHardDisk = purchasedHardDiskService.selectById(id);
		if(purchasedHardDisk == null) {
			return fail(request, ConstantEnum._WEB_DTAT_IS_NULL.getVal(), ConstantEnum._WEB_DTAT_IS_NULL.getDesc());
		}
		logger.debug("PurchasedHardDiskController exe getById out={} ",purchasedHardDisk);
		return success(request,purchasedHardDisk);
	}
	
	@DeleteMapping(value = "delete/{id}")
	@ResponseBody
	public WebResout delete(HttpServletRequest request,@PathVariable int id) throws BusinessException{
		logger.debug("PurchasedHardDiskController exe delete?id={}",id);
		
		PurchasedHardDisk purchasedHardDisk = purchasedHardDiskService.selectById(id);
		if(purchasedHardDisk == null) {
			return fail(request, ConstantEnum._WEB_DTAT_IS_NULL.getVal(), ConstantEnum._WEB_DTAT_IS_NULL.getDesc());
		}
		purchasedHardDiskService.deleteById(id);
		logger.debug("PurchasedHardDiskController exe delete?id={}",id);
		
		return success(request);
	}
	
	@PutMapping(value = "update")
	@ResponseBody
	public WebResout update(HttpServletRequest request,@ModelAttribute PurchasedHardDisk purchasedHardDisk) throws BusinessException{
		
		logger.debug("PurchasedHardDiskController exe update?baseAd={}",purchasedHardDisk);
		
		int i = purchasedHardDiskService.updateObj(purchasedHardDisk);
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
	public WebResout list(HttpServletRequest request,Pager<PurchasedHardDisk> pager, 
						@ModelAttribute PurchasedHardDiskDTO purchasedHardDiskDto) throws BusinessException{
		
		logger.debug("PurchasedHardDiskController exe list?pager={}",pager);
		logger.debug("PurchasedHardDiskController exe list?PurchasedHardDiskDto={}",purchasedHardDiskDto);
		
		pager.setParams(purchasedHardDiskDto);
		purchasedHardDiskService.selectTList(pager);
		
		logger.debug("PurchasedHardDiskController exe list out={}",pager);
		
		return success(request,pager);
	}

	@PostMapping("/findHardDiskCondition")
	@ResponseBody
//    @RequiresPermissions("static:findHardDiskCondition")
	public WebResout findOrderByCondition(HttpServletRequest request,
										  @RequestParam Map<String,Object> map) throws BusinessException {
		Map hashMap= purchasedHardDiskService.findHardDiskCondition(map);
		if(hashMap.get("totalCount").equals(0)){
			return fail(request,"无查询结果");
		}
		return success(request,hashMap);
	}
}
