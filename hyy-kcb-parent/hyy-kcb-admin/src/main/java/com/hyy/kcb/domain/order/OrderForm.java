package com.hyy.kcb.domain.order;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.math.BigDecimal;

/**
 * @author WhiteLee
 * 功能描述:转入充值到POS记录管理
 */
@SuppressWarnings("serial")
public class OrderForm  implements java.io.Serializable {

	private Long id ; //主键
	private Long uid ; //用户id
	private String orderNumber ; //订单号
	private BigDecimal amount ; //变化额
	private Long shift ; //1转入、2转出
	private Long status ; //0进行中、1成功、2失败
	private String cTime ; //创建时间
	private String body ; //订单说明
	private String subject ; //订单标题
 	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date eTime ; //订单结束时间
	private BigDecimal fee ; //手续费

	

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

	public String getOrderNumber() {
		return orderNumber;
	}
	
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public BigDecimal getAmount() {
		return amount;
	}
	
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Long getShift() {
		return shift;
	}
	
	public void setShift(Long shift) {
		this.shift = shift;
	}

	public Long getStatus() {
		return status;
	}
	
	public void setStatus(Long status) {
		this.status = status;
	}

	public String getCTime() {
		return cTime;
	}
	
	public void setCTime(String cTime) {
		this.cTime = cTime;
	}

	public String getBody() {
		return body;
	}
	
	public void setBody(String body) {
		this.body = body;
	}

	public String getSubject() {
		return subject;
	}
	
	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Date getETime() {
		return eTime;
	}
	
	public void setETime(Date eTime) {
		this.eTime = eTime;
	}

	public BigDecimal getFee() {
		return fee;
	}
	
	public void setFee(BigDecimal fee) {
		this.fee = fee;
	}
}