package com.hyy.kcb.domain.order;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.math.BigDecimal;

/**
 * @author WhiteLee
 * 功能描述:POS付款流水表管理
 */
@SuppressWarnings("serial")
public class TransactionPayment  implements java.io.Serializable {

	private Long id ; //
	private Long paymentUid ; //付款人id
	private BigDecimal amount ; //付款数量
	private String receiptMobile ; //收款手机号
	private BigDecimal fee ; //手续费
	private String remark ; //备注
	private BigDecimal receiptAmount ; //到账数量
 	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") 
	private Date createTime ; //创建时间

	

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public Long getPaymentUid() {
		return paymentUid;
	}
	
	public void setPaymentUid(Long paymentUid) {
		this.paymentUid = paymentUid;
	}

	public BigDecimal getAmount() {
		return amount;
	}
	
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getReceiptMobile() {
		return receiptMobile;
	}
	
	public void setReceiptMobile(String receiptMobile) {
		this.receiptMobile = receiptMobile;
	}

	public BigDecimal getFee() {
		return fee;
	}
	
	public void setFee(BigDecimal fee) {
		this.fee = fee;
	}

	public String getRemark() {
		return remark;
	}
	
	public void setRemark(String remark) {
		this.remark = remark;
	}

	public BigDecimal getReceiptAmount() {
		return receiptAmount;
	}
	
	public void setReceiptAmount(BigDecimal receiptAmount) {
		this.receiptAmount = receiptAmount;
	}

	public Date getCreateTime() {
		return createTime;
	}
	
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}