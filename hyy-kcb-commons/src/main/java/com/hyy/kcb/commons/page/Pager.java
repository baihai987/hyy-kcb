package com.hyy.kcb.commons.page;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class Pager<T> implements java.io.Serializable {

	/**
	 * 
	 */
	
	private static final long serialVersionUID = -8154405986796333298L;
	
	private static final String key[] = {"pageSize=","pager.offset=","pageOffset="};

	/**
	 * 当前页
	 */
	private int currentPage = 1;
	private int pageNum ;
	
	private int totalCount;

	/**
	 * 每页条数
	 */
	private int numPerPage = 20;
	
	private int firstResult;
	
	private int maxResults;
	
	private String queryString;
		
	private String url;
	
	private int totalPage;
	
	private int limitStart;
	private int pageSize;
	
	/**
	 * 排序字段
	 */
	private String orderField;

	/**
	 * 排序方式：asc or desc
	 */
	private String orderDirection;
	

//	private Map<String,Object> params; // 传入的参数
	private Object params; // 传入的参数
	
	public int getTotalPage() {
		return totalPage;
	}
	
	public void setTotalPage(int totalPage) {
		this.totalPage = this.totalCount%this.numPerPage>0?this.totalCount/this.numPerPage+1:this.totalCount/this.numPerPage;
	}
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	private List<T> list;



	public int getCurrentPage() {
		return this.pageNum;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getNumPerPage() {
		return numPerPage;
	}

	public void setNumPerPage(int numPerPage) {
		this.numPerPage = numPerPage;
	}
	
	public static String stringToArrayList(String str, String reg) {
		String m = "";
		if (str == null || str.equals(""))
			return m;
		
		String[] strArr = str.split(reg);
			
		for (int i = 0; i < strArr.length; ++i) {
			if(strArr[i].indexOf(key[0])==-1 &&
					strArr[i].indexOf(key[1])==-1 &&
					strArr[i].indexOf(key[2])==-1){
				m += "&"+strArr[i];
			}
		}

		if(!m.equals("")){
			return m;
		} else {
			return "";
		}
	}

	public String getQueryString() {
		return queryString;
	}

	public void setQueryString(HttpServletRequest req) {
		String queryString =  req.getQueryString();
		this.queryString = stringToArrayList(queryString,"&");;
	}

	public int getFirstResult() {
		firstResult = numPerPage * (currentPage - 1);
		return firstResult;
	}

	public int getMaxResults() {
		maxResults = numPerPage * currentPage;
		return maxResults;
	}


	public String getOrderField() {
		return orderField;
	}

	public String getOrderDirection() {
		return orderDirection;
	}

	public void setOrderField(String orderField) {
		this.orderField = orderField;
	}

	public void setOrderDirection(String orderDirection) {
		this.orderDirection = orderDirection;
	}

	public int getLimitStart() {
		return limitStart;
	}

	public void setLimitStart(int limitStart) {
		this.limitStart = limitStart;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.setCurrentPage(pageNum);
		this.pageNum = pageNum;
	}

	public Object getParams() {
		return params;
	}

	public void setParams(Object params) {
		this.params = params;
	}

	@Override
	public String toString() {
		return "Pager [currentPage=" + currentPage + ", pageNum=" + pageNum + ", totalCount=" + totalCount
				+ ", numPerPage=" + numPerPage + ", firstResult=" + firstResult + ", maxResults=" + maxResults
				+ ", queryString=" + queryString + ", url=" + url + ", totalPage=" + totalPage + ", limitStart="
				+ limitStart + ", pageSize=" + pageSize + ", orderField=" + orderField + ", orderDirection="
				+ orderDirection + ", params=" + params + ", list=" + list + "]";
	}

}
