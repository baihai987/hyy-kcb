package com.hyy.kcb.domain.configuration;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.math.BigDecimal;

/**
 * @author WhiteLee
 * 功能描述:硬盘配置管理
 */
@SuppressWarnings("serial")
public class HardDisk  implements java.io.Serializable {

	private Long id ; //主键
	private String name ; //磁盘名称
	private Long level ; //T1级、T2级、T3级、T4级、T5级
	private BigDecimal price ; //价格(单位KCB)
	private BigDecimal hashrate ; //算力
	private BigDecimal assetTransferRestriction ; //每日提币数量
	private BigDecimal annualRate ; //年收益率区间值最小值5%,年收益率区间值最大值100%
	private Long reviewTime ; //审核时间 （单位天）

	

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public Long getLevel() {
		return level;
	}
	
	public void setLevel(Long level) {
		this.level = level;
	}

	public BigDecimal getPrice() {
		return price;
	}
	
	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getHashrate() {
		return hashrate;
	}
	
	public void setHashrate(BigDecimal hashrate) {
		this.hashrate = hashrate;
	}

	public BigDecimal getAssetTransferRestriction() {
		return assetTransferRestriction;
	}
	
	public void setAssetTransferRestriction(BigDecimal assetTransferRestriction) {
		this.assetTransferRestriction = assetTransferRestriction;
	}

	public BigDecimal getAnnualRate() {
		return annualRate;
	}
	
	public void setAnnualRate(BigDecimal annualRate) {
		this.annualRate = annualRate;
	}

	public Long getReviewTime() {
		return reviewTime;
	}
	
	public void setReviewTime(Long reviewTime) {
		this.reviewTime = reviewTime;
	}
}