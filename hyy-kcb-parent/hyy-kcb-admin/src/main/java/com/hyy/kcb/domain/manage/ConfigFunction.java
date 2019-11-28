package com.hyy.kcb.domain.manage;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author WhiteLee
 * 功能描述:方法管理(un)管理
 */
@SuppressWarnings("serial")
public class ConfigFunction  implements java.io.Serializable {

	private Long id ; //
	private String function ; //功能
	private String interfacePath ; //接口路径
	private Long isOpen ; //是否开启 0关闭  1开启

	

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public String getFunction() {
		return function;
	}
	
	public void setFunction(String function) {
		this.function = function;
	}

	public String getInterfacePath() {
		return interfacePath;
	}
	
	public void setInterfacePath(String interfacePath) {
		this.interfacePath = interfacePath;
	}

	public Long getIsOpen() {
		return isOpen;
	}
	
	public void setIsOpen(Long isOpen) {
		this.isOpen = isOpen;
	}
}