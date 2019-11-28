package com.hyy.kcb.domain.sys;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author WhiteLee
 * 功能描述:权限管理-用户管理
 */
@SuppressWarnings("serial")
public class SysUser  implements java.io.Serializable {

	private Long id ; //
	private String userName ; //用户名
	private String name ; //真实姓名／昵称
	private String password ; //密码
	private String salt ; //加密密码的盐
	private String state ; //1可用 0删除
 	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") 
	private Date createDate ; //创建时间
	private Long createUser ; //创建人
	private Long updateUser ; //更新用户id
 	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") 
	private Date updateDate ; //最后一次更新时间
	private Long isDel ; //是否删除 0是 1否

	

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}
	
	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getState() {
		return state;
	}
	
	public void setState(String state) {
		this.state = state;
	}

	public Date getCreateDate() {
		return createDate;
	}
	
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Long getCreateUser() {
		return createUser;
	}
	
	public void setCreateUser(Long createUser) {
		this.createUser = createUser;
	}

	public Long getUpdateUser() {
		return updateUser;
	}
	
	public void setUpdateUser(Long updateUser) {
		this.updateUser = updateUser;
	}

	public Date getUpdateDate() {
		return updateDate;
	}
	
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Long getIsDel() {
		return isDel;
	}
	
	public void setIsDel(Long isDel) {
		this.isDel = isDel;
	}

	public String getCredentialsSalt() {
		return userName + salt;
	}
}