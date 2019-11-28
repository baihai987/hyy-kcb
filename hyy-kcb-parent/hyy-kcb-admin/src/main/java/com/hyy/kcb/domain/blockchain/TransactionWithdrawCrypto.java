package com.hyy.kcb.domain.blockchain;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.math.BigDecimal;

/**
 * @author WhiteLee
 * 功能描述:区块链资产提现流水记录(un)管理
 */
@SuppressWarnings("serial")
public class TransactionWithdrawCrypto  implements java.io.Serializable {

	private Long id ; //
	private Long uid ; //用户id
	private String symbol ; //加密货币代号，大写字母 BTC，LTC，ETH
	private BigDecimal amount ; //提现金额
	private BigDecimal fee ; //手续费
	private BigDecimal realFee ; //实际花费区块链手续费
	private BigDecimal payAmount ; //实际发币数量
	private String createdAt ; //创建时间
	private String updatedAt ; //更新时间
	private String addressFrom ; //来源地址，暂未使用
	private String addressTo ; //到账地址
	private String txid ; //区块链交易ID
	private Long confirmations ; //区块确认数
	private Long status ; //提现状态: 0 未审核，1 审核通过，2 审核拒绝，3 支付中已经打币，4 支付失败，5 已完成，6 已撤销
	private String encrypt ; //密文
	private String verifyDescription ; //说明备注
	private String verifyHash ; //与节点校验的hash
	private String refuseMsg ; //拒绝原因
	private Long opUid ; //审核人id  0为初始化，-99为自动审核，other.管理员id 
	private String payTime ; //支付时间
	private String upTime ; //上链时间
	private String fingerprint ; //防篡改指纹

	

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

	public BigDecimal getPayAmount() {
		return payAmount;
	}
	
	public void setPayAmount(BigDecimal payAmount) {
		this.payAmount = payAmount;
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

	public String getAddressFrom() {
		return addressFrom;
	}
	
	public void setAddressFrom(String addressFrom) {
		this.addressFrom = addressFrom;
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

	public String getRefuseMsg() {
		return refuseMsg;
	}
	
	public void setRefuseMsg(String refuseMsg) {
		this.refuseMsg = refuseMsg;
	}

	public Long getOpUid() {
		return opUid;
	}
	
	public void setOpUid(Long opUid) {
		this.opUid = opUid;
	}

	public String getPayTime() {
		return payTime;
	}
	
	public void setPayTime(String payTime) {
		this.payTime = payTime;
	}

	public String getUpTime() {
		return upTime;
	}
	
	public void setUpTime(String upTime) {
		this.upTime = upTime;
	}

	public String getFingerprint() {
		return fingerprint;
	}
	
	public void setFingerprint(String fingerprint) {
		this.fingerprint = fingerprint;
	}
}