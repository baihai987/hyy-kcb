package com.hyy.kcb.domain.order;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.math.BigDecimal;

/**
 * @author WhiteLee
 * 功能描述:硬盘购买记录管理
 */
@SuppressWarnings("serial")
public class PurchasedHardDisk  implements java.io.Serializable {

	private Long id ; //主键
	private Long uid ; //用户id
	private String mobileNumber ; //购买手机号
	private Long hardDiskId ; //硬盘id
	private String hardDiskName ; //硬盘名称
	private Long level ; //硬盘等级
	private BigDecimal buyingPrice ; //购买价格
	private String cTime ; //购买时间
	private String liftTime ; //解除时间
	private Long remainingDays ; //剩余解除天数
	private Long type ; //1挖矿中/2解除中/3已解除
	private String deductMoneyOrder ; //1、已同步、2中心化钱包可用账户
	private BigDecimal outputToday ; //今日产出
	private BigDecimal pendingAmount ; //待发放数量
	private Long beforeLevel ; //之前硬盘等级

	

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

	public String getMobileNumber() {
		return mobileNumber;
	}
	
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public Long getHardDiskId() {
		return hardDiskId;
	}
	
	public void setHardDiskId(Long hardDiskId) {
		this.hardDiskId = hardDiskId;
	}

	public String getHardDiskName() {
		return hardDiskName;
	}
	
	public void setHardDiskName(String hardDiskName) {
		this.hardDiskName = hardDiskName;
	}

	public Long getLevel() {
		return level;
	}
	
	public void setLevel(Long level) {
		this.level = level;
	}

	public BigDecimal getBuyingPrice() {
		return buyingPrice;
	}
	
	public void setBuyingPrice(BigDecimal buyingPrice) {
		this.buyingPrice = buyingPrice;
	}

	public String getCTime() {
		return cTime;
	}
	
	public void setCTime(String cTime) {
		this.cTime = cTime;
	}

	public String getLiftTime() {
		return liftTime;
	}
	
	public void setLiftTime(String liftTime) {
		this.liftTime = liftTime;
	}

	public Long getRemainingDays() {
		return remainingDays;
	}
	
	public void setRemainingDays(Long remainingDays) {
		this.remainingDays = remainingDays;
	}

	public Long getType() {
		return type;
	}
	
	public void setType(Long type) {
		this.type = type;
	}

	public String getDeductMoneyOrder() {
		return deductMoneyOrder;
	}
	
	public void setDeductMoneyOrder(String deductMoneyOrder) {
		this.deductMoneyOrder = deductMoneyOrder;
	}

	public BigDecimal getOutputToday() {
		return outputToday;
	}
	
	public void setOutputToday(BigDecimal outputToday) {
		this.outputToday = outputToday;
	}

	public BigDecimal getPendingAmount() {
		return pendingAmount;
	}
	
	public void setPendingAmount(BigDecimal pendingAmount) {
		this.pendingAmount = pendingAmount;
	}

	public Long getBeforeLevel() {
		return beforeLevel;
	}
	
	public void setBeforeLevel(Long beforeLevel) {
		this.beforeLevel = beforeLevel;
	}
}