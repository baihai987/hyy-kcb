package com.hyy.kcb.domain.drop;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.math.BigDecimal;

/**
 * @author WhiteLee
 * 功能描述:空投记录（un）管理
 */
@SuppressWarnings("serial")
public class RecordDrop  implements java.io.Serializable {

	private Long id ; //主键
	private Long openid ; //用户id
	private String time ; //时间
	private BigDecimal grossAmount ; //总金额
	private BigDecimal releaseAmount ; //释放金额
	private BigDecimal balance ; //剩余金额
	private Long releaseDay ; //释放天数
	private Long type ; //1、KCB余额、2、硬盘产生的空投

	

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public Long getOpenid() {
		return openid;
	}
	
	public void setOpenid(Long openid) {
		this.openid = openid;
	}

	public String getTime() {
		return time;
	}
	
	public void setTime(String time) {
		this.time = time;
	}

	public BigDecimal getGrossAmount() {
		return grossAmount;
	}
	
	public void setGrossAmount(BigDecimal grossAmount) {
		this.grossAmount = grossAmount;
	}

	public BigDecimal getReleaseAmount() {
		return releaseAmount;
	}
	
	public void setReleaseAmount(BigDecimal releaseAmount) {
		this.releaseAmount = releaseAmount;
	}

	public BigDecimal getBalance() {
		return balance;
	}
	
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public Long getReleaseDay() {
		return releaseDay;
	}
	
	public void setReleaseDay(Long releaseDay) {
		this.releaseDay = releaseDay;
	}

	public Long getType() {
		return type;
	}
	
	public void setType(Long type) {
		this.type = type;
	}
}