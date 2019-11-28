package com.hyy.kcb.domain.blockchain;

import java.math.BigDecimal;

/**
 * @author WhiteLee
 * 功能描述:区块链资产充值流水记录(un)管理
 */
@SuppressWarnings("serial")
public class TransactionDepositCrypto  implements java.io.Serializable {

	private Long id ; //
	private Long uid ; //用户id
	private String symbol ; //充值加密货币代号，大写字母 BTC，LTC，ETH
	private BigDecimal amount ; //充值金额
	private BigDecimal fee ; //充值手续费
	private BigDecimal realFee ; //真实花费的区块转账费
	private String createdAt ; //充值创建时间
	private String updatedAt ; //充值更新时间
	private String addressTo ; //到账地址
	private String txid ; //区块链交易ID
	private Long confirmations ; //确认数
	private Long isMining ; //是否来自挖矿奖励：0 不是，1 是
	private Long status ; //充值状态: 0 未确认，1 已完成，2 异常
	private String encrypt ; //密文
	private String verifyDescription ; //说明备注
	private String verifyHash ; //与节点校验的hash

	

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

	public String getSymbol() {
		return symbol;
	}
	
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public BigDecimal getAmount() {
		return amount;
	}
	
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public BigDecimal getFee() {
		return fee;
	}
	
	public void setFee(BigDecimal fee) {
		this.fee = fee;
	}

	public BigDecimal getRealFee() {
		return realFee;
	}
	
	public void setRealFee(BigDecimal realFee) {
		this.realFee = realFee;
	}

	public String getCreatedAt() {
		return createdAt;
	}
	
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}
	
	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getAddressTo() {
		return addressTo;
	}
	
	public void setAddressTo(String addressTo) {
		this.addressTo = addressTo;
	}

	public String getTxid() {
		return txid;
	}
	
	public void setTxid(String txid) {
		this.txid = txid;
	}

	public Long getConfirmations() {
		return confirmations;
	}
	
	public void setConfirmations(Long confirmations) {
		this.confirmations = confirmations;
	}

	public Long getIsMining() {
		return isMining;
	}
	
	public void setIsMining(Long isMining) {
		this.isMining = isMining;
	}

	public Long getStatus() {
		return status;
	}
	
	public void setStatus(Long status) {
		this.status = status;
	}

	public String getEncrypt() {
		return encrypt;
	}
	
	public void setEncrypt(String encrypt) {
		this.encrypt = encrypt;
	}

	public String getVerifyDescription() {
		return verifyDescription;
	}
	
	public void setVerifyDescription(String verifyDescription) {
		this.verifyDescription = verifyDescription;
	}

	public String getVerifyHash() {
		return verifyHash;
	}
	
	public void setVerifyHash(String verifyHash) {
		this.verifyHash = verifyHash;
	}
}