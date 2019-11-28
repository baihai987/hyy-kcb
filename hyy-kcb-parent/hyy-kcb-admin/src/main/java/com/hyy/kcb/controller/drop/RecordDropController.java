package com.hyy.kcb.controller.drop;

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
import com.hyy.kcb.domain.drop.RecordDrop;
import com.hyy.kcb.domain.drop.dto.RecordDropDTO;
import com.hyy.kcb.out.WebResout;
import com.hyy.kcb.service.drop.IRecordDropService;


@Controller
@RequestMapping(value = "/drop/recordDrop/1.0", method = RequestMethod.POST)
public class RecordDropController extends ApiBaseController{

	@Autowired
	private IRecordDropService recordDropService;

	@PostMapping(value = "save")
	@ResponseBody
	public WebResout saveObj(@ModelAttribute RecordDrop recordDrop,HttpServletRequest request) throws BusinessException{
		
		logger.debug("RecordDropController exe saveObj param={}",recordDrop);
		
		int i = recordDropService.insert(recordDrop);
		if(i > 0) {
			return success(request);
		}
		return fail(request);
	}
	
	@GetMapping(value = "listAll")
	@ResponseBody
	public WebResout listAll(HttpServletRequest request) throws BusinessException{
		logger.debug("RecordDropController exe listAll ");
		List<RecordDrop> list =  recordDropService.selectAll();
		logger.debug("RecordDropController exe listAll out={}",list);
		return success(request,list);
	}
	@GetMapping(value = "getById/{id}")
	@ResponseBody
	public WebResout getById(HttpServletRequest request,@PathVariable int id) throws BusinessException{
		
		logger.debug("RecordDropController exe getById?id={}",id);
		
		RecordDrop recordDrop = recordDropService.selectById(id);
		if(recordDrop == null) {
			return fail(request, ConstantEnum._WEB_DTAT_IS_NULL.getVal(), ConstantEnum._WEB_DTAT_IS_NULL.getDesc());
		}
		logger.debug("RecordDropController exe getById out={} ",recordDrop);
		return success(request,recordDrop);
	}
	
	@DeleteMapping(value = "delete/{id}")
	@ResponseBody
	public WebResout delete(HttpServletRequest request,@PathVariable int id) throws BusinessException{
		logger.debug("RecordDropController exe delete?id={}",id);
		
		RecordDrop recordDrop = recordDropService.selectById(id);
		if(recordDrop == null) {
			return fail(request, ConstantEnum._WEB_DTAT_IS_NULL.getVal(), ConstantEnum._WEB_DTAT_IS_NULL.getDesc());
		}
		recordDropService.deleteById(id);
		logger.debug("RecordDropController exe delete?id={}",id);
		
		return success(request);
	}
	
	@PutMapping(value = "update")
	@ResponseBody
	public WebResout update(HttpServletRequest request,@ModelAttribute RecordDrop recordDrop) throws BusinessException{
		
		logger.debug("RecordDropController exe update?baseAd={}",recordDrop);
		
		int i = recordDropService.updateObj(recordDrop);
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
	public WebResout list(HttpServletRequest request,Pager<RecordDrop> pager, 
						@ModelAttribute RecordDropDTO recordDropDto) throws BusinessException{
		
		logger.debug("RecordDropController exe list?pager={}",pager);
		logger.debug("RecordDropController exe list?RecordDropDto={}",recordDropDto);
		
		pager.setParams(recordDropDto);
		recordDropService.selectTList(pager);
		
		logger.debug("RecordDropController exe list out={}",pager);
		
		return success(request,pager);
	}
}
