package com.hyy.kcb.commons;

public enum ConstantEnum {
	
	//全局操作成功失败
	_SUCCESS("成功", 0),
	_FAIL("失败", -1),
	
	_NIGHT_NO_SERVER("晚上12:00-07:00为夜间服务时间",-1),
	
	
	_TOKEN_FAIL_NULL("TOKEN不能为空",-100),
	_TOKEN_FAIL_IS_ERROR("TOKEN错误",-100),
	_TOKEN_FAIL_KEY_VAL("TOKEN保存的值错误",-100),

    _TOKEN_OUT_TIME_VAL("TOKEN过期",-100),
	
	_WEB_NOT_LOGIN("Boss系统未登录",-1),
	_WEB_NOT_LOGIN_ERROR("登录错误",-1),
	
	_WEB_NOT_AUTH_ERROR("没有权限",300),
	_WEB_DTAT_IS_NULL("数据不存在或已被删除",-1),
	
	//dao exp 
	DAO_ERROR_EXP("数据操作失败",-1),
	
	//dev 开发错误 100
	DEV_PARM_ERROR("缺少必要参数错误",-1),
	DEV_PARM_TYPE_ERROR("参数数据类型错误",-1),
	
	SERVER_DATA_ERROR("数据错误",-1),
	
	SERVER_BOOK_IN("图书已入库，请检查后再试",-1),
	
	SERVER_BOOK_OUT("图书已出库，请检查后再试",-1),
	SERVER_FACILITY_IN("设备已入库，请检查后再试",-1),
	SERVER_FACILITY_OUT("设备已入库，请检查后再试",-1),
	SERVER_OTHER_IN("设备已入库，请检查后再试",-1),
	SERVER_OTHER_OUT("设备已入库，请检查后再试",-1),
	
	//app server des  错误码从1000 开始
	
	APP_SER_MEMBER_LOCK("账户被冻结,请联系管理员!",-1),
	
	APP_SER_MEMBER_FORCE_IDENT("请完成部队实名认证",-10001),
	APP_SER_MEMBER_NO_FORCE_IDENT("认证信息非内部信息",-10002),
	
	APP_SER_UPDATE("版本太低，请更新到最新版本",-1),
	APP_SER_IVAUTH("接口版本太低，请升级到%s以上的接口服务",-1),
	
	app_ser_msg_not_user("用户不存在",-1),
	app_ser_msg_error_pass("用户名或密码错误",-1),
	
	app_ser_msg_not_phone_code("验证码不存在或已过期",-1),
	app_ser_msg_not_phone_code_error("验证码错误",-1),
	
	//web server des 错误码从2000 开始
	WEB_SER_controller_exp("业务访问出现异常",-1),
	WEB_SER_IVAUTH("接口版本太低，请升级到%s以上的接口服务",-1),
	
	
	WEB_SER_ERROR("服务器错误,请联系平台管理员",-500),
	
	
	web_ser_NoAuth("没有绑定账户",-1);
	
	
	private int val;
	private String desc;

	private ConstantEnum(String desc, int val) {
		this.desc = desc;
		this.val = val;
	}

	public int getVal() {
		return this.val;
	}
	public String getDesc() {
		return this.desc;
	}
}
