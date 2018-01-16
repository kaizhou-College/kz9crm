package com.kz.crm.entity;

public class SysRoleQuery extends SysRole {
	/*每页显示多少条数据*/
	private int pageSize =2;
	/*当前页数*/
	private int curPage = 1;
	/*总页数*/
	private int maxPage;
	/*总条数*/
	private int totleCount;
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getCurPage() {
		return curPage;
	}
	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}
	public int getMaxPage() {
		return maxPage;
	}
	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}
	public int getTotleCount() {
		return totleCount;
	}
	public void setTotleCount(int totleCount) {
		this.totleCount = totleCount;
	}
	
	
	
}
