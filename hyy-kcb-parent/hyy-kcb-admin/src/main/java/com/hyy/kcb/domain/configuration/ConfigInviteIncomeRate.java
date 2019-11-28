package com.hyy.kcb.domain.configuration;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.math.BigDecimal;

/**
 * @author WhiteLee
 * 功能描述:布道代数算力配置管理
 */
@SuppressWarnings("serial")
public class ConfigInviteIncomeRate  implements java.io.Serializable {

	private Long id ; //主键
	private Long level ; //T1级、T2级、T3级、T4级
	private Long generation ; //邀请代数
	private BigDecimal incomeRate ; //收益率
	private Long numberOfInvitees ; //邀请人数

	

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public Long getLevel() {
		return level;
	}
	
	public void setLevel(Long level) {
		this.level = level;
	}

	public Long getGeneration() {
		return generation;
	}
	
	public void setGeneration(Long generation) {
		this.generation = generation;
	}

	public BigDecimal getIncomeRate() {
		return incomeRate;
	}
	
	public void setIncomeRate(BigDecimal incomeRate) {
		this.incomeRate = incomeRate;
	}

	public Long getNumberOfInvitees() {
		return numberOfInvitees;
	}
	
	public void setNumberOfInvitees(Long numberOfInvitees) {
		this.numberOfInvitees = numberOfInvitees;
	}
}