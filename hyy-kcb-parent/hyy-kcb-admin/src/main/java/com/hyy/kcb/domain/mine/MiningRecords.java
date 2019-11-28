package com.hyy.kcb.domain.mine;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.math.BigDecimal;

/**
 * @author WhiteLee
 * 功能描述:挖矿记录管理
 */
@SuppressWarnings("serial")
public class MiningRecords  implements java.io.Serializable {

	private Long id ; //主键
	private Long uid ; //用户id
	private BigDecimal miningAmount ; //挖矿金额--产生的币进入到未同步账户中
	private String createTime ; //创建时间
	private Long purchasedHardDiskId ; //我的硬盘id
	private Long level ; //硬盘等级
	private Long type ; //类型  1挖矿产出  2邀请产出
	private String fromMobile ; //来源用户手机号  邀请产出用
	private BigDecimal fromAmount ; //来源用户总收益
	private BigDecimal incomeRate ; //收益率
	private Long generation ; //邀请代数

	

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

	public BigDecimal getMiningAmount() {
		return miningAmount;
	}
	
	public void setMiningAmount(BigDecimal miningAmount) {
		this.miningAmount = miningAmount;
	}

	public String getCreateTime() {
		return createTime;
	}
	
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public Long getPurchasedHardDiskId() {
		return purchasedHardDiskId;
	}
	
	public void setPurchasedHardDiskId(Long purchasedHardDiskId) {
		this.purchasedHardDiskId = purchasedHardDiskId;
	}

	public Long getLevel() {
		return level;
	}
	
	public void setLevel(Long level) {
		this.level = level;
	}

	public Long getType() {
		return type;
	}
	
	public void setType(Long type) {
		this.type = type;
	}

	public String getFromMobile() {
		return fromMobile;
	}
	
	public void setFromMobile(String fromMobile) {
		this.fromMobile = fromMobile;
	}

	public BigDecimal getFromAmount() {
		return fromAmount;
	}
	
	public void setFromAmount(BigDecimal fromAmount) {
		this.fromAmount = fromAmount;
	}

	public BigDecimal getIncomeRate() {
		return incomeRate;
	}
	
	public void setIncomeRate(BigDecimal incomeRate) {
		this.incomeRate = incomeRate;
	}

	public Long getGeneration() {
		return generation;
	}
	
	public void setGeneration(Long generation) {
		this.generation = generation;
	}
}