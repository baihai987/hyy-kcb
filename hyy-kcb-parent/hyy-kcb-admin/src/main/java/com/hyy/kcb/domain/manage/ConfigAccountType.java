package com.hyy.kcb.domain.manage;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author WhiteLee
 * 功能描述:资产类型(un)管理
 */
@SuppressWarnings("serial")
public class ConfigAccountType  implements java.io.Serializable {

	private Long id ; //主键
	private Long assetType ; //资产类型，三部分组成，asset_a、asset_bc、asset_coin_number
	private String assetA ; //资产类型的第一位，1：工资账户，2用户账户
	private String assetBc ; //资产类型的第2、3位；"01","余额账户"、"02","冻结账户"、WITHDRAW("03","提现中")、MARGIN("04","保证金账户")、REALIZED_PL("05","已实现盈亏账户")、PRESENT_COIN("06", "赠币账户")
	private Long assetCoinNumber ; //资产类型的后几位、货币代码；分法币和数字货币，后台添加的都是数字货币，代码从起始值1001开始递增，小于1000的货币代码为交易所初期手动添加的币对
	private String coinSymbol ; //币种符号 大写；BTC、ETH等
	private String symbol ; //币对编码，允许为null；大写如ETHBTC，只有账户为手续费账户时需要这个字段
	private String tag ; //资产标识，account表的tag字段使用这个标识
	private String description ; //资产描述，默认空串
	private String ctime ; //
	private String mtime ; //

	

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public Long getAssetType() {
		return assetType;
	}
	
	public void setAssetType(Long assetType) {
		this.assetType = assetType;
	}

	public String getAssetA() {
		return assetA;
	}
	
	public void setAssetA(String assetA) {
		this.assetA = assetA;
	}

	public String getAssetBc() {
		return assetBc;
	}
	
	public void setAssetBc(String assetBc) {
		this.assetBc = assetBc;
	}

	public Long getAssetCoinNumber() {
		return assetCoinNumber;
	}
	
	public void setAssetCoinNumber(Long assetCoinNumber) {
		this.assetCoinNumber = assetCoinNumber;
	}

	public String getCoinSymbol() {
		return coinSymbol;
	}
	
	public void setCoinSymbol(String coinSymbol) {
		this.coinSymbol = coinSymbol;
	}

	public String getSymbol() {
		return symbol;
	}
	
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getTag() {
		return tag;
	}
	
	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
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
}