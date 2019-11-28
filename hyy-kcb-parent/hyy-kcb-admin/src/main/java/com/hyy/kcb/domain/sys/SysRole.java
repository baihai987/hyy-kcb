package com.hyy.kcb.domain.sys;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author WhiteLee
 * 功能描述:权限管理-角色管理
 */
@SuppressWarnings("serial")
public class SysRole  implements java.io.Serializable {

	private Long id ; //
	private String role ; //角色名称
	private String description ; //角色描述
	private String available ; //是否可用 1可用  0不可用

	

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}
	
	public void setRole(String role) {
		this.role = role;
	}

	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

	public String getAvailable() {
		return available;
	}
	
	public void setAvailable(String available) {
		this.available = available;
	}
}