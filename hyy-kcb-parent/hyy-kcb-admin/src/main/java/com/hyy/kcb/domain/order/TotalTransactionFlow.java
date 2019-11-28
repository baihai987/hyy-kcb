package com.hyy.kcb.domain.order;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.math.BigDecimal;

/**
 * @author WhiteLee
 * 功能描述:总交易流水(contain order_form)管理
 */
@SuppressWarnings("serial")
public class TotalTransactionFlow  implements java.io.Serializable {

	private Long id ; //主键
	private Long uid ; //用户id
	private BigDecimal amount ; //交易金额
 	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") 
	private Date createTime ; //创建时间
	private String remark ; //备注
	private Long businessTableId ; //业务表id
	private String businessTableName ; //业务表名
	private Long businessType ; //业务类型  1转入  2转出  3硬盘租赁  4重新租赁  5硬盘升级  6解除租赁每日产出  7硬盘每次收益  8付款  9收款

	

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

	public Date getCreateTime() {
		return createTime;
	}
	
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getRemark() {
		return remark;
	}
	
	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Long getBusinessTableId() {
		return businessTableId;
	}
	
	public void setBusinessTableId(Long businessTableId) {
		this.businessTableId = businessTableId;
	}

	public String getBusinessTableName() {
		return businessTableName;
	}
	
	public void setBusinessTableName(String businessTableName) {
		this.businessTableName = businessTableName;
	}

	public Long getBusinessType() {
		return businessType;
	}
	
	public void setBusinessType(Long businessType) {
		this.businessType = businessType;
	}
}