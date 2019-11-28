package com.hyy.kcb.commons.service;

import com.hyy.kcb.commons.page.Pager;

import java.util.List;

public interface BaseService<T> {
	
	public List<T> selectAll();
	public T selectById(int id);
	public T selectByUUID(String uuid);
	
	public void selectTList(Pager<T> pager);
	
	public void deleteById(int id);
	
	public int insert(T t) ;
	
	public int updateObj(T t);
}
