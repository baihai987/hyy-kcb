package com.hyy.kcb.domain.sys;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author WhiteLee
 * 功能描述:权限管理-用户-角色管理
 */
@SuppressWarnings("serial")
public class SysUserRole  implements java.io.Serializable {

	private Long id ; //
	private Long sysUserId ; //用户id
	private Long sysRoleId ; //角色id

	

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public Long getSysUserId() {
		return sysUserId;
	}
	
	public void setSysUserId(Long sysUserId) {
		this.sysUserId = sysUserId;
	}

	public Long getSysRoleId() {
		return sysRoleId;
	}
	
	public void setSysRoleId(Long sysRoleId) {
		this.sysRoleId = sysRoleId;
	}
}