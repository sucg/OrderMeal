package com.glodon.model;

public class Page {
	private int nowPage;
	private int pageSize;

	public int getNowPage() {
		return nowPage;
	}

	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public Page() {
		// TODO Auto-generated constructor stub
	}
	public Page(int nowPage, int pageSize) {
		this.nowPage = nowPage;
		this.pageSize = pageSize;
	}

}
