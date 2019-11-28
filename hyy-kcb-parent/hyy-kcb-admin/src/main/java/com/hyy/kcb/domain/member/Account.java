package com.hyy.kcb.domain.member;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.math.BigDecimal;

/**
 * @author WhiteLee
 * 功能描述:用户基础数据管理
 */
@SuppressWarnings("serial")
public class Account  implements java.io.Serializable {

	private Long id ; //主键
	private Long uid ; //UID，10000以内保留，作为公司账户
	private Long type ; //账户类型 1:充值卡 2:GMCC
	private BigDecimal balance ; //余额
	private String tag ; //标签，冗余，只帮助直观反馈
	private String ctime ; //创建时间
	private String mtime ; //修改时间

	

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public Long getUid() {
		return uid;
	}
	
	public void setUid(Long uid) {
		this.uid = uid;
	}

	public Long getType() {
		return type;
	}
	
	public void setType(Long type) {
		this.type = type;
	}

	public BigDecimal getBalance() {
		return balance;
	}
	
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public String getTag() {
		return tag;
	}
	
	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getCtime() {
		return ctime;
	}
	
	public void setCtime(String ctime) {
		this.ctime = ctime;
	}

	public String getMtime() {
		return mtime;
	}
	
	public void setMtime(String mtime) {
		this.mtime = mtime;
	}

}