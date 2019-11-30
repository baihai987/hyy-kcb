package com.hyy.kcb.domain.order.dto;

import com.hyy.kcb.domain.order.OrderForm;
/**
 * @author WhiteLee
 * 功能描述:转入充值到POS记录管理 扩展
 */
@SuppressWarnings("serial") 
public class OrderFormDTO extends OrderForm implements java.io.Serializable {

    private String mobile;
    private String startTime;
    private String endTime;
    private String email;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}