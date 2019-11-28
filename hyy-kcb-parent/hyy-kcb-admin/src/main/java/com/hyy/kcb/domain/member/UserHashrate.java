package com.hyy.kcb.domain.member;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.math.BigDecimal;

/**
 * @author WhiteLee
 * 功能描述:用户算力管理
 */
@SuppressWarnings("serial")
public class UserHashrate  implements java.io.Serializable {

	private Long uid ; //用户id
	private BigDecimal uHashrate ; //算力
	private String openId ; //openId
	private String nickname ; //用户昵称
	private String mobileNumber ; //手机号
	private String countryCode ; //手机号对应的国家编码
	private String email ; //邮箱
	private String origin ; //用户来源
	private String role ; //用户在经济人中的角色
	private String parentMobileNumber ; //邀请人手机号
	private String parentCountryCode ; //邀请人手机号对应的国家编码
	private String parentEmail ; //邀请人邮箱
	private BigDecimal freezeUHashrate ; //

	

	public Long getUid() {
		return uid;
	}
	
	public void setUid(Long uid) {
		this.uid = uid;
	}

	public BigDecimal getUHashrate() {
		return uHashrate;
	}
	
	public void setUHashrate(BigDecimal uHashrate) {
		this.uHashrate = uHashrate;
	}

	public String getOpenId() {
		return openId;
	}
	
	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public String getNickname() {
		return nickname;
	}
	
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}
	
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getCountryCode() {
		return countryCode;
	}
	
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public String getOrigin() {
		return origin;
	}
	
	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getRole() {
		return role;
	}
	
	public void setRole(String role) {
		this.role = role;
	}

	public String getParentMobileNumber() {
		return parentMobileNumber;
	}
	
	public void setParentMobileNumber(String parentMobileNumber) {
		this.parentMobileNumber = parentMobileNumber;
	}

	public String getParentCountryCode() {
		return parentCountryCode;
	}
	
	public void setParentCountryCode(String parentCountryCode) {
		this.parentCountryCode = parentCountryCode;
	}

	public String getParentEmail() {
		return parentEmail;
	}
	
	public void setParentEmail(String parentEmail) {
		this.parentEmail = parentEmail;
	}

	public BigDecimal getFreezeUHashrate() {
		return freezeUHashrate;
	}
	
	public void setFreezeUHashrate(BigDecimal freezeUHashrate) {
		this.freezeUHashrate = freezeUHashrate;
	}
}