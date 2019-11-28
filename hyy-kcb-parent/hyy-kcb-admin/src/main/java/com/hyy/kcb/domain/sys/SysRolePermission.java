package com.hyy.kcb.domain.sys;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author WhiteLee
 * 功能描述:权限管理-角色-资源管理
 */
@SuppressWarnings("serial")
public class SysRolePermission  implements java.io.Serializable {

	private Long id ; //
	private Long sysRoleId ; //角色id
	private Long sysPermissionId ; //资源id

	

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public Long getSysRoleId() {
		return sysRoleId;
	}
	
	public void setSysRoleId(Long sysRoleId) {
		this.sysRoleId = sysRoleId;
	}

	public Long getSysPermissionId() {
		return sysPermissionId;
	}
	
	public void setSysPermissionId(Long sysPermissionId) {
		this.sysPermissionId = sysPermissionId;
	}
}