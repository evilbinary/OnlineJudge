package org.evilbinary.manager;

public class PageManager {
	private String currentPage;
	private int totalNum;
	private int currentPageNum;
	private int pageSize;
	public PageManager(){
		currentPage="";
		totalNum=0;
		currentPageNum=1;
		pageSize=1;
	}
	
	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public void nextPage(){
		if(currentPageNum<=totalNum/pageSize)
			currentPageNum++;
	}
	public void prePage(){
		if(currentPageNum>1)
			currentPageNum--;
	}
	public void toPage(int i){
		currentPageNum=i;
	}
	public int getTotalNum(){
		return totalNum;
	}
	public int getCurrentPageNum(){
		return currentPageNum;
	}
	public String getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(String currentPage) {
		this.currentPage = currentPage;
	}
	 
	public void setTotalNum(int totalNum) {
		this.totalNum = totalNum;
	}
	public void setCurrentPageNum(int currentPageNum) {
		this.currentPageNum = currentPageNum;
	}
	
}
