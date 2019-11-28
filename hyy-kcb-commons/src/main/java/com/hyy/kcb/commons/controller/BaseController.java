package com.hyy.kcb.commons.controller;

import com.hyy.kcb.commons.ConstantEnum;
import com.hyy.kcb.commons.base.BaseObject;
import com.hyy.kcb.out.WebResout;

import javax.servlet.http.HttpServletRequest;

public class BaseController extends BaseObject{
	public BaseController() {
	}

	/**获取真实IP */
	  public String getIpAddress(HttpServletRequest request) { 
	    String ip = request.getHeader("x-forwarded-for"); 
	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
	      ip = request.getHeader("Proxy-Client-IP"); 
	    } 
	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
	      ip = request.getHeader("WL-Proxy-Client-IP"); 
	    } 
	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
	      ip = request.getHeader("HTTP_CLIENT_IP"); 
	    } 
	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
	      ip = request.getHeader("HTTP_X_FORWARDED_FOR"); 
	    } 
	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
	      ip = request.getRemoteAddr(); 
	    } 
	    return ip; 
	  } 
	  
	  public WebResout success(HttpServletRequest request) {
		  WebResout out = new WebResout(request);
		  out.setCode(ConstantEnum._SUCCESS.getVal());
		  out.setDesc(ConstantEnum._SUCCESS.getDesc());
		  return out;
	  }
	  public WebResout success(HttpServletRequest request,Object data) {
		  WebResout out = new WebResout(request);
		  out.setCode(ConstantEnum._SUCCESS.getVal());
		  out.setDesc(ConstantEnum._SUCCESS.getDesc());
		  out.setData(data);
		  return out;
	  }
	  public WebResout success(HttpServletRequest request,String token) {
		  WebResout out = new WebResout(request,token);
		  out.setCode(ConstantEnum._SUCCESS.getVal());
		  out.setDesc(ConstantEnum._SUCCESS.getDesc());
		  return out;
	  }
	  public WebResout success(HttpServletRequest request,String token,Object data) {
		  WebResout out = new WebResout(request,token);
		  out.setCode(ConstantEnum._SUCCESS.getVal());
		  out.setDesc(ConstantEnum._SUCCESS.getDesc());
		  out.setData(data);
		  return out;
	  }
	  
	  public WebResout fail(HttpServletRequest request) {
		  WebResout out = new WebResout(request);
		  out.setCode(ConstantEnum._FAIL.getVal());
		  out.setDesc(ConstantEnum._FAIL.getDesc());
		  return out;
	  }
  
    public WebResout fail(HttpServletRequest request,String data) {
        WebResout out = new WebResout(request);
        out.setCode(ConstantEnum._FAIL.getVal());
        out.setDesc(data);
        return out;
    }
    
    public WebResout fail_force_ident(HttpServletRequest request,int code,String desc) {
        WebResout out = new WebResout(request);
        out.setCode(code);
        out.setDesc(desc);
        return out;
    }

	  public WebResout fail_exp(int code,String msg) {
		  WebResout out = new WebResout();
		  out.setCode(code);
		  out.setDesc(msg);
		  return out;
	  }
	  public WebResout fail_WithQrCode(int code,String msg){
          WebResout out = new WebResout();
          out.setCode(code);
          out.setDesc(msg);
          return out;
      }
	  
	  public WebResout fail_exp() {
		  WebResout out = new WebResout();
		  out.setCode(ConstantEnum.WEB_SER_controller_exp.getVal());
		  out.setDesc(ConstantEnum.WEB_SER_controller_exp.getDesc());
		  return out;
	  }
	  
	  public WebResout fail_exp_auth() {
		  WebResout out = new WebResout();
		  out.setCode(ConstantEnum.WEB_SER_controller_exp.getVal());
		  out.setDesc(ConstantEnum.WEB_SER_controller_exp.getDesc());
		  return out;
	  }
	  
	  public WebResout fail(HttpServletRequest request,int code,String desc) {
		  WebResout out = new WebResout(request);
		  out.setCode(code);
		  out.setDesc(desc);
		  return out;
	  }
	  
	  public WebResout fail(HttpServletRequest request,String token,int code,String desc) {
		  WebResout out = new WebResout(request,token);
		  out.setCode(code);
		  out.setDesc(desc);
		  return out;
	  }


	  
}
