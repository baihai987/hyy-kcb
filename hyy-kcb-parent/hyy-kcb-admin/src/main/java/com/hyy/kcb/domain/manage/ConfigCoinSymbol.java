package com.hyy.kcb.domain.manage;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.math.BigDecimal;

/**
 * @author WhiteLee
 * 功能描述:币种配置(un)管理
 */
@SuppressWarnings("serial")
public class ConfigCoinSymbol  implements java.io.Serializable {

	private Long id ; //
	private String coinSymbol ; //币种简称，大写：BTC
	private String contractAddress ; //erc20合约地址
	private Long contractPrecision ; //合约精度
	private Long showPrecision ; //资产显示精度
	private Long otcOpen ; //场外是否出现 0不出现，1出现
	private Long isFiat ; //是否为法币，0:数字货币，1法币
	private Long isQuote ; //是否为计价货币 0非计价货币，1计价货币
	private Long isOpen ; //是否开启；0关闭，1开启
	private Long depositOpen ; //是否开放充值，0关闭充值，1开放充值；
	private Long withdrawOpen ; //是否开启提现，0关闭提现，1开启提现；
	private Long useRate ; //是否维护与各币种汇率,用户脚本计算汇率；0否，1是；
	private String tokenBase ; //币种资产类型；例如：mex属于eth资产；lyb属于xas资产；主链币，资产类型就是本身；
	private String chainAddress ; //根据地址查询的,区块链浏览器地址，http开头，”/“结尾
	private String chainTx ; //根据txid查询的区块链浏览器地址，http开头，”/“结尾
	private Long depositConfirm ; //充值到账确认数
	private Long miningDepositConfirm ; //来自矿工奖励的充值确认数
	private BigDecimal withdrawMax ; //单次提现最大值
	private BigDecimal withdrawMin ; //单次提现最小值
	private BigDecimal withdrawMaxDay ; //已认证每日提币最大值
	private BigDecimal withdrawMaxDayNoAuth ; //未认证每日提币最大值
	private Long addressLen ; //地址长度，用于提现地址校验
	private String name ; //前台展示名称
	private String icon ; //币种logo图片地址
	private String link ; //冗余设计
	private Long sort ; //排序
	private Long releaseStatus ; //上线状态（1沙盒、2线上）
	private String ctime ; //
	private String mtime ; //
	private String btcRateMath ; //汇率计算公式（在币种不出现在usdt、eth、btc三个大区，并且不是计价货币时用这个公司技术btc汇率）
	private Long isRelease ; //是否需要重新发布 1是，0否
	private Long securityStatus ; //0未审核 1审核通过 2审核拒绝
	private BigDecimal depositMin ; //单次充值最小值
	private Long tagType ; //tag类型: 0：无tag     1:有tag非必填     2：有tag且必填
	private Long supportToken ; //是否支持token   0：不支持  1：支持
	private String regular ; //地址校验正则表达式
	private Long depositLockOpen ; //充值是否进锁仓，0否，1是

	

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public String getCoinSymbol() {
		return coinSymbol;
	}
	
	public void setCoinSymbol(String coinSymbol) {
		this.coinSymbol = coinSymbol;
	}

	public String getContractAddress() {
		return contractAddress;
	}
	
	public void setContractAddress(String contractAddress) {
		this.contractAddress = contractAddress;
	}

	public Long getContractPrecision() {
		return contractPrecision;
	}
	
	public void setContractPrecision(Long contractPrecision) {
		this.contractPrecision = contractPrecision;
	}

	public Long getShowPrecision() {
		return showPrecision;
	}
	
	public void setShowPrecision(Long showPrecision) {
		this.showPrecision = showPrecision;
	}

	public Long getOtcOpen() {
		return otcOpen;
	}
	
	public void setOtcOpen(Long otcOpen) {
		this.otcOpen = otcOpen;
	}

	public Long getIsFiat() {
		return isFiat;
	}
	
	public void setIsFiat(Long isFiat) {
		this.isFiat = isFiat;
	}

	public Long getIsQuote() {
		return isQuote;
	}
	
	public void setIsQuote(Long isQuote) {
		this.isQuote = isQuote;
	}

	public Long getIsOpen() {
		return isOpen;
	}
	
	public void setIsOpen(Long isOpen) {
		this.isOpen = isOpen;
	}

