package com.hyy.kcb.domain.configuration;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.math.BigDecimal;

/**
 * @author WhiteLee
 * 功能描述:总算力配置管理
 */
@SuppressWarnings("serial")
public class SumHashrate  implements java.io.Serializable {

	private Long id ; //主键
	private BigDecimal managedForce ; //总算力

	

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getManagedForce() {
		return managedForce;
	}
	
	public void setManagedForce(BigDecimal managedForce) {
		this.managedForce = managedForce;
	}
}