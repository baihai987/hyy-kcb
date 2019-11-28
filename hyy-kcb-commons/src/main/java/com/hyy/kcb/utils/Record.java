package com.hyy.kcb.utils;




import java.util.HashMap;

/**
 * 
 * @ClassName:  Record   
 * @Description:记录封装
 * @author: crj
 * @date:   2019年4月19日 上午9:54:18
 */
@SuppressWarnings("unchecked")
public class Record extends HashMap<String, Object>{

	private static final long serialVersionUID = -3712396864942166642L;
	
	public <T> T getT(String key){
		Object value = get(key);
		return (T)value;
	}
	
}
