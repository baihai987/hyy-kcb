package com.hyy.kcb.commons.exception;

/**
 * 获取member exception
 * @author Administrator
 *
 */
public class BaseMemberException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	protected int expCode;
	protected String expMsg;

	public BaseMemberException(int expCode, String expMsg) {
		this.expCode = expCode;
		this.expMsg = expMsg;
	}

	public int getExpCode() {
		return expCode;
	}

	public void setExpCode(int expCode) {
		this.expCode = expCode;
	}

	public String getExpMsg() {
		return expMsg;
	}

	public void setExpMsg(String expMsg) {
		this.expMsg = expMsg;
	}

	@Override
	public String toString() {
		return "ServiceException [expCode=" + expCode + ", expMsg=" + expMsg + "]";
	}
}
