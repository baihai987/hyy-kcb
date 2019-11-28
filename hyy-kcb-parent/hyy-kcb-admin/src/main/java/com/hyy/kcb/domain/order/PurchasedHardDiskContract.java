package com.hyy.kcb.domain.order;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author WhiteLee
 * 功能描述:合约到期记录管理
 */
@SuppressWarnings("serial")
public class PurchasedHardDiskContract  implements java.io.Serializable {

	private Long purchasedHardDiskId ; //主键
	private Long contractId ; //合约id
 	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") 
	private Date contractStartTime ; //合约开始时间
 	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") 
	private Date contractEndTime ; //合约结束时间

	

	public Long getPurchasedHardDiskId() {
		return purchasedHardDiskId;
	}
	
	public void setPurchasedHardDiskId(Long purchasedHardDiskId) {
		this.purchasedHardDiskId = purchasedHardDiskId;
	}

	public Long getContractId() {
		return contractId;
	}
	
	public void setContractId(Long contractId) {
		this.contractId = contractId;
	}

	public Date getContractStartTime() {
		return contractStartTime;
	}
	
	public void setContractStartTime(Date contractStartTime) {
		this.contractStartTime = contractStartTime;
	}

	public Date getContractEndTime() {
		return contractEndTime;
	}
	
	public void setContractEndTime(Date contractEndTime) {
		this.contractEndTime = contractEndTime;
	}
}