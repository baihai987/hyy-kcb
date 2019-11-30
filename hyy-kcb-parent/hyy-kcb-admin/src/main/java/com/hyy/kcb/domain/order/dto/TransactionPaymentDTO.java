package com.hyy.kcb.domain.order.dto;

import com.hyy.kcb.domain.order.TransactionPayment;
/**
 * @author WhiteLee
 * 功能描述:POS付款流水表管理 扩展
 */
@SuppressWarnings("serial") 
public class TransactionPaymentDTO extends TransactionPayment implements java.io.Serializable {
    private String startTime;
    private String endTime;
    private String payMobile;

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getPayMobile() {
        return payMobile;
    }

    public void setPayMobile(String payMobile) {
        this.payMobile = payMobile;
    }
}