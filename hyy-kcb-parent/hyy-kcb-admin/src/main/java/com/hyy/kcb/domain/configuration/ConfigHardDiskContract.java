package com.hyy.kcb.domain.configuration;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.math.BigDecimal;

/**
 * @author WhiteLee
 * 功能描述:合约时长配置管理
 */
@SuppressWarnings("serial")
public class ConfigHardDiskContract  implements java.io.Serializable {

	private Long contractId ; //合约id
	private Long contractValidity ; //合约有效期   (单位月)
	private BigDecimal discount ; //折扣
	private String contractName ; //合约名称

	

	public Long getContractId() {
		return contractId;
	}
	
	public void setContractId(Long contractId) {
		this.contractId = contractId;
	}

	public Long getContractValidity() {
		return contractValidity;
	}
	
	public void setContractValidity(Long contractValidity) {
		this.contractValidity = contractValidity;
	}

	public BigDecimal getDiscount() {
		return discount;
	}
	
	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}

	public String getContractName() {
		return contractName;
	}
	
	public void setContractName(String contractName) {
		this.contractName = contractName;
	}
}