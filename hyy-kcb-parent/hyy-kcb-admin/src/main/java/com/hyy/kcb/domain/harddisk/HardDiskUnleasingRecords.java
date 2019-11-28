package com.hyy.kcb.domain.harddisk;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.math.BigDecimal;

/**
 * @author WhiteLee
 * 功能描述:硬盘解压管理
 */
@SuppressWarnings("serial")
public class HardDiskUnleasingRecords  implements java.io.Serializable {

	private Long id ; //主键
	private Long uid ; //用户id
	private Long purchasedHardDiskId ; //用户硬盘id
	private BigDecimal dailyIssue ; //每日发放数量
	private String createTime ; //创建时间
	private Long numberOfDaysIssued ; //第几天

	

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

	public Long getPurchasedHardDiskId() {
		return purchasedHardDiskId;
	}
	
	public void setPurchasedHardDiskId(Long purchasedHardDiskId) {
		this.purchasedHardDiskId = purchasedHardDiskId;
	}

	public BigDecimal getDailyIssue() {
		return dailyIssue;
	}
	
	public void setDailyIssue(BigDecimal dailyIssue) {
		this.dailyIssue = dailyIssue;
	}

	public String getCreateTime() {
		return createTime;
	}
	
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public Long getNumberOfDaysIssued() {
		return numberOfDaysIssued;
	}
	
	public void setNumberOfDaysIssued(Long numberOfDaysIssued) {
		this.numberOfDaysIssued = numberOfDaysIssued;
	}
}