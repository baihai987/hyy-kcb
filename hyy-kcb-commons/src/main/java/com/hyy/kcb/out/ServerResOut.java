package com.hyy.kcb.out;


import com.hyy.kcb.commons.base.BaseObject;

/**
 *     业务访问操作
 * @author Administrator
 */
public class ServerResOut extends BaseObject {
	private int code = 0xffffffff;    //错误码
	private String desc = "";         //描述
	private Object data = null;    //响应数据

    public ServerResOut() {
    }

    public static ServerResOut build(int code, String desc, Object o){
        return new ServerResOut( code,  desc,  o);
    }

    public  static ServerResOut build(int code,String desc){
        return new ServerResOut(code,desc);
    }

    public ServerResOut(int code, String desc, Object data) {
		this.code = code;
		this.desc = desc;
		this.data = data;
	}

    private ServerResOut(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }


    public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
}
