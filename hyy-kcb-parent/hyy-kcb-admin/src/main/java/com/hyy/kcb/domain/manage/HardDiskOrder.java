package com.hyy.kcb.domain.manage;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author WhiteLee
 * 功能描述:硬盘订单(un)管理
 */
@SuppressWarnings("serial")
public class HardDiskOrder  implements java.io.Serializable {

	private Long id ; //编号
	private Long uid ; //用户id
	private Long hardDiskId ; //硬盘id
	private Long totalAmount ; //付款金额
	private String settleCurrency ; //支付币种大写
	private String openid ; //openid
	private String outTradeNo ; //第三方网站唯一订单号
	private Long status ; //1统一下单2支付成功3支付失败
 	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") 
	private Date createTime ; //创建时间
 	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") 
	private Date updateTime ; //最后修改时间

	

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

	public Long getHardDiskId() {
		return hardDiskId;
	}
	
	public void setHardDiskId(Long hardDiskId) {
		this.hardDiskId = hardDiskId;
	}

	public Long getTotalAmount() {
		return totalAmount;
	}
	
	public void setTotalAmount(Long totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getSettleCurrency() {
		return settleCurrency;
	}
	
	public void setSettleCurrency(String settleCurrency) {
		this.settleCurrency = settleCurrency;
	}

	public String getOpenid() {
		return openid;
	}
	
	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getOutTradeNo() {
		return outTradeNo;
	}
	
	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}

	public Long getStatus() {
		return status;
	}
	
	public void setStatus(Long status) {
		this.status = status;
	}

	public Date getCreateTime() {
		return createTime;
	}
	
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}
	
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
}