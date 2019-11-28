package com.hyy.kcb.domain.configuration;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.math.BigDecimal;

/**
 * @author WhiteLee
 * 功能描述:算力类型（un）管理
 */
@SuppressWarnings("serial")
public class TypeHashrate  implements java.io.Serializable {

	private Long id ; //主键
	private String type ; //算力类型
	private BigDecimal hashrate ; //算力
	private String isOpen ; //1未删除、2已删除
	private String cTime ; //创建时间
	private String mTime ; //修改时间

	

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}

	public BigDecimal getHashrate() {
		return hashrate;
	}
	
	public void setHashrate(BigDecimal hashrate) {
		this.hashrate = hashrate;
	}

	public String getIsOpen() {
		return isOpen;
	}
	
	public void setIsOpen(String isOpen) {
		this.isOpen = isOpen;
	}

	public String getCTime() {
		return cTime;
	}
	
	public void setCTime(String cTime) {
		this.cTime = cTime;
	}

	public String getMTime() {
		return mTime;
	}
	
	public void setMTime(String mTime) {
		this.mTime = mTime;
	}
}