package com.hyy.kcb.domain.member;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.math.BigDecimal;

/**
 * @author WhiteLee
 * 功能描述:用户算力流水管理
 */
@SuppressWarnings("serial")
public class WaterHashrate  implements java.io.Serializable {

	private Long id ; //主键
	private Long uid ; //用户id
	private BigDecimal amount ; //数量
	private String hashrateType ; //算力类型
	private String createTime ; //时间
 	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") 
	private Date createDate ; //创建日期

	

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

	public String getHashrateType() {
		return hashrateType;
	}
	
	public void setHashrateType(String hashrateType) {
		this.hashrateType = hashrateType;
	}

	public String getCreateTime() {
		return createTime;
	}
	
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public Date getCreateDate() {
		return createDate;
	}
	
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
}