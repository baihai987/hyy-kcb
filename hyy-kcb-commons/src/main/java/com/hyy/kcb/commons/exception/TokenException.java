package com.hyy.kcb.commons.exception;

/**
 * 异常处理类
 * 
 * TokenNotNullException token 不能为空
 */
public class TokenException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	protected int expCode;
	protected String expMsg;

	public TokenException(int expCode, String expMsg) {
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
		return "TokenException [expCode=" + expCode + ", expMsg=" + expMsg + "]";
	}

}
