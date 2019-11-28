package com.hyy.kcb.domain.order;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.math.BigDecimal;

/**
 * @author WhiteLee
 * 功能描述:交易记录(contain mining_records)管理
 */
@SuppressWarnings("serial")
public class Transaction  implements java.io.Serializable {

	private Long id ; //
	private Long fromUid ; //转出账户ID
	private Long fromType ; //转出账户type
	private BigDecimal fromBalance ; //转出后账户余额
	private Long toUid ; //转入账户ID
	private Long toType ; //转入账户type
	private BigDecimal toBalance ; //转入后账户余额
	private BigDecimal amount ; //发生额
	private String meta ; //转账说明，因为国际化，所以只能对应数字
	private String scene ; //场景，用于连接上下文
	private String refType ; //转账时涉及的主业务表名，或者特性名，不一定准确
	private Long refId ; //转账时涉及的主业务表ID
	private Long opUid ; //操作的UID，0：系统自动转账，主要用于记录后台转账使用
	private String opIp ; //操作的IP，‘’：系统自动转账，主要用于记录后台转账使用
	private String ctime ; //创建时间
	private String mtime ; //修改时间
	private String fingerprint ; //防篡改指纹

	

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public Long getFromUid() {
		return fromUid;
	}
	
	public void setFromUid(Long fromUid) {
		this.fromUid = fromUid;
	}

	public Long getFromType() {
		return fromType;
	}
	
	public void setFromType(Long fromType) {
		this.fromType = fromType;
	}

	public BigDecimal getFromBalance() {
		return fromBalance;
	}
	
	public void setFromBalance(BigDecimal fromBalance) {
		this.fromBalance = fromBalance;
	}

	public Long getToUid() {
		return toUid;
	}
	
	public void setToUid(Long toUid) {
		this.toUid = toUid;
	}

	public Long getToType() {
		return toType;
	}
	
	public void setToType(Long toType) {
		this.toType = toType;
	}

	public BigDecimal getToBalance() {
		return toBalance;
	}
	
	public void setToBalance(BigDecimal toBalance) {
		this.toBalance = toBalance;
	}

	public BigDecimal getAmount() {
		return amount;
	}
	
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getMeta() {
		return meta;
	}
	
	public void setMeta(String meta) {
		this.meta = meta;
	}

	public String getScene() {
		return scene;
	}
	
	public void setScene(String scene) {
		this.scene = scene;
	}

	public String getRefType() {
		return refType;
	}
	
	public void setRefType(String refType) {
		this.refType = refType;
	}

	public Long getRefId() {
		return refId;
	}
	
	public void setRefId(Long refId) {
		this.refId = refId;
	}

	public Long getOpUid() {
		return opUid;
	}
	
	public void setOpUid(Long opUid) {
		this.opUid = opUid;
	}

	public String getOpIp() {
		return opIp;
	}
	
	public void setOpIp(String opIp) {
		this.opIp = opIp;
	}

	public String getCtime() {
		return ctime;
	}
	
	public void setCtime(String ctime) {
		this.ctime = ctime;
	}

	public String getMtime() {
		return mtime;
	}
	
	public void setMtime(String mtime) {
		this.mtime = mtime;
	}

	public String getFingerprint() {
		return fingerprint;
	}
	
	public void setFingerprint(String fingerprint) {
		this.fingerprint = fingerprint;
	}
}