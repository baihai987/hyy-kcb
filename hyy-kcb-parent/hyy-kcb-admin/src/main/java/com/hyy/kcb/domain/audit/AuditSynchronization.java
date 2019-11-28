package com.hyy.kcb.domain.audit;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.math.BigDecimal;

/**
 * @author WhiteLee
 * 功能描述:审核同步管理
 */
@SuppressWarnings("serial")
public class AuditSynchronization  implements java.io.Serializable {

	private Long id ; //主键
	private Long uid ; //用户id
	private BigDecimal amount ; //数额
	private String cTime ; //时间
	private Long status ; //1、未审核 2、审核成功 3、审核失败

	

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

	public BigDecimal getAmount() {
		return amount;
	}
	
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getCTime() {
		return cTime;
	}
	
	public void setCTime(String cTime) {
		this.cTime = cTime;
	}

	public Long getStatus() {
		return status;
	}
	
	public void setStatus(Long status) {
		this.status = status;
	}
}