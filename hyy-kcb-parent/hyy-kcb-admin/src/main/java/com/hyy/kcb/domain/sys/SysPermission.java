package com.hyy.kcb.domain.sys;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author WhiteLee
 * 功能描述:权限管理-资源管理
 */
@SuppressWarnings("serial")
public class SysPermission  implements java.io.Serializable {

	private Long id ; //
	private String name ; //名称
	private String resourceType ; //资源类型，[menu|button]
	private String url ; //资源路径
	private String permission ; //权限字符串,menu例子：role:*，button例
	private Long parentId ; //父编号
	private String parentIds ; //父编号列表
	private String available ; //是否可用  1可用  0不可用

	

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getResourceType() {
		return resourceType;
	}
	
	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
	}

	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}

	public String getPermission() {
		return permission;
	}
	
	public void setPermission(String permission) {
		this.permission = permission;
	}

	public Long getParentId() {
		return parentId;
	}
	
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public String getParentIds() {
		return parentIds;
	}
	
	public void setParentIds(String parentIds) {
		this.parentIds = parentIds;
	}

	public String getAvailable() {
		return available;
	}
	
	public void setAvailable(String available) {
		this.available = available;
	}
}