	public Long getDepositOpen() {
		return depositOpen;
	}
	
	public void setDepositOpen(Long depositOpen) {
		this.depositOpen = depositOpen;
	}

	public Long getWithdrawOpen() {
		return withdrawOpen;
	}
	
	public void setWithdrawOpen(Long withdrawOpen) {
		this.withdrawOpen = withdrawOpen;
	}

	public Long getUseRate() {
		return useRate;
	}
	
	public void setUseRate(Long useRate) {
		this.useRate = useRate;
	}

	public String getTokenBase() {
		return tokenBase;
	}
	
	public void setTokenBase(String tokenBase) {
		this.tokenBase = tokenBase;
	}

	public String getChainAddress() {
		return chainAddress;
	}
	
	public void setChainAddress(String chainAddress) {
		this.chainAddress = chainAddress;
	}

	public String getChainTx() {
		return chainTx;
	}
	
	public void setChainTx(String chainTx) {
		this.chainTx = chainTx;
	}

	public Long getDepositConfirm() {
		return depositConfirm;
	}
	
	public void setDepositConfirm(Long depositConfirm) {
		this.depositConfirm = depositConfirm;
	}

	public Long getMiningDepositConfirm() {
		return miningDepositConfirm;
	}
	
	public void setMiningDepositConfirm(Long miningDepositConfirm) {
		this.miningDepositConfirm = miningDepositConfirm;
	}

	public BigDecimal getWithdrawMax() {
		return withdrawMax;
	}
	
	public void setWithdrawMax(BigDecimal withdrawMax) {
		this.withdrawMax = withdrawMax;
	}

	public BigDecimal getWithdrawMin() {
		return withdrawMin;
	}
	
	public void setWithdrawMin(BigDecimal withdrawMin) {
		this.withdrawMin = withdrawMin;
	}

	public BigDecimal getWithdrawMaxDay() {
		return withdrawMaxDay;
	}
	
	public void setWithdrawMaxDay(BigDecimal withdrawMaxDay) {
		this.withdrawMaxDay = withdrawMaxDay;
	}

	public BigDecimal getWithdrawMaxDayNoAuth() {
		return withdrawMaxDayNoAuth;
	}
	
	public void setWithdrawMaxDayNoAuth(BigDecimal withdrawMaxDayNoAuth) {
		this.withdrawMaxDayNoAuth = withdrawMaxDayNoAuth;
	}

	public Long getAddressLen() {
		return addressLen;
	}
	
	public void setAddressLen(Long addressLen) {
		this.addressLen = addressLen;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getIcon() {
		return icon;
	}
	
	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getLink() {
		return link;
	}
	
	public void setLink(String link) {
		this.link = link;
	}

	public Long getSort() {
		return sort;
	}
	
	public void setSort(Long sort) {
		this.sort = sort;
	}

	public Long getReleaseStatus() {
		return releaseStatus;
	}
	
	public void setReleaseStatus(Long releaseStatus) {
		this.releaseStatus = releaseStatus;
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

	public String getBtcRateMath() {
		return btcRateMath;
	}
	
	public void setBtcRateMath(String btcRateMath) {
		this.btcRateMath = btcRateMath;
	}

	public Long getIsRelease() {
		return isRelease;
	}
	
	public void setIsRelease(Long isRelease) {
		this.isRelease = isRelease;
	}

	public Long getSecurityStatus() {
		return securityStatus;
	}
	
	public void setSecurityStatus(Long securityStatus) {
		this.securityStatus = securityStatus;
	}

	public BigDecimal getDepositMin() {
		return depositMin;
	}
	
	public void setDepositMin(BigDecimal depositMin) {
		this.depositMin = depositMin;
	}

	public Long getTagType() {
		return tagType;
	}
	
	public void setTagType(Long tagType) {
		this.tagType = tagType;
	}

	public Long getSupportToken() {
		return supportToken;
	}
	
	public void setSupportToken(Long supportToken) {
		this.supportToken = supportToken;
	}

	public String getRegular() {
		return regular;
	}
	
	public void setRegular(String regular) {
		this.regular = regular;
	}

	public Long getDepositLockOpen() {
		return depositLockOpen;
	}
	
	public void setDepositLockOpen(Long depositLockOpen) {
		this.depositLockOpen = depositLockOpen;
	}
}