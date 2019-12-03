package com.hyy.kcb.domain.order.dto;

import com.hyy.kcb.domain.order.PurchasedHardDisk;

import java.math.BigDecimal;

/**
 * @author WhiteLee
 * 功能描述:硬盘购买记录管理 扩展
 */
@SuppressWarnings("serial") 
public class PurchasedHardDiskDTO extends PurchasedHardDisk implements java.io.Serializable {
    private String email;
    //合约时长 1 不限制 2 3个月 3 6个月 4 12个月
    private String contractId;
    //挖矿总和
    private BigDecimal miningAmount;
    private String contractStartTime;
    private String contractEndTime;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId;
    }

    public BigDecimal getMiningAmount() {
        return miningAmount;
    }

    public void setMiningAmount(BigDecimal miningAmount) {
        this.miningAmount = miningAmount;
    }

    public String getContractStartTime() {
        return contractStartTime;
    }

    public void setContractStartTime(String contractStartTime) {
        this.contractStartTime = contractStartTime;
    }

    public String getContractEndTime() {
        return contractEndTime;
    }

    public void setContractEndTime(String contractEndTime) {
        this.contractEndTime = contractEndTime;
    }
